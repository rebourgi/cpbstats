'use strict';

/**
 * @ngdoc function
 * @name app.controller:HomeCtrl
 * @description # HomeCtrl Controller of the app
 */
angular.module('app').controller('HomeCtrl', function($rootScope, $scope, $log, toaster, userDataService) {

	  $scope.labels = ["Download Sales", "In-Store Sales", "Mail-Order Sales"];
	  $scope.data = [320, 500, 100];
	  
	  $scope.labels1 = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
	  $scope.series1 = ['Series A', 'Series B'];

	  $scope.data1 = [
	    [65, 59, 80, 81, 56, 55, 40],
	    [28, 48, 40, 19, 86, 27, 90]
	  ];
	  
	  userDataService.getTypes().success(function(data) {
          $log.info(data);
          $log.info(data);
          $scope.dataTypeExercices =  data.data;
          $scope.labelsTypeExercices = data.labels;
      }).error(function(data) {
          $log.info(data);
      });
	
    $scope.isAdmin = function() {
        return $rootScope.currentGroup === "ADMINISTRATEUR";
    };

    $scope.isCommercial = function() {
        return $rootScope.currentGroup === "COMMERCIAL";
    };

    $scope.isProjectHeader = function() {
        return $rootScope.currentGroup === "CHEF DE PROJET";
    };

    $rootScope.init = function() {
        if ($rootScope.currentGroup === "CHEF DE PROJET") {
            taskService.getNbPoLineToValidate().success(function(data) {
                $log.info(data);
                $scope.nbPoLineToValidate = data;
                if ($scope.nbPoLineToValidate === 0) {
                    $scope.poLink = "";
                } else {
                    $scope.poLink = "#/purchaseorderline";
                }
            }).error(function(data) {
                $log.info(data);
                $scope.nbPoLineToValidate = 0;
                $scope.poLink = "";
            });
        } else {
            $scope.poLink = "#/fileUpload";
        }
    };
    $rootScope.init();
    $scope.poRedirect = function() {
        if ($scope.poLink === "" && $rootScope.currentGroup === "CHEF DE PROJET") {
            toaster.clear();
            toaster.pop('info', "No Purchase order to validate.");
        }
    };
});
