// Karma configuration
// Generated on Sun Dec 08 2013 09:01:46 GMT+0000 (GMT)

module.exports = function(config) {
  config.set({

    // base path, that will be used to resolve files and exclude
    basePath: '../',


    // frameworks to use
    frameworks: ['jasmine'],


    // list of files / patterns to load in the browser
    files: [
      'public/javascripts/angular.js',
      'test/js/lib/angular-*.js',
      'app/assets/javascripts/**/*.js',
      'app/assets/javascripts/**/*.coffee',
      //'target/scala-2.10/resource_managed/main/public/javascripts/**/*.js',
      'test/js/specs/**/*.spec.js',
      'test/js/specs/**/*.spec.coffee',
      'test/js/mocks/**/*.js'
    ],


    // list of files to exclude
    exclude: [
      'public/javascripts/**/*.min.js',
      'target/scala-2.10/resource_managed/main/public/javascripts/**/*.min.js',
      '**/*.swp'
    ],


    // test results reporter to use
    // possible values: 'dots', 'progress', 'junit', 'growl', 'coverage'
    reporters: ['progress'],


    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    // Start these browsers, currently available:
    // - Chrome
    // - ChromeCanary
    // - Firefox
    // - Opera (has to be installed with `npm install karma-opera-launcher`)
    // - Safari (only Mac; has to be installed with `npm install karma-safari-launcher`)
    // - PhantomJS
    // - IE (only Windows; has to be installed with `npm install karma-ie-launcher`)
    browsers: ['PhantomJS'],

    plugins : [
            'karma-junit-reporter',
            'karma-chrome-launcher',
            'karma-phantomjs-launcher',
            'karma-coffee-preprocessor',
            'karma-jasmine'
            ],

    // If browser does not capture in given timeout [ms], kill it
    captureTimeout: 60000,

    junitReporter : {
        outputFile: 'target/unit.xml',
        suite: 'unit'
    },

    // Continuous Integration mode
    // if true, it capture browsers, run tests and exit
    singleRun: false
  });
};
