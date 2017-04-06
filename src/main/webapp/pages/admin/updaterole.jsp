<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="headadmin.jsp"></jsp:include>
<html>
<head>
    <title>Updaterole</title>
</head>
<body>
<h3 align="center" style="margin-left: 300px;">Внесите новые данные:</h3>
<form align="center" style="margin-left: 550px;" name="loginForm" method="post" action="${pageContext.servletContext.contextPath}/updateRoleServlet">
    RoleName: <input align="center" style="margin-left: 5px;" type="text" name="role_name"/> <br/>
    RoleID: <input align="center" style="margin-left: 23px;" type="int" name="id" /> <br/>
    <input align="center" style="margin-left: 105px;" type="submit" value="Отправить" />
</form>
</body>
</html>
