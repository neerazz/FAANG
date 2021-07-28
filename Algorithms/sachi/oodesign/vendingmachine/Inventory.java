package oodesign.vendingmachine;

import java.util.List;

public class Inventory {

    private List<Product> productList;

    public Inventory() {

    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addBulkProducts(List<Product> newProducts) {
        productList.addAll(newProducts);
    }

    public void updateQuantity(int productId, int newQuantity) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                product.setQuantity(newQuantity);
            }
        }
    }
}
