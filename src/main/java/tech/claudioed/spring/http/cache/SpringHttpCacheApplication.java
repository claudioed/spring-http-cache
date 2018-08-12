package tech.claudioed.spring.http.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringHttpCacheApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringHttpCacheApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate(){
    final RestTemplate restTemplate = new RestTemplate();
    return restTemplate;
  }
}
