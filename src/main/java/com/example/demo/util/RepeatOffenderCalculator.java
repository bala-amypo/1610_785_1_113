package com.example.demo.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

@Component
public class RepeatOffenderCalculator {

    // ✅ THIS METHOD WAS MISSING – NOW ADDED
    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile student,
            List<IntegrityCase> cases) {

        int totalCases = (cases == null) ? 0 : cases.size();
        String severity = "LOW";

        if (totalCases >= 4) {
            severity = "HIGH";
        } else if (totalCases == 2 || totalCases == 3) {
            severity = "MEDIUM";
        }

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setTotalCases(totalCases);
        record.setFlagSeverity(severity);

        return record;
    }
}
