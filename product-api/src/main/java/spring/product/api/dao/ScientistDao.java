package spring.product.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import spring.product.api.vo.ScientistVo;

public interface ScientistDao {

  List<ScientistVo> findAll();
  
  ScientistVo findById(@Param("id") Integer id);
  
  ScientistVo findByName(@Param("name") String name);

  List<ScientistVo> findByNames(@Param("names") String names);

  
  void add(ScientistVo vo);
  void modify(ScientistVo vo);
  void delete(ScientistVo vo);
}
