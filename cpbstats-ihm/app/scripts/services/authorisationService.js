'use strict';

/**
 * @ngdoc service
 * @name app.authorisationService
 * @description # authorisationService Service in the app.
 */
angular.module('app').service('authorisationService', function($http) {
    // appel de service web pour la déconnexion
    this.logout = function() {
        return $http.get(appConfig.apiUrl + '/authentication/logout');
    };
    // appel de service web pour la connexion
    this.authenticate = function(pseudo, password) {
        return $http.get(appConfig.apiUrl + '/login?username=' + pseudo + '&password=' + password);
    };
    this.getStatut = function() {
        return $http.get(appConfig.apiUrl + '/authentication/status');
    };
});
