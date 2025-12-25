 package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.entity.IntegrityCase;

public interface PenaltyActionRepository extends JpaRepository<PenaltyAction, Long> {

    List<PenaltyAction> findByIntegrityCase(IntegrityCase integrityCase);
}