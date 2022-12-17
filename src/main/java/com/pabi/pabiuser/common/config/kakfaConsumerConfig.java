package com.pabi.pabiuser.common.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class kakfaConsumerConfig {

  // 토픽에 접속하기 위한 정보가 들어가 있음
  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    Map<String, Object> properties = new HashMap<>();
    //kafka container host
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "3.39.225.171:9092");
    properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    return new DefaultKafkaConsumerFactory<>(properties);
  }


  // 이벤트 발생시 캐치할 수 있는 리스너
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String>
    kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
    kafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
    return kafkaListenerContainerFactory;
  }
}
