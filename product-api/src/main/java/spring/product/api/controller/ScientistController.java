package spring.product.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.product.api.dao.ScientistDao;
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
  public ResponseEntity<ScientistResDto.Scientist> findById(@PathVariable(name = "id") String id) {
    ScientistVo result = scientistDao.findById(id);
    ScientistResDto.Scientist resDto = modelMapper.map(result, ScientistResDto.Scientist.class);
    return ResponseEntity.ok(resDto);
  }
}
