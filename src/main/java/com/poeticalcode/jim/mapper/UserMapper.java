package com.poeticalcode.jim.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.poeticalcode.jim.model.entity.UserEntity;

/**
 * @author poeticalcode
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
