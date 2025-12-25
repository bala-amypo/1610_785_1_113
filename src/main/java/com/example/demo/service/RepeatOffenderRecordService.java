// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.RepeatOffenderRecord;

// public interface RepeatOffenderRecordService {

//     RepeatOffenderRecord recalculateRepeatOffender(Long studentId);

//     RepeatOffenderRecord getByStudentId(Long studentId);

//     List<RepeatOffenderRecord> getAllRepeatOffenders();
// } 

package com.example.demo.service;

import com.example.demo.entity.RepeatOffenderRecord;
import java.util.List;

public interface RepeatOffenderRecordService {

    RepeatOffenderRecord generateRecord(Long studentId);

    List<RepeatOffenderRecord> getAllRepeatOffenders();
}
