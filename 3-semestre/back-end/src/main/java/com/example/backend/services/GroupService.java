package com.example.backend.services;


import com.example.backend.controllers.UserController;
import com.example.backend.exceptions.RequiredObjectIsNullException;
import com.example.backend.exceptions.ResourceNotFoundException;
import com.example.backend.mapper.DozerMapper;
import com.example.backend.models.Group;
import com.example.backend.models.User;
import com.example.backend.repositories.GroupRepository;
import com.example.backend.repositories.UserRepository;
import com.example.backend.vo.GroupVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class GroupService {
    final GroupRepository repository;
    final UserRepository userRepository;

    public GroupService(GroupRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<GroupVO> findAll() {
        List<Group> groupDbList = repository.findAll();
        List<GroupVO> grupos = DozerMapper.parseListObject(groupDbList, GroupVO.class);
        grupos.forEach(user -> {
            try {
                user.add(linkTo(methodOn(UserController.class).findById(user.getId()))
                        .withSelfRel()
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        return grupos;
    }

    public GroupVO findById(Long id) throws Exception {
        Group groupdb = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        GroupVO groups = DozerMapper.parseObject(groupdb, GroupVO.class);
        groups.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
        groups.add(linkTo(methodOn(UserController.class).update(groups.removeLinks())).withSelfRel());
        groups.add(linkTo(methodOn(UserController.class).delete(id)).withSelfRel());
        return groups;
    }

    public GroupVO save(GroupVO groupVO) throws Exception {
        if (groupVO == null) throw new RequiredObjectIsNullException();
        Group group = DozerMapper.parseObject(groupVO, Group.class);
        Group groupDb = repository.save(group);
        groupVO = DozerMapper.parseObject(groupDb, GroupVO.class);
        groupVO.add(linkTo(methodOn(UserController.class).findById(groupVO.getId())).withSelfRel());
        return groupVO;
    }

    public GroupVO insertUsers(GroupVO groupVO) {
        List<User> users = new ArrayList<>();

        Optional<Group> dbGroupOp = repository.findById(groupVO.getId());
        if (dbGroupOp.isPresent()) {
            Group dbGroup = dbGroupOp.get();
            for (User user : groupVO.getUsers()) {
                Optional<User> managedUserOpt = userRepository.findById(user.getId());
                if (managedUserOpt.isPresent()) {
                    User managedUser = managedUserOpt.get();
                    users.add(managedUser);
                    managedUser.addGroup(dbGroup); // Use o método helper para sincronizar a relação bidirecional

                }
            }

            dbGroup.setUsers(users);
            dbGroup = repository.save(dbGroup);
            return DozerMapper.parseObject(dbGroup, GroupVO.class);
        }
        return null;
    }

    public GroupVO update(GroupVO groupVO) throws Exception {
        if (groupVO == null) throw new RequiredObjectIsNullException();

        Group group = DozerMapper.parseObject(groupVO, Group.class);
        group = repository.save(group);
        groupVO = DozerMapper.parseObject(group, GroupVO.class);
        groupVO.add(linkTo(methodOn(UserController.class).findById(groupVO.getId())).withSelfRel());
        return groupVO;
    }

    public String delete(Long id) {
        Optional<Group> groupDb = repository.findById(id);
        if (groupDb.isPresent()) {
            repository.deleteById(id);
            return "Group with id " + id + " has been deleted!";
        } else return "Group ID " + id + " not found!";
    }
}
