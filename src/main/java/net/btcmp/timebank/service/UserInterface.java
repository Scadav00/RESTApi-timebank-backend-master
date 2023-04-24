package net.btcmp.timebank.service;

import net.btcmp.timebank.dto.NewUserDto;
import net.btcmp.timebank.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserInterface {

    User getUserById(Long id);
    List<User>getAllUsers(int page, int size);
    User registerUser(NewUserDto user);
    Boolean PasswordMatching(String enteredPassword, String encodedPassword);

//        net.btcmp.timebank.entity.Service getUsersHours(Long userId);

}
