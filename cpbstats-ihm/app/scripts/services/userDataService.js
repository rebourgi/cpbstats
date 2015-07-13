'use strict';

/**
 * @ngdoc service
 * @name app.userService
 * @description # userService Service in the app.
 */
angular.module('app').service('userDataService', function($http) {

    this.getTypes = function() {
        return $http.get(appConfig.apiUrl + '/userData/types');
    };
    
    this.getObjectifs = function() {
        return $http.get(appConfig.apiUrl + '/userData/objectifs');
    };   
    
    this.addObjectif = function(objectif) {
        return $http.post(appConfig.apiUrl + '/userData/objectifs', objectif);
    };
    
    this.delObjectif = function(objectif) {
        return $http.delete(appConfig.apiUrl + '/userData/objectifs/' + objectif.id);
    };
});
