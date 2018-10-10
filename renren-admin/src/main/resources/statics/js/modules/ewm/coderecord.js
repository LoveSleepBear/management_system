$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'ewm/coderecord/list',
        datatype: "json",
        colModel: [			
			{ label: 'recordId', name: 'recordId', index: 'record_id', width: 50, key: true },
			{ label: '批次id', name: 'batchId', index: 'batch_id', width: 80 }, 			
			{ label: '产生数量', name: 'num', index: 'num', width: 80 }, 			
			{ label: '操作人员id', name: 'operatorId', index: 'operator_id', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		codeRecord: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.codeRecord = {};
		},
		update: function (event) {
			var recordId = getSelectedRow();
			if(recordId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(recordId)
		},
		saveOrUpdate: function (event) {
			var url = vm.codeRecord.recordId == null ? "ewm/coderecord/save" : "ewm/coderecord/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.codeRecord),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var recordIds = getSelectedRows();
			if(recordIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "ewm/coderecord/delete",
                    contentType: "application/json",
				    data: JSON.stringify(recordIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(recordId){
			$.get(baseURL + "ewm/coderecord/info/"+recordId, function(r){
                vm.codeRecord = r.codeRecord;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});