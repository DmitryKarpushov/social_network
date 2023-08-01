## Техническое задание ##
Данный проект представляет собой сервис для социальной сети.
## Основные функции

- Регистрация нового пользователя
- Авторизация существующего пользователя
- Пользователь может искать других пользователей
- Пользователь может добавлять других пользователей в друзья
- Пользователь может добавлять удалять пользователей из друзей
- Пользователь может получить список своих друзей

## Технологический стек

- Java 11+
- Spring
- База данных
- Unit-тесты (опционально)

## Критерии завершения:

- Приложение написано и загружено в гит-репозиторий на проверку.
- Необходимо также подготовить инструкцию по запуску (README file).
- Опционально можно развернуть приложение на облачном сервисе (не обязательно).*

### Как пользоваться приложением
- В качестве базы данных я использовал Postgresql. Язык - Java 11. 
- Сборщик проектов - Maven. 
- Используемые зависимости: Spring (Boot, Web, Security, Data JPA, JWT, Lombok),
- Перед запуском необходимо создать базу, скрипт в файле: create.sql.
- Далее запуске создаются нужные таблицы в БД.

### REST API

##### Регистрация #####
Чтобы зарегистрировать нового пользователя в приложении, нужно отправить на адрес
http://localhost:8080/social-network/api/v1/registration
POST запрос с телом (login и password, confirmPassword, email):
```
{
    "login": "Dmitry",
    "password" : "4648",
    "confirmPassword" : "4648",
    "email":"Dmitry@Gmail.com"
}
```
##### Авторизация (Получение токена) #####
Чтобы авторизоваться в приложении, нужно отправить на адрес
http://localhost:8080/social-network/api/v1/auth
POST запрос с телом:
```
{
    "login": "Dmitry",
    "password": 4648
}
```
В ответ придёт access token в формате:
```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJJdmFuIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTY5MDkzMzI2OCwiaWF0IjoxNjkwOTI3ODY4fQ.RQ_Gt_R6bDRWtn8fybJnic-kAQQ7WrYvt973tWjGKAI"
}
```
в последующих запросах этот самый access token следует отправлять в headers в формате:

Authorization:token

##### Поиск пользователей #####
Для получение пользователя по id, login, email, необходимо отправить такие на адреса с PathVariable
```
По id:
http://localhost:8080/social-network/api/v1/user/1
По логину:
http://localhost:8080/social-network/api/v1/user/login/Dmitry
По email:
http://localhost:8080/social-network/api/v1/user/email/Dmitry@Gmail.com
```
В ответ получаем DTO которая содержит в себе id, login, email

##### Добавление в друзья #####
Для добавления в друзья по Login переходим по адресу:
```
По логину:
http://localhost:8080/social-network/api/v1/friend/Roma
```
В ответ получаем список друзей, каждый из которых содержит в себе id, login, email

##### Удаление из друзей #####
Удаление из друзей происходит по адресу:
```
По id:
http://localhost:8080/social-network/api/v1/friend/delete/3
```
В ответ получаем список друзей, каждый из которых содержит в себе id, login, email

##### Список друзей #####
Получение списка друзей:
```
По id:
http://localhost:8080/social-network/api/v1/friend
```
В ответ получаем список друзей, каждый из которых содержит в себе id, login, email
