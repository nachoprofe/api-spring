package com.users2.users2.Service;

import com.users2.users2.Entity.RoleEntity;
import com.users2.users2.Exceptions.EntityNotFoundException;
import com.users2.users2.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public RoleEntity getById(int id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
    }
}
