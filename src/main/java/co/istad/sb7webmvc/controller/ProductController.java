package co.istad.sb7webmvc.controller;

import co.istad.sb7webmvc.model.Product;
import co.istad.sb7webmvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public List<Product> getProducts() {
        return productService.loadProducts();
    }
    @PostMapping
    public Product createNewProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id,
                                 @RequestBody Product newProduct) {
        return productService.updateProduct(id, newProduct);
    }
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }
    @PatchMapping
    public String updateProductPartially() {
        return "Update product partially";
    }
    @GetMapping("/{id}/{slug}")
    public Product getProductById(@PathVariable("id") Integer proId,
                                  @PathVariable("slug") String proSlug) {
        System.out.println("Product ID: " + proId);
        System.out.println("Product Slug: " + proSlug);
        return productService.loadProductById(proId);
    }
    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false,defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "true") Boolean status) {
        System.out.println("Name: " + name);
        System.out.println("Status: " + status);
        return productService.searchProducts(name, status);
    }
}
