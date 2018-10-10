$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'ewm/qrcode/list',
        datatype: "json",
        colModel: [			
			{ label: '二维码编号', name: 'uniqueId', index: 'unique_id', width: 150, key: true },
			{ label: '批次信息id', name: 'batchId', index: 'batch_id', width: 80 }, 			
			{ label: '扫描次数', name: 'useNum', index: 'use_num', width: 80 }, 			
			{ label: '状态', name: 'status', index: 'status', width: 80 },
			{ label: '操作人id', name: 'operatorId', index: 'operator_id', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 },
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 ,hidden:true}
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
        q:{
            uniqueId: null
        },
		showList: true,
		title: null,
		qrCode: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "生成";
			vm.qrCode = {};
		},
        batch: function(){
            vm.showList = false;
            vm.title = "批量生成";
            vm.qrCode = {};
        },
		update: function (event) {
			var uniqueId = getSelectedRow();
			if(uniqueId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(uniqueId)
		},
		saveOrUpdate: function (event) {
			var url = vm.qrCode.uniqueId == null ? "ewm/qrcode/save" : "ewm/qrcode/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.qrCode),
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
			var uniqueIds = getSelectedRows();
			if(uniqueIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "ewm/qrcode/delete",
                    contentType: "application/json",
				    data: JSON.stringify(uniqueIds),
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
		getInfo: function(uniqueId){
			$.get(baseURL + "ewm/qrcode/info/"+uniqueId, function(r){
                vm.qrCode = r.qrCode;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'uniqueId': vm.q.uniqueId},
                page:page
            }).trigger("reloadGrid");
		}
	}
});