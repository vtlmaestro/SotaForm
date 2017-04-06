<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="formbackground.jsp"></jsp:include>
<html>
<head>
    <title>SotaForm</title>
</head>
</br>
</br>
<form class="contact_form label" align="center" style="margin-left: 250px;" method="post" action="${pageContext.servletContext.contextPath}/terminateSession">
    <button style="margin-left: 620px;" class="submit" type="submit">Выход</button>
</form>
<body>
     <ul>

<h1 align="center" style="margin-left: -110px;">Данные успешно переданы!</h1>

</br>
</br>

<h2 align="center" style="margin-left: -110px;">Номер созданной задачи - ${lastInsertId}</h2>

</ul>
</br>
</br>
</br>
<form class="contact_form label" align="center" style="margin-left: 250px;" method="post" name="addtask" action="${pageContext.servletContext.contextPath}/addimageservlet" enctype="multipart/form-data">
     <ul>
         <li>
    <label>Загрузить скрин: </label>
            <input type="file" name="fileName" min="1" max="9999" name="file[]" multiple="true" required>
        </li>
         <li>
             <label>Тема:</label>
             <input type="string" name="subject" placeholder="сформулируйте тему задачи" required/>
             <%--<input type="text"  placeholder="John Doe" required />--%>
         </li>
     </ul>
    </br>
    </br>
            <button style="margin-right: 520px;" class="submit" type="submit">Отправить</button>
    </br>
    </br>
    </br>

</form>
</body>
</br>
<jsp:include page="../common/mainpage.jsp"></jsp:include>
</html>
