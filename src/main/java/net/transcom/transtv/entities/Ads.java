package net.transcom.transtv.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date created_at = new Date();
    private String entity_name;
    private String video_name;
    private String customerId;
    private String entity_identity;
    private String serial_no;
    private String estimpressions = "33";
    private String route;
    private int latitude;
    private int longitude;
    private boolean deleted;
    private boolean active;
    private String status;

}
