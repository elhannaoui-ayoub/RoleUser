package ma.enset.roleuser.metier;

import ma.enset.roleuser.dao.Role;
import ma.enset.roleuser.dao.User;



public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String name);
    void addRoleToUser(String username,String roleName);
    User authenticate(String userName,String password);
}
