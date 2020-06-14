package com.company.dnevnik.services.impl;

import com.company.dnevnik.entities.Mark;
import com.company.dnevnik.repositories.MarkRepository;
import com.company.dnevnik.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements MarkService{
    @Autowired
    MarkRepository markRepository;

    @Override
    public List<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    @Override
    public Mark getMarkById(Long id) {
        Optional<Mark> mark = markRepository.findById(id);
        return mark.orElse(new Mark());
    }

    @Override
    public void updateMark(Long id, Mark mark) {

    }

    @Override
    public void saveMark(Mark mark) {
        markRepository.save(mark);
    }

    @Override
    public void deleteMarkById(Long id) {
        markRepository.deleteById(id);
    }
}
