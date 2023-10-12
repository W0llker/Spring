package repository;

import domain.Product;

public interface ProductRepository {
    void addProduct(Product product);
    void showProduct();
}
