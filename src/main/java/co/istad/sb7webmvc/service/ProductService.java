package co.istad.sb7webmvc.service;

import co.istad.sb7webmvc.dto.CreateProductDto;
import co.istad.sb7webmvc.dto.UpdateProductDto;
import co.istad.sb7webmvc.model.Product;

import java.util.List;

public interface ProductService {
    void updateProductById(Integer id, UpdateProductDto updateProductDto);
    void createNewProduct(CreateProductDto createProductDto);

    void deleteProductById(Integer id);

    void updateProductById(Integer id, Product product);

    List<Product> loadProducts();

    Product loadProductById(Integer id);
}
