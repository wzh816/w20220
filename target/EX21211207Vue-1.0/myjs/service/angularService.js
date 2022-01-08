
app.service('indexService',function ($http) {
    this.getTeacherSelect=function (pageNum,pageSize,teacherSibe) {
        var url='TeacherController/TeacherSelect.do?pageNum='+pageNum+'&pageSize='+pageSize;
        return  $http.post(url,teacherSibe);
    }
    this.deleteTeacher=function (tid) {
        return  $http.post('TeacherController/TeacherDelete.do?tid='+tid);
    }
    this.updateTeacher=function (tid) {
        return $http.post('TeacherController/TeacherById.do?tid='+tid);
    }
    this.ctrl_s=function (teacher) {
        return $http.post('TeacherController/TeacherAddUpdate.do',teacher);
    }
})