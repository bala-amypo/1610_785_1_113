package com.example.demo.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.PenaltyAction;
// import com.example.demo.entity.IntegrityCase;

@Repository
public interface PenaltyActionRepository extends JpaRepository<PenaltyAction, Long> {

    // List<PenaltyAction> findByIntegrityCase(IntegrityCase integrityCase);
} 