package com.pabi.pabiuser.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuctionType {
  REAL_TIME("실시간"),
  NORMAL("일반");

  private final String value;

  public String getValue() { return this.value; }
}
