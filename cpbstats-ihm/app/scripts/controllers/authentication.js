'use strict';

/**
 * @ngdoc function
 * @name app.controller:AuthenticationCtrl
 * @description # AuthenticationCtrl Controller of the app
 */
angular.module('app').controller('AuthenticationCtrl', function($rootScope, $scope, $log, authorisationService, $location, toaster) {
    // Executé lors du click sur le bouton de login
    $scope.submit = function() {
    	$location.path('/home');
    	return;
        authorisationService.authenticate($scope.login.pseudo, $scope.login.password).success(function(data, status) {
            if (status === 200) {
                // affichage de message de success
                $log.info("sucess connexion");

                $rootScope.isLogged = true;
                $rootScope.user = data;
                $rootScope.groups = data.groups;
                $rootScope.currentGroup = data.groups[0];
            }
            // Redirection vers la page d'accueil
            $location.path('/home');

        }).error(function(data, status) {
            if (status === 403) {
                // affichage de message d'erreur
                $log.info("Pseudo ou mot de passe incorrecte.");
                toaster.clear();
                toaster.pop('error', "Login ou mot de passe incorrecte!");
            } else if (status === 500) {
                toaster.clear();
                toaster.pop('error', "Une erreur est survenue.");
            }
        });
    };
});
