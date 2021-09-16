app.controller("categories-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.cates = [];
	$scope.form = {};
	
	$scope.initialize = function() {
		//load sp
		$http.get("/rest/categories").then(resp => {
			$scope.items = resp.data;
		});
		
	}
	//khoi dau
	$scope.initialize();
	//xoa form
	$scope.reset = function(){
			$scope.form = {
			};
	}
	//hien thi form
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
	}
	//them sp
	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post(`/rest/categories`,item).then(resp =>{
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Them thanh cong");
		}).catch(error =>{
			alert("Loi them moi sp");
			console.log("Error" , error);
		});
	}
	//cap nhat sp
	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put(`/rest/categories/${item.id}`,item).then(resp =>{
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("Cap nhap thanh cong");
		}).catch(error =>{
			alert("Loi cap nhap sp");
			console.log("Error" , error);
		});
	}
	//xoa san pham
	$scope.delete = function(item) {
		$http.delete(`/rest/categories/${item.id}`).then(resp =>{
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items.splice(index,1);
			$scope.reset();
			alert("Xoa thanh cong");
		}).catch(error =>{
			alert("Loi cap nhap sp");
			console.log("Error" , error);
		});
	}
	$scope.pager = {
		page: 0,
		size: 10,
		get items(){
			var start = this.page * this.size;
			return $scope.items.slice(start,start + this.size);
		},
		get count(){
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		prev(){
			this.page--;
			if(this.page < 0 ){
				this.page = this.count - 1;
			}
		},
		next(){
			this.page++;
			if(this.page >= this.count){
				this.page = 0;	
			}
		}
		
	}

});