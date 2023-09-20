package com.example.amelinroman.dataanalysermicroservice.service;

import com.example.amelinroman.dataanalysermicroservice.config.LocalDateTimeDeserializer;
import com.example.amelinroman.dataanalysermicroservice.model.Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.time.LocalDateTime;

/**
 * Класс KafkaDataReceiverIml реализует интерфейс KafkaDataReceiver для получения данных от Kafka.
 * Он использует сервис KafkaDataService для обработки полученных данных измерений.
 */
@Service
@RequiredArgsConstructor
public class KafkaDataReceiverIml implements KafkaDataReceiver {

    private final KafkaReceiver<String, Object> receiver;
    private final LocalDateTimeDeserializer timeDeserializer;
    private final KafkaDataService kafkaDataService;

    /**
     * Метод, вызываемый после создания объекта KafkaDataReceiverIml для инициализации получения данных.
     */
    @PostConstruct
    private void init() {
        fetch();
    }

    /**
     * Реализация метода fetch, который отвечает за получение данных от Kafka и их обработку.
     * Метод десериализует данные и передает их сервису KafkaDataService для последующей обработки.
     */
    @Override
    public void fetch() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, timeDeserializer).create();
        receiver.receive()
                .subscribe(r -> {
                    Data data = gson.fromJson(r.value().toString(), Data.class);
                    kafkaDataService.handle(data);
                    r.receiverOffset().acknowledge();
                });
    }
}
