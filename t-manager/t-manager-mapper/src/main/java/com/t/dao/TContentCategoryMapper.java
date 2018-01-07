package com.t.dao;

import java.util.List;
import java.util.Map;

import com.t.pojo.TContentCategory;

public interface TContentCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TContentCategory record);

    int insertSelective(TContentCategory record);

    TContentCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TContentCategory record);

    int updateByPrimaryKey(TContentCategory record);
    
    List<TContentCategory> getTContentCategoryList(Map<String, Object> map);
}