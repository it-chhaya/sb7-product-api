package co.istad.sb7webmvc.repository;

import co.istad.sb7webmvc.model.Category;
import co.istad.sb7webmvc.repository.provider.CategoryProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryRepository {

    @SelectProvider(CategoryProvider.class)
    List<Category> selectProductCategories(@Param("productId") Integer productId);
}
