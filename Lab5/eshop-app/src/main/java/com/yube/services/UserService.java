package com.yube.services;

import com.yube.model.dto.User;
import com.yube.model.entity.UserEntity;
import com.yube.model.mapping.UserMapper;
import com.yube.model.mapping.utils.MappingUtils;
import com.yube.repositories.declaration.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final CryptographicService cryptographicService;

    public List<User> getAll() {
        return MappingUtils.mapAll(userRepository.getAll(), userMapper::map);
    }

    public User getById(String id) {
        return userMapper.map(userRepository.get(UUID.fromString(id)).get());
    }

    public User findByEmailAndPassword(String email, String password) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            if (cryptographicService.verifyHash(password, userEntity.getPassword())) {
                return userMapper.map(userEntity);
            }
        }
        return null;
    }

    public User create(User user) {
        user.setPassword(cryptographicService.hash(user.getPassword()));
        UserEntity userEntity = userMapper.unmap(user);
        return userMapper.map(userRepository.create(userEntity));
    }

    public User update(User user) {
        UserEntity sourceUserEntity = userMapper.unmap(user);
        UserEntity targetUserEntity = userRepository.get(sourceUserEntity.getId()).get();
        BeanUtils.copyProperties(sourceUserEntity, targetUserEntity);
        UserEntity updatedUserEntity = userRepository.update(targetUserEntity);
        return userMapper.map(updatedUserEntity);
    }

    public void delete(String id) {
        userRepository.delete(UUID.fromString(id));
    }
}
