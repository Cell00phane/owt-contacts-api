package owt.demo.contacts.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owt.demo.contacts.api.exceptions.NotFoundException;
import owt.demo.contacts.api.utils.DTOConverter;
import owt.demo.contacts.model.User;
import owt.demo.contacts.model.UserEntity;
import owt.demo.contacts.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImplementation implements UsersService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        for (UserEntity userEntity: userRepository.findAll()) {
            users.add(DTOConverter.userEntityToDTO(userEntity));
        }

        return users;
    }

    @Override
    public User getUserById(Long id) throws NotFoundException {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No user found with id " + id));

        return DTOConverter.userEntityToDTO(userEntity);
    }
}
