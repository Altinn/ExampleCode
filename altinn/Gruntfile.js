module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    concat: {
      options: {
        separator: '\n\n/* --- Ny fil --- */ \n\n'
      },
      altinn: {
        src: ['scripts/libs/lodash.compat.min.js',
          'scripts/libs/angular/angular.min.js',
          'scripts/libs/angular/angular-route.min.js',
          'scripts/libs/angular/restangular.min.js',
          'scripts/libs/angular/angular-locale_no.js',
          'scripts/libs/angular/ui-bootstrap-tpls.min.js',
          'scripts/apps/altinn-service/altinn/*.js',
          'scripts/apps/altinn-service/**/*-module.js',
          'scripts/apps/altinn-service/**/*.js',
          'scripts/apps/radiobuttons/**/*-module.js',
          'scripts/apps/radiobuttons/**/*.js'],
        dest: 'scripts/packed/altinn.packed.js'
      }
    },
    jshint: {
      files: ['scripts/apps/**/*.js'
      ],
      options: {
        // options here to override JSHint defaults
        globals: {
          jQuery: true,
          console: true,
          module: true,
          document: true,
          angular: true
        }
      }
    },
    compass: {
      altinn: { // Target
        options: { // Target options
          sassDir: 'styles/sass',
          specify: 'styles/sass/main.scss',
          cssDir: 'styles/packed',
          environment: 'production',
          imagesDir: "images",
          outputStyle: "compressed"
        }
      }
    },
    watch: {
      options: {
        debounceDelay: 250,
        livereload: true
      },
      styles: {
        files: ['styles/sass/**/*.scss'],
        tasks: ['compass']
      },
      images: {
        files: ['images/**/*'],
        tasks: ['compass']
      },
      scripts: {
        files: ['scripts/**/*.js', '!scripts/packed/**/*.js'],
        tasks: ['concat']
      }
    },
    connect: {
      server: {
        options: {
          port: 9001,
          keepalive: true
        }
      }
    }
  });

  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-connect');
  grunt.loadNpmTasks('grunt-contrib-compass');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-watch');

  grunt.registerTask('default', ['jshint', 'concat', 'compass']);
  grunt.registerTask('js', ['jshint', 'concat']);
};
