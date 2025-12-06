package com.itschool.springapp.service.impl;

import com.itschool.springapp.entity.User;
import com.itschool.springapp.model.UserDTO;
import com.itschool.springapp.repository.UserRepository;
import com.itschool.springapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO getUSer(long id) {

        User userFromDatabase = userRepository.findById(id).orElseThrow(); //throw exception in case findById() does not find anything

        //store retrieved info in a DTO object
        UserDTO localUserDTO = new UserDTO(userFromDatabase.getId(), userFromDatabase.getName(), userFromDatabase.getEmail(), userFromDatabase.getAge());

        return localUserDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> localUserList = userRepository.findAll();

        List<UserDTO> localUserDTOList = localUserList.stream()
                .map(lambdaParam -> new UserDTO(lambdaParam.getId(), lambdaParam.getName(), lambdaParam.getEmail(), lambdaParam.getAge()))
                .toList();

        return localUserDTOList;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User localUserInstance = new User(userDTO.name(), userDTO.email(), userDTO.age()); //we do NOT provide the ID of this database entry yet

        //save this new "user entity" into the database:
        User storedUser = userRepository.save(localUserInstance); //the returned "storedUser" will have the ID generated
        //we need to return UserDTO:
        UserDTO returnedUserDTO = new UserDTO(storedUser.getId(), storedUser.getName(), storedUser.getEmail(), storedUser.getAge());

        return returnedUserDTO;
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }
}
