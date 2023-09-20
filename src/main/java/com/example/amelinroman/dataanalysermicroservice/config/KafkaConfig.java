package com.example.amelinroman.dataanalysermicroservice.config;

import com.jcabi.xml.XML;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Класс KafkaConfig содержит конфигурацию Kafka для приложения Spring Boot.
 */
@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

    /**
     * Адреса Kafka с серверами.
     */
    @Value("${spring.kafka.bootstrap-servers}")
    private String servers;

    /**
     * Список тем, на которые будет подписан Kafka-консьюмер.
     */
    @Value("${topics}")
    private List<String> topics;

    /**
     * Настройки XML, которые используются в контексте приложения.
     */
    private final XML settings;

    /**
     * Создает и возвращает настройки консьюмера Kafka.
     *
     * @return Map с настройками консьюмера Kafka.
     */
    @Bean
    public Map<String, Object> receiverProperties() {
        Map<String, Object> props = new HashMap<>(5);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, new TextXPath(this.settings, "//groupId").toString());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, new TextXPath(this.settings, "//keyDeserializer").toString());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, new TextXPath(this.settings, "//valueDeserializer").toString());
        props.put("spring.json.trusted.packages", new TextXPath(this.settings, "//trustedPackages").toString());

        return props;
    }

    /**
     * Создает и возвращает опции консьюмера Kafka.
     *
     * @return Объект ReceiverOptions со свойствами консьюмера.
     */
    @Bean
    public ReceiverOptions<String, Object> receiverOptions() {
        ReceiverOptions<String, Object> receiverOptions = ReceiverOptions.create(receiverProperties());

        return receiverOptions.subscription(topics)
                .addAssignListener(receiverPartitions -> System.out.println("assigned: "+receiverPartitions))
                .addRevokeListener(receiverPartitions -> System.out.println("revoked: "+receiverPartitions));
    }

    /**
     * Создает и возвращает экземпляр консьюмера Kafka.
     *
     * @param receiverOptions опции консьюмера.
     * @return Экземпляр KafkaReceiver с заданными опциями консьюмера.
     */
    @Bean
    public KafkaReceiver<String, Object> kafkaReceiver(ReceiverOptions<String, Object> receiverOptions) {
        return KafkaReceiver.create(receiverOptions);
    }

}
