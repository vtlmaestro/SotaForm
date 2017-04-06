<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/formbackground.jsp"></jsp:include>
<jsp:include page="../common/terminatesession.jsp"></jsp:include>
<html>
<head>
    <title>Answer</title>
</head>
<body>
<%--<body style="border-top-style: ridge">--%>
<h3 align="center" style="margin-left: -100px; color: #45A4FF">Комментарий к задаче №${task_id}</h3>
        <c:forEach items="${answerTaskDTOList}" var="commentList">

<h4 style="border-top-style: ridge"></h4>
    <br>
            <a align="center" style="margin-left: 400px; color: #214AFF"><i>Комментарий: </i>${commentList.nameAuthor}<i>  (</i>${commentList.time}<i>)</i></a><br>
            <br>
            <a align="center" style="margin-left: 100px; color: #214AFF">${commentList.comment}</a><br>
</h4>
        </c:forEach>

</body>
<%--<c:forEach var="person" items="${people.people}">--%>
    <%--<tr>--%>
        <%--<td>${person.name}</td>--%>
        <%--<td>${person.age}</td>--%>
        <%--<td>${person.height}</td>--%>
    <%--</tr>--%>
<%--</c:forEach>--%>
     <%--<div align="center" style="margin-left: 300px;">--%>
        <%--&lt;%&ndash;<i>Комментарий: </i>${answerTaskDTO.comment}<br>&ndash;%&gt;--%>
         <%--&lt;%&ndash;<i>Автор: </i>${answerTaskDTO.nameAuthor}<br>&ndash;%&gt;--%>
           <%--<i>Комментарий: </i>${answerTaskDTOList}--%>
      <%--</div>--%>
  <%--</div>--%>
  <%--</body>--%>
</html>
<%--<a align="center" style="margin-left: 50px;">Комментарий от ${commentList.nameAuthor}: ${commentList.time}&nbsp; ${commentList.comment}</a>--%>