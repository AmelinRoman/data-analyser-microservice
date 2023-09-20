package com.example.amelinroman.dataanalysermicroservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Класс Data моделирует данные, полученные от датчика.
 * Он содержит информацию о датчике, времени измерения, значении измерения и его типе.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Data {

    /**
     * Идентификатор (ID) датчика.
     */
    private Long sensorId;

    /**
     * Временная метка (timestamp) измерения.
     */
    private LocalDateTime timestamp;

    /**
     * Значение измерения.
     */
    private double measurement;

    /**
     * Тип измерения.
     */
    private MeasurementType measurementType;

    /**
     * Перечисление типов измерений, поддерживаемых датчиком.
     */
    public enum MeasurementType {
        TEMPERATURE,
        VOLTAGE,
        POWER
    }
}
