package tqs.marketplace.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqs.marketplace.auth.JwtTokenProvider;
import tqs.marketplace.entities.User;
import tqs.marketplace.services.UserService;

import java.util.List;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userPartialName}")
    public ResponseEntity<List<User>> searchByName(@PathVariable("userPartialName") String userPartialName) {
        return new ResponseEntity<List<User>>(userService.findByName(userPartialName), HttpStatus.OK);
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<User> searchById(@PathVariable("userId") int userId) {
        return new ResponseEntity<User>(userService.findById(userId), HttpStatus.OK);
    }

    // Returns the user who owns a token
    @GetMapping("/get")
    public ResponseEntity<User> populate(@RequestHeader("Authorization") String token) {
        String tkn = token.split(" ")[1];
        JwtTokenProvider provider = new JwtTokenProvider();
        String email = provider.extractUsername(tkn);
        return new ResponseEntity<User>(userService.loadUserByEmail(email),HttpStatus.OK);
    }


}