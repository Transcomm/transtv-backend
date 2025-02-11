package net.transcom.transtv.services.impl;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.entities.Survey;
import net.transcom.transtv.repository.SurveyRepository;
import net.transcom.transtv.services.SurveyService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

}
