package com.globant.challenge.dao;

import com.globant.challenge.domain.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by gamy on 5/2/17.
 */
public interface ShoppingCartItemDao extends PagingAndSortingRepository<Item, Long> {

}
