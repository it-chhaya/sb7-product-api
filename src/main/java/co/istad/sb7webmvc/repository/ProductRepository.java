package co.istad.sb7webmvc.repository;

import co.istad.sb7webmvc.model.Product;
import co.istad.sb7webmvc.repository.provider.ProductProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface ProductRepository {

    @Select("SELECT * FROM products ORDER BY id DESC")
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

    @InsertProvider(ProductProvider.class)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(@Param("p") Product product);

    @InsertProvider(ProductProvider.class)
    void insertProductCategory(@Param("proId") Integer productId,
                               @Param("cateId") Integer categoryId);

    @UpdateProvider(ProductProvider.class)
    void update(@Param("p") Product product);

    @Delete("DELETE FROM products_categories WHERE product_id = #{proId}")
    void deleteProductCategories(@Param("proId") Integer productId);
}
