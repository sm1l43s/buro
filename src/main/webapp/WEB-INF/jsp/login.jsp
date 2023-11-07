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
        <!-- Форма авторизации на сайте -->
    <form action="/login" method="post">
        <table>
            <tr>
                <th colspan="2">Форма авторизации на сайте</th>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><input type="email" name="username" required></td>
            </tr>
            <tr>
                <td>Пароль:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Войти"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
