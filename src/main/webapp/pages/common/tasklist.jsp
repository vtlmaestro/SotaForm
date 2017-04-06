<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/imagelisttask.jsp"></jsp:include>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">

    <h2 align="center" style="margin-left: -10px; color: #2D5EFF">Список задач:</h2>
    <c:forEach items="${taskDTOList}" var="task">
        <br>
        <a align="center" style="margin-left: -20px; border-top-style: none" href="${pageContext.servletContext.contextPath}/gettaskservlet?id=${task.id}">Номер задачи:&nbsp;${task.id}&nbsp;&nbsp;Тема:&nbsp;${task.subject}</a><br/>
        <br>
    </c:forEach>
    <%--style="margin-left: -150px; border-top-style: inherit"--%>
</div>
<jsp:include page="../common/mainpage.jsp"></jsp:include>
</body>
</html>
