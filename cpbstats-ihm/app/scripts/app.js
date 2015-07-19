/* global app: true */
'use strict';


Chart.defaults.global.colours = [
	'#ED1654',
	'#00A5E0',
	'#8AC53F',
	'#005676',
	'#F68923',
	'#C4C4C4',
	'#ABDCDC'
];

var app = angular.module(
        'app',
        [ 'ngAnimate', 'toaster', 'ngResource', 'ngRoute', 'ngSanitize', 'ngTouch', 'ui.bootstrap', 'angularFileUpload', 'angularModalService',
                'ui.grid', 'ui.grid.selection', 'chart.js', 'angularSpinner']).config(function($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl : 'views/home.html'
    }).when('/signin', {
        templateUrl : 'views/signin.html',
        controller : 'AuthenticationCtrl'
    }).when('/logout', {
        templateUrl : 'views/index.html',
        controller : 'NavigationCtrl'
    }).when('/objectifs', {
        templateUrl : 'views/objectifs.html',
        controller : ''
    })
    .otherwise({
        redirectTo : '/signin'
    });
});

var appConfig = {
	apiUrl: "/cpbstats-api/rest"
};