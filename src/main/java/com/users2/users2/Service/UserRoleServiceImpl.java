package com.users2.users2.Service;

import com.users2.users2.Entity.RoleEntity;
import com.users2.users2.Entity.UserEntity;
import com.users2.users2.Entity.UserRole;
import com.users2.users2.Exceptions.BadRequestException;
import com.users2.users2.Exceptions.EntityNotFoundException;
import com.users2.users2.Repository.UserRepository;
import com.users2.users2.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public UserRole assignRoleToUser(int userId, int roleId, LocalDate assignedDate) {
        UserEntity user = userService.getById(userId);
        RoleEntity role = roleService.getById(roleId);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRole.setAssignedDate(assignedDate);

        return userRoleRepository.save(userRole);
    }
}
