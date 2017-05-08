package com.globant.challenge.dao;

import com.globant.challenge.domain.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author gervasio.amy
 */
public interface ShoppingCartItemDao extends PagingAndSortingRepository<Item, Long> {

}
