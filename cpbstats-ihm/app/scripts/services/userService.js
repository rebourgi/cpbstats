'use strict';

/**
 * @ngdoc service
 * @name app.userService
 * @description # userService Service in the app.
 */
angular.module('app').service('userService', function($http) {
    this.getUsers = function() {
        return $http.get('/fintrack-back/rest/user/list');
    };
});
