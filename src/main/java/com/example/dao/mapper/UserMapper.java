package com.example.dao.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by yanglikun on 2017/3/19.
 */
@Mapper
public interface UserMapper {

    void save(User user);

    User selectById(Long id);

}
