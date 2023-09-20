package com.example.amelinroman.dataanalysermicroservice.service;

import com.example.amelinroman.dataanalysermicroservice.model.Data;

/**
 * Интерфейс KafkaDataService определяет контракт для сервиса, который обрабатывает полученные данные измерений
 * от KafkaDataReceiver.
 */
public interface KafkaDataService {

    void handle(Data data);
}
