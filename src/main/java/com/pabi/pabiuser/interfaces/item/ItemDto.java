package com.pabi.pabiuser.interfaces.item;

import com.pabi.pabiuser.domain.item.AuctionType;
import com.pabi.pabiuser.domain.item.ItemCategory;
import lombok.Data;

@Data
public class ItemDto {

    private String userUuid;
    private String uuid;
    private String title;
    private AuctionType auctionType;
    private ItemCategory itemCategory;
    private Long startPrice;
    private Long endPrice;
}

