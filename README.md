# Ц.У.Н.А.М.И.
## Для запуска проекта необходимо:

Java JRE 1.8 (или выше)(возможно не только JRE, TODO: проверить, какая конкретно часть джавы необходима для запуска)
Postgresql 10 (или выше)
TODO: проверить, что еще нужно для развертывания

## Для разработки необходимо дополнительно:

Git
Gradle
Java SDK(TODO: проверить, какая конкретно часть джавы необходима для разработки)
TODO: проверить, что еще нужно для локальной разработки

Ветки github по git flow

API

Запрос на получение списка info

GET ..api/v1/info
Request Params:
category - PERSON|BG|PLANET
status - AVAILABLE|HIDDEN|DELETED((required = false, defaultValue = "AVAILABLE"))

URL example:
localhost:8080/api/v1/info?category=PERSON
Output example:
[
    {
        "infoId": 1,
        "name": "1",
        "data": "\"{'test': test}\"",
        "category": "PERSON",
        "photo": null,
        "status": "AVAILABLE"
    },
    {
        "infoId": 2,
        "name": "2",
        "data": "\"{'test': test}\"",
        "category": "PERSON",
        "photo": null,
        "status": "AVAILABLE"
    }
]

Запрос на получение записи info
GET ..api/v1/info/{id}
Path Variable:
id - id записи в бд
Request Params:
status - AVAILABLE|HIDDEN|DELETED((required = false, defaultValue = "AVAILABLE"))

URL example:
localhost:8080/api/v1/info/2
Output example:
{
    "infoId": 2,
    "name": "2",
    "data": "\"{'test': test}\"",
    "category": "PERSON",
    "photo": null,
    "status": "AVAILABLE"
}

Запрос на удаление записи info 
метод возвращает id записи
(//TODO:если не нужно, сообщи)

DELETE ..api/v1/info/{id}
Path Variable:
id - id записи в бд

URL example:
localhost:8080/api/v1/info/2
Output example:
2

Запрос на создание записи info
POST ..api/v1/info

RequestBody example:
{
    "name": "1",
    "data": "{'test': test}",
    "category": "PERSON",
    "status": "HIDDEN"
}

URL example:
localhost:8080/api/v1/info
Output example:
{
    "infoId": 6,
    "name": "1",
    "data": "{'test': test}",
    "category": "PERSON",
    "photo": null,
    "status": "AVAILABLE"
}

Запрос на изменение записи info
(изменяются все поля на переданные данные)
(отчасти это еще полезно для случая, когда надо удалить фотку из профиля)
PUT ..api/v1/info/{id}
Path Variable:
id - id записи в бд

RequestBody example:
{
    "name": "1",
    "data": "{'test': test}",
    "category": "PERSON",
    "status": "HIDDEN"
}

URL example:
localhost:8080/api/v1/info
Output example:
{
    "infoId": 6,
    "name": "1",
    "data": "{'test': test}",
    "category": "PERSON",
    "photo": null,
    "status": "AVAILABLE"
}

