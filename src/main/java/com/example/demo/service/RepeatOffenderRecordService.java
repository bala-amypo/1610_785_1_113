
package com.example.demo.service;

import com.example.demo.entity.RepeatOffenderRecord;
import java.util.List;

public interface RepeatOffenderRecordService {

    RepeatOffenderRecord generateRecord(Long studentId);

    RepeatOffenderRecord recalculateRepeatOffender(Long studentId);

    RepeatOffenderRecord getByStudentId(Long studentId);

    List<RepeatOffenderRecord> getAllRepeatOffenders();
}      