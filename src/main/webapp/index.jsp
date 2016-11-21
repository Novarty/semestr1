<!DOCTYPE html>
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
        <li><p>Список форумов: </p></li>
        <c:forEach items="${forums}" var="forum">
            <li><a href="/forum?id=${forum.forumID}">${forum.nameOfForum}</a></li>
        </c:forEach>
        <%--<li><a href="/forum?id=2">IOS</a></li>--%>
        <%--<li><a href="/forum?id=3">Windows Phone</a></li>--%>
    </ul>
    <br>
    <ol class="breadcrumb mybreadcrumb">
        <li><a href="/main">Главная</a></li>
        <li><a href="#"><c:out value="${forum.nameOfForum}"/></a></li>
        <li class="active">Прошивки</li>
    </ol>
    <%--<ul class="mybreadcrumb">--%>
    <%--<li><a href="#">Link1</a></li>--%>
    <%--<li><a href="#">Link2</a></li>--%>
    <%--<li><a href="#">Link3</a></li>--%>
    <%--<li><a href="#">Link4</a></li>--%>
    <%--</ul>--%>
</nav>
<div class="btn-group btn-group-sm c1">
    <button type="button" class="btn btn-default" href="#">1</button>
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
        <h3 class="panel-title">${forum.nameOfForum} - Темы</h3>
    </div>
    <div class="panel-body">
        <c:forEach items="${topics}" var="topic">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <a href="/topic?id=${topic.topicID}" class="panel-title topicLink"><c:out
                            value="${topic.titleOfTopic}"/></a>
                    <ul class="menu">
                        <li><p class="authorOfTopic">Автор темы: <c:out value="${topic.authorOfMessage}"/></p></li>
                    </ul>
                </div>
                <div class="panel-body">
                    <c:out value="${topic.message}"/>
                </div>
            </div>
        </c:forEach>
        <%--<div class="panel panel-info">--%>
        <%--<div class="panel-heading">--%>
        <%--<a class="panel-title topicLink">Android - Первая помощь</a>--%>
        <%--<ul class="menu">--%>
        <%--<li><p class="authorOfTopic">Автор темы: Иванов Артем, 22/12/2012</p></li>--%>
        <%--<li class="navbar-right"><p>Ответов</p></li>--%>
        <%--</ul>--%>
        <%--</div>--%>
        <%--<div class="panel-body">--%>
        <%--Установка прошивки для MEIZU MX6--%>
        <%--<span class="label label-warning">#Тэги</span>--%>
        <%--<span class="label label-info">#Тэги</span>--%>
        <%--<p class="answers">725</p>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--<div class="panel panel-info">--%>
        <%--<div class="panel-heading">--%>
        <%--<a class="panel-title topicLink">Android - Первая помощь</a>--%>
        <%--<ul class="menu">--%>
        <%--<li><p class="authorOfTopic">Автор темы: Иванов Артем, 22/12/2012</p></li>--%>
        <%--<li class="navbar-right"><p>Ответов</p></li>--%>
        <%--</ul>--%>

        <%--</div>--%>
        <%--<div class="panel-body">--%>
        <%--Официальная прошивка для M2 Note--%>
        <%--<span class="label label-warning">#Тэги</span>--%>
        <%--<span class="label label-info">#Тэги</span>--%>
        <%--<p class="answers">725</p>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--<div class="panel panel-info">--%>
        <%--<div class="panel-heading">--%>
        <%--<a class="panel-title topicLink">Android - Скорая помощь</a>--%>
        <%--<ul class="menu">--%>
        <%--<li><p class="authorOfTopic">Автор темы: Иванов Артем, 22/12/2012</p></li>--%>
        <%--<li class="navbar-right"><p>Ответов</p></li>--%>
        <%--</ul>--%>

        <%--</div>--%>
        <%--<div class="panel-body">--%>
        <%--Установка прошивки для MEIZU MX5--%>
        <%--<span class="label label-warning">#Тэги</span>--%>
        <%--<span class="label label-info">#Тэги</span>--%>
        <%--<p class="answers">725</p>--%>
        <%--</div>--%>
        <%--</div>--%>
    </div>
</div>
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
</body>
</html>
