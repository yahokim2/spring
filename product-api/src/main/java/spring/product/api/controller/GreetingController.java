package spring.product.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.product.api.dto.GreetingResDto;
import spring.product.api.dto.GreetingResDto.GreetingRes;
import spring.product.api.dto.StudyResDto;
import spring.product.api.dto.StudyResDto.StudyRes;

@RestController
@RequiredArgsConstructor
public class GreetingController {

  // 단순 GET 요청 처리 예시
  @GetMapping("/product/greeting")
  public String greet() {
      return "Hello, Welcome to Spring Boot!";
  }
  
  @GetMapping("/product/greeting2/{var2}")
  public String greetWithName(@PathVariable(name="var2") String var2) {
    //  public String greetWithName(@PathVariable String var4) {
    //  ******* Whitelabel Error Page ~~ There was an unexpected error (type=Internal Server Error, status=500).

      return "Hello, " + var2 + "!";
  }  

  // Request Param을 사용하는 GET 요청 예시(1) 
  @GetMapping("/product/greeting3") 
  public String greetWithParams(@RequestParam(name="param3", required = false) String param3) {
    return "Greetings, Mr./Ms. " + param3;
} 
  // Request Param을 사용하는 GET 요청 예시(2)  
  @GetMapping("/product/greeting4")
  public String greetWithParams(@RequestParam(name="param4") String param4, @RequestParam(name="isFormal", defaultValue = "false") boolean isFormal) {
    if (isFormal) {
        return "Greetings, Mr./Ms. " + param4;
    } else {
        return "~~~~~~~~~~ Hello, " + param4 + "!";
    }
} 


  // class 형태 출력 (1)
  @GetMapping("/product/greeting123")
  public ResponseEntity<GreetingRes> greeting123() {
    GreetingResDto.GreetingRes resDto = new GreetingResDto.GreetingRes();
    resDto.setMessage("Long time no see! Hi~");
    GreetingResDto.Person p123 = resDto.getPerson();
    p123.setName("John");
    p123.setAge(33);

    return ResponseEntity.ok(resDto);
  }
  
  // class 형태 출력 (2)
  @GetMapping("/product/greeting124")
  public ResponseEntity<GreetingRes> greeting124(
      @RequestParam(name = "lang", required = false) String lang) {
    GreetingResDto.GreetingRes resDto = new GreetingResDto.GreetingRes();
    
    if ("en".equals(lang)) {
      resDto.setMessage("hello");
    } else if ("de".equals(lang)) {
      resDto.setMessage("Hallo");
    } else if ("zh".equals(lang)) {
      resDto.setMessage("Ni~hao~");  
      
    } else {
      resDto.setMessage("안녕");
    }
    GreetingResDto.Person p21 = resDto.getPerson();
    p21.setName("I'm JVM");
    p21.setAge(33);
    
    return ResponseEntity.ok(resDto);
  }

  // list 형태 출력 (1)
//  @GetMapping("/product/greeting23")
//  public ResponseEntity<List<GreetingResDto.GreetingRes>> greeting23() {
//    List<GreetingResDto.GreetingRes> list = Arrays.asList(
//        new GreetingResDto.GreetingRes("hi", "hubert", 11),
//        new GreetingResDto.GreetingRes("hello", "mgkim", 20)
//        );
//The method asList(T...) in the type Arrays is not applicable for the arguments (GreetingResDto.GreetingRes, GreetingResDto.GreetingRes)

//
//    return ResponseEntity.ok(list);
//  }
  // class 형태 출력 (2)
  @GetMapping("/product/study000")
  public ResponseEntity<StudyRes> study000() {
    StudyResDto.StudyRes resDto = new StudyResDto.StudyRes();
    
    resDto.setMessage("~자바 공부~");
    
    StudyResDto.Movie movie1 = resDto.getResmovie();
    
//    movie.setTitle("바람과 함께 사라지다");
//    movie.setGenre("사랑");
//    movie.setRating(3);
//    
//    movie.setTitle("매트릭스");
//    movie.setGenre("가상현실");
//    movie.setRating(1);
    
    movie1.setTitle("베테랑");
    movie1.setGenre("액션코믹4");
    movie1.setRating(2);
    
    return ResponseEntity.ok(resDto);
  }

} 
