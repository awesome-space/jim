package com.poeticalcode.jim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.poeticalcode.jim.model.entity.MessageEntity;
import com.poeticalcode.jim.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author poeticalcode
 */
@Mapper
public interface MessageMapper extends BaseMapper<MessageEntity> {

}
