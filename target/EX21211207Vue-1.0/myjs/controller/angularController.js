var app=angular.module('angular',[]);
app.controller('indexController',function ($scope,$controller,indexService) {
    $controller('baseController',{$scope:$scope});
    $scope.getTeacherSelect=function () {

       indexService.getTeacherSelect($scope.pageNum,$scope.pageSize,$scope.teacherSibe).success(function (response) {
            $scope.page=response;
            $scope.list=response.list;
            $scope.pageNum=response.pageNum;
        })
    },

    $scope.deleteTeacher=function (tid) {
       indexService.deleteTeacher(tid).success(function (response) {
            if(response.goon){
                $scope.getTeacherSelect();
            }else{
                alert($scope.uname);
            }
        })
    }
    $scope.addTeacher=function () {
        $scope.teacher={};
        document.getElementById("angularTablediv").style.display="block";
    }
    $scope.updateTeacher=function (tid) {

        indexService.updateTeacher(tid).success(function (response) {
            document.getElementById("angularTablediv").style.display="block";
            $scope.teacher=response;
        })
    }
    $scope.ctrl_s=function () {
      indexService.ctrl_s($scope.teacher).success(function (response) {

            if(response.goon){
                document.getElementById("angularTablediv").style.display="none";

                $scope.getTeacherSelect();
            }else{
                alert($scope.uname);
            }
        })
    }

})