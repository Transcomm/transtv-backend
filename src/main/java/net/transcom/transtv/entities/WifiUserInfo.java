package net.transcom.transtv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_wifi_user_info")
public class WifiUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt = new Date();
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
