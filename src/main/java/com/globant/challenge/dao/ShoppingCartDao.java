package com.globant.challenge.dao;

import com.globant.challenge.domain.ShoppingCart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gervasio.amy
 */
@Repository
public interface ShoppingCartDao extends PagingAndSortingRepository<ShoppingCart, Long> {


}
