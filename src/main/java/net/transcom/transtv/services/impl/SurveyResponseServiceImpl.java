package net.transcom.transtv.services.impl;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.entities.SurveyResponse;
import net.transcom.transtv.repository.SurveyResponseRepository;
import net.transcom.transtv.services.SurveyResponseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

}
