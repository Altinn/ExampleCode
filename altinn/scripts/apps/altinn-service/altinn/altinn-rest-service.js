/**************************************************************************************************************************************   
* 17.02.2015 Hilde T L Rafaelsen
* Her definerer vi en altinn-rest modul som bruker restangular. Se https://github.com/mgonto/restangular
*
***************************************************************************************************************************************/


// Konfigurasjon av altinn-rest
// Endre setBaseURL til produksjonsmiljø om du skal kjøre applikasjonen i produksjon
// Kontakt AAS for å få en ApiKey og lim den inn i klammene {}

var altinnRest = angular.module('altinn-rest', ['restangular']);

altinnRest.factory('AltinnRestConfig', ['Restangular', function(Restangular){
    return Restangular.withConfig(function(RestangularConfigurer) {
      RestangularConfigurer.setBaseUrl('https://tt02.altinn.basefarm.net/api');
      RestangularConfigurer.setDefaultHttpFields({
        'withCredentials': true
      });
      RestangularConfigurer.setDefaultHeaders({
        'X-Requested-With': 'XMLHttpRequest',
        'ApiKey': '{}',
        'Content-Type': 'application/hal+json',
        'Accept': 'application/hal+json'
      });
    });
  }]);


// Factory funksjon som fyller en XML med data og sender den over til Altinn gjennom rest API
altinnRest.factory('AltinnRestService', ['AltinnRestConfig',
    function(AltinnRestConfig){

    var altinnSoknadOmBarnehage = function (soknadsvalg) {
        
      // DataFormatID og dataFormatVersion får du fra XSD som er definert på tjenesten i TUL
      var xml = "<melding dataFormatProvider=\"SERES\" dataFormatId=\"4600\" dataFormatVersion=\"32968\"><Innhold><oversiktBarn>";

      angular.forEach(soknadsvalg.valgteBarn, function (barn, key) {

        xml+= "<barn><foedselsnummer>"+barn.fnummer+"</foedselsnummer><fornavn>"+barn.navn+"</fornavn><etternavn>Trana</etternavn><morsmaal>Norsk</morsmaal>" +
                    "<kommentar>"+soknadsvalg.annenInfo+"</kommentar></barn>";
      });

      xml +="</oversiktBarn><oversiktBarnehage>";

      angular.forEach(soknadsvalg.valgteBarnehager, function (barnehage, key) {

        xml +="<barnehage><navn>" +barnehage.navn +"</navn><prioritet>"+ (soknadsvalg.forstePri === barnehage ? '1' : '0') + "</prioritet><omBarnehagen></omBarnehagen></barnehage>";

      });

      xml +="</oversiktBarnehage></Innhold></melding>";

        return xml;
    };


    return {
      sendSkjema: function (soknadsvalg) {

        //ServiceCode, ServiceCodeEdition, DataFormatId og DataFormatVersion får du fra tjenesten som er opprettet i TUL
        var json_obj = {
          "Type": "FormTask",
          "ServiceCode": "3863",
          "ServiceEdition": 1,
          "_embedded" : {
            "forms" : [
              {
                "Type": "MainForm",
                "DataFormatId": "4600",
                "DataFormatVersion": "32968",
                "FormData": altinnSoknadOmBarnehage(soknadsvalg)
              }
            ]
          }
        };

        return AltinnRestConfig.all('my/messages').post(json_obj);
      },

      profile: function () {
        return AltinnRestConfig.one('my/profile').get();
      }
    };
  }
]);
