package com.company.dnevnik.services.impl;

import com.company.dnevnik.entities.HW;
import com.company.dnevnik.repositories.HWRepository;
import com.company.dnevnik.services.HWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HWServiceImpl implements HWService{
    @Autowired
    HWRepository hwRepository;

    @Override
    public List<HW> getAllHWs() {
        return hwRepository.findAll();
    }

    @Override
    public HW getHWById(Long id) {
        Optional<HW> hw = hwRepository.findById(id);
        return hw.orElse(new HW());
    }

    @Override
    public void updateHW(Long id, HW hw) {

    }

    @Override
    public void saveHW(HW hw) {
        hwRepository.save(hw);
    }

    @Override
    public void deleteHWById(Long id) {
        hwRepository.deleteById(id);
    }
}
