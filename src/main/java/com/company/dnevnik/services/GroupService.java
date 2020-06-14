package com.company.dnevnik.services;

import com.company.dnevnik.entities.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroups();

    Group getGroupById(Long id);

    void updateGroup(Long id, Group group);

    void saveGroup(Group group);

    void deleteGroupById(Long id);
}
