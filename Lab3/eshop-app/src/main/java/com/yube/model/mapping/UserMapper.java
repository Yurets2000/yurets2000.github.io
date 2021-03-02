package com.yube.model.mapping;

import com.yube.model.dto.User;
import com.yube.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {StringToIdMapper.class, ProductMapper.class}, componentModel = "spring")
public abstract class UserMapper implements BaseMapper<UserEntity, User> {

    @Override
    public abstract User map(UserEntity source);

    @Override
    public abstract UserEntity unmap(User source);
}
