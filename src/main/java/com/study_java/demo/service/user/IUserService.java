package com.study_java.demo.service.user;

import com.study_java.demo.dto.UserDTO;
import com.study_java.demo.models.User;
import com.study_java.demo.request.CreateUserRequest;
import com.study_java.demo.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDTO convertUserToDTO(User user);
}
