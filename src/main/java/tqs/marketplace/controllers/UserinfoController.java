package tqs.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tqs.marketplace.entities.Credential;
import tqs.marketplace.entities.User;
import tqs.marketplace.services.CredentialService;
import tqs.marketplace.services.UserService;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins= "*")
@RestController()
public class UserinfoController {

    private CredentialService credentialService;

    private UserService userService;

    @Autowired
    public UserinfoController(UserService userService,CredentialService credentialService){
        this.credentialService = credentialService;
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity currentUser(@AuthenticationPrincipal Credential user){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", user.getUsername());
        model.put("details", user.getUser());
        model.put("roles", user.getAuthorities()
                .stream()
                .map(a -> ((GrantedAuthority) a).getAuthority())
                .collect(toList())
        );
        return ok(model);
    }

    @PutMapping("/update/details")
    public ResponseEntity<User> updateUser(@AuthenticationPrincipal Credential user, String newFName, String newLName, String newEmail, String newContact){
        return new ResponseEntity<User>(userService.updateUser(
                user.getUsername(),
                newFName,
                newLName,
                newEmail,
                newContact
        ), HttpStatus.OK);
    }

    @PutMapping("/update/password")
    public ResponseEntity<Credential> updatePassword(@AuthenticationPrincipal Credential user, String newPassword){
        return new ResponseEntity<Credential>(credentialService.updateCredential(
                user.getUsername(),
                null,
                newPassword
        ), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Boolean> newUser(String fName, String lName, String email, String contact, String password){
        System.out.println(fName + lName + email);
        return new ResponseEntity<Boolean>(userService.saveUser(
                fName,
                lName,
                email,
                contact,
                password
        ), HttpStatus.OK);
    }
}
