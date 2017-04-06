<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/formbackground.jsp"></jsp:include>
<jsp:include page="../common/terminatesession.jsp"></jsp:include>
<jsp:include page="updatetask.jsp"></jsp:include>
<jsp:include page="addcomment.jsp"></jsp:include>
<jsp:include page="seecomment.jsp"></jsp:include>

<html>
<body>
<div align="center">

    <%--<jsp:forward page="../user/addcommentform.jsp">--%>
        <%--<jsp:param name="task_id"--%>
                   <%--value="${task.id}" />--%>
    <%--</jsp:forward>--%>

    <h2 align="center" style="margin-left: -10px; color: #214AFF" >Информация по задаче: ${idTask}</h2>
    <br>
    <ul>
        <li align="center" style="margin-left: 300px; color: #1926FF" class="show_info">
            Тема: <i>${task.subject}</i>
        </li>
        <br>
    <li align="center" style="margin-left: 300px; color: #1926FF" class="show_info">
        Текст ошибки: <i>${task.textError}</i>
    </li>
        <br>
    <li align="center" style="margin-left: 300px; color: #1926FF" class="show_info">
        Описание: <i>${task.description} </i>
    </li>
        <br>
    <li align="center" style="margin-left: 300px; color: #1926FF" class="show_info">
        Дата: <i>${task.dateTask} </i>
    </li>
        <br>
        <li align="center" style="margin-left: 300px; color: #1926FF" class="show_info">
           ЕДРПОУ: <i>${clientDTO.edrpou}</i>
        </li>
        <br>
        <li align="center" style="margin-left: 300px; color: #1926FF" class="show_info">
            E-mail: <i>${clientDTO.email}</i>
        </li>
        <br>
        <li align="center" style="margin-left: 300px; color: #1926FF" class="show_info">
           Телефон клиента: <i>${clientDTO.phoneClient}</i>
        </li>
        <br>
        <li align="center" style="margin-left: 300px; color: #1926FF" class="show_info">
            Автор задачи: <i>${clientDTO.authorTask}</i>
        </li>
        <br>
        <li align="center" style="margin-left: 300px; color: #1926FF" class="show_info">
            Внутренний номер консультанта: <i>${clientDTO.internaltelauthor}</i>
        </li>
        <br>
        </ul>
</div>
<div align="center" style="margin-left: 970px;">
    <h4 align="center" style="margin-left: 50px; color: #336BFF" >Вложенные файлы:</h4>
    <%--<c:out value="${request.getSession().getAttribute(message)}"></c:out>--%>
    <h5 align="center" style="margin-left: 50px; color: #FF4957"><c:out value="${notFound}"></c:out></h5>
    <c:forEach items="${arrayOnlyName}" var="listImage" varStatus="status">
        <%--<c:out value="${listImage}"/><br>  - вывод коллекции--%>
        <%--<a align="center" style="margin-left: 50px; " href="${pageContext.servletContext.contextPath}/showimage?id=${status.index}" target="new_blank">${listImage}</a><br/>--%>
        <a align="center" style="margin-left: 50px; " href="${pageContext.servletContext.contextPath}/showimage?name=${listImage}&idTask=${idTask}" target="new_blank">${listImage}</a><br/>
    </c:forEach>
</div>
<jsp:include page="../common/mainpage.jsp"></jsp:include>
</body>
</html>

