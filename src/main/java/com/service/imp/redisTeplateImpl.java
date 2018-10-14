package com.service.imp;

import com.service.redistepmlate;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class redisTeplateImpl implements redistepmlate {

    @Resource
    private RedisTemplate redisTemplate;

    @Bean
    public RedisTemplate<String, Object> stringSerializerRedisTemplate() {
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        return  redisTemplate;
    }

    @Override
    public void addSno(String stuNo, String name) throws Exception {

        if(redisTemplate.opsForSet().isMember(stuNo,name).booleanValue()){
            String tExceptionMsg = "学生添加重复,学号为:" + stuNo;
            System.out.println("学号添加到缓存中失败！！");
            throw new Exception(tExceptionMsg);
        }else{
            redisTemplate.opsForSet().add(stuNo,name);
            System.out.println("学号添加到缓存中成功！！");
        }

    }
}
