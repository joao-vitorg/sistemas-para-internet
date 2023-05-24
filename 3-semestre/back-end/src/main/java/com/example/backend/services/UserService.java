package com.example.backend.services;


import com.example.backend.controllers.UserController;
import com.example.backend.exceptions.RequiredObjectIsNullException;
import com.example.backend.exceptions.ResourceNotFoundException;
import com.example.backend.mapper.DozerMapper;
import com.example.backend.models.User;
import com.example.backend.repositories.UserRepository;
import com.example.backend.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserVO> findAll() {
        List<User> userDbList = repository.findAll();
        List<UserVO> users = DozerMapper.parseListObject(userDbList, UserVO.class);
        users.forEach(user -> {
            try {
                user.add(linkTo(methodOn(UserController.class).findById(user.getId()))
                        .withSelfRel()
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        return users;
    }

    public UserVO findById(Long id) throws Exception {
        User userDb = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        UserVO user = DozerMapper.parseObject(userDb, UserVO.class);
        user.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
        user.add(linkTo(methodOn(UserController.class).update(user)).withSelfRel());
        user.add(linkTo(methodOn(UserController.class).delete(id)).withSelfRel());
        return user;
    }

    public List<UserVO> findByGroupName(String groupName) {
        List<User> users = repository.findUsersByGroupName(groupName);
        List<UserVO> usersVO = DozerMapper.parseListObject(users, UserVO.class);
        usersVO.forEach(user -> {
            try {
                user.add(linkTo(methodOn(UserController.class).findById(user.getId()))
                        .withSelfRel()
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return usersVO;
    }

    public UserVO save(UserVO userVO) throws Exception {
        if (userVO == null) throw new RequiredObjectIsNullException();
        User user = DozerMapper.parseObject(userVO, User.class);
        var userDb = repository.save(user);
        userVO = DozerMapper.parseObject(userDb, UserVO.class);
        userVO.add(linkTo(methodOn(UserController.class).findById(userVO.getId())).withSelfRel());
        return userVO;
    }

    public UserVO update(UserVO userVO) throws Exception {
        if (userVO == null) throw new RequiredObjectIsNullException();

        User dbUser = repository.findById(userVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        User user = DozerMapper.parseObject(userVO, User.class);
        user = repository.save(user);
        userVO = DozerMapper.parseObject(user, UserVO.class);
        userVO.add(linkTo(methodOn(UserController.class).findById(userVO.getId())).withSelfRel());
        return userVO;
    }

    public String delete(Long id) {
        User dbUser = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.deleteById(id);
        return "User with id " + id + " has been deleted!";
    }
}
