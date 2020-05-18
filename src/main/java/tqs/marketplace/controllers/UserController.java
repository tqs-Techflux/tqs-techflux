package tqs.marketplace.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tqs.marketplace.entities.User;
import tqs.marketplace.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<User> search() {
        return userService.search();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> search(@PathVariable("userId") int userId) {
        return userService.search(userId);
    }

}