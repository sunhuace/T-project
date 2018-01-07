package com.t.dao;

import java.util.List;
import java.util.Map;

import com.t.pojo.TItemCat;

public interface TItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TItemCat record);

    int insertSelective(TItemCat record);

    TItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TItemCat record);

    int updateByPrimaryKey(TItemCat record);
    
    List<TItemCat> getTItemCats(long parentId);
    
    List<TItemCat> getTItemCats2(Map<String, Object> map);
}