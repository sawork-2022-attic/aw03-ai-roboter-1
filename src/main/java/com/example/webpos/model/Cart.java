package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        var target = getItem(item.getProduct().getId());
        if (target != null) {
            target.setQuantity(target.getQuantity() + item.getQuantity());
            return true;
        }
        return items.add(item);
    }

    public Item getItem(String productId) {
        for (Item currentItem : items) {
            if (currentItem.getProduct().getId().equals(productId)) {
                return currentItem;
            }
        }
        return null;
    }

    public boolean deleteItem(String productId) {
        var item = getItem(productId);
        if (item == null)
            return false;
        return getItems().remove(item);
    }

    public boolean modifyItem(String productId, int amount) {
        var item = getItem(productId);
        if (item == null) {
            return false;
        }
        item.setQuantity(amount);
        return true;
    }

    public int itemsTotalPrice() {
        int total = 0;
        for (var item: items){
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        return total;
    }

    public boolean empty() {
        if (items != null) {
            items.clear();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (items.size() == 0) {
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n");

        for (Item item : items) {
            stringBuilder.append(item.toString()).append("\n");
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n");

        stringBuilder.append("Total...\t\t\t").append(total);

        return stringBuilder.toString();
    }

}
