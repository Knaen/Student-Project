package com.example.studentproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentStatisticsResponse {

    private long totalStudents;

    private double averageAge;

    private double averageGpa;

    private long excellentStudents;

    private long failedStudents;

    private Map<String, Long> ageGroups;
}
