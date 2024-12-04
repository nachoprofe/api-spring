package com.users2.users2.Service;

import com.users2.users2.Entity.UserRole;

import java.time.LocalDate;
import java.util.List;

public interface UserRoleService {
    public UserRole assignRoleToUser(int userId, int roleId, LocalDate assignedDate);
}
