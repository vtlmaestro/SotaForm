<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<form style="margin-top: -45px" method="post" action="${pageContext.servletContext.contextPath}/pages/user/addcommentform.jsp">--%>
<form style="margin-top: -45px" method="post" action="${pageContext.servletContext.contextPath}/seecomment?id=${task.id}" target="_blank">
    <button style="margin-left: 433px" class="submit" type="submit">Посмотреть комментарий</button>
</form>
