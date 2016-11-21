<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 11.11.2016
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forum</title>
    <link rel="stylesheet" href="http://meyerweb.com/eric/tools/css/reset/reset.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/mystyle.css" rel="stylesheet">
    <link href="fonts/glyphicons-halflings-regular.ttf">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default c1">
    <c:if test="${user != null}">
        <h1 class="h5">You sing in as <a href="profile.jsp">${user.getUsername()}</a></h1>
    </c:if>
    <ul class="menu">
        <li><a href="#">Android</a></li>
        <li><a href="#">IOS</a></li>
        <li><a href="#">Windows Phone</a></li>
    </ul>
    <br>
    <ol class="breadcrumb mybreadcrumb">
        <li><a href="#">Главная</a></li>
        <li><a href="#">Android</a></li>
        <li class="active">Прошивки</li>
    </ol>
</nav>
<%--кнопки--%>
<div class="btn-group btn-group-sm c1">
    <button type="button" class="btn btn-default">1</button>
    <button type="button" class="btn btn-default">2</button>
    <button type="button" class="btn btn-default">3</button>
    <button type="button" class="btn btn-default">4</button>
    <button type="button" class="btn btn-default">Next</button>
    <button type="button" class="btn btn-default">Last</button>
    <div class="btn-group dropdown">
        <button type="button" class="dropdown-toggle" data-toggle="dropdown">
            <span class="glyphicon glyphicon-chevron-down"></span>
        </button>
        <ul class="dropdown-menu">
            <li><h1 class="h6">Перейти на страницу</h1></li>
            <li><input type="text" class="form-control"></li>
        </ul>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <ul class="menu">
            <li><h3 class="panel-title">Название темы</h3></li>
            <li><p>22/12/2012</p></li>
        </ul>

    </div>
    <div class="panel-body">
        <div class="row">
            <%--Колонка профиля--%>
            <div class="col-lg-2">
                <img src="img/s.png" height="100" width="100" align="top" alt="альтернативный текст">
                <ul>
                    <li><a href="#">Автор</a></li>
                    <li><p>Администратор</p></li>
                </ul>
            </div>
            <%--Колонка сообщения--%>
            <div class="col-lg-10">
                <p>текст тыл ывгцшу ывтолфф уицф лосфыолв уи ыфлвуфл о флуотфсы тфыовлсфыу тсфлоытул офсмны рпнги фрои
                    унг флоыви sssssssssssssssssssssssssssssssssssл ьлдывьмдлы лдвь ытв лоыв тлоы втлыо твлыо вт лыовт лыов толы вт лоы твлоы твол ытвол ытв олытв лоытв лытвло ытвл ытвло ыт </p>
            </div>
        </div>
    </div>
</div>

</body>
</html>
