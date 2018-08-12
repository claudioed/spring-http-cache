package tech.claudioed.spring.http.cache.domain.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import tech.claudioed.spring.http.cache.domain.Product;
import tech.claudioed.spring.http.cache.domain.repository.ProductRepository;

/**
 * @author claudioed on 12/08/18.
 * Project spring-http-cache
 */
@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product get(@NonNull String id){
    return this.productRepository.product(id);
  }

  public Product add(@NonNull String name){
    return this.productRepository.add(name);
  }

  public Product update(@NonNull String id,@NonNull String name){
    return this.productRepository.update(id,name);
  }

}
