package co.istad.sb7webmvc.mapper;

import co.istad.sb7webmvc.dto.CreateProductDto;
import co.istad.sb7webmvc.dto.UpdateProductDto;
import co.istad.sb7webmvc.model.Category;
import co.istad.sb7webmvc.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "supplierId", target = "supplier.id")
    Product fromCreateProductDto(CreateProductDto createProductDto);

    @Mapping(source = "supplierId", target = "supplier.id")
    Product fromUpdateProductDto(UpdateProductDto updateProductDto);

}
