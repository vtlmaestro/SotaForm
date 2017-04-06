<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:include page="formbackground.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="terminatesession.jsp"></jsp:include>
<html>
<head>
    <title>Upload File Response</title>
</head>
<br>
<%-- Using JSP EL to get message attribute value from request scope --%>
<%--<h2>${requestScope.message}</h2>--%>
</br>
</br>
</br>
<body>
<h1 align="center" style="margin-left: -110px;">Данные загружены успешно!</h1>
<h2 align="center" style="margin-left: -110px;">Номер созданной задачи - ${lastInsertId}</h2>
</body>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
<jsp:include page="../common/mainpage.jsp"></jsp:include>
</html>