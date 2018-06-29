package com.org.springboot.mapper;


import com.org.springboot.model.db.WashProductInfoDO;

public interface WashProductInfoDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(WashProductInfoDO record);

    int insertSelective(WashProductInfoDO record);

    WashProductInfoDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WashProductInfoDO record);

    int updateByPrimaryKey(WashProductInfoDO record);
}