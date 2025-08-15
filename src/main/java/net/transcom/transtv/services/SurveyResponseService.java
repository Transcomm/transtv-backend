package net.transcom.transtv.services;

import net.transcom.transtv.dto.SurveyReportDTO;
import net.transcom.transtv.entities.SurveyResponse;
import org.springframework.data.domain.Page;

public interface SurveyResponseService {

    SurveyResponse saveResponse(SurveyResponse response);
    Page<SurveyResponse> getAllResponses(int page, int size);
    SurveyReportDTO generateReport();

}
