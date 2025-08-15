package net.transcom.transtv.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import net.transcom.transtv.entities.SurveyResponse;
import net.transcom.transtv.repository.SurveyRepository;
import net.transcom.transtv.repository.SurveyResponseRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyImportServiceImpl {
    private final SurveyResponseRepository surveyResponseRepository;
    private final ObjectMapper objectMapper;

    public void importFromJson(String filePath) {
        try {
            List<SurveyResponse> responses = objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<List<SurveyResponse>>() {}
            );
            surveyResponseRepository.saveAll(responses);
            System.out.println("✅ Successfully imported " + responses.size() + " responses.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
