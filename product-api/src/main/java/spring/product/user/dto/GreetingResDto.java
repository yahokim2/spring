package spring.product.user.dto;

import lombok.Data;

public class GreetingResDto {
  
  private GreetingResDto() {}
  
  @Data
  public static class GreetingRes {
    private String message;
  }
}