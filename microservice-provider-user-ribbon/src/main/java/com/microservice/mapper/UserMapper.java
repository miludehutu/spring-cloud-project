package com.microservice.mapper;

import com.microservice.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User Sel_user_id(int id);
}
