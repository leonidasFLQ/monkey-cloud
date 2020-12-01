package com.monkey4cloud.monkey.auth.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.monkey4cloud.monkey.auth.constant.RedisConstant;

import cn.hutool.core.collection.CollUtil;

/**
 * 资源与角色匹配关系管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class ResourceServiceImpl {

    private Map<String, List<String>> resourceRolesMap;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void initData() {
        resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/api/hello", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/api/user/currentUser", CollUtil.toList("ADMIN", "TEST"));
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }
}
