package tqs.marketplace.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tqs.marketplace.entities.Credential;
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

    protected UserinfoController(){}

    public UserinfoController(CredentialService credentialService, UserService userService){
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
    public ResponseEntity<Boolean> updateUser(@AuthenticationPrincipal String username, String newFName, String newLName, String newEmail, String newContact){
        return new ResponseEntity<Boolean>(userService.updateUser(
                username,
                newFName,
                newLName,
                newEmail,
                newContact
        ), HttpStatus.OK);
    }

    @PutMapping("/update/password")
    public ResponseEntity<Boolean> updatePassword(@AuthenticationPrincipal String username, String newPassword){
        return new ResponseEntity<Boolean>(credentialService.updateCredential(
                username,
                null,
                newPassword
        ), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Boolean> newUser(@AuthenticationPrincipal Credential user, String fName, String lName, String email, String contact, String password){
        return new ResponseEntity<Boolean>(userService.saveUser(
                fName,
                lName,
                email,
                contact,
                password
        ), HttpStatus.OK);
    }
}
