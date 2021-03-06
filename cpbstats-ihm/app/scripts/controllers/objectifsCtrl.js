'use strict';

/**
 * @ngdoc function
 * @name app.controller:objectifsCtrl
 * @description # objectifsCtrl Controller of the app
 */
angular.module('app').controller('objectifsCtrl', function($rootScope, $scope, $log, toaster, userDataService, usSpinnerService) {

    $scope.getTypesExercice = function() {	
	  	  userDataService.getTypesExercice().success(function(data) {
	  		  $scope.typeExercices=data;
	      }).error(function(data) {
              toaster.clear();
              toaster.pop('error', 'Erreur lors de la récupérartion des types d\'exercice');
	      });
    };
	
    $scope.getObjectifs = function() {	
	  	  userDataService.getObjectifs().success(function(data) {
	  		  $scope.objectifs=data;
	      }).error(function(data) {
              toaster.clear();
              toaster.pop('error', 'Erreur lors de la récupération des objectifs');
	      });
    };
	
	
    $scope.addObjectif = function() {	
    	usSpinnerService.spin('spinner');
    	$log.info('Ajout obj '+$scope.newObjectif);
	  	  userDataService.addObjectif($scope.newObjectif).success(function(data) {
	  		usSpinnerService.stop('spinner');
	  		$scope.objectifs.push({
	  			'libelle' : $scope.newObjectif.libelle,
	  			'id' : data
	  			});
              toaster.clear();
              toaster.pop('info', 'Ajout de l\'objectif avec succès');
	      }).error(function(data) {
	    	  usSpinnerService.stop('spinner');
              toaster.clear();
              toaster.pop('error', 'Erreur lors de l\'ajout de l\'objectif');
	      });
    };
    
    
    
    $scope.delObjectif = function(index) {	
    	usSpinnerService.spin('spinner');
	  	  userDataService.delObjectif($scope.objectifs[index]).success(function(data) {
	  		usSpinnerService.stop('spinner');
	  		$scope.objectifs.splice(index, 1);
              toaster.clear();
              toaster.pop('info', 'Supression de l\'objectif avec succès');
	      }).error(function(data) {
	    	  usSpinnerService.stop('spinner');
              toaster.clear();
              toaster.pop('error', 'Erreur lors de la suppression de l\'objectif');
	      });
    };
    
    
    $scope.addObjectifExercice = function(newObjectifExercice, index) {	
    	usSpinnerService.spin('spinner');
    	$log.info('Ajout obj '+newObjectifExercice);
    	newObjectifExercice.idObjectif = $scope.objectifs[index].id;
	  	userDataService.addObjectifExercice(newObjectifExercice).success(function(data) {
	  		usSpinnerService.stop('spinner');
	  		newObjectifExercice.id=data;
	  		$scope.objectifs[index].objectifExercices.push(angular.copy(newObjectifExercice));
              toaster.clear();
              toaster.pop('info', 'Ajout de l\'exerice dans l\'objectif avec succès');
	      }).error(function(data) {
	    	  usSpinnerService.stop('spinner');
              toaster.clear();
              toaster.pop('error', 'Erreur lors de l\'ajout de l\'objectif');
	      });
    };
    
    
    $scope.getTypesExercice();
    $scope.getObjectifs();
    
    
    $scope.today = function() {
        $scope.dt = new Date();
    };
    $scope.today();
    
    $scope.opened = [];
    /* Gestion des calendriers */
    $scope.open = function($event, numCalendar) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened[numCalendar] = !$scope.opened[numCalendar];

    };
      
});
