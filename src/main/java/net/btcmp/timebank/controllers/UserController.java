package net.btcmp.timebank.controllers;

import net.btcmp.timebank.dto.NewUserDto;
import net.btcmp.timebank.entity.User;
import net.btcmp.timebank.service.ServiceInterface;
import net.btcmp.timebank.service.UserInterface;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
// odobraty final
    private final UserInterface userInterface;

    private final ServiceInterface serviceInterface;

    public UserController(UserInterface userInterface, ServiceInterface serviceInterface) {
        this.userInterface = userInterface;
        this.serviceInterface = serviceInterface;
    }


    //    getAllUsersByUserId
    @GetMapping("/users")
    public List<User> getAllUsers(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "20", required = false) int size){

        return userInterface.getAllUsers(page, size);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userInterface.getUserById(id);
    }


    //    registracka
    @PostMapping("/user")
    public User registerUser(@RequestBody @Valid NewUserDto user) {
        return userInterface.registerUser(user);

    }

    @GetMapping("/user/password")
    public Boolean PasswordMatching(@RequestParam String enteredPassword, @RequestParam String encodedPassword) {
        return userInterface.PasswordMatching(enteredPassword, encodedPassword);
    }
// get estimated_hours by serviceId
//    @GetMapping("/users/{id}/hours")
//    public Service userHours(@PathVariable Long id) {
//        return userInterface.getUsersHours(id);
//    }




}
