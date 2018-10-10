$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'ewm/batch/list',
        datatype: "json",
        colModel: [			
			{ label: 'batchId', name: 'batchId', index: 'batch_id', width: 50, key: true },
			{ label: '批次名称', name: 'batchName', index: 'batch_name', width: 80 }, 			
			{ label: '产品名称', name: 'productName', index: 'product_name', width: 80 }, 			
			{ label: '生产日期', name: 'productDate', index: 'product_date', width: 80 }, 			
			{ label: '操作人id', name: 'operatorId', index: 'operator_id', width: 80 }, 			
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
		batch: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.batch = {};
		},
		update: function (event) {
			var batchId = getSelectedRow();
			if(batchId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(batchId)
		},
		saveOrUpdate: function (event) {
			var url = vm.batch.batchId == null ? "ewm/batch/save" : "ewm/batch/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.batch),
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
			var batchIds = getSelectedRows();
			if(batchIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "ewm/batch/delete",
                    contentType: "application/json",
				    data: JSON.stringify(batchIds),
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
		getInfo: function(batchId){
			$.get(baseURL + "ewm/batch/info/"+batchId, function(r){
                vm.batch = r.batch;
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