package co.istad.sb7webmvc.repository;

import co.istad.sb7webmvc.model.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface ProductRepository {

    @Select("SELECT * FROM products")
    @Results(id = "productResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "inStock", column = "in_stock"),
            @Result(property = "categories", column = "id",
                many = @Many(select = "co.istad.sb7webmvc.repository.CategoryRepository.selectProductCategories")),
            @Result(property = "supplier", column = "supplier_id",
                one = @One(select = "co.istad.sb7webmvc.repository.SupplierRepository.selectProductSupplier"))
    })
    List<Product> select();

    @Select("SELECT * FROM products WHERE id = #{id}")
    @ResultMap("productResultMap")
    Optional<Product> selectById(@Param("id") Integer id);

}
