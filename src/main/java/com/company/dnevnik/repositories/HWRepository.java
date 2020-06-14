package com.company.dnevnik.repositories;

import com.company.dnevnik.entities.HW;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HWRepository extends JpaRepository<HW, Long>{
}
