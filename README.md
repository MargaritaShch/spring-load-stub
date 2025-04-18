# Load Testing Project: Product Stub Service

Практическое задание по нагрузочному тестированию.  
Цель — протестировать REST-сервис на Spring Boot с PostgreSQL и определить его максимальную производительность.

---

##  Цель проекта

- Развернуть и протестировать собственную заглушку (`stub`).
- Развернуть мониторинг.
- Провести тест поиска максимума.
- Сформировать МНТ и отчёт.

---

##  Технологии

- Java 21 + Spring Boot 3.4.4
- PostgreSQL 16 (в Docker)
- Maven
- JMeter 
- Grafana + Prometheus 

---

## Описание заглушки

Сервис предоставляет REST API для управления сущностью `Product` (товар).

Поддерживаемые операции:

| Метод  | URL                       | Описание              |
|--------|---------------------------|-----------------------|
| `GET`  | `/api/products`           | Получить все товары   |
| `GET`  | `/api/products/{id}`      | Получить товар по ID  |
| `POST` | `/api/products`           | Добавить товар        |
| `PUT`  | `/api/products/{id}`      | Обновить товар        |
| `DELETE` | `/api/products/{id}`    | Удалить товар         |

Сервис использует PostgreSQL и реализует искусственные задержки (500–1500 мс) в каждом запросе для имитации поведения реального сервиса.

---

## Запуск БД

```bash
docker compose up -d
```
## Запуск заглушки
### Добавить товар:

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name": "Сахар", "category": "Бакалея", "price": 79.90, "stock": 25}'
```
### Получить все товары:

```bash
curl http://localhost:8080/api/products
```
### Получить товар по ID:

```bash
curl http://localhost:8080/api/products/1
```
### Обновить товар:

```bash
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "Сахар тростниковый", "category": "Бакалея", "price": 99.90, "stock": 20}'
```
### Удалить товар:

```bash
curl -X DELETE http://localhost:8080/api/products/1
```
