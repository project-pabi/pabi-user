package com.pabi.pabiuser.infrastructure.item;

import com.pabi.pabiuser.domain.item.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<UserItem,Long> {

}
