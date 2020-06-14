package com.company.dnevnik.services;

import com.company.dnevnik.entities.ReportCard;

import java.util.List;

public interface ReportCardService {

    List<ReportCard> getAllReportCards();

    ReportCard getReportCardById(Long id);

    void updateReportCard(Long id, ReportCard reportCard);

    void saveReportCard(ReportCard reportCard);

    void deleteReportCardById(Long id);
}
