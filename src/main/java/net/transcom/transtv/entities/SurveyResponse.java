package net.transcom.transtv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "survey_preferences", joinColumns = @JoinColumn(name = "survey_id"))
    @Column(name = "preference")
    private List<String> question3;

    private String question4;
    private String question5;

}
