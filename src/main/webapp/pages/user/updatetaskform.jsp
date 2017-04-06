<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/formbackground.jsp"></jsp:include>
<script type="text/javascript">
    function clock() {
        var d = new Date();
        var month_num = d.getMonth();
        var day = d.getDate();
        var hours = d.getHours();
        var minutes = d.getMinutes();
        var seconds = d.getSeconds();

        month=new Array("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");

        if (day <= 9) day = "0" + day;
        if (hours <= 9) hours = "0" + hours;
        if (minutes <= 9) minutes = "0" + minutes;
        if (seconds <= 9) seconds = "0" + seconds;

        date_time = day+"."+month[month_num]+"."+d.getFullYear()+" - "+ hours + ":" + minutes + ":" + seconds;
//        date_time = "Сегодня - " + day + " " + month[month_num] + " " + d.getFullYear() +
//                " г.&nbsp;&nbsp;&nbsp;Текущее время - "+ hours + ":" + minutes + ":" + seconds;
        if (document.layers) {
            document.layers.doc_time.document.write(date_time);
            document.layers.doc_time.document.close();
        }
        else document.getElementById("doc_time").innerHTML = date_time;
        setTimeout("clock()", 1000);
    }
</script>
<html>
<head>
    <title>updateTask</title>
    <br>
    <h1 style="margin-left: 500px;">Функция в доработке!!!</h1>
</head>
<body style="border-top-style: ridge">
<form class="contact_form label" align="center" style="margin-left: 250px;" method="post" name="addComment" action="${pageContext.servletContext.contextPath}/addanswer?id=${id_task}" enctype="multipart/form-data">
    <br>
    <ul>
        <li>
            <h2 style="color: #336BFF">Обновить задачу: ${id_task}</h2>
            <%--<span class="required_notification">* Denotes Required Field</span>--%>
        </li>
        <li>
            <label>Дата:</label>
            <%--<output>--%>
            <%--hidden="hidden"--%>
            <textarea rows="1" id="doc_time" name="datetask" readonly></textarea>
            <script type="text/javascript">clock();</script>
        </li>
        <li>
            <label>Комментарий:</label>
            <textarea type="text" name="comment" required></textarea>
        </li>
        <li>
            <label>Загрузить скрин: </label>
            <input type="file"  name="fileName" min="1" max="9999" name="file[]" multiple="true">
        </li>
    </ul>
    <button style="margin-left: 620px;" class="submit" type="submit">Добавить</button>
</form>
</body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<jsp:include page="../common/mainpage.jsp"></jsp:include>
</html>
