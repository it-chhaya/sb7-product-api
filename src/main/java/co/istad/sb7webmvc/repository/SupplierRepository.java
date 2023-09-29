package co.istad.sb7webmvc.repository;

import co.istad.sb7webmvc.model.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SupplierRepository {

    @Select("SELECT * FROM suppliers WHERE id = #{id}")
    Supplier selectProductSupplier(@Param("id") Integer id);

}
