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
import com.investpulse.api.util.PasswordEncryptor;

@Service
public class UserService {

    private PasswordEncryptor encryptor;

    private UserRepository userRepository;

    public UserService(PasswordEncryptor encryptor, UserRepository userRepository) {
        this.encryptor = encryptor;
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

        user.setPassword(encryptor.encrypt(user.getPassword()));
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

        if (!encryptor.matches(user.getPassword(), existingUser.getPassword())) {
            existingUser.setPassword(encryptor.encrypt(user.getPassword()));
        }

        existingUser.setUpdatedAt(Instant.now());

        return userRepository.save(existingUser).toUserResponseDTO();
    }

    public UserResponseDTO patchUpdateUser(String email, UserPatchUpdateDTO user) {
        if (user.getFullName() == null && user.getPassword() == null) {
            throw new IllegalArgumentException("Deve ser fornecido pelo menos um campo para atualizar o usuario");
        }

        Optional<User> optionalUser = userRepository.findById(email);
        if (!optionalUser.isPresent()) {
            throw new NotFoundException();
        }

        User existingUser = optionalUser.get();

        if (user.getFullName() != null && !user.getFullName().equals(existingUser.getFullName())) {
            existingUser.setFullName(user.getFullName());
        }

        if (user.getPassword() != null && !encryptor.matches(user.getPassword(), existingUser.getPassword())) {
            existingUser.setPassword(encryptor.encrypt(user.getPassword()));
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
