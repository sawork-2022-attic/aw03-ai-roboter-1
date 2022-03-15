package com.example.webpos.biz;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;

import java.util.List;

public interface PosService {
    Cart getCart();

    Cart newCart();

    void checkout(Cart cart);

    void total(Cart cart);

    boolean add(Product product, int amount);

    boolean add(String productId, int amount);

    boolean modify(String productId, int amount);

    boolean delete(String productId);

    List<Product> products();

    boolean empty();
}
