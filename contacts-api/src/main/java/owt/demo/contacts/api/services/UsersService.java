package owt.demo.contacts.api.services;

import owt.demo.contacts.api.exceptions.NotFoundException;
import owt.demo.contacts.model.User;

import java.util.List;

public interface UsersService {
    List<User> getUsers();
    User getUserById(Long id) throws NotFoundException;
}
