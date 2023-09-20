# Микросервис анализатор данных

Это приложение получает данные из [службы генератора данных](https://github.com/AmelinRoman/data-generator-microservice) с помощью Apache Kafka.


## Переменные окружения


Перед запуском приложения убедитесь, что вы создали файл .env со следующими переменными:

`KAFKA_BOOTSTRAP_SERVERS=localhost:9092
 KAFKA_SUBSCRIBED_TOPICS=data-temperature,data-power,data-voltage`


 ## Запуск приложения

 Для запуска приложения выполните следующие шаги:
 

1. Установите зависимости: npm install.
   

2. Запустите приложение: npm start.


4. Приложение будет запущено на порту 8082.


### Сразу после запуска приложение попытается подключиться к Apache Kafka и начнет прослушивать темы из KAFKA_SUBSCRIBED_TOPICS.
