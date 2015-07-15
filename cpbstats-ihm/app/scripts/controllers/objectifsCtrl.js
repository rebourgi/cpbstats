'use strict';

/**
 * @ngdoc function
 * @name app.controller:objectifsCtrl
 * @description # objectifsCtrl Controller of the app
 */
angular.module('app').controller('objectifsCtrl', function($rootScope, $scope, $log, toaster, userDataService) {

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
    	$log.info('Ajout obj '+$scope.newObjectif);
	  	  userDataService.addObjectif($scope.newObjectif).success(function(data) {
	  		$scope.objectifs.push({
	  			'libelle' : $scope.newObjectif.libelle,
	  			'id' : data
	  			});
              toaster.clear();
              toaster.pop('info', 'Ajout de l\'objectif avec succès');
	      }).error(function(data) {
              toaster.clear();
              toaster.pop('error', 'Erreur lors de l\'ajout de l\'objectif');
	      });
    };
    
    
    
    $scope.delObjectif = function(index) {	
	  	  userDataService.delObjectif($scope.objectifs[index]).success(function(data) {
	  		$scope.objectifs.splice(index, 1);
              toaster.clear();
              toaster.pop('info', 'Supression de l\'objectif avec succès');
	      }).error(function(data) {
              toaster.clear();
              toaster.pop('error', 'Erreur lors de la suppression de l\'objectif');
	      });
    };
    
    
    $scope.addObjectifExercice = function(newObjectifExercice, index) {	
    	$log.info('Ajout obj '+newObjectifExercice);
    	newObjectifExercice.idObjectif = $scope.objectifs[index].id;
	  	userDataService.addObjectifExercice(newObjectifExercice).success(function(data) {
	  		newObjectifExercice.id=data;
	  		$scope.objectifs[index].objectifExercices.push(newObjectifExercice);
              toaster.clear();
              toaster.pop('info', 'Ajout de l\'exerice dans l\'objectif avec succès');
	      }).error(function(data) {
              toaster.clear();
              toaster.pop('error', 'Erreur lors de l\'ajout de l\'objectif');
	      });
    };
    
    
    $scope.getTypesExercice();
    $scope.getObjectifs();
});
