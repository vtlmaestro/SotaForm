<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="headadmin.jsp"></jsp:include>
<html>
<head>
    <title>Addrole</title>
</head>
<body>
<h3 align="center" style="margin-left: 300px;">Внесите новые данные:</h3>
<form align="center" style="margin-left: 550px;" name="sessionForm" method="post" action="${pageContext.servletContext.contextPath}/addSessionServlet">
    Hall_Id: <input align="center" style="margin-left: 5px;" type="int" name="hall_id"/> <br/>
    Movie_Id: <input align="center" style="margin-left: 16px;" type="int" name="movie_id"/> <br/>
    Price: <input align="center" style="margin-left: 16px;" type="BigDecimal" name="price"/> <br/>
    SessionTime: <input align="center" style="margin-left: 16px;" type="time" name="sessionTime"/> <br/>
    Date: <input align="center" style="margin-left: 16px;" type="DATE" name="dateDTO"/> <br/>
    <input align="center" style="margin-left: 105px;" type="submit" value="Отправить" />
</form>
</body>
</html>