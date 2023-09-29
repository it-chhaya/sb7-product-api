package co.istad.sb7webmvc.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Integer id;
    private String name;
    private String slug;
    private Double price;
    private Boolean inStock;
    private Supplier supplier;
    private List<Category> categories;
}
