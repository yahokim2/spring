package spring.product.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GreetingResDto {
  
  private GreetingResDto() {}
  
  @Data
  public static class Person {
    private String name;
    private Integer age;
  }
  
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class GreetingRes {
    private String message;
    private Person person = new Person();

//    private String name;
//    private Integer age;
  }
}
