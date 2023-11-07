ALTER TABLE ORDERS DROP CONSTRAINT CONSTRAINT_8;

INSERT INTO CONSTRUCTORS (NAME)
VALUES ('Строймастер'),
       ('Домострой'),
       ('Квартирник'),
       ('Лофтмейкер'),
       ('Скандинав');

INSERT INTO CUSTOMERS (NAME, EMAIL, PHONE)
VALUES ('Иван Иванов', 'ivanov@mail.ru', '+375291234567'),
       ('Петр Петров', 'petrov@mail.ru', '+375292345678'),
       ('Анна Андреева', 'andreeva@mail.ru', '+375293456789'),
       ('Сергей Сергеев', 'sergeev@mail.ru', '+375294567890'),
       ('Мария Мариева', 'marieva@mail.ru', '+375295678901');

INSERT INTO ORDERS (STATUS, CUSTOMER_ID, FLOORS, APARTMENTS, AREA, STYLE, FLOOR_AREA, PLAN, RATIO, WISHES, COST)
VALUES ('REGISTERED', 1, 2, 4, 60, 'Современный', 120, 'Квадратный', '1:1', 'Хочу большое окно', 100000),
       ('PAID', 2, 3, 6, 80, 'Классический', 125, 'Прямоугольный', '2:1', 'Хочу камин', 150000),
       ('ASSIGNED', 3, 4, 8, 100, 'Минималистичный', 125, 'Круглый', '1:2', 'Хочу аквариум', 200000),
       ('IN_PROGRESS', 4, 5, 10, 90, 'Лофт', 140, 'Треугольный', '1:3', 'Хочу ковер', 250000),
       ('COMPLETED', 5, 6, 12, 68, 'Скандинавский', 135, 'Пятиугольный', '1:4', 'Хочу шкаф', 300000);

INSERT INTO CONSTRUCTORS_ORDERS (CONSTRUCTOR_ID, ORDERS_ID)
VALUES (1, 3),
       (2, 4),
       (3, 5);

INSERT INTO roles (name)
VALUES ('ADMIN'),
       ('MANAGER'),
       ('CONSTRUCTOR');

INSERT INTO users (name, email, password, role_id)
VALUES ('Alice', 'test@test.com', '$2a$12$Nozw8ZRtWkfGfcjiQBxZ4.czyucD8B6dqG58O9vSjtBDhHD8ob8Ja', 1),
       ('Bob', 'bob@example.com', '$2a$12$Nozw8ZRtWkfGfcjiQBxZ4.czyucD8B6dqG58O9vSjtBDhHD8ob8Ja', 2),
       ('Charlie', 'charlie@example.com', 'abcdef', 3);