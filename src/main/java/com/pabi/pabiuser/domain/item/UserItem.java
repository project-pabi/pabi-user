package com.pabi.pabiuser.domain.item;

import com.pabi.pabiuser.interfaces.item.ItemDto;
import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.validator.constraints.Length;

@Entity
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PROTECTED)
@TypeDefs({
    @TypeDef(name = "string-list", typeClass = ListArrayType.class),
    @TypeDef(name = "enum-list", typeClass = EnumArrayType.class)
})
public class UserItem {

  @Column(unique = true)
  private String uuid = UUID.randomUUID().toString();

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Length(max = 100)
  private String title;

  @Length(max = 3000)
  private String content;

  @Enumerated(EnumType.STRING)
  private AuctionType auctionType;

  @Enumerated(EnumType.STRING)
  private ItemCategory itemCategory;

  private Long startPrice;

  private Long endPrice;

  public static UserItem createKafkaItem(ItemDto dto) {
    UserItem userItem = new UserItem();
    userItem.setUuid(dto.getUuid());
    userItem.setTitle(dto.getTitle());
    userItem.setAuctionType(dto.getAuctionType());
    userItem.setItemCategory(dto.getItemCategory());
    userItem.setStartPrice(dto.getStartPrice());
    userItem.setEndPrice(dto.getEndPrice());
    return userItem;
  }
}
