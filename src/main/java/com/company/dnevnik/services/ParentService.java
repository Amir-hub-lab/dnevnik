package com.company.dnevnik.services;

import com.company.dnevnik.entities.Parent;

import java.util.List;

public interface ParentService {

    List<Parent> getAllParents();

    Parent getParentById(Long id);

    void updateParent(Long id, Parent parent);

    void saveParent(Parent parent);

    void deleteParentById(Long id);
}
