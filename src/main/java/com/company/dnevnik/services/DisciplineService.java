package com.company.dnevnik.services;

import com.company.dnevnik.entities.Discipline;

import java.util.List;

public interface DisciplineService {

    List<Discipline> getAllDisciplines();

    Discipline getDisciplineById(Long id);

    void updateDiscipline(Long id, Discipline discipline);

    void saveDiscipline(Discipline discipline);

    void deleteDisciplineById(Long id);
}
