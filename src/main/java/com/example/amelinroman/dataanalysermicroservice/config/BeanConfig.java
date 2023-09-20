package com.example.amelinroman.dataanalysermicroservice.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;


/**
 * Класс BeanConfig содержит конфигурацию JavaBeans для приложения Spring Boot.
 */
@Configuration
public class BeanConfig {

    /**
     * Создает и возвращает экземпляр XMLDocument на основе файла consumer.xml.
     *
     * @return XMLDocument, представляющий конфигурацию Kafka консьюмера.
     */
    @SneakyThrows
    @Bean
    public XML consumerXml() {
        return new XMLDocument(
                new File("src/main/resources/kafka/consumer.xml")
        );
    }
}
