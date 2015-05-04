/************************************************************************************************************************************** 	
*	17.02.2015 Hilde T L Rafaelsen
*	Her definerer vi alle controller som brukes i applikasjonen. Controllerene blir kaldt fra fila altinn-services-module.js	
*	Vi har en controller pr view og et view defineres i en egen templalate html fil (se altinn-service-module).
*	Alle servicer som brukes av controllerene ligger i filene altinn-service-services.js og fila altinn-rest-service.js
*
***************************************************************************************************************************************/


// Controller som tar vare på og viser det som skal stå under oppsummeringen når brukeren trykker på oppsummeringsknappen.

altinnservice.controller('OppsummeringController', ['$scope', 'AltinnRestService','BarnehageService','BarnService','AnnenInfoService', function ($scope, AltinnRestService, BarnehageService, BarnService, AnnenInfoService) {
		AltinnRestService.profile().then(function(profile) {
			$scope.me = profile;
		}, function (error) {
			$scope.error = error;
		});

		$scope.sendSkjema = function () {
			var soknadsvalg = {
				valgteBarn: BarnService.getValgteBarn(),
				valgteBarnehager: BarnehageService.getValgteBarnehager(),
				forstePri: BarnehageService.getForstePri(),
				annenInfo: AnnenInfoService.getAnnenInfo(),
				profile: $scope.me
			};

			AltinnRestService.sendSkjema(soknadsvalg);
		};
}]);


// Controller som viser kvitteringen til brukeren.
// AltinnRestService.profile funksjonen henter data fra profilen til brukeren som er logget inn i Altinn gjennom angularRest factory som er satt
// opp i fila altinn-rest-service.js
// Vi fjerner samtidig alle valgte barnehager, barn og info
//
altinnservice.controller('KvitteringController', ['$scope', 'AltinnRestService','BarnehageService','BarnService','AnnenInfoService', function ($scope, AltinnRestService, BarnehageService, BarnService, AnnenInfoService) {
		AltinnRestService.profile().then(function(profile) {
			$scope.me = profile;
		}, function (error) {
			$scope.error = error;
		});

		BarnehageService.resetValgteBarnehager();
		BarnService.resetValgteBarn();
		AnnenInfoService.resetAnnenInfo();

}]);

// Controller som henter ut alle barnehager
altinnservice.controller('VisBarnehage', ['$scope', 'BarnehageService', function ($scope, BarnehageService) {
		$scope.barnehager = BarnehageService.alleBarnehager();
}]);



// Controller som henter ut informasjon om brukeren som er logget inn i Altinn
// $scope.$watch står og lytter etter endringer noe som gjør at vi kan få ut data om innlogget bruker
// med det samme at applikasjonen starter
altinnservice.controller('Personalia', ['$scope', 'AltinnRestService', function ($scope, AltinnRestService) {
	 $scope.$watch(AltinnRestService.profile().then(function(profile) {
			$scope.me = profile;
		}));		
}]);

// Controller som henter ut alle barn og tar vare på de barnene som er valgt
altinnservice.controller('BarnController', ['$scope', 'BarnService', function ($scope, BarnService) {

	$scope.barneListe = BarnService.getBarn();
	$scope.valgteBarn = BarnService.getValgteBarn();

	$scope.velgBarn = function(barn){
		BarnService.velgBarn(barn);
	};

	$scope.fjernBarn = function(barn) {
		BarnService.fjernBarn(barn);
	};


	$scope.erBarnValgt = function(barn) {
		return _.contains(BarnService.getValgteBarn(), barn);
	}

}]);

// Controller som tar vare på det som bruker skriver under annen info 
altinnservice.controller('AnnenInfo', ['$scope', 'AnnenInfoService', function ($scope, AnnenInfoService) {

	$scope.$watch('typePlass', function (type) {
		$scope.typePlass = type;
	});

	$scope.AnnenInfo = AnnenInfoService.getAnnenInfo();
	
	$scope.setAnnenInfo = function(info){
		AnnenInfoService.setAnnenInfo(info);
	};

	$scope.getAnnenInfo = function(){
		return AnnenInfoService.getAnnenInfo();
	};


}]);

// Controller som styrer hvilke tabs/overskrifter som skal markeres i menyen. Denne controlleren blir kaldt direkte fra
// index.html
altinnservice.controller('HeaderController', ['$scope', '$location', function ($scope, $location) { 
    $scope.isActive = function (viewLocation) { 
        return viewLocation === $location.path();
    };
}])


// Controller som viser og tar vare på valgte barnehager, barnehagetype og prioritet av barnehager
altinnservice.controller('BarnehageController', ['$scope', 'BarnehageService', function ($scope, BarnehageService) {
	$scope.valgteBarnehager = BarnehageService.getValgteBarnehager();
	$scope.forstePri = BarnehageService.getForstePri();


	$scope.$watch('typeBarnehage', function (type) {
		$scope.barnehageListe = BarnehageService.filterBarnehager(type);
	});

	$scope.velgBarnehage = function(barnehage){
		if(BarnehageService.getValgteBarnehager().length < 3) {
			BarnehageService.velgBarnehage(barnehage);

			// Hvis dette er den første barnehagen valgt, skal denne default settes til første prioritet
			if(BarnehageService.getValgteBarnehager().length === 1) {
				BarnehageService.setForstePri(BarnehageService.getValgteBarnehager()[0]);
			}
		}

		else {
			alert("Du har valgt maksimalt antall barnehager.");
		}
	};

	$scope.fjernBarnehage = function(barnehage) {
		
		BarnehageService.fjernBarnehage(barnehage)
		
		// Hvis denne barnehagen har 1. prioritet, sett 1. prioritet på første barnehage i valgteBarnehager
		if(BarnehageService.getForstePri() === barnehage) {
			BarnehageService.setForstePri(BarnehageService.getValgteBarnehager()[0]);
		}
	};

	$scope.settForstePri = function(barnehage) {
		BarnehageService.setForstePri(barnehage);
	};

	$scope.getForstePri = function(barnehage) {
		return BarnehageService.getForstePri();
	};


	$scope.erBarnehageValgt = function(barnehage) {
		return _.contains(BarnehageService.getValgteBarnehager(), barnehage);
	}
}]);

