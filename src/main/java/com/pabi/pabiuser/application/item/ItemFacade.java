package com.pabi.pabiuser.application.item;

import com.pabi.pabiuser.domain.item.ItemService;
import com.pabi.pabiuser.interfaces.item.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemFacade {
  private final ItemService itemService;

  public void updateQty(ItemDto itemDto) {
    itemService.updateQty(itemDto);
  }
}
