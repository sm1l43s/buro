<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Веб-приложение для проектирования многоэтажных домов</title>
    <style>
        /* Общие стили для всей страницы */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
        }
        /* Стили для заголовка страницы */
        .header {
            background-color: #333;
            color: white;
            padding: 20px;
            text-align: center;
        }
        /* Стили для основного контента страницы */
        .main {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        /* Стили для таблицы с списком технических заданий */
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
        }
        th {
            background-color: #eee;
        }
        .addButton {
            color: #0f0f65;
            text-decoration: none;
        }
        .addButton:hover {
            color: #444;
            text-decoration: underline;
        }
        a {
            color: #c71111;
            text-decoration: none;
        }
        a:hover {
            color: #444;
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="header">
    <h1>Веб-приложение для проектирования многоэтажных домов</h1>
</div>

<div class="main">

    <!-- Таблица со списком технических заданий на проектирование домов -->
    <div>
        <a class="addButton" href="/register">Добавить нового сотрудника</a>
    </div>
    <table>
        <tr>
            <th colspan="8">Список работников</th>
        </tr>
        <tr>
            <th>№</th>
            <th>Ф.И.О работника</th>
            <th>Email работника</th>
            <th>Роль в системе</th>
            <th>Действие</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.role.authority}</td>
                <td>
                    <div>
                        <a href="/users/delete/<c:out value="${user.id}"/>">Удалить</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>