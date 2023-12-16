package org.itmentor.service;

import org.itmentor.repository.UserRepository;
import org.itmentor.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    public void save(User user) {
        userRepository.save(user);
    }
    public User show(int id) {
        return userRepository.findById(id).get();
    }

    public void remove(int id) {
        userRepository.deleteById(id);
    }
    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurName(updatedUser.getSurName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }
}