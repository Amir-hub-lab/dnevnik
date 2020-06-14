package com.company.dnevnik.services.impl;

import com.company.dnevnik.entities.Parent;
import com.company.dnevnik.repositories.ParentRepository;
import com.company.dnevnik.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService{
    @Autowired
    ParentRepository parentRepository;

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getParentById(Long id) {
        Optional<Parent> parent = parentRepository.findById(id);
        return parent.orElse(new Parent());
    }

    @Override
    public void updateParent(Long id, Parent parent) {

    }

    @Override
    public void saveParent(Parent parent) {
        parentRepository.save(parent);
    }

    @Override
    public void deleteParentById(Long id) {
        parentRepository.deleteById(id);
    }
}
