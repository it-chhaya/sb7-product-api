package co.istad.sb7webmvc.service;

import co.istad.sb7webmvc.model.Product;

import java.util.List;

public interface ProductService {
    void createNewProduct(Product product);

    void deleteProductById(Integer id);

    void updateProductById(Integer id, Product product);

    List<Product> loadProducts();

    Product loadProductById(Integer id);
}
