
app.controller('baseController',function ($scope) {
    $scope.list=[];
    $scope.teacherSibe={};
    $scope.teacher={};
    $scope.page={};
    $scope.pageNum=1;
    $scope.pageSize=3;
    $scope.on=function (pageNum) {
        if(pageNum==0){
            pageNum=1;
        }
        $scope.pageNum=pageNum;
        $scope.getTeacherSelect();
    }
})

