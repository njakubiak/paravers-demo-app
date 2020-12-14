var app = angular.module('orderPageApp', ['pascalprecht.translate']);

setLocale(app);
//initialize controllers of import page
initImportPageControllers(app);

initToastr();

app.controller('orderHistoryController', function($rootScope, $http, $filter) {
	var history = this;
	connectAndSubscribeMQ(CURRENT_ROLE,$http,$rootScope,$filter);
	getUnreviewedAmount($http,$rootScope,$filter);

	history.showOrderItems = function(items){
		var processedItems = "";
		$.each(items,function(i,item){
			var itemInfo = (i+1)+". "+item.name+" ("+item.quantity+") - ";
			if((i + 1) % 3 === 0){
				processedItems += itemInfo +"\n";
			}else{
				processedItems += itemInfo;
			}
			
		});
		return processedItems.substring(0,processedItems.lastIndexOf(" - "));
	}
	
	history.orderItems = function(items){
		var processedItems = "";
		$.each(items,function(i,item){
			var itemInfo = (i+1)+". "+item.name+" ("+item.quantity+") - ";
			processedItems += itemInfo;
		});
		
		return processedItems.substring(0,processedItems.lastIndexOf(" - "));
	}
	
	history.showOrderDetail = {'show':false}
	
	history.openOrderDetail = function(index, orderStatus, orderNumber, reviewedByAPV, reviewedByPRCH){
		if(!reviewedByPRCH){
			$http({
				method: 'PUT',
				url: '/proxy/v1/orders/'+orderNumber,
				data: {"status":orderStatus,"reviewedByPRCH":true,"reviewedByAPV":reviewedByAPV},
				headers: { 'Content-Type': 'application/json' }
			}).then(function(result) {
				angular.element(".new_label" + index).css("visibility", "hidden");
				//Update icon
				getUnreviewedAmount($http,$rootScope,$filter);
			}).catch(function(result) {
				console.log(result);
			});
		}
		
		$http({
			method: 'GET',
			url: '/proxy/v1/orders/'+orderNumber,
		}).then(function(result) {
			history.order = result.data.data;
			
			var introduceIncorrectNumberBug = false;
			$.each($rootScope.deBugs,function(i,debug){
	            if(debug.demoBugsType === "INCORRECT_NUMBER_OF_ITEMS_IN_SUMMARY_OF_PENDING_ORDER"){
	            	introduceIncorrectNumberBug = true;
	                return false;
	            }
	        });
			
            if(introduceIncorrectNumberBug && history.order.status === "SUBMITTED"){
            	history.totalItemQuantity = 0;
            }else{
            	var totalAmount = 0;
            	$.each(history.order.orderItems,function(i,item){
                    totalAmount += item.quantity;
                });
            	
            	history.totalItemQuantity = totalAmount;
            }
		}).catch(function(result) {
			console.log(result);
		});
		
		history.showOrderDetail['show'] = true;
	}
	
	history.closeOrderDetail = function(){
		history.showOrderDetail['show'] = false;
	}
	
	history.loadStyles = function(index){
		return{
			"top": 85 * index + "px",
			"position": "absolute"
		};
	}

	/**For pagination**/
	// The item number for per page
	history.pageSize = 10;
	
	// Load data for previous page
	history.prev = function(currentPage){
		history.selectPage(currentPage-1);
	}

	// Load data for next page
	history.next = function(currentPage){
		history.selectPage(currentPage+1);
	}

	// Load data for given page number
	history.selectPage = function(page) {

		// Situation for page number is more than legal range
		if((history.totalPages !== 0 || history.totalPages !== undefined) && (page < 1 || page > history.totalPages)){
			return ;
		}

		$http({
			method: 'GET',
			url: '/proxy/v1/orders',
			params: {'page':page-1,'size':history.pageSize,'sort':'orderNumber,desc'}
		}).then(function(result) {
			var orders = result.data.data.content;
			if(orders.length < 1){
				$rootScope.emptyContentError = true;
			}
			
			// Update the new data on web
			history.orders = orders;
			if(history.orders.length<1){
				history.emptyContentsMessage = true;
			}
			history.totalPages = result.data.data.totalPages;
			history.currentPage = history.totalPages === 0 ? 0 : page;
		}).catch(function(result) {
			console.log(result);
			history.totalPages = 0;
			history.currentPage = 0;
			displayLoadError(result,$rootScope,$filter,$http,false,"orders");
			history.ordersLoadError = true;
		});
	}

	// Set time out for avoiding to get the key when using $filter('translate') filter.
	setTimeout(function(){
		// Initialize pagination
		history.selectPage(1);
	}, 500);

	setTimeout(function(){ $("body").css("visibility","visible") }, 100);
});