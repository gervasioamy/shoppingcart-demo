# shoppingcart-demo
Simple shopping cart implementation based on Spring Boot

This is just a demo for Spring Boot features implementing a very basic RESTFul API

## Domain 
It implements a RESTFul API which exposes web services for managing a “Shopping Cart”. 
The goal is to allow adding items to a cart, changing the quantity and removing them, that’s it.

Available articles to be added to the shopping cart are provided by this third party web service.
Assume the available articles are subject to change at any time.

* GET  http://challenge.getsandbox.com/articles  
  *  200 OK. JSON array of articles, for ex.:
```javascript
[
  {
    "id": "1",
    "title": "Bannana",
    "price": "2.50"
  },
  {
    "id": "2",
    "title": "Apple",
    "price": "3.20"
  },
  ...
]
```

* GET http://challenge.getsandbox.com/articles/{articleId}  
  * 200 OK. A JSON article, for ex.:
```javascript
{
  "id": "1",
  "title": "Bannana",
  "price": "2.50"
}
```
  * 404 Not Found If {articleId} is not existent
  
  
## Endpoints exposed
* POST   /api/carts : creates a cart
* GET    /api/carts/{cartId} : retrieves a cart
* POST   /api/carts/{cartId}/items : add an item to a cart
* DELETE /api/carts/{cartId}/items/{itemId} : removes an item from a cart
* DELETE /api/carts/{cartId}/items : clears a carts
* PUT    /api/carts/{cartId}/items/{itemId} : updates an item from a cart 


### Out of scope
* Security integration
* Caching
* Real DB integration (just in-memory for this propouse)
* Full error handling (just some 400 and 404 at this point)
