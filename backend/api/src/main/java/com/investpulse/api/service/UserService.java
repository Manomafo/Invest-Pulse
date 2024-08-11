package com.investpulse.api.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.investpulse.api.dto.UserRequestDTO;
import com.investpulse.api.dto.UserResponseDTO;
import com.investpulse.api.dto.UserPatchUpdateDTO;
import com.investpulse.api.dto.UserPutUpdateDTO;
import com.investpulse.api.exception.EntityAlreadyExistsException;
import com.investpulse.api.exception.NotFoundException;
import com.investpulse.api.model.User;
import com.investpulse.api.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();

        if (userList.isEmpty()) {
            throw new NotFoundException("Não foi possível encontrar usuários", "Não há usuários cadastrados");
        }

        return userList.stream()
                .map(User::toUserResponseDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (!optionalUser.isPresent()) {
            throw new NotFoundException();
        }

        return new UserResponseDTO(optionalUser.get());
    }

    public UserResponseDTO postCreateUser(UserRequestDTO user) {
        Optional<User> optionalUserById = userRepository.findById(user.getEmail());
        if (optionalUserById.isPresent()) {
            throw new EntityAlreadyExistsException();
        }

        Optional<User> optionalUserByPhoneNumber = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (optionalUserByPhoneNumber.isPresent()) {
            throw new EntityAlreadyExistsException();
        }

        return userRepository.save(user.toUser()).toUserResponseDTO();

    }

    public UserResponseDTO putUpdateUser(String email, UserPutUpdateDTO user) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (!optionalUser.isPresent()) {
            throw new NotFoundException();
        }

        User existingUser = optionalUser.get();

        if (!user.getFullName().equals(existingUser.getFullName())) {
            existingUser.setFullName(user.getFullName());
        }

        if (!user.getPassword().equals(existingUser.getPassword())) {
            existingUser.setPassword(user.getPassword());
        }

        existingUser.setUpdatedAt(Instant.now());

        return userRepository.save(existingUser).toUserResponseDTO();
    }

    public UserResponseDTO patchUpdateUser(String email, UserPatchUpdateDTO user) {
        if (user.getFullName() == null && user.getPassword() == null) {
            return null;
        }

        Optional<User> optionalUser = userRepository.findById(email);
        if (!optionalUser.isPresent()) {
            throw new NotFoundException();
        }

        User existingUser = optionalUser.get();

        if (user.getFullName() != null && !user.getFullName().equals(existingUser.getFullName())) {
            existingUser.setFullName(user.getFullName());
        }

        if (user.getPassword() != null && !user.getPassword().equals(existingUser.getPassword())) {
            existingUser.setPassword(user.getPassword());
        }

        existingUser.setUpdatedAt(Instant.now());

        return userRepository.save(existingUser).toUserResponseDTO();
    }

    public void deleteUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (!optionalUser.isPresent()) {
            throw new NotFoundException();
        } else {
            userRepository.deleteById(email);
        }
    }
}
