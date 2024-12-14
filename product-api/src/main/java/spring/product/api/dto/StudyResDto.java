package spring.product.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class StudyResDto {

  private StudyResDto() {}
  
  @Data
  public static class Movie {
    private String title;
    private String genre;
    private Integer rating;
    
    void playIt() {
      System.out.println("Playing the movie");
    }
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class StudyRes {
    private String message;
    private Movie resmovie = new Movie();
//    resmovie.title = "aaa";  //*** s error
  }
  
}
