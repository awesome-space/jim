package com.poeticalcode.jim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poeticalcode.jim.mapper.MessageMapper;
import com.poeticalcode.jim.model.entity.MessageEntity;
import com.poeticalcode.jim.service.IMessageService;
import org.springframework.stereotype.Service;


/**
 * @author poeticalcode
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, MessageEntity> implements IMessageService {
}
