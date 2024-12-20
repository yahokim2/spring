package spring.product.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.product.api.dao.ScientistDao;
import spring.product.api.dto.ScientistReqDto;
import spring.product.api.dto.ScientistResDto;
import spring.product.api.vo.ScientistVo;

@RestController
@RequiredArgsConstructor
public class ScientistController {

  final ModelMapper modelMapper;
  final ScientistDao scientistDao;
  
  @GetMapping("/product/scientist/all")
  public ResponseEntity<ScientistResDto.ScientistList> findAll() {
    List<ScientistVo> result = scientistDao.findAll();
    ScientistResDto.ScientistList resDto = new ScientistResDto.ScientistList();
    List<ScientistResDto.Scientist> list = result.stream()
        .map(item -> modelMapper.map(item, ScientistResDto.Scientist.class))
        .collect(Collectors.toList());
    resDto.setList(list);
    return ResponseEntity.ok(resDto);
  }
  
  @GetMapping("/product/scientist/{id}")
  public ResponseEntity<ScientistResDto.Scientist> findById(@PathVariable(name = "id") Integer id) {
    String str = "1234567888";
    Integer num = Integer.parseInt(str);
    System.out.println(str);
    System.err.println(num);
    
    System.out.println(id);
    ScientistVo result = scientistDao.findById(id);
    
    ScientistResDto.Scientist resDto = modelMapper.map(result, ScientistResDto.Scientist.class);
    return ResponseEntity.ok(resDto);
  }
  
  @GetMapping("/product/scientist/name/{name}")
  public ResponseEntity<ScientistResDto.Scientist> findByName(@PathVariable(name = "name") String name) {
    
    System.out.println(name);
    
    ScientistVo result = scientistDao.findByName(name);
    
    ScientistResDto.Scientist resDto = modelMapper.map(result, ScientistResDto.Scientist.class);
    return ResponseEntity.ok(resDto);

  }  

  @GetMapping("/product/scientist/names/{names}")
  public ResponseEntity<ScientistResDto.ScientistList> findNames(@PathVariable(name="names") String names) {
    List<ScientistVo> result = scientistDao.findByNames(names);
    ScientistResDto.ScientistList resDto = new ScientistResDto.ScientistList();
    List<ScientistResDto.Scientist> list = result.stream()
        .map(item -> modelMapper.map(item, ScientistResDto.Scientist.class))
        .collect(Collectors.toList());
    resDto.setList(list);
    return ResponseEntity.ok(resDto);
  }
  
  
  @GetMapping("/product/scientist/test/{value}")
  public ResponseEntity findScientist(@PathVariable(name="value") String value) {
    try {
        Integer id = Integer.parseInt(value);
        ScientistVo result = scientistDao.findById(id);
        ScientistResDto.Scientist resDto = modelMapper.map(result, ScientistResDto.Scientist.class);
        return ResponseEntity.ok(resDto);

    } catch (NumberFormatException e) {
        ScientistVo result = scientistDao.findByName(value);
        ScientistResDto.Scientist resDto = modelMapper.map(result, ScientistResDto.Scientist.class);
        return ResponseEntity.ok(resDto);
    }   
  }
  
  @PostMapping("/product/scientist")
  public ResponseEntity<?> addById(@RequestBody ScientistReqDto.AddScientist reqDto) {
    ScientistVo vo = modelMapper.map(reqDto, ScientistVo.class);
    scientistDao.add(vo);
    return ResponseEntity.ok().body(null);
  }

  @PutMapping("/product/scientist")
  public ResponseEntity<?> modifyById(@RequestBody ScientistReqDto.ModifyScientist reqDto) {
    ScientistVo vo = modelMapper.map(reqDto, ScientistVo.class);
    scientistDao.modify(vo);
    return ResponseEntity.ok().body(null);
  }
  
  @DeleteMapping("/product/scientist")
  public ResponseEntity<?> deleteById(@RequestBody ScientistReqDto.DeleteScientist reqDto) {
    ScientistVo vo = modelMapper.map(reqDto, ScientistVo.class);
    scientistDao.delete(vo);
    return ResponseEntity.ok().body(null);
  }

//  @DeleteMapping("/product/scientist/{id}") //다른 방시 : 추후 시도
//  public ResponseEntity<Void> deleteItem(@PathVariable("id") Long id) {
//      itemService.delete(id);
//      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//  }
  
 
}
