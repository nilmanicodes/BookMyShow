package NK.BookMyShow.controller;

import NK.BookMyShow.dto.LoginRequest;
import NK.BookMyShow.dto.UserRequest;
import NK.BookMyShow.entity.User;
import NK.BookMyShow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRequest request){
        return ResponseEntity.ok(userService.register(request));
    }
    @PostMapping("/login")
    public  ResponseEntity<User> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(userService.login(request));
    }
    @GetMapping
    private ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

}
