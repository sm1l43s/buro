<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        /* Стили для таблицы с формой изменения информации о заказе */
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

        input, select, textarea {
            width: 100%;
            box-sizing: border-box;
        }

        /* Стили для кнопки отправки формы */
        input[type=submit] {
            background-color: #333;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #444;
        }
    </style>
</head>
<body>

<div class="header">
    <h1>Веб-приложение для проектирования многоэтажных домов</h1>
</div>

<div class="main">
    <p>На этой странице вы можете изменить информацию о заказе на проектирование дома. Для этого вам нужно заполнить
        форму ниже и отправить ее нам.</p>

    <form action="/orderUpdate" method="post">
        <table>
            <tr>
                <th colspan="2">Форма изменения информации о заказе на проектирование многоэтажного дома</th>
            </tr>
            <td><input hidden type="text" name="id" value="${order.id}"></td>
            <tr>
                <td>ФИО заказчика:</td>
                <td><input type="text" hidden value="${order.customer.name}">${order.customer.name}</td>
            </tr>
            <tr>
                <td>E-mail заказчика:</td>
                <td><input type="email" hidden value="${order.customer.email}">${order.customer.email}</td>
            </tr>
            <tr>
                <td>Телефон заказчика:</td>
                <td><input type="tel" hidden value="${order.customer.phone}">${order.customer.phone}</td>
            </tr>
            <input hidden name="customerId" value="${order.customer.customerId}">
            <tr>
                <td>Количество этажей:</td>
                <td><input type="number" name="floors" value="${order.floors}" min="2" max="20" required></td>
            </tr>
            <tr>
                <td>Количество квартир на этаже:</td>
                <td><input type="number" name="apartments" value="${order.apartments}" min="1" max="10" required></td>
            </tr>
            <tr>
                <td>Площадь квартир (м2):</td>
                <td><input type="number" name="area" value="${order.area}" min="20" max="200" required></td>
            </tr>
            <tr>
                <td>Соотношение квартир по количеству комнат (однокомнатные/двухкомнатные/трехкомнатные):</td>
                <td><input type="text" name="ratio" value="${order.ratio}" placeholder="Например, 40/40/20" required>
                </td>
            </tr>
            <tr>
                <td>Площадь типового этажа (м2):</td>
                <td><input type="number" value="${order.floorArea}" name="floorArea" min="50" max="1000" required></td>
            </tr>
            <tr>
                <td>Стиль архитектуры:</td>
                <td><select name="style" value="${order.style}" required>
                    <option value="modern">Современный</option>
                    <option value="classic">Классический</option>
                    <option value="eclectic">Эклектичный</option>
                    <option value="minimalist">Минималистичный</option>
                    <option value="other">Другой</option>
                </select></td>
            </tr>
            <tr>
                <td>Конфигурация плана этажа:</td>
                <td><select name="plan" value="${order.plan}">
                    <option value="Прямоугольная">Прямоугольная</option>
                    <option value="L-образная">L-образная</option>
                    <option value="U-образная">U-образная</option>
                    <option value="П-образная">П-образная</option>
                    <option value="Сложная">Сложная</option>
                </select></td>
            </tr>
            <tr>
                <td>Дополнительные пожелания:</td>
                <td><textarea name="wishes" rows="5">${order.wishes}</textarea></td>
            </tr>
            <tr>
                <td>Стоимость:</td>
                <td><input name="cost" required value="${order.cost}"></td>
            </tr>
            <tr>
                <td>Статус проекта:</td>
                <td><select name="status" value="${order.status}" required>
                    <option value="REGISTERED">Заказ зарегистрирован</option>
                    <option value="PAID">Заказ оплачен</option>
                    <option value="ASSIGNED">Заказ назначен бригаде конструкторов</option>
                    <option value="IN_PROGRESS">Заказ в процессе выполнения</option>
                    <option value="COMPLETED">Заказ выполнен</option>
                </select></td>
            </tr>
            <tr>
                <td>Назначить бригаду конструкторов:</td>
                <td>
                    <select name="constructorId" required>
                        <c:forEach var="constructor" items="${constructors}">
                            <option value="${constructor.id}">${constructor.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Сохранить изменения"></td>
            </tr>

        </table>

    </form>

</div>

</body>
</html>

