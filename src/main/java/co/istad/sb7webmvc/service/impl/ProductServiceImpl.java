package co.istad.sb7webmvc.service.impl;

import co.istad.sb7webmvc.dto.CreateProductDto;
import co.istad.sb7webmvc.dto.UpdateProductDto;
import co.istad.sb7webmvc.mapper.ProductMapper;
import co.istad.sb7webmvc.model.Category;
import co.istad.sb7webmvc.model.Product;
import co.istad.sb7webmvc.model.Supplier;
import co.istad.sb7webmvc.repository.ProductRepository;
import co.istad.sb7webmvc.service.ProductService;
import co.istad.sb7webmvc.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    @Override
    public void updateProductById(Integer id, UpdateProductDto updateProductDto) {

        Product product = productMapper.fromUpdateProductDto(
                updateProductDto
        );
        product.setId(id);

        if (product.getName() != null) {
            product.setSlug(SlugUtil.toSlug(updateProductDto.name()));
        }

        productRepository.update(product);

        // Reset product category
        productRepository.deleteProductCategories(product.getId());

        // Start inserting a product category
        updateProductDto.categoryIds().forEach(cateId ->
                productRepository.insertProductCategory(product.getId(), cateId));
    }

    @Transactional
    @Override
    public void createNewProduct(CreateProductDto createProductDto) {
        // Map DTO to POJO
        Product product = productMapper.fromCreateProductDto(createProductDto);
        product.setSlug(SlugUtil.toSlug(createProductDto.name()));

        // Start inserting a product
        productRepository.insert(product);

        System.out.println("INSERT PRODUCT ID: " + product.getId());

        // Start inserting a product category
        createProductDto.categoryIds().forEach(id ->
                productRepository.insertProductCategory(product.getId(), id));
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
