/**************************************************************************************************************************************   
* 17.02.2015 Hilde T L Rafaelsen
* Her definerer vi alle factories og funksjoner som brukes i vår applikasjon, foruten de funksjoner som omhandler
* altinn-rest. De ligger i en egen fil altinn-rest-service.js
*
***************************************************************************************************************************************/




altinnservice.factory('BarnehageService', function() {
  var kommunal = [
    {
      id: 1,
      navn: "Tassen barnehage",
      adresse: "Brynsengfaret 6A",
      postnr: "0196",
      poststed: "Oslo",
      webside: "http://www.tassenbhg.no",
      type: "Kommunal"
    },
    {
      id: 2,
      navn: "Nasse nøff barnehage",
      adresse: "Østensjøveien 69",
      postnr: "0196",
      poststed: "Oslo",
      webside: "http://www.nassenuffbhg.no",
      type: "Kommunal"
    },
    {
      id: 3,
      navn: "Ole Brum barnehage",
      adresse: "Karl Johans gate 4",
      postnr: "0196",
      poststed: "Oslo",
      webside: "http://www.olerbrumbhg.no",
      type: "Kommunal"
    },

    {
      id: 4,
      navn: "Knerten barnehage",
      adresse: "Nordgata 12",
      postnr: "0196",
      poststed: "Oslo",
      webside: "http://www.knerten.no",
      type: "Kommunal"
    }



  ];

  var privat = [
    {
      id: 4,
      navn: "Sola barnehage",
      adresse: "Bogstadveien 5",
      postnr: "0196",
      poststed: "Oslo",
      webside: "http://www.solbhg.no",
      type: "Privat"
    },
    {
      id: 5,
      navn: "Reirstubben barnehage",
      adresse: "Hausmannsgate 44",
      postnr: "0196",
      poststed: "Oslo",
      webside: "http://www.reirbhg.no",
      type: "Privat"
    },
    {
      id: 6,
      navn: "Blåbæret barnehage",
      adresse: "Tøyengata 8",
      postnr: "0196",
      poststed: "Oslo",
      webside: "http://www.blåbarbhg.no",
      type: "Privat"
    }
  ];

  var valgteBarnehager = [];
  var forstepri = [];

  var barnehageService = {};


  barnehageService.alleBarnehager = function() {
      return kommunal.concat(privat);
  }

  barnehageService.filterBarnehager = function(type) {
      // Kode for å hente barnehager ut i fra type her, implementert kjempeenkelt for eksempelet sin del

      if(type === "kommunal") {
        return kommunal;
      }

      else if(type === "privat") {
        return privat;
      }
  }

  barnehageService.getValgteBarnehager = function (barnehage) {

    return valgteBarnehager;
  }

  barnehageService.velgBarnehage = function(barnehage) {
    valgteBarnehager.push(barnehage);
  }

  barnehageService.fjernBarnehage = function(barnehage) {
    _.pull(valgteBarnehager, barnehage);
  }

  barnehageService.setForstePri = function (barnehage) {
    forstepri = [];
    forstepri.push(barnehage);
  }

  barnehageService.getForstePri = function () {
    return forstepri[0];
  }



  barnehageService.resetValgteBarnehager = function () {
    valgteBarnehager = [];
    forstepri = [];
  }


  return barnehageService;

});




altinnservice.factory('BarnService', [function(){
    var barn =[{
          navn: "Emma Amundsen",
          fnummer: "12040512345"
        },
        {
          navn: "Aksel Amundsen",
          fnummer: "06090798745"
        }];

    var valgteBarn = []
    
    var barnService = {};

    barnService.getBarn = function () {
        return barn;
      }

    barnService.getValgteBarn = function() {
      return valgteBarn;
    }

    barnService.velgBarn = function(barn) {
      valgteBarn.push(barn);
    }

    barnService.fjernBarn = function(barn) {
        _.pull(valgteBarn, barn);
    }

    barnService.resetValgteBarn = function () {
      valgteBarn = [];
    }

    return barnService;

  }]);


altinnservice.factory('AnnenInfoService', [function(){
    var anneninfo =[];

    var annenInfoService = {};

    annenInfoService.getAnnenInfo = function () {      
        return anneninfo[0];
      }

    annenInfoService.setAnnenInfo = function (info) {      
        anneninfo = [];
        anneninfo.push(info);
    }

    annenInfoService.resetAnnenInfo = function () {
      anneninfo = [];
    }

    return annenInfoService;

  }]);

