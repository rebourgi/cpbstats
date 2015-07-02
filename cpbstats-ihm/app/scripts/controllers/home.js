'use strict';

/**
 * @ngdoc function
 * @name app.controller:HomeCtrl
 * @description # HomeCtrl Controller of the app
 */
angular.module('app').controller('HomeCtrl', function($rootScope, $scope, $log, toaster, taskService) {

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
