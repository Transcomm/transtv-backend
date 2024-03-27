package net.transcom.transtv.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    @JsonProperty("created_at")
    private Date createdAt = new Date();
    @Column(name = "entity_name")
    @JsonProperty("entity_name")
    private String entityName;
    @Column(name = "video_name")
    @JsonProperty("video_name")
    private String videoName;
    @Column(name = "customer_id")
    @JsonProperty("customer_id")
    private String customerId;
    @Column(name = "entity_identity")
    @JsonProperty("entity_identity")
    private String entityIdentity;
    @Column(name = "serial_no")
    @JsonProperty("serial_no")
    private String serialNo;
    private String estimpressions = "33";
    private String route;
    private int latitude;
    private int longitude;
    private boolean deleted;
    private boolean active;
    private String status;

}
