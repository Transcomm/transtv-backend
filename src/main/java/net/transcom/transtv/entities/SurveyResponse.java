package net.transcom.transtv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tbl_survey_responses")
@Data
public class SurveyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date submittedAt = new Date();
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;

}
