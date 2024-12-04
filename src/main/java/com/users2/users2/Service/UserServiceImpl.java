package com.users2.users2.Service;

import java.util.List;
import java.util.Optional;

import com.users2.users2.Exceptions.BadRequestException;
import com.users2.users2.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users2.users2.Entity.UserEntity;
import com.users2.users2.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity save(UserEntity userEntity){
        try {
            return userRepository.save(userEntity);

        }catch (Exception ex){
            throw new BadRequestException("Ya existe ese usuario");
        }
    }
    public String delete(int id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Usuario eliminado";
        }
        throw new BadRequestException("El usuario con id " + id +" no existe");
    }
    public UserEntity getById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }
    public String login(UserEntity user){
        if(userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).size()>0){
            return "Se inició sesión con éxito";
        }
        throw new BadRequestException("Credenciales incorrectas");
    }
}
