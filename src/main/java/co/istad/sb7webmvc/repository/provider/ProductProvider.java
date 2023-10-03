package co.istad.sb7webmvc.repository.provider;

import co.istad.sb7webmvc.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class ProductProvider implements ProviderMethodResolver {

    private final String TB_NAME = "products";

    public String insert() {
        return new SQL() {{
            INSERT_INTO(TB_NAME);
            VALUES("name", "#{p.name}");
            VALUES("slug", "#{p.slug}");
            VALUES("description", "#{p.description}");
            VALUES("price", "#{p.price}");
            VALUES("in_stock", "#{p.inStock}");
            VALUES("supplier_id", "#{p.supplier.id}");
        }}.toString();
    }

    public String insertProductCategory() {
        return new SQL() {{
            INSERT_INTO("products_categories");
            VALUES("product_id", "#{proId}");
            VALUES("category_id", "#{cateId}");
        }}.toString();
    }

    public String update(@Param("p") Product product) {
        return new SQL() {{
            UPDATE(TB_NAME);

            if (product.getName() != null && product.getSlug() != null) {
                SET("name = #{p.name}");
                SET("slug = #{p.slug}");
            }

            if (product.getDescription() != null)
                SET("description = #{p.description}");

            if (product.getSupplier() != null)
                SET("supplier_id = #{p.supplier.id}");

            WHERE("id = #{p.id}");
        }}.toString();
    }

}
