package io.hoanghai.pharmacy.service;

import io.hoanghai.pharmacy.model.Role;
import io.hoanghai.pharmacy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(@Qualifier("roleRepository") RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public void save(Role item) {
        roleRepository.save(item);
    }
}
