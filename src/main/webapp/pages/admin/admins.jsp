<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/formbackground.jsp"></jsp:include>
<jsp:include page="../common/terminatesession.jsp"></jsp:include>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<br>
<h2 align="center" style="margin-left: 5px;">Кабинет администратора</h2>
&nbsp;&nbsp;&nbsp;
<h3 align="left" style="margin-left: 550px;">Выберите операцию:</br>
    1. <a href="${pageContext.servletContext.contextPath}/pages/admin/addmovie.jsp">Добавить задачу</a> </br>
    2. <a href="${pageContext.servletContext.contextPath}/pages/admin/updatemovie.jsp">Обновить задачу</a> </br>
    3. <a href="${pageContext.servletContext.contextPath}/pages/admin/adduser.jsp">Добавить пользователя</a> </br>
    4. <a href="${pageContext.servletContext.contextPath}/pages/admin/updateuser.jsp">Обновить пользователя</a></br>
    5. <a href="${pageContext.servletContext.contextPath}/pages/admin/addrole.jsp">Добавить роль</a></br>
    6. <a href="${pageContext.servletContext.contextPath}/pages/admin/updaterole.jsp">Обновить роль</a></br>
    7. <a href="${pageContext.servletContext.contextPath}/pages/admin/seetask.jsp">Посмотреть задачу</a> </br>

</h3>
</body>
</html>
