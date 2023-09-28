package co.istad.sb7webmvc.model;

import lombok.*;

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
}
