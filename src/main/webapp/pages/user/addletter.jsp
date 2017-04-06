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
<%--Выбор браузера--%>
<%--<%--%>
    <%--String sUserAgent = null;--%>
    <%--boolean bIsIE = false;--%>
    <%--boolean bIsMozilla140_a1 = false;--%>
    <%--if (request != null) {--%>
        <%--sUserAgent = request.getHeader("user-agent");--%>
        <%--bIsIE = sUserAgent.indexOf("MSIE") >= 0;--%>
        <%--bIsMozilla140_a1 = sUserAgent.indexOf("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:14.0) Gecko/20120405 Firefox/14.0a1") >= 0;--%>

    <%--}--%>

    <%--if (bIsIE) {--%>
<%--// ... Клиентский запрос пришел от Internet Explorer--%>



    <%--} else if (bIsMozilla140_a1) {--%>

<%--// ... Запрос пришел от Mozilla Firefox версии 14.0a1--%>

    <%--} else {--%>


    <%--}--%>
<%--%>--%>

<html>
<body  style="border-top-style: ridge">
<c:out value="${sessionScope.message}"/>
<form class="contact_form label" align="center" style="margin-left: 250px;" method="post" name="addtask" action="${pageContext.servletContext.contextPath}/addletterservlet" enctype="multipart/form-data">
    <ul>
        <%--<li>--%>
        <%--<h2>Внесите информацию по задаче:</h2>--%>
        <%--&lt;%&ndash;<span class="required_notification">* Denotes Required Field</span>&ndash;%&gt;--%>
        <%--</li>--%>
        <li>
            <label>Дата:</label>
            <%--<output>--%>
            <%--hidden="hidden"--%>
            <textarea rows="1" id="doc_time" name="datetask" readonly></textarea>
            <script type="text/javascript">clock();</script>
        </li>
        <li>
            <label>Тема:</label>
            <input type="string" name="subject" value="Перенос предприятия в другую учетную запись" readonly />
            <%--<input type="text"  placeholder="John Doe" required />--%>
        </li>
            <li>
                <label>Причина переноса:</label>
                <textarea type="text" name="description" placeholder="укажите причину переноса предприятия" required></textarea>
            </li>
        <li>
            <label>Код предприятия:</label>
            <input type="int" name="edrpou" placeholder="не более 10-ти цифр" required pattern="[0-9]{8,10}"/>
            <%--<input type="text"  placeholder="John Doe" required />--%>
        </li>
        <li>
            <label>E-mail(желательно):</label>
            <input type="text" name="email" placeholder="ivanov@example.com"/>
            <span class="form_hint">Формат данных: "name@something.com"</span>
        </li>
        <li>
            <label>Старый телефон:</label>
            <input type="int" name="oldphoneclient" placeholder="если доступен" pattern="[0-9]{7,15}" />
        </li>
            <li>
                <label>Новый телефон:</label>
                <input type="int" name="newphoneclient" placeholder="обязательно" required pattern="[0-9]{7,15}" />
            </li>
        <%--<li>--%>
            <%--<label>ФИО автора:</label>--%>
            <%--<input type="text" name="authorquest" placeholder="укажите ваши ФИО" required />--%>
        <%--</li>--%>
        <%--<li>--%>
            <%--<label>Внутренний номер:</label>--%>
            <%--<input type="int" name="phoneauthorquest" placeholder="внесите внутренний номер" required pattern="[0-9]{1,11}" />--%>
        <%--</li>--%>
    </ul>
    <ul>
        <li>
            <label>Загрузить письмо: </label>
            <input type="file"  name="fileName" min="1" max="9999" name="file[]" multiple="true" required>
        </li>
    </ul>
<br>
    <br>
    <button style="margin-left: 770px;" class="submit" type="submit">Отправить</button>
</form>
<jsp:include page="../common/mainpage.jsp"></jsp:include>
</body>
</html>