Для запуска приложения:

1. git clone https://github.com/Berhtz/Java_app
2. cd Java_app
3. ./mvnw clean package
4. docker-compose up

Альтернативный вариант запуска без докера (потребуется настройка application.properties):

1. git clone https://github.com/Berhtz/Java_app
2. cd Java_app
4. ./mvnw spring-boot:run

Для просмотра диаграммы нужно перейти на страницу localhost:8080/show_events
