package com.company.dnevnik.services.impl;

import com.company.dnevnik.entities.Discipline;
import com.company.dnevnik.repositories.DisciplineRepository;
import com.company.dnevnik.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements DisciplineService{
    @Autowired
    DisciplineRepository disciplineRepository;

    @Override
    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }

    @Override
    public Discipline getDisciplineById(Long id) {
        Optional<Discipline> discipline = disciplineRepository.findById(id);
        return discipline.orElse(new Discipline());
    }

    @Override
    public void updateDiscipline(Long id, Discipline discipline) {

    }

    @Override
    public void saveDiscipline(Discipline discipline) {
        disciplineRepository.save(discipline);
    }

    @Override
    public void deleteDisciplineById(Long id) {
        disciplineRepository.deleteById(id);
    }
}
