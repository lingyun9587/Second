<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2018/6/5
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<body>
<p>文件上传热部署</p>


<script type="text/javascript" src="jquery-1.10.2.js"></script>
<script>


    $(function () {

    });
</script>
<form  action="/upload" method="post" enctype="multipart/form-data">
    <p><input type="file" name="t_pic"> <input type="submit"  id="sc" value="上传">   </p>
</form>


</body>
</html>
