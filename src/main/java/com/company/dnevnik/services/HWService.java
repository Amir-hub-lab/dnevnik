package com.company.dnevnik.services;

import com.company.dnevnik.entities.HW;

import java.util.List;

public interface HWService {

    List<HW> getAllHWs();

    HW getHWById(Long id);

    void updateHW(Long id, HW hw);

    void saveHW(HW hw);

    void deleteHWById(Long id);
}
