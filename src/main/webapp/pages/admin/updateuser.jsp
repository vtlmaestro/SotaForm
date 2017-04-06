<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="headadmin.jsp"></jsp:include>
<html>
<head>
    <title>Updateuser</title>
</head>
<body>
<h3 align="center" style="margin-left: 300px;">Внесите новые регистрационные данные пользователя:</h3>
<form align="center" style="margin-left: 550px;" name="userForm" method="post" action="${pageContext.servletContext.contextPath}/updateUserServlet">
    Login: <input align="center" style="margin-left: 5px;" type="text" name="login"/> <br/>
    Password: <input align="center" style="margin-left: 9px;" type="text" name="password"/> <br/>
    Firstname: <input align="center" style="margin-left: 37px;"type="text" name="firstName"/> <br/>
    LastName: <input align="center" style="margin-left: 52px;" type="text" name="lastName"/> <br/>
    E-mail: <input align="center" style="margin-left: 31px;" type="text" name="email"/> <br/>
    Sex: <input align="center" style="margin-left: 52px;" type="text" name="sex"/> <br/>
    Birthday: <input align="center" style="margin-left: 16px;" type="dateDTO" name="birthday"/> <br/>
    Role_Name: <input align="center" style="margin-left: 31px;" type="text" name="role"/> <br/>
    Role_ID: <input align="center" style="margin-left: 16px;" type="int" name="role_id"/> <br/>
    ID: <input align="center" style="margin-left: 23px;" type="int" name="id" /> <br/>
    <input align="center" style="margin-left: 105px;" type="submit" value="Отправить" />
</form>
</body>
</html>
