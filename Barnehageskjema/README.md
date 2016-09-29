# Barnehageskjema example using Altinn API

This is an example implementation of a responsive web application that can run outside the Altinn portal, using the [Altinn API](https://altinn.no/api/help). 

It is developed using [AngularJS](https://github.com/angular/angular.js) and [Bootstrap](https://github.com/twbs/bootstrap).
AngularJS and [restantangular](https://github.com/mgonto/restangular) are used for the communication with Altinn, 
whilst the Bootstrap framework is used to facilitate a responsive UI that looks decent on tablets and smartphones.

The definition of the service is created in the Altinn Service Development tool (TUL) but the application is created and 
runs on your own server.  

## Setup
The application uses Grunt and Compass/SASS as building blocks on the server. 
Before setting up the application you have to install the following:

1.   http://gruntjs.com/getting-started  (requires NPM)
2.   http://sass-lang.com/install (Command line. Requires Ruby)
3.   http://compass-style.org/install/ 

When Grunt, Sass and Compass are up and running, you can unzip the application library and store it on your server or local PC. 
After unzipping the file, follow these steps:

1. Open two command prompt windows (run CMD on windows)
2. Navigate to the catalog where[eok1] the grunt file (Gruntfile.js) is located 
3. Run grunt watch in the first CMD window. Grunt watch listens for code changes 
4. Run grunt connect in the second CMD window. Grunt connect starts an internal webserver on localhost

Angular controllers, modules, services and HTML template files can be found in the scripts/apps catalog. 
The Grunt Configuration is found in [Gruntfile.js](https://github.com/Altinn/ExampleCode/blob/master/Barnehageskjema/Gruntfile.js) and all styles are stored in [/styles/sass/bootstrap](https://github.com/Altinn/ExampleCode/tree/master/Barnehageskjema/styles/sass/bootstrap).

More documentation for Altinn REST-API can be found here: https://altinnett.brreg.no/no/Altinn-API/

