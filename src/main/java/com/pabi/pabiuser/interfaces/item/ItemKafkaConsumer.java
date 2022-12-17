package com.pabi.pabiuser.interfaces.item;

import com.pabi.pabiuser.application.item.ItemFacade;
import com.pabi.pabiuser.common.annotation.kafkaParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemKafkaConsumer {
  private final ItemFacade itemFacade;

  @KafkaListener(topics = "item-topic")
  public void updateQty(@Payload ItemDto itemDto) {
    itemFacade.updateQty(itemDto);
  }
}