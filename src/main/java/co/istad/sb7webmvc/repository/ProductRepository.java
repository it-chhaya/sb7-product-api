package co.istad.sb7webmvc.repository;

import co.istad.sb7webmvc.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface ProductRepository {

    @Select("SELECT * FROM products")
    List<Product> select();

    @Select("SELECT * FROM products WHERE id = #{id}")
    Optional<Product> selectById(@Param("id") Integer id);

}
