package me.wonwoo.service;

import me.wonwoo.domain.RoleHierarchy;
import me.wonwoo.repository.RoleHierarchyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
public class RoleHierarchyService {

    @Autowired
    private RoleHierarchyRepository roleHierarchyRepository;

    @Transactional
    public String findAllHierarchy() {

        List<RoleHierarchy> rolesHierarchy = roleHierarchyRepository.findAll();

        Iterator<RoleHierarchy> itr = rolesHierarchy.iterator();
        StringBuffer concatedRoles = new StringBuffer();
        while (itr.hasNext()) {
            RoleHierarchy model = itr.next();
            if (model.getParentRole() != null) {
                concatedRoles.append(model.getParentRole().getRoleId());
                concatedRoles.append(" > ");
                concatedRoles.append(model.getRoleId());
                concatedRoles.append("\n");
            }
        }
        return concatedRoles.toString();

    }
}
