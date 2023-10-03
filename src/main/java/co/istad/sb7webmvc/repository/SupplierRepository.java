package co.istad.sb7webmvc.repository;

import co.istad.sb7webmvc.model.Supplier;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SupplierRepository {

    @Select("SELECT * FROM suppliers WHERE id = #{id}")
    Supplier selectProductSupplier(@Param("id") Integer id);

    @Insert("""
                INSERT INTO suppliers (company, since, status)
                VALUES (#{s.company}, #{s.since}, #{s.status})
            """)
    void insert(@Param("s") Supplier supplier);

    @Update("""
                UPDATE suppliers
                SET company = #{s.company},
                    status = #{s.status}
                WHERE id = #{s.id}
            """)
    void update(@Param("s") Supplier supplier);

    @Delete("DELETE FROM suppliers WHERE id = #{id}")
    void delete(@Param("id") Integer id);

}
