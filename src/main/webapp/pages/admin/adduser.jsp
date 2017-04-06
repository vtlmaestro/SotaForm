<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="headadmin.jsp"></jsp:include>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3 align="center" style="margin-left: 300px;">Внесите ваши регистрационные данные:</h3>
<c:out value="${sessionScope.message}"/>
<form align="center" style="margin-left: 550px;" name="loginForm" method="post" action="${pageContext.servletContext.contextPath}/addUserServlet">
    Login: <input align="center" style="margin-left: 5px;" type="text" name="login"/> <br/>
    Password: <input align="center" style="margin-left: 9px;" type="text" name="password"/> <br/>
    Firstname: <input align="center" style="margin-left: 37px;"type="text" name="firstName"/> <br/>
    LastName: <input align="center" style="margin-left: 52px;" type="text" name="lastName"/> <br/>
    E-mail: <input align="center" style="margin-left: 31px;" type="text" name="email"/> <br/>
    Sex: <input align="center" style="margin-left: 52px;" type="text" name="sex"/> <br/>
    Birthday: <input align="center" style="margin-left: 16px;" type="dateDTO" name="birthday"/> <br/>
    ID_Role: <input align="center" style="margin-left: 16px;" type="int" name="role_id"/> <br/>
    <input align="center" style="margin-left: 105px;" type="submit" value="Отправить" />
</form>
</body>
</html>
