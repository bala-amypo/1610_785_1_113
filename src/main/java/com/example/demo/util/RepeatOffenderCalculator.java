// package com.example.demo.util;

// import java.util.List;

// import org.springframework.stereotype.Component;

// import com.example.demo.entity.IntegrityCase;
// import com.example.demo.entity.RepeatOffenderRecord;
// import com.example.demo.entity.StudentProfile;

// @Component
// public class RepeatOffenderCalculator {

//     // ✅ THIS METHOD WAS MISSING – NOW ADDED
//     public RepeatOffenderRecord computeRepeatOffenderRecord(
//             StudentProfile student,
//             List<IntegrityCase> cases) {

//         int totalCases = (cases == null) ? 0 : cases.size();
//         String severity = "LOW";

//         if (totalCases >= 4) {
//             severity = "HIGH";
//         } else if (totalCases == 2 || totalCases == 3) {
//             severity = "MEDIUM";
//         }

//         RepeatOffenderRecord record = new RepeatOffenderRecord();
//         record.setStudentProfile(student);
//         record.setTotalCases(totalCases);
//         record.setFlagSeverity(severity);

//         return record;
//     }
// }






package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RepeatOffenderCalculator {
    
    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile student, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setTotalCases(cases.size());
        
        if (cases.size() == 1) {
            record.setFlagSeverity("LOW");
        } else if (cases.size() == 2 || cases.size() == 3) {
            record.setFlagSeverity("MEDIUM");
        } else if (cases.size() >= 4) {
            record.setFlagSeverity("HIGH");
        }
        
        return record;
    }
}