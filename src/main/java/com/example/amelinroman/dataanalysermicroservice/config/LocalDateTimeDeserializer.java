package com.example.amelinroman.dataanalysermicroservice.config;

import com.google.gson.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

/**
 * Класс LocalDateTimeDeserializer реализует интерфейс JsonDeserializer для десериализации объектов типа LocalDateTime.
 */
@Component
public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

    /**
     * Метод deserialize переопределен для конвертации JSON-элемента в объект типа LocalDateTime.
     *
     * @param jsonElement JSON-элемент, который будет преобразован в объект LocalDateTime.
     * @param type        Тип объекта, результатом которого является десериализация JSON-элемента.
     * @param jsonDeserializationContext Контекст, в котором выполняется десериализация.
     * @return Объект типа LocalDateTime, полученный из JSON-элемента.
     * @throws JsonParseException Если возникает ошибка при парсинге JSON-элемента.
     */
    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        int year = jsonArray.get(0).getAsInt();
        int month = jsonArray.get(1).getAsInt();
        int day = jsonArray.get(2).getAsInt();
        int hour = jsonArray.get(3).getAsInt();
        int minute = jsonArray.get(4).getAsInt();
        int second = jsonArray.get(5).getAsInt();
        return LocalDateTime.of(year,month,day,hour,minute,second);
    }
}
