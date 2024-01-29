package com.hexagonal.config

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.std.StringDeserializer
import com.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerConfig.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, CustomerMessage> {
        val props: MutableMap<String, Any> = HashMap()
        props[BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        props[GROUP_ID_CONFIG] = "hexagon"
        props[KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserialize::class.java
        props[AUTO_OFFSET_RESET_CONFIG] = "earliest"
        return DefaultKafkaConsumerFactory(props)
    }

    @Bean
    fun kafkaListernerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, CustomerMessage>()
        factory.consumerFactory = consumerFactory()
        return factory
    }
}