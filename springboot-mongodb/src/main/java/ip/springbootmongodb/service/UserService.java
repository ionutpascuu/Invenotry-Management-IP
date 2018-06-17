package ip.springbootmongodb.service;

import ip.springbootmongodb.model.User;
import ip.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
       return userRepository.insert(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User find(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User findbyId(String id) {
        return userRepository.findOne(id);
    }//era Long
}

