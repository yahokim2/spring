package spring.product.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.product.api.dto.GreetingResDto;
import spring.product.api.dto.GreetingResDto.GreetingRes;

@RestController
@RequiredArgsConstructor
public class GreetingController {
  
  @GetMapping("/product/greeting")
  public ResponseEntity<GreetingRes> greeting(
      @RequestParam(name = "lang", required = false) String lang) {
    GreetingResDto.GreetingRes resDto = new GreetingResDto.GreetingRes();
    if ("en".equals(lang)) {
      resDto.setMessage("hello");
    } else if ("de".equals(lang)) {
      resDto.setMessage("Hallo");
    } else {
      resDto.setMessage("안녕하세요");
    }
    
    return ResponseEntity.ok(resDto);
  }
  
}
