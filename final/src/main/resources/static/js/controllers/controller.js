/**
 * Created by assis on 17/03/17.
 */
app.controller('listaController', function($scope, $http) {


    ano = new Date().getFullYear();

    var arrayMes = new Array(12);
    arrayMes[0] = {numero:0, mes:"Janeiro"};
    arrayMes[1] = {numero:1, mes:"Fevereiro"};
    arrayMes[2] = {numero:2, mes:"Março"};
    arrayMes[3] = {numero:3, mes:"Abril"};
    arrayMes[4] = {numero:4, mes:"Maio"};
    arrayMes[5] = {numero:5, mes:"Junho"};
    arrayMes[6] = {numero:6, mes:"Julho"};
    arrayMes[7] = {numero:7, mes:"Agosto"};
    arrayMes[8] = {numero:8, mes:"Setembro"};
    arrayMes[9] = {numero:9, mes:"Outubro"};
    arrayMes[10] = {numero:10, mes:"Novembro"};
    arrayMes[11] = {numero:11, mes:"Dezembro"};

    $scope.mesDoAno = arrayMes;

    $scope.listaConsumo = [];
    $scope.acessaServicoLista = function(mes){
             $http.get('lista/'+  ano + "/" + (mes.numero+1) + "/")
            .success(function(lista){
                $scope.listaConsumo = lista;
            })
            .error(function(erro){
                console.log(erro);
            });
    };

    $scope.headingTitle = arrayMes[new Date().getMonth()].mes;
});
