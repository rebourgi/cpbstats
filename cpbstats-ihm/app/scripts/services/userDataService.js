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
    
    this.getTypesExercice = function() {
    	//TODO : Mettre dans service exercice
        return $http.get(appConfig.apiUrl + '/exercices/types');
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
    
    this.addObjectifExercice = function(objectifExercice) {
        return $http.post(appConfig.apiUrl + '/userData/objectifs/exercices', objectifExercice);
    };
});
