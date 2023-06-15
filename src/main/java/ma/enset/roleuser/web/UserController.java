package ma.enset.roleuser.web;

import ma.enset.roleuser.dao.User;
import ma.enset.roleuser.metier.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/{userName}")
    public User user(@PathVariable String userName){
        User user=userService.findUserByUserName(userName);
        return user;
    }
}
