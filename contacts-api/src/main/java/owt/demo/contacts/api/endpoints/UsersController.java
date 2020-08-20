package owt.demo.contacts.api.endpoints;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import owt.demo.contacts.api.UserApi;
import owt.demo.contacts.api.services.UsersService;
import owt.demo.contacts.model.User;

import java.util.List;

@Controller
@Api(value = "User", description = "the User API", tags = {"user"})
public class UsersController implements UserApi {
    @Autowired
    UsersService usersService;

    @Override
    public ResponseEntity<List<User>> getUsers() throws Exception {
        return ResponseEntity.ok(usersService.getUsers());
    }

    @Override
    public ResponseEntity<User> getUserById(Long userId) throws Exception {
        return ResponseEntity.ok(usersService.getUserById(userId));
    }
}
