package com.example.backendendproject.Services;

import com.example.backendendproject.Dtos.UserDto;
import com.example.backendendproject.Exceptions.RecordNotFoundException;
import com.example.backendendproject.Exceptions.UsernameNotFoundException;
import com.example.backendendproject.Models.User;
import com.example.backendendproject.Repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class UserService {

        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public List<UserDto> getUsers() {
            List<UserDto> collection = new ArrayList<>();
            List<User> list = userRepository.findAll();
            for (User user : list) {
                collection.add(fromUser(user));
            }
            return collection;
        }

        public UserDto getUser(String username) {
            UserDto dto = new UserDto();
            Optional<User> user = userRepository.findById(username);
            if (user.isPresent()){
                dto = fromUser(user.get());
            }else {
                throw new UsernameNotFoundException(username);
            }
            return dto;
        }

        public boolean userExists(String username) {
            return userRepository.existsById(username);
        }

        public String createUser(UserDto userDto) {
            User newUser = userRepository.save(toUser(userDto));
            return newUser.getUsername();
        }

        public void deleteUser(String username) {
            userRepository.deleteById(username);
        }

        public void updateUser(String username, UserDto newUser) {
            if (!userRepository.existsById(username)) throw new RecordNotFoundException();
            User user = userRepository.findById(username).get();
            user.setPassword(newUser.getPassword());
            userRepository.save(user);
        }

        public static UserDto fromUser(User user){

            var dto = new UserDto();

            dto.username = user.getUsername();
            dto.password = user.getPassword();
            dto.email = user.getEmail();

            return dto;
        }

        public User toUser(UserDto userDto) {

            var user = new User();

            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setEmail(userDto.getEmail());

            return user;
        }

    public void addAuthority(String newUsername, String role_user) {
    }

    public Object getAuthorities(String username) {
        return null;
    }

    public void removeAuthority(String username, String authority) {
    }
}
