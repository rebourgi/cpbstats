'use strict';

/**
 * @ngdoc function
 * @name app.controller:NavigationCtrl
 * @description # NavigationCtrl Controller of the app
 */
angular.module('app').controller('NavigationCtrl', function($rootScope, $scope, $log, authorisationService, $location) {
    // Executé lors du click sur le bouton de login
    $scope.logout = function() {
        $rootScope.isLogged = false;
        authorisationService.logout().success(function() {
            $log.info("Déconnexion réussie");
            // Redirection vers la page d'accueil
            $location.path('/signin');
        }).error(function() {
            $log.info("Déconnexion échouée");
            $location.path('/signin');
        });
    };

    if ($scope.isLogged !== true || $scope.isLogged !== false) {
        authorisationService.getStatut().success(function(data) {
            $rootScope.isLogged = true;
            $rootScope.user = data;
            $rootScope.groups = data.groups;
            $rootScope.currentGroup = data.groups[0];
            $location.path('/home');
        }).error(function() {
            $location.path('/signin');
        });
    }
    $scope.home = function() {
        if ($scope.isLogged) {
            $location.path('/home');
        } else {
            $location.path('/signin');
        }
    };

    $scope.selected = function(element) {
        $rootScope.currentGroup = element;
        $location.path('/home');
        $rootScope.init();
    };
});
