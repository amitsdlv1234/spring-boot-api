package backend.spring_boot_api.Service;

import backend.spring_boot_api.Entity.UserEntity;
import backend.spring_boot_api.Exception.ResourceNotFoundException;
import backend.spring_boot_api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity>getAllUsers() {
        return userRepository.findAll();
    }
    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity updateUser(int id,UserEntity user){
        UserEntity present=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id "+id));
        present.setName(user.getName());
        present.setEmail(user.getEmail());
        present.setPhone(user.getPhone());
        present.setDob(user.getDob());
        present.setRole(user.getRole());

        return userRepository.save(present);
    }
    public void deleteUser(int id){
        UserEntity user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not present with id "+id));
        userRepository.delete(user);
    }
    public UserEntity getUserById(int id){
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user not found with id "+id));
    }
}
