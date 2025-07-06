package backend.spring_boot_api.Controller;

import backend.spring_boot_api.Entity.UserEntity;
import backend.spring_boot_api.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public UserEntity addUser(@Valid @RequestBody UserEntity user){
        return userService.createUser(user);
    }
    @PutMapping("/{id}")
    public  UserEntity updateUser(@PathVariable int id,@Valid @RequestBody UserEntity user){
        return userService.updateUser(id,user);
    }
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "user deleted with id "+id;
    }
}
