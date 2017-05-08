package com.globant.challenge.controllers;

import com.globant.challenge.domain.Item;
import com.globant.challenge.domain.ShoppingCart;
import com.globant.challenge.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * The main RESTFul controller that implements the following endpoints:
 * <ul>
 *     <li>POST   /carts : creates a cart</li>
 *     <li>GET    /carts/{cartId} : retrieves a cart</li>
 *     <li>POST   /carts/{cartId}/items : add an item to a cart </li>
 *     <li>DELETE /carts/{cartId}/items/{itemId} : removes an item from a cart</li>
 *     <li>DELETE /carts/{cartId}/items : clears a carts</li>
 *     <li>PUT    /carts/{cartId}/items/{itemId} : updates an item from a cart </li>
 * </ul>
 *
 * @author gervasio.amy
 */
@RestController
@RequestMapping("/api")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService service;

    @RequestMapping(path = "/carts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCart(HttpServletResponse response) {
        ShoppingCart cart = service.createCart();
        response.addHeader("Location", String.valueOf(cart.getId()));
    }

    @RequestMapping(path = "/carts/{cartId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ShoppingCart getCart(@PathVariable Long cartId) {
        return service.getCart(cartId);
    }

    @RequestMapping(path = "/carts/{cartId}/items", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addItemToCart(@PathVariable Long cartId, @RequestBody Item item) {
        service.addItemToCart(cartId, item);
    }

    @RequestMapping(path = "/carts/{cartId}/items/{itemId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeItemFromCart(@PathVariable Long cartId, @PathVariable Long itemId) {
        service.removeItemFromCart(cartId, itemId);
    }

    @RequestMapping(path = "/carts/{cartId}/items/", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable Long cartId) {
        service.clearCart(cartId);
    }

    @RequestMapping(path = "/carts/{cartId}/items/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCartItem(@PathVariable Long cartId, @PathVariable Long itemId, @RequestBody Item item) {
        service.upadteItem(itemId, item);
    }

}
