package net.transcom.transtv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class SurveyReportDTO {
    private Map<String, Double> question1Report;
    private Map<String, Double> question2Report;
    private Map<String, Double> question3Report;
    private Map<String, Double> question4Report;
    private Map<String, Double> question5Report;
}
