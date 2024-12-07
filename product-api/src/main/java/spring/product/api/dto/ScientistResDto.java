package spring.product.api.dto;

import java.util.List;

import lombok.Data;
import spring.product.api.vo.ScientistVo;

@Data
public class ScientistResDto {

  public static class Scientist extends ScientistVo { }
  
  @Data
  public static class ScientistList {
    private List<Scientist> list;
  }
}