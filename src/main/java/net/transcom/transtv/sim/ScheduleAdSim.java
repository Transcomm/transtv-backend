package net.transcom.transtv.sim;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.transcom.transtv.entities.Ads;
import net.transcom.transtv.repository.AdsRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@EnableScheduling
@RequiredArgsConstructor
@Log4j2
public class ScheduleAdSim {

    private final AdsRepository adsRepository;

    // Scheduled to run at 15, 30, 45, and 00 minutes of each hour between 04:00 and 22:00
    @Scheduled(cron = "0 0,15,30,45 4-21 * * *")
    public void executeTask() {
        List<Ads> dataList = Arrays.asList(

                new Ads("BVB", "COOP_BANK_FASHION", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
                new Ads("BUMAYE", "COOP_BANK_FASHION", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "COOP_BANK_FASHION", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("ISSACHAR", "COOP_BANK_FASHION", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
                new Ads("DROID", "COOP_BANK_FASHION", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),

                new Ads("BVB", "COOP_BANK_FLOWER", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
                new Ads("BUMAYE", "COOP_BANK_FLOWER", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "COOP_BANK_FLOWER", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("ISSACHAR", "COOP_BANK_FLOWER", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
                new Ads("DROID", "COOP_BANK_FLOWER", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),

                new Ads("BVB", "COOP_BANK_DJ", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
                new Ads("BUMAYE", "COOP_BANK_DJ", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "COOP_BANK_DJ", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("ISSACHAR", "COOP_BANK_DJ", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
                new Ads("DROID", "COOP_BANK_DJ", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),

                new Ads("BVB", "CHROME TVC", "25", "KDK 983A", "KDK 983A", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("BUMAYE", "CHROME TVC", "25", "KDA 087L", "KDA 087L", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "CHROME TVC", "25", "KDN 267J", "KDN 267J", "31", "KIAMBU ROAD", 0, 0, false, true, "sim"),
                new Ads("ISSACHAR", "CHROME TVC", "25", "KDN 101K", "KDN 101K", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
                new Ads("DROID", "CHROME TVC", "25", "KDH 049C", "KDH 049C", "31", "WAIYAKI WAY", 0, 0, false, true, "sim")
        );

        adsRepository.saveAll(dataList);
        log.info("Data saved at: " + System.currentTimeMillis());
    }
}
