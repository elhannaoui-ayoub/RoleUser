package ma.enset.roleuser.metier;

import ma.enset.roleuser.dao.Role;
import ma.enset.roleuser.dao.User;
import ma.enset.roleuser.repositories.RoleRepository;
import ma.enset.roleuser.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

//on utilise @Component ou @service(metier) ou @Entity(dao) pour dire à spring d'unstancier la classse au moment du demarage
@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
        role.getUsers().add(user);}
    }

    @Override
    public User authenticate(String userName, String password) {
        User user = userRepository.findUserByUserName(userName);
        if(user !=null && user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials") ;
    }
}
