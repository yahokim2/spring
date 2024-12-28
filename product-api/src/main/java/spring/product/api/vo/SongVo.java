package spring.product.api.vo;

import lombok.Data;

@Data
public class SongVo {
  private String title;
  private String artist;
  private int bpm;
  
  public SongVo (String title, String artist, int bpm){
    this.title = title;
    this.artist = artist;
    this.bpm = bpm;
  }
}