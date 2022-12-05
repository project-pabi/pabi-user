package com.pabi.pabiuser.domain.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pabi.pabiuser.infrastructure.item.ItemRepository;
import com.pabi.pabiuser.interfaces.item.ItemDto;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
class ItemServiceImpl implements ItemService {

  private final ItemRepository itemRepository;

  @Override
  @Transactional
  public void updateQty(ItemDto kafkaMessage) {
    log.info("Kafka Message: ->" + kafkaMessage);

    Map<Object, Object> map = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();

//    try {
//      map = mapper.readValue(ItemDto kafkaMessage, new TypeReference<ItemDto>() {
//      });
//    } catch (JsonProcessingException ex) {
//      ex.printStackTrace();
//    }

    UserItem kafkaUserItem = UserItem.createKafkaItem(kafkaMessage);

    itemRepository.save(kafkaUserItem);

  }
}
