var app = angular.module('consumo', ['ngRoute','ngResource']);

app.config(function($routeProvider){

    $routeProvider
        .when('/',{
            templateUrl: '/views/lista.html',
            controller: 'listaController'})
        .otherwise( { redirectTo: '/'});
});
