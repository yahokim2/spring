package spring.product.api.dto;

import lombok.Data;

public class GreetingReqDto {
  
  private GreetingReqDto() {}

  @Data
  public static class GreetingReq {
    private String lang;
  }
}
