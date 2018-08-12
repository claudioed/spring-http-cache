package tech.claudioed.spring.http.cache.domain.repository;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.NonNull;
import lombok.val;
import org.springframework.stereotype.Service;
import tech.claudioed.spring.http.cache.domain.Product;

/**
 * @author claudioed on 12/08/18.
 * Project spring-http-cache
 */
@Service
public class ProductRepository {

  private final Map<String, Product> products = new HashMap<>();

  public Product add(@NonNull String name){
    val product = Product.builder().id(UUID.randomUUID().toString()).name(name).updatedAt(ZonedDateTime.now()).build();
    this.products.put(product.getId(),product);
    return product;
  }

  public Product product(@NonNull String id){
    return this.products.get(id);
  }

  public Product update(@NonNull String id,@NonNull String name){
    final Product product = this.products.get(id);
    product.setName(name);
    product.setUpdatedAt(ZonedDateTime.now());
    this.products.put(product.getId(),product);
    return product;
  }

}
