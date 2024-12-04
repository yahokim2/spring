package spring.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "spring")
public class ProductMain {
  
  public static void main(String[] args) {
    SpringApplication.run(ProductMain.class, args);
  }
  
}
