package net.transcom.transtv.services.impl;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.dto.SurveyReportDTO;
import net.transcom.transtv.entities.SurveyResponse;
import net.transcom.transtv.repository.SurveyResponseRepository;
import net.transcom.transtv.services.SurveyResponseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyResponseServiceImpl implements SurveyResponseService {

    private final SurveyResponseRepository surveyResponseRepository;

    public SurveyResponse saveResponse(SurveyResponse response) {
        return surveyResponseRepository.save(response);
    }

    public Page<SurveyResponse> getAllResponses(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("submittedAt").descending());
        return surveyResponseRepository.findAll(pageable);
    }

    public SurveyReportDTO generateReport() {
        long total = surveyResponseRepository.count();
        if (total == 0) {
            return new SurveyReportDTO(Map.of(), Map.of(), Map.of(), Map.of(), Map.of());
        }

        Map<String, Double> q1 = convert(surveyResponseRepository.getQuestion1Stats(), total);
        Map<String, Double> q2 = convert(surveyResponseRepository.getQuestion2Stats(), total);

        // Question 3: calculate based on total selections (not total responses)
        List<Object[]> q3Stats = surveyResponseRepository.getQuestion3Stats();
        long totalSelections = q3Stats.stream()
                .mapToLong(row -> ((Number) row[1]).longValue())
                .sum();
        Map<String, Double> q3 = convert(q3Stats, totalSelections);

        Map<String, Double> q4 = convert(surveyResponseRepository.getQuestion4Stats(), total);
        Map<String, Double> q5 = convert(surveyResponseRepository.getQuestion5Stats(), total);

        return new SurveyReportDTO(q1, q2, q3, q4, q5);
    }

    private Map<String, Double> convert(List<Object[]> stats, long divisor) {
        if (divisor == 0) return Map.of();

        return stats.stream()
                .collect(Collectors.toMap(
                        row -> row[0] != null ? row[0].toString() : "Unknown",
                        row -> (double) Math.round((Double.valueOf(row[1].toString()) * 100.0) / divisor * 1.0) // round to whole number
                ));
    }

}
