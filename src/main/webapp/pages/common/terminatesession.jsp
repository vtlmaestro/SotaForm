<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="formbackground.jsp"></jsp:include>
<br>
<form  style="margin-top: -2px;" method="post" action="${pageContext.servletContext.contextPath}/terminateSession">
    <button style="margin-left: 1225px;" class="submit" type="submit">Выход</button>
</form>
