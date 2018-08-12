package tech.claudioed.spring.http.cache.domain.resource;

import java.time.ZonedDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tech.claudioed.spring.http.cache.domain.Product;

/**
 * @author claudioed on 12/08/18.
 * Project spring-http-cache
 */
@Slf4j
@RestController
@RequestMapping("/api/cache")
public class ProductResourceWithLoadCache {

  private final RestTemplate restTemplate;

  public ProductResourceWithLoadCache(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> get(@PathVariable("id")String id){
    final ResponseEntity<Product> productResponseEntity = this.restTemplate
        .getForEntity("http://localhost:8080/api/products/" + id, Product.class);
    final Product product = productResponseEntity.getBody();
    log.info("HTTP status code : " + productResponseEntity.getStatusCode());
    return ResponseEntity.ok().lastModified(product.getUpdatedAt().toInstant().toEpochMilli()).body(product);
  }

}
