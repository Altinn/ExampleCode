/*  16.02.2015 Hilde T Lauvset Rafaelsen
*
*   Her definerer vi vår angular module "AltinnService". Modulen er en container for AltinnService sine controllere.
*   Routeprovider konfigurere "rutene" som bruker kan ta i applikasjonen og viser koblingen  mellom en kontroller
*   og en template fil. Hver template fil definerer et eget view. 
*
**********************************************************************************************************************/





var altinnservice = angular.module('AltinnService', [
  'ngRoute',
  'altinn-rest',
  'ui.bootstrap'
]);


altinnservice.config(
  ['$routeProvider',
    function($routeProvider) {
      $routeProvider
        .when('/', {
          templateUrl: 'scripts/apps/altinn-service/velg-barnehage.html',
          controller: 'BarnehageController'
        })

         .when('/personalia', {
          templateUrl: 'scripts/apps/altinn-service/personalia.html',
          controller: 'Personalia'
        })

        .when('/barnehager', {
          templateUrl: 'scripts/apps/altinn-service/vis-barnehage.html',
          controller: 'VisBarnehage'
        })

        .when('/oppsummering', {
          templateUrl: 'scripts/apps/altinn-service/oppsummering.html',
          controller: 'OppsummeringController'
        })

        .when('/kvittering', {
          templateUrl: 'scripts/apps/altinn-service/kvittering.html',
          controller: 'KvitteringController'
        })

        .when('/annet', {
          templateUrl: 'scripts/apps/altinn-service/annet.html',
          controller: 'AnnenInfo'
        })

        .when('/velgBarnehage', {
          templateUrl: 'scripts/apps/altinn-service/velg-barnehage.html',
          controller: 'BarnehageController'
        })

        .otherwise({
          redirectTo: '/'
        });
    }
  ]
);
