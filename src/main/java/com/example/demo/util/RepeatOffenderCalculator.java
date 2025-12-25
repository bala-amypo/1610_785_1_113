package com.example.demo.util;

import java.util.List;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile student,
            List<IntegrityCase> cases) {

        int total = cases.size();
        String severity = "LOW";

        if (total == 2) {
            severity = "MEDIUM";
        } else if (total >= 4) {
            severity = "HIGH";
        }

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setTotalCases(total);
        record.setFlagSeverity(severity);

        return record;
    }
}
