package com.example.amelinroman.dataanalysermicroservice.service;

/**
 * Интерфейс KafkaDataReceiver определяет контракт для получения данных от Kafka.
 */
public interface KafkaDataReceiver {

    void fetch();
}
