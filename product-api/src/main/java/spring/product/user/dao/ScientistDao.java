package spring.product.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import spring.product.user.vo.ScientistVo;

public interface ScientistDao {

  List<ScientistVo> findAll();
  
  ScientistVo findById(@Param("id") String id);
}
