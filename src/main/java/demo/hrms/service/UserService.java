package demo.hrms.service;

import demo.hrms.domain.User;
import demo.hrms.domain.Role;
import demo.hrms.repository.RoleRepository;
import demo.hrms.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User addNewUser(User user) {
        return this.userRepository.save(user);
    }

    public User deleteUser(long id) {
        return this.userRepository.deleteById(id);
    }

    public List<User> listAllUser() {
        return this.userRepository.findAll();
    }

    public User loadUserById(long id) {
        return this.userRepository.findById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findIdByName(name);
    }
}
