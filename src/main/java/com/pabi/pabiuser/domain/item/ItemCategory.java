package com.pabi.pabiuser.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemCategory {
  CLOTHES("의류"),
  APPLIANCE("가전제품"),
  FOOD("음식"),
  LEISURE("레저/스포츠"),
  BEAUTY("뷰티/미용"),
  HOBBY("취미용품"),
  FURNITURE("가구"),
  ETC("기타");

  private final String value;

  public String getValue() { return this.value; }
}
