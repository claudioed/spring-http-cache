package tech.claudioed.spring.http.cache.domain.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.claudioed.spring.http.cache.domain.Product;
import tech.claudioed.spring.http.cache.domain.resource.data.NewProductRequest;
import tech.claudioed.spring.http.cache.domain.service.ProductService;

/**
 * @author claudioed on 12/08/18.
 * Project spring-http-cache
 */
@RestController
@RequestMapping("/api/products")
public class ProductResource {

  private final ProductService productService;

  public ProductResource(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> get(@PathVariable("id")String id){
    final Product product = this.productService.get(id);
    return ResponseEntity.ok().lastModified(product.getUpdatedAt().toInstant().toEpochMilli()).body(product);
  }

  @PostMapping
  public ResponseEntity<Product> add(@RequestBody NewProductRequest request){
    final Product product = this.productService.add(request.getName());
    return ResponseEntity.status(201).lastModified(product.getUpdatedAt().toInstant().toEpochMilli()).body(product);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> add(@PathVariable("id")String id,@RequestBody NewProductRequest request){
    final Product product = this.productService.update(id,request.getName());
    return ResponseEntity.status(202).lastModified(product.getUpdatedAt().toInstant().toEpochMilli()).body(product);
  }

}
