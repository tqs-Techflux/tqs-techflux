package tqs.marketplace.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tqs.marketplace.entities.User;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins= "http://localhost:4200")
@RestController()
public class UserinfoController {
    @GetMapping("/me")
    public ResponseEntity currentUser(@AuthenticationPrincipal User user){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", user.getUsername());
        model.put("roles", user.getAuthorities()
                .stream()
                .map(a -> ((GrantedAuthority) a).getAuthority())
                .collect(toList())
        );
        return ok(model);
    }
}
