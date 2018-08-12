package tech.claudioed.spring.http.cache.domain;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author claudioed on 12/08/18.
 * Project spring-http-cache
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  private String id;

  private String name;

  private ZonedDateTime updatedAt;

}
