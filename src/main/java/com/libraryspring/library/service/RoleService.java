package com.libraryspring.library.service;

import com.libraryspring.library.domain.Role;
import com.libraryspring.library.domain.enums.RoleType;
import com.libraryspring.library.exception.ResourceNotFoundException;
import com.libraryspring.library.exception.message.ErrorMessage;
import com.libraryspring.library.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByType(RoleType roleType){
        Role role = roleRepository.findByType(roleType).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessage.ROLE_NOT_FOUND_EXCEPTION, roleType.name())));
        return role;
    }
}
