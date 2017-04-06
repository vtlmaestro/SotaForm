<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<form style="margin-top: -45px" method="post" action="${pageContext.servletContext.contextPath}/pages/user/addcommentform.jsp">--%>
    <form style="margin-top: -45px" method="post" action="${pageContext.servletContext.contextPath}/addcomment?id=${task.id}">
    <button style="margin-left: 3px" class="submit" type="submit">&nbsp;&nbsp;Добавить комментарий&nbsp;&nbsp;</button>
</form>
