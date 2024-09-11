package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.User;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) throws MiException {
        return userRepository.findById(id)
                .orElseThrow(() -> new MiException("User not found with id: " + id));
    }

    @Override
    @Transactional
    public User createUser(User user) throws MiException {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new MiException("Error creating user!");
        }
    }

    @Override
    @Transactional
    public User updateUser(Long id, User user) throws MiException {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new MiException("User not found with id: " + id));

        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        existingUser.setRequests(user.getRequests());

        try {
            return userRepository.save(existingUser);
        } catch (Exception e) {
            throw new MiException("Error updating user!");
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long id) throws MiException {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new MiException("User not found with id: " + id));

        try {
            userRepository.delete(existingUser);
        } catch (Exception e) {
            throw new MiException("Error deleting user!");
        }
    }
}
