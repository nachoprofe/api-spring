package com.users2.users2.Repository;

import com.users2.users2.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{
}
