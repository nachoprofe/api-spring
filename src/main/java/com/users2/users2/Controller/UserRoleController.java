package com.users2.users2.Controller;

import com.users2.users2.Entity.UserRole;
import com.users2.users2.Service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user-role")
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    @PostMapping("/assign-role")
    public ResponseEntity<?> assignRoleToUser(@RequestBody Map<String, Object> requestData) {
        int userId = (int) requestData.get("userId");
        int roleId = (int) requestData.get("roleId");
        LocalDate assignedDate = LocalDate.parse((String) requestData.get("assignedDate"));

        UserRole userRole = userRoleService.assignRoleToUser(userId, roleId, assignedDate);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRole);
    }

}
