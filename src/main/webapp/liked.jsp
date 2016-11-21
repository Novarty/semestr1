<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 03.11.2016
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elected</title>
    <link rel="stylesheet" href="http://meyerweb.com/eric/tools/css/reset/reset.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/mystyle.css" rel="stylesheet">
    <link href="fonts/glyphicons-halflings-regular.ttf">
</head>
<body>
 <%-- Топики добавленные в избранное--%>
 <div class="panel panel-default">
     <div class="panel-heading">
         <h2 class="panel-title">Закладки</h2>
     </div>
     <div class="panel-body">
         <div class="panel panel-info">
             <div class="panel-heading">
                 <a class="panel-title topicLink">Android - Первая помощь</a>
                 <ul class="menu">
                     <li><p class="authorOfTopic">Автор темы: Иванов Артем, 22/12/2012</p></li>
                     <li class="navbar-right"><p>Ответов</p></li>
                 </ul>

             </div>
             <div class="panel-body">
                 Установка прошивки для MEIZU MX4
                 <span class="label label-warning">#Тэги</span>
                 <span class="label label-info">#Тэги</span>
                 <p class="answers">725</p>
             </div>
         </div>
         <div class="panel panel-info">
             <div class="panel-heading">
                 <a class="panel-title topicLink">Android - Первая помощь</a>
                 <ul class="menu">
                     <li><p class="authorOfTopic">Автор темы: Иванов Артем, 22/12/2012</p></li>
                     <li class="navbar-right"><p>Ответов</p></li>
                 </ul>

             </div>
             <div class="panel-body">
                 Установка прошивки для MEIZU MX6
                 <span class="label label-warning">#Тэги</span>
                 <span class="label label-info">#Тэги</span>
                 <p class="answers">725</p>
             </div>
         </div>

         <div class="panel panel-info">
             <div class="panel-heading">
                 <a class="panel-title topicLink">Android - Первая помощь</a>
                 <ul class="menu">
                     <li><p class="authorOfTopic">Автор темы: Иванов Артем, 22/12/2012</p></li>
                     <li class="navbar-right"><p>Ответов</p></li>
                 </ul>

             </div>
             <div class="panel-body">
                 Официальная прошивка для M2 Note
                 <span class="label label-warning">#Тэги</span>
                 <span class="label label-info">#Тэги</span>
                 <p class="answers">725</p>
             </div>
         </div>

         <div class="panel panel-info">
             <div class="panel-heading">
                 <a class="panel-title topicLink">Android - Скорая помощь</a>
                 <ul class="menu">
                     <li><p class="authorOfTopic">Автор темы: Иванов Артем, 22/12/2012</p></li>
                     <li class="navbar-right"><p>Ответов</p></li>
                 </ul>

             </div>
             <div class="panel-body">
                 Установка прошивки для MEIZU MX5
                 <span class="label label-warning">#Тэги</span>
                 <span class="label label-info">#Тэги</span>
                 <p class="answers">725</p>
             </div>
         </div>
     </div>
 </div>
<%--Кнопки переключения страниц--%>
<div class="btn-group btn-group-sm c1">
    <button type="button" class="btn btn-default">1</button>
    <button type="button" class="btn btn-default">2</button>
    <button type="button" class="btn btn-default">3</button>
    <button type="button" class="btn btn-default">4</button>
    <button type="button" class="btn btn-default">Next</button>
    <button type="button" class="btn btn-default">Last</button>
    <div class="btn-group btn-group-default">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
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
