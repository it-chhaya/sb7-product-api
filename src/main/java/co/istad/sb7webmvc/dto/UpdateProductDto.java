package co.istad.sb7webmvc.dto;

import java.util.List;

public record UpdateProductDto(String name,
                               String description,
                               Integer supplierId,
                               List<Integer> categoryIds) {
}
