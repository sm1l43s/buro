<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        /* Стили для таблицы с формой */
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

    <p>Добро пожаловать на наш сайт, где вы можете заказать и выполнить проект многоэтажного дома по вашим требованиям и
        пожеланиям. Мы предлагаем вам качественный и надежный сервис, который включает в себя:</p>
    <ul>
        <li>Регистрацию и оплату заказа на проектирование дома</li>
        <li>Выбор бригады конструкторов для выполнения проекта</li>
        <li>Просмотр и скачивание проектной документации</li>
        <li>Отслеживание статуса и хода выполнения проекта</li>
        <li>Обратную связь и поддержку от нашей команды</li>
    </ul>
    <p>Для того, чтобы начать работу с нашим веб-приложением, вам нужно заполнить форму ниже и отправить ее нам. Мы
        рассмотрим ваше техническое задание и определим стоимость проекта на проектирование и строительство дома. После
        этого мы выставим вам счет за проектирование дома и создадим бригаду конструкторов для выполнения проекта.</p>

    <!-- Форма технического задания на проектирование дома -->
    <form action="/order" method="post">
        <table>
            <tr>
                <th colspan="2">Форма технического задания на проектирование многоэтажного дома</th>
            </tr>
            <tr>
                <td>ФИО заказчика:</td>
                <td><input type="text" name="customerName" required></td>
            </tr>
            <tr>
                <td>E-mail заказчика:</td>
                <td><input type="email" name="customerEmail" required></td>
            </tr>
            <tr>
                <td>Телефон заказчика:</td>
                <td><input type="tel" name="phone" required></td>
            </tr>
            <tr>
                <td>Количество этажей:</td>
                <td><input type="number" name="floors" min="2" max="20" required></td>
            </tr>
            <tr>
                <td>Количество квартир на этаже:</td>
                <td><input type="number" name="apartments" min="1" max="10" required></td>
            </tr>
            <tr>
                <td>Площадь квартир (м2):</td>
                <td><input type="number" name="area" min="20" max="200" required></td>
            </tr>
            <tr>
                <td>Стиль архитектуры:</td>
                <td><select name="style" required>
                    <option value="Modern">Современный</option>
                    <option value="Classic">Классический</option>
                    <option value="Eclectic">Эклектичный</option>
                    <option value="Minimalist">Минималистичный</option>
                    <option value="Other">Другой</option>
                </select></td>
            </tr>
            <tr>
                <td>Площадь типового этажа (м2):</td>
                <td><input type="number" name="floorArea" min="50" max="1000" required></td>
            </tr>
            <tr>
                <td>Конфигурация плана этажа:</td>
                <td><select name="plan">
                    <option value="Прямоугольная">Прямоугольная</option>
                    <option value="L-образная">L-образная</option>
                    <option value="U-образная">U-образная</option>
                    <option value="П-образная">П-образная</option>
                    <option value="Сложная">Сложная</option>
                </select></td>
            </tr>
            <tr>
                <td>Соотношение квартир по количеству комнат (однокомнатные/двухкомнатные/трехкомнатные):</td>
                <td><input type="text" name="ratio" placeholder="Например, 40/40/20" required></td>
            </tr>
            <tr>
                <td>Дополнительные пожелания:</td>
                <td><textarea name="wishes" rows="5"></textarea></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Отправить"></td>
            </tr>
        </table>

    </form>

</div>
</body>

</html>