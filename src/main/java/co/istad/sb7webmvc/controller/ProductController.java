package co.istad.sb7webmvc.controller;

import co.istad.sb7webmvc.dto.CreateProductDto;
import co.istad.sb7webmvc.dto.UpdateProductDto;
import co.istad.sb7webmvc.model.Product;
import co.istad.sb7webmvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> loadProducts() {
        return productService.loadProducts();
    }

    @GetMapping("/{id}")
    public Product loadProductById(@PathVariable("id") Integer proId) {
        return productService.loadProductById(proId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewProduct(@RequestBody CreateProductDto createProductDto) {
        System.out.println(createProductDto.supplierId());
        System.out.println(createProductDto.categoryIds());
        productService.createNewProduct(createProductDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Integer id,
                                 @RequestBody UpdateProductDto updateProductDto) {
        productService.updateProductById(id, updateProductDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }

    @PatchMapping
    public String updateProductPartially() {
        return "Update product partially";
    }

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false,defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "true") Boolean status) {
        System.out.println("Name: " + name);
        System.out.println("Status: " + status);
        return null;
    }
}
