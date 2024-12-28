package spring.product.api.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.product.api.dao.ScientistDao;
import spring.product.api.dto.ScientistReqDto;
import spring.product.api.dto.ScientistResDto;
import spring.product.api.vo.ScientistVo;
import spring.product.api.vo.SongVo;

@RestController
@RequiredArgsConstructor
public class ScientistController {

  final ModelMapper modelMapper;
  final ScientistDao scientistDao;
  
  @GetMapping("/product/scientist/all")
  public ResponseEntity<ScientistResDto.ScientistList> findAll() {
    List<ScientistVo> result = scientistDao.findAll();

//    System.out.println("##1 scientists list = ");
//    System.out.println(result);

    
    ScientistResDto.ScientistList resDto = new ScientistResDto.ScientistList();
 
//    System.out.println("~~2 scientistlist list ~~ resDto = ");
//    System.out.println(resDto);
    
    List<ScientistResDto.Scientist> list = result.stream()
        .map(item -> modelMapper.map(item, ScientistResDto.Scientist.class))
        .collect(Collectors.toList());
    resDto.setList(list);
    
    // 자료구조 연습1 : 단순 List
//    List<String> songs = new ArrayList<String>();
//    
//    songs.add("somersault");
//    songs.add("cassidy");
//    songs.add("$10");
//    songs.add("havana");
//    songs.add("Cassidy");
//    songs.add("50 Ways");
//
//    System.out.println("songs list = " + songs);
//
//    Collections.sort(songs);
//    System.out.println("songs list (sorted) = " + songs);

    // 자료구조 연습2 : 클래스 List


    List<SongVo> songs = new ArrayList<>();
    
   
    
    songs.add(new SongVo("somersault","zero 7", 147));    
    songs.add(new SongVo("cassidy","greatful dead", 158));
    songs.add(new SongVo("$10","hitchhiker", 140));
    songs.add(new SongVo("havana","cabello", 105));
    songs.add(new SongVo("sCassidy","greatful dead", 158));
    songs.add(new SongVo("50 ways","simon", 102));
  
    System.out.println("song객체  list = " + songs);  
//    Collections.sort(songs);
    System.out.println("song객체 list (sorted) = " + songs);

    
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
  
  @GetMapping("/product/scientist")
  public ResponseEntity<ScientistResDto.Scientist> findByName(@RequestParam(name = "name") String name) {
    
    System.out.println(name);
    
    ScientistVo result = scientistDao.findByName(name);
//    String a  = 'http://localhost:8080/product/scientist/names?names=A';
    String a  = "http://localhost:8080/product/scientist/names?names=A";
    ScientistResDto.Scientist resDto = modelMapper.map(result, ScientistResDto.Scientist.class);
    return ResponseEntity.ok(resDto);

  }  

  @GetMapping("/product/scientist/names")
  public ResponseEntity<ScientistResDto.ScientistList> findNames(@RequestParam(name="names") String names) {
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
  public ResponseEntity<?> add(@RequestBody ScientistReqDto.AddScientist reqDto) {
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
