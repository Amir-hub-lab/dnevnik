package com.company.dnevnik.services;

import com.company.dnevnik.entities.Mark;

import java.util.List;

public interface MarkService {

    List<Mark> getAllMarks();

    Mark getMarkById(Long id);

    void updateMark(Long id, Mark mark);

    void saveMark(Mark mark);

    void deleteMarkById(Long id);
}
