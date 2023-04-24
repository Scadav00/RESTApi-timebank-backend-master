package net.btcmp.timebank.service;

import net.btcmp.timebank.dto.NewUserDto;
import net.btcmp.timebank.entity.User;
import net.btcmp.timebank.exception.PasswordNotEqualException;
import net.btcmp.timebank.exception.UserNotFoundException;
import net.btcmp.timebank.repository.ServiceRepository;
import net.btcmp.timebank.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserImpl implements UserInterface {

    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;

    public UserImpl(UserRepository userRepository, ServiceRepository serviceRepository) {

        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(
                        MessageFormat.format("User with id [{0}] not found",id)));

        return user;
    }

    @Override
    public List<User> getAllUsers(int page, int size) {
        Page<User> userList = userRepository.findAll(PageRequest.of(page, size));
            return userList.stream().toList();
    }

    @Override
    public User registerUser(NewUserDto user) {
        if(!user.getPassword().equals(user.getConfirmPassword())) {
            throw new PasswordNotEqualException("Passwords don't match.");
        }

        User userTosave = new User();
        userTosave.setUsername(user.getUsername());
        userTosave.setPhone(user.getPhone());
        userTosave.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(userTosave);
    }

    @Override
    public Boolean PasswordMatching(String enterPassword, String encodPassword) {
        return new BCryptPasswordEncoder().matches(enterPassword, encodPassword);
    }

//    @Override
//    public net.btcmp.timebank.entity.Service getUsersHours(Long userId) {
//        return serviceRepository.getUsersHours(userId);
//    }



}
