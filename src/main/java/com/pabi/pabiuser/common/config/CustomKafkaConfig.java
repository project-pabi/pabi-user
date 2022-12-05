package com.pabi.pabiuser.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pabi.pabiuser.common.annotation.kafkaParam;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.kafka.annotation.KafkaListenerConfigurer;
import org.springframework.kafka.config.KafkaListenerEndpointRegistrar;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;

@Configuration
@RequiredArgsConstructor
class CustomKafkaConfig implements KafkaListenerConfigurer {

  private final ObjectMapper mapper;
  @Override
  public void configureKafkaListeners(KafkaListenerEndpointRegistrar registrar) {
    registrar.setCustomMethodArgumentResolvers(
        new HandlerMethodArgumentResolver() {

          @Override
          public boolean supportsParameter(MethodParameter methodParameter) {
            return methodParameter.getParameterAnnotation(Payload.class) != null;
          }

          @Override
          public Object resolveArgument(MethodParameter parameter, Message<?> message) throws Exception {
            String s = (String) message.getPayload();

            return mapper.readValue(s, parameter.getParameterType());
          }
        }
    );
  }

}