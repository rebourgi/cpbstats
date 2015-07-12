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
});
