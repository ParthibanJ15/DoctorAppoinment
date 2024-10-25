package com.appointmentsystem.appointmentsystem.repository;

import com.appointmentsystem.appointmentsystem.model.MednDet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MednRepo extends JpaRepository<MednDet,Long> {
    MednDet findByid(Long id);
}
