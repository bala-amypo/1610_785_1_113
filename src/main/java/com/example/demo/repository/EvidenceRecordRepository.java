//  package com.example.demo.repository;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.demo.entity.EvidenceRecord;
// import com.example.demo.entity.IntegrityCase;

// public interface EvidenceRecordRepository extends JpaRepository<EvidenceRecord, Long> {

//     List<EvidenceRecord> findByIntegrityCase(IntegrityCase integrityCase);
// }  





package com.example.demo.repository;

import com.example.demo.entity.EvidenceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenceRecordRepository extends JpaRepository<EvidenceRecord, Long> {
}
