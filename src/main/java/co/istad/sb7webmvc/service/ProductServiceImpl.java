package co.istad.sb7webmvc.service;

import co.istad.sb7webmvc.model.Product;
import co.istad.sb7webmvc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createNewProduct(Product product) {

    }

    @Override
    public void deleteProductById(Integer id) {

    }

    @Override
    public void updateProductById(Integer id, Product product) {

    }

    @Override
    public List<Product> loadProducts() {
        return productRepository.select();
    }

    @Override
    public Product loadProductById(Integer id) {
        return productRepository.selectById(id).orElseThrow();
    }
}
