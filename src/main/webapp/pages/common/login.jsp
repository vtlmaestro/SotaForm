<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="other.jsp"></jsp:include>
<html>
<head>
    <title>SotaForm</title>
</head>
<body>
<%--<h2 align="center" style="margin-left: 300px;">Авторизация:</h2>--%>
<c:out value="${sessionScope.message}"/>

<%--<form align="center" style="margin-left: 620px;" name="loginForm" method="post" action="${pageContext.servletContext.contextPath}/login">--%>
    <%--Login:    <input type="text" name="login"/> <br/>--%>
    <%--Password: <input type="password" name="password"/> <br/>--%>
    <%--<input type="submit" value="Login" />--%>
<%--</form>--%>
<div style="margin-left: 520px;" id="login-form">
    <h1>АВТОРИЗАЦИЯ</h1>
    <fieldset>
        <form method="post" action="${pageContext.servletContext.contextPath}/login">
            <label>Логин:</label>
            <input type="text" name="login">
            <label>Пароль:</label>
            <input type="password" name="password">
            <input type="submit" value="ВОЙТИ">
        </form>
    </fieldset>
</div>
</body>
<%--<jsp:include page="mainpage.jsp"></jsp:include>--%>
</html>
