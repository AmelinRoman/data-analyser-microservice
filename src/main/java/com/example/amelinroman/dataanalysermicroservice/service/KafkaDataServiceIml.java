package com.example.amelinroman.dataanalysermicroservice.service;

import com.example.amelinroman.dataanalysermicroservice.model.Data;
import org.springframework.stereotype.Service;

/**
 * Класс KafkaDataServiceIml реализует интерфейс KafkaDataService для обработки полученных данных измерений.
 * В данной реализации обработка данных производится путем вывода информации о полученных объектах Data в консоль.
 */
@Service
public class KafkaDataServiceIml implements KafkaDataService {

    /**
     * Метод обработки данных измерений. Выводит информацию о полученном объекте Data в консоль.
     *
     * @param data объект Data, содержащий данные измерений, полученные от KafkaDataReceiver
     */
    @Override
    public void handle(Data data) {
        System.out.println("Data object is received: "+data.toString());
    }
}
