package spring.product.api.dto;

import lombok.Data;

@Data
public class ScientistReqDto {

//  public static class Scientist extends ScientistVo { }
  @Data
  public static class AddScientist {
    private String name;
  }
  @Data
  public static class ModifyScientist {
    private Integer id;  // private int id : int changed String 
    private String name;
  }
  
  @Data
  public static class DeleteScientist {
    private Integer id;  
  }
}