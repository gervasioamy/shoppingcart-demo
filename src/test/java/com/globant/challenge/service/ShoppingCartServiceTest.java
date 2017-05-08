package com.globant.challenge.service;

import com.globant.challenge.dao.ArticlesDAO;
import com.globant.challenge.dao.ShoppingCartDao;
import com.globant.challenge.domain.Article;
import com.globant.challenge.domain.Item;
import com.globant.challenge.domain.ShoppingCart;
import com.globant.challenge.error.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * Unit test for {@link ShoppingCartService} class
 *
 * @author gervasio.amy
 */
public class ShoppingCartServiceTest {

    @InjectMocks
    private ShoppingCartService serivce;

    @Mock
    private ShoppingCartDao dao;

    @Mock
    private ArticlesDAO articlesDAO;

    private List<Item> stubbedItems;

    private Article[] stubbedArticles;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        stubbedItems = new ArrayList<>();
        stubbedItems.add(new Item(100L, "article1", 2));
        stubbedItems.add(new Item(101L, "article4", 1));

        stubbedArticles = new Article[2];
        stubbedArticles[0] = new Article("article1", "Article 1", 3.50);
        stubbedArticles[1] = new Article("article4", "Article 4", 2.00);

    }

    @Test
    public void givenHappyPathGetCartThenPriceIsWellCalculated() {
        //given
        ShoppingCart cart = new ShoppingCart();
        cart.setItems(stubbedItems);
        given(dao.findOne(1L)).willReturn(cart);
        given(articlesDAO.fetchArticles()).willReturn(stubbedArticles);
        // when
        ShoppingCart returnedCart = serivce.getCart(1L);
        // then
        Assert.assertEquals((3.5*2)+(2.0*1), returnedCart.getTotalPrice());
    }

    @Test(expected = NotFoundException.class)
    public void givenCartIsNotExistentGetCartThorwsException() {
        serivce.getCart(39L);
    }


    @Test(expected = NotFoundException.class)
    public void givenItemNotExistsRemoveItemFromCartThrowNFE() {
        ShoppingCart cart = new ShoppingCart();
        cart.setItems(stubbedItems);
        given(dao.findOne(1L)).willReturn(cart);
        // when
        serivce.removeItemFromCart(1L, 555L);
    }

    @Test
    public void givenItemExistsRemoveItemFromCartWorksFine() {
        ShoppingCart cart = new ShoppingCart();
        cart.setItems(stubbedItems);
        given(dao.findOne(1L)).willReturn(cart);
        // when
        serivce.removeItemFromCart(1L, 100L);
        // Then
        Assert.assertEquals("There should be only ONE item in this cart",1, cart.getItems().size());
    }
}
