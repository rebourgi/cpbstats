/* global app: true */
'use strict';

var app = angular.module(
        'app',
        [ 'ngAnimate', 'toaster', 'ngResource', 'ngRoute', 'ngSanitize', 'ngTouch', 'ui.bootstrap', 'angularFileUpload', 'angularModalService',
                'ui.grid', 'ui.grid.selection', 'pdf']).config(function($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl : 'views/home.html'
    }).when('/signin', {
        templateUrl : 'views/signin.html',
        controller : 'AuthenticationCtrl'
    }).when('/logout', {
        templateUrl : 'views/index.html',
        controller : 'NavigationCtrl'
    })
    .otherwise({
        redirectTo : '/signin'
    });
});