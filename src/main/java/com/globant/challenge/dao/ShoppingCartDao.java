package com.globant.challenge.dao;

import com.globant.challenge.domain.ShoppingCart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gamy on 5/2/17.
 */
@Repository
public interface ShoppingCartDao extends PagingAndSortingRepository<ShoppingCart, Long> {


}
