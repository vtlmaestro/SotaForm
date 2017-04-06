<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/formbackground.jsp"></jsp:include>
<html>
<head>
    <title>seeTask</title>
</head>
<body>
<form class="contact_form label" align="center" style="margin-left: 250px;" method="post" name="addtask" action="${pageContext.servletContext.contextPath}/gettaskservlet">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <ul>
        <li>
            <h2>Внесите номер задачи:</h2>
            <%--<span class="required_notification">* Denotes Required Field</span>--%>
        </li>
        <li>
            <label>№:</label>
            <%--<output>--%>
            <input type="int" name="id"  placeholder="не более 10-ти цифр" required pattern="[0-9]{0,999999}"/>
        </li>
    </ul>
    <button style="margin-left: 620px;" class="submit" type="submit">Получить данные</button>
    </form>
</body>
</html>
