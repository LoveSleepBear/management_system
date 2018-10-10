$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'ewm/codekey/list',
        datatype: "json",
        colModel: [			
			{ label: 'keyId', name: 'keyId', index: 'key_id', width: 50, key: true },
			{ label: '私钥', name: 'priKey', index: 'pri_key', width: 80 }, 			
			{ label: '公钥', name: 'pubKey', index: 'pub_key', width: 80 }, 			
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
		codeKey: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.codeKey = {};
		},
		update: function (event) {
			var keyId = getSelectedRow();
			if(keyId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(keyId)
		},
		saveOrUpdate: function (event) {
			var url = vm.codeKey.keyId == null ? "ewm/codekey/save" : "ewm/codekey/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.codeKey),
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
			var keyIds = getSelectedRows();
			if(keyIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "ewm/codekey/delete",
                    contentType: "application/json",
				    data: JSON.stringify(keyIds),
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
		getInfo: function(keyId){
			$.get(baseURL + "ewm/codekey/info/"+keyId, function(r){
                vm.codeKey = r.codeKey;
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