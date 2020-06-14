package com.company.dnevnik.services.impl;

import com.company.dnevnik.entities.ReportCard;
import com.company.dnevnik.repositories.ReportCardRepository;
import com.company.dnevnik.services.ReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportCardServiceImpl implements ReportCardService{
    @Autowired
    ReportCardRepository reportCardRepository;

    @Override
    public List<ReportCard> getAllReportCards() {
        return reportCardRepository.findAll();
    }

    @Override
    public ReportCard getReportCardById(Long id) {
        Optional<ReportCard> reportCard = reportCardRepository.findById(id);
        return reportCard.orElse(new ReportCard());
    }

    @Override
    public void updateReportCard(Long id, ReportCard reportCard) {

    }

    @Override
    public void saveReportCard(ReportCard reportCard) {
        reportCardRepository.save(reportCard);
    }

    @Override
    public void deleteReportCardById(Long id) {
        reportCardRepository.deleteById(id);
    }
}
