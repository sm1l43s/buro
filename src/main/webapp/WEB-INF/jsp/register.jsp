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
    <!-- Форма регистрации на сайте -->
    <form action="/register" method="post">
        <table>
            <tr>
                <th colspan="2">Форма регистрации на сайте</th>
            </tr>
            <tr>
                <td>Ф.И.О. сотрудника:</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td>Пароль:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>Роль:</td>
                <td><select name="role" required>
                    <option value="MANAGER">Менеджер</option>
                    <option value="CONSTRUCTOR">Конструктор</option>
                    <option value="ADMIN">Админ</option>
                </select></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Зарегистрироваться"></td>
            </tr>
        </table>
    </form>
</div>

</body
</html>