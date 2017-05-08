package com.globant.challenge.service;

import com.globant.challenge.dao.ArticlesDAO;
import com.globant.challenge.dao.ShoppingCartDao;
import com.globant.challenge.dao.ShoppingCartItemDao;
import com.globant.challenge.domain.Article;
import com.globant.challenge.domain.Item;
import com.globant.challenge.domain.ShoppingCart;
import com.globant.challenge.error.InvalidItemReferenceException;
import com.globant.challenge.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

/**
 * The service layer. Controllers should have to use the facade to deal with the domain.
 *
 * @author gervasio.amy
 */
@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartDao dao;

    @Autowired
    private ShoppingCartItemDao itemDao;

    @Autowired
    private ArticlesDAO articlesDAO;


    public ShoppingCart createCart() {
        return dao.save(new ShoppingCart());
    }

    public void clearCart(Long cartId){
        ShoppingCart cart = getCartFromDao(cartId);
        cart.clearItems();
        dao.save(cart);
    }

    public ShoppingCart getCart(Long cartId) {
        ShoppingCart cart = getCartFromDao(cartId);
        cart.setTotalPrice(this.calculateTotalPrice(cart));
        return cart;
    }

    private Double calculateTotalPrice(ShoppingCart cart) {
        Article[] articles = articlesDAO.fetchArticles();
        double total = cart.getItems().stream().
                mapToDouble(item -> calculateItemTotalPrice(item, findArticle(articles, item.getReference()))).
                sum();
        return total;
    }

    private Article findArticle(Article[] articles, String articleRef) {
        return Arrays.stream(articles).
                filter((article -> article.getId().equals(articleRef))).
                findFirst().
                orElseThrow(InvalidItemReferenceException::new);
    }

    private double calculateItemTotalPrice(Item item, Article article) {
        return item.getQuantity().doubleValue() * article.getPrice().doubleValue();
    }

    public ShoppingCart addItemToCart(Long cartId, Item item) {
        Article article = articlesDAO.fetchArticle(item.getReference()); // 404 is handled
        ShoppingCart cart = getCartFromDao(cartId);
        // do something with the article if needed...
        cart.addItem(item);
        return dao.save(cart);
    }

    public void removeItemFromCart(Long cartId, Long itemId) {
        ShoppingCart cart = getCartFromDao(cartId);
        boolean removed = cart.getItems().removeIf((item) -> item.getId().equals(itemId));
        if (!removed) {
            throw new NotFoundException();
        }
    }

    public void upadteItem(Long itemId, Item item) {
        item.setId(itemId);
        // TODO improve by validating the article reference is not changed
        itemDao.save(item);
    }

    private ShoppingCart getCartFromDao(Long cartId) {
        ShoppingCart cart = Optional.ofNullable(dao.findOne(cartId))
                .orElseThrow(NotFoundException::new);
        return cart;
    }

    /* old non-restful approach
    private boolean isItemReferenceValid(String reference) {
        Article[] articles = articlesDAO.fetchArticles();
        Article art = Arrays.stream(articles).
                filter((article) -> article.getId().equals(reference)).
                findFirst().
                orElseThrow(InvalidItemReferenceException::new);
        return art != null;
    }
    */

}
