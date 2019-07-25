package io.github.jass2125.beer.api.user.resource;

import io.github.jass2125.beer.api.model.user.User;
import io.github.jass2125.beer.api.user.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody User user) {
        String token = this.userService.login(user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        return ResponseEntity.ok().headers(headers).build();
    }

    @PostMapping("new")
    public ResponseEntity newUser(@RequestBody @Valid User user) {
        this.userService.save(user);
        return ResponseEntity.ok().build();
    }

}
