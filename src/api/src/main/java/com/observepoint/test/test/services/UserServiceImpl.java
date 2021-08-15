package com.observepoint.test.test.services;

import com.observepoint.test.test.exceptions.ResourceNotFoundException;
import com.observepoint.test.test.models.Role;
import com.observepoint.test.test.models.User;
import com.observepoint.test.test.models.UserRoles;
import com.observepoint.test.test.repositories.UserRepository;
import com.observepoint.test.test.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value="userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleRepository userRoleRepo;

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        userRepo.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findUserById(long userId) throws
            ResourceNotFoundException
    {
        return userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Id" + userId + "Not Found"));
    }


    @Transactional
    @Override
    public User save(User newuser)
    {

        User newUserMade = new User();

        if(newuser.getUserid() != 0)
        {
            userRepo.findById(newuser.getUserid());
            newUserMade.setUserid(newuser.getUserid());
        }
        newUserMade.setFirstname(newuser.getFirstname());
        newUserMade.setLastname(newuser.getLastname());
        newUserMade.setCode(newuser.getCode());

        newUserMade.getRoles()
                .clear();
        for (UserRoles ur : newuser.getRoles())
        {
            Role role = roleService.findRoleById(ur.getRole().getRoleid());
            UserRoles newUserRole = new UserRoles(
                    newUserMade,
                    role
            );
            newUserMade.getRoles().add(newUserRole);
        }

        return userRepo.save(newUserMade);
    }

    @Transactional
    @Override
    public User update(User updateUser, long userId)
    {
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User" + userId + "Not Found!"));

        if (updateUser.getFirstname() != null)
        {
            existingUser.setFirstname(updateUser.getFirstname().toLowerCase());
        }
        if (updateUser.getLastname() != null)
        {
            existingUser.setLastname(updateUser.getLastname().toLowerCase());
        }
        if (updateUser.getCode() != null)
        {
            existingUser.setCode(updateUser.getCode());
        }

        if (updateUser.getRoles()
                .size() > 0)
        {
            existingUser.getRoles()
                    .clear();
            for (UserRoles ur: updateUser.getRoles())
            {
                UserRoles addRole = userRoleRepo.findById(ur.getRole().getRoleid())
                        .orElseThrow(() -> new EntityNotFoundException("Role id" + ur.getRole().getRoleid()));

                existingUser.getRoles()
                        .add(addRole);
            }
        }
        return userRepo.save(existingUser);
    }

    @Transactional
    @Override
    public void delete(long userId)
    {
        userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User id" + userId + "Not Found to Delete."));
        userRepo.deleteById(userId);
    }
}
