package com.company.dnevnik.services;

import com.company.dnevnik.entities.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long id);

    void updateTeacher(Long id, Teacher teacher);

    void saveTeacher(Teacher teacher);

    void deleteTeacherById(Long id);
}
