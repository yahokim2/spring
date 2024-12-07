package spring.product.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import spring.product.api.vo.ScientistVo;

public interface ScientistDao {

  List<ScientistVo> findAll();
  
  ScientistVo findById(@Param("id") String id);
}
