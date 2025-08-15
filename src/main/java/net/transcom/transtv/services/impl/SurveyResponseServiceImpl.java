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
        List<SurveyResponse> responses = surveyResponseRepository.findAll();
        long total = responses.size();

        if (total == 0) {
            return new SurveyReportDTO(Map.of(), Map.of(), Map.of(), Map.of(), Map.of());
        }

        Map<String, Double> q1 = calculatePercentage(responses.stream()
                .map(SurveyResponse::getQuestion1)
                .collect(Collectors.toList()), total);

        Map<String, Double> q2 = calculatePercentage(responses.stream()
                .map(SurveyResponse::getQuestion2)
                .collect(Collectors.toList()), total);

        // Flatten question3 (list answers into one list)
        List<String> q3List = responses.stream()
                .flatMap(r -> r.getQuestion3().stream())
                .collect(Collectors.toList());
        Map<String, Double> q3 = calculatePercentage(q3List, total);

        Map<String, Double> q4 = calculatePercentage(responses.stream()
                .map(SurveyResponse::getQuestion4)
                .collect(Collectors.toList()), total);

        Map<String, Double> q5 = calculatePercentage(responses.stream()
                .map(SurveyResponse::getQuestion5)
                .collect(Collectors.toList()), total);

        return new SurveyReportDTO(q1, q2, q3, q4, q5);
    }

    private Map<String, Double> calculatePercentage(List<String> answers, long total) {
        return answers.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> (e.getValue() * 100.0) / total
                ));
    }

}
