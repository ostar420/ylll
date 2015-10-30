<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>测试页面</title>
        <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.min.js"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            .pageDetail {
                display: none;
            }

            .show {
                display: table-row;
            }
        </style>
        <script>
            function click1(){
                var tmp = {};
                tmp.project_seq='j8TX0NoZxK/PL4G7u94fHQ==';
                tmp.project_version='1.0';
                var obj = {};
                obj.name='onmygod';
                obj.id='113';
                obj.tel='13';
                obj.phone='13';
                obj.email='13@email.com';
                obj.address='13';

                tmp.data = JSON.stringify(obj);
                
                callPost('./user/add',tmp);
                
            }
            function callPost(url,data){
                $.post(url,data,function(result){
                    $("#spanMsg").html(result);
                });
            }

        </script>
    </head>
    <body>
        <input type="button" value="button1" onclick="click1();"/>
        <input type="button" value="button2"/>
        <input type="button" value="button3"/>
        <div id="spanMsg">
            
        </div>
    </body>
</html>