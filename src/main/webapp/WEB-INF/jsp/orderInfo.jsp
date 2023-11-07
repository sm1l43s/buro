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
        a {
            color: #af1414;
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
    <h1>Ваша заявка на проектирования многоэтажного дома принята!</h1>
</div>

<div class="main">

    <p>На этой странице вы можете просмотреть поданное вами технических заданий на проектирование домов. Для каждого технического задания вы можете узнать его статус, стоимость. Вы также можете отменить свое техническое задание, если оно еще не начало выполняться.</p>

    <!-- Таблица со списком технических заданий на проектирование домов -->
    <table>
        <tr>
            <th colspan="6">Техническое задание на проектирование многоэтажного дома</th>
        </tr>
        <tr>
            <th>№</th>
            <th>Ф.И.О заказчика</th>
            <th>Проектная документация</th>
            <th>Стоимость (руб.)</th>
            <th>Статус</th>
            <th>Действия</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.customer.name}</td>
                <td>
                    <div>Этажность: ${order.floors}</div>
                    <div>Количество квартир на этаже: ${order.apartments}</div>
                    <div>Площадь квартир: ${order.area}</div>
                    <div>Стиль архитектуры: ${order.style}</div>
                    <div>Площадь типового этажа: ${order.floorArea}</div>
                    <div>Конфигурация этажа: ${order.plan}</div>
                    <div>Соотношение квартир: ${order.ratio}</div>
                    <div>Дополнительные пожелания: ${order.wishes}</div>
                </td>
                <td>
                    <c:if test = "${order.cost > 0}">
                        ${order.cost}
                    </c:if>
                    <c:if test = "${order.cost == 0}">
                        <span>Стоимость проекта не выставлена</span>
                    </c:if>
                </td>
                <td>${order.status.value}</td>
                <td>
                        <div>
                            <a href="/orders/remove/<c:out value="${order.id}"/>">Отменить заказ</a>
                        </div>

                </td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>