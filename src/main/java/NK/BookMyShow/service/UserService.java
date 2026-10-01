package NK.BookMyShow.service;

import NK.BookMyShow.dto.LoginRequest;
import NK.BookMyShow.dto.UserRequest;
import NK.BookMyShow.entity.User;
import NK.BookMyShow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //Register
    public User register(UserRequest request){
        if( userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email Already Exicts :" + request.getEmail());
        }
        User user=User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phone(request.getPhone())
                .build();
        return userRepository.save(user);
    }

    //login
    public User login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Registered With Email: " + request.getEmail()));
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Passward");
        }
        return user;

    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User Not Founf By Id: "+id));
    }

}
