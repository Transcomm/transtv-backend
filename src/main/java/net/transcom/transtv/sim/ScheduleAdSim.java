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
                new Ads("FUNKADELICA", "Rina TVC", "20", "KDK 983A", "KDK 983A", "31", "CBD, MOMBASA RD, JOGOO RD", 0, 0, false, true, "sim"),
                new Ads("WAVE 1", "Rina TVC", "20", "KDA 087L", "KDA 087L", "31", "CBD LANG'ATA NGONG RD NGO", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "Rina TVC", "20", "KDN 267J", "KDN 267J", "31", "EMBAKASI CBD MOMBASA RD", 0, 0, false, true, "sim"),
                new Ads("NO FEAR", "Rina TVC", "20", "KDN 101K", "KDN 101K", "31", "CBD,KARIKOR JUJA PUMWANI, DANDORA", 0, 0, false, true, "sim"),
                new Ads("SQUID GAME", "Rina TVC", "20", "KDH 049C", "KDH 049C", "31", "JOGOO RD MOMBASA RD THINK", 0, 0, false, true, "sim"),
                new Ads("WAVE 2", "Rina TVC", "20", "KCD 844E", "KCD 844E", "31", "CBD LANG'ATA NGONG WAIYAKI WAY", 0, 0, false, true, "sim"),
                new Ads("PUDDING", "Rina TVC", "20", "KDH 304C", "KDH 304C", "31", "CBD,KARIKOR JUJA PUMWANI, DANDORA", 0, 0, false, true, "sim"),
                new Ads("BACK LASH", "Rina TVC", "20", "KDC 279N", "KDC 279N", "31", "CBD,KARIKOR JUJA PUMWANI, DANDORA", 0, 0, false, true, "sim"),
                new Ads("BIG CHIEF", "Rina TVC", "20", "KDA 067D", "KDA 067D", "31", "CBD,KARIKOR JUJA PUMWANI, DANDORA", 0, 0, false, true, "sim"),
                new Ads("BLACK MARKET", "Rina TVC", "20", "KCR 328A", "KCR 328A", "31", "CBD,KARIKOR JUJA PUMWANI, DANDORA", 0, 0, false, true, "sim"),
                new Ads("VOICE MAIL", "Rina TVC", "20", "KDD 001L", "KDD 001L", "31", "CBD,KARIKOR JUJA PUMWANI, DANDORA", 0, 0, false, true, "sim"),
                new Ads("ELSABROSA", "Rina TVC", "20", "KDB 037E", "KDB 037E", "31", "JOGOO RD, MOMBASA RD, THIKA RD", 0, 0, false, true, "sim"),
                new Ads("OPPOSITE", "Rina TVC", "20", "KDH 112E", "KDH 112E", "31", "CBD,KARIKOR JUJA PUMWANI, DANDORA", 0, 0, false, true, "sim"),
                new Ads("QUEENTA", "Rina TVC", "20", "KCW 079R", "KCW 079R", "31", "JOGOO RD, MOMBASA RD, THIKA RD", 0, 0, false, true, "sim"),
                new Ads("BIONIC", "Rina TVC", "20", "KDK 063K", "KDK 063K", "31", "JOGOO RD, MOMBASA RD, THIKA RD", 0, 0, false, true, "sim"),
                new Ads("BVB", "Rina TVC", "20", "KDK 216U", "KDK 216U", "31", "JOGOO RD, MOMBASA RD, THIKA RD", 0, 0, false, true, "sim"),
                new Ads("AMBUSH", "Rina TVC", "20", "KDG 195K", "KDG 195K", "31", "JOGOO RD, MOMBASA RD, THIKA RD", 0, 0, false, true, "sim"),
                new Ads("ISSACHAR", "Rina TVC", "20", "KDM 117M", "KDM 117M", "31", "JOGOO RD, MOMBASA RD, THIKA RD", 0, 0, false, true, "sim")

        );

        adsRepository.saveAll(dataList);
        log.info("Data saved at: " + System.currentTimeMillis());
    }
}
