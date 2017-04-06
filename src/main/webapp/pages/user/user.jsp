<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<jsp:include page="../common/other.jsp"></jsp:include>
<jsp:include page="../common/terminatesession.jsp"></jsp:include>

<html>
<head>
    <title>SotaForm</title>
</head>
<body>
<%--<h2 align="center" style="margin-left: 270px;">Страница пользователя</h2>--%>
<h3 align="left" style="margin-left: 500px;">Выберите операцию:</br>
    </br>
    </br>
    <form class="contact_form label" align="left" style="margin-left: -200px;">
        <div>
    <ul>
        <li>
           <span style="font-family: 'Calibri Light';"><a href="${pageContext.servletContext.contextPath}/pages/user/addtask.jsp">Внести данные для задачи</a></span>
        </li>
        <li>
           <span style="font-family: 'Calibri Light';"><a href="${pageContext.servletContext.contextPath}/pages/user/searchbynumber.jsp">Обновить данные в задаче</a> </span>
        </li>
        <li>
           <span style="font-family: 'Calibri Light';"><a href="${pageContext.servletContext.contextPath}/tasklist">Просмотр списка созданных задач</a> </span>
        </li>
        <li>
           <span style="font-family: 'Calibri Light';"><a href="${pageContext.servletContext.contextPath}/pages/user/searchbynumber.jsp">Найти задачу по номеру</a> </span>
        </li>
        <li>
           <span style="font-family: 'Calibri Light';"><a href="${pageContext.servletContext.contextPath}/pages/user/addletter.jsp">Письмо клиента для переноса предприятия в другую учетную запись</a> </span>
        </li>
    </ul>
            </div>
    </form>
</h3>
</body>
</html>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
<%--<jsp:include page="../common/mainpage.jsp"></jsp:include>--%>