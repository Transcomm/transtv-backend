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
    @Scheduled(cron = "0 0,15,30,45 05-23 * * *")
    public void executeTask() {
        List<Ads> dataList = Arrays.asList(

                new Ads("BABAYEGA", "CHOCO_MASTER", "38", "KDK 983A", "KDK 983A", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("BVB", "CHOCO_MASTER", "38", "KDA 087L", "KDA 087L", "31", "RONGAI ROAD", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "CHOCO_MASTER", "38", "KDN 267J", "KDN 267J", "31", "RONGAI ROAD", 0, 0, false, true, "sim"),
                new Ads("DICE", "CHOCO_MASTER", "38", "KDR 806R", "KDR 806R", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
                new Ads("DRUID", "CHOCO_MASTER", "38", "KDP 584W", "KDP 584W", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("BIONIC", "CHOCO_MASTER", "38", "KDK 6I9G", "KDK 6I9G", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),

                new Ads("BABAYEGA", "PB_CRUNCHY", "38", "KDK 983A", "KDK 983A", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("BVB", "PB_CRUNCHY", "38", "KDA 087L", "KDA 087L", "31", "RONGAI ROAD", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "PB_CRUNCHY", "38", "KDN 267J", "KDN 267J", "31", "RONGAI ROAD", 0, 0, false, true, "sim"),
                new Ads("DICE", "PB_CRUNCHY", "38", "KDR 806R", "KDR 806R", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
                new Ads("DRUID", "PB_CRUNCHY", "38", "KDP 584W", "KDP 584W", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("BIONIC", "PB_CRUNCHY", "38", "KDK 6I9G", "KDK 6I9G", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),

                new Ads("BABAYEGA", "CORE_ROLEX", "38", "KDK 983A", "KDK 983A", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("BVB", "CORE_ROLEX", "38", "KDA 087L", "KDA 087L", "31", "RONGAI ROAD", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "CORE_ROLEX", "38", "KDN 267J", "KDN 267J", "31", "RONGAI ROAD", 0, 0, false, true, "sim"),
                new Ads("DICE", "CORE_ROLEX", "38", "KDR 806R", "KDR 806R", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
                new Ads("DRUID", "CORE_ROLEX", "38", "KDP 584W", "KDP 584W", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("BIONIC", "CORE_ROLEX", "38", "KDK 6I9G", "KDK 6I9G", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),

//                new Ads("BABAYEGA", "Predator TVC", "40", "KDK 983A", "KDK 983A", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
//                new Ads("BVB", "Predator TVC", "40", "KDA 087L", "KDA 087L", "31", "RONGAI ROAD", 0, 0, false, true, "sim"),
//                new Ads("G-UNIT", "Predator TVC", "40", "KDN 267J", "KDN 267J", "31", "RONGAI ROAD", 0, 0, false, true, "sim"),
//                new Ads("DICE", "Predator TVC", "40", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
//                new Ads("DRUID", "Predator TVC", "40", "KDP 584W", "KDP 584W", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
//                new Ads("BIONIC", "Predator TVC", "40", "KDK 6I9G", "KDK 6I9G", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),

//                new Ads("FUNKADELICA", "KRA", "27", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("BVB", "KRA", "27", "KDA 087L", "KDA 087L", "31", "JOGOO/OUTERING ROAD", 0, 0, false, true, "sim"),
//                new Ads("G-UNIT", "KRA", "27", "KDN 267J", "KDN 267J", "31", "JOGOO/OUTERING ROAD", 0, 0, false, true, "sim"),
//                new Ads("FORTUNE", "KRA", "27", "KDN 101K", "KDN 101K", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("DRUID", "KRA", "27", "KDH 049C", "KDH 049C", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
//
//                new Ads("BVB", "COOP_BANK_FLOWER", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("BUMAYE", "COOP_BANK_FLOWER", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("G-UNIT", "COOP_BANK_FLOWER", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
//                new Ads("ISSACHAR", "COOP_BANK_FLOWER", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
//                new Ads("DROID", "COOP_BANK_FLOWER", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
//
//                new Ads("BVB", "COOP_BANK_DJ", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("BUMAYE", "COOP_BANK_DJ", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("G-UNIT", "COOP_BANK_DJ", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
//                new Ads("ISSACHAR", "COOP_BANK_DJ", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
//                new Ads("DROID", "COOP_BANK_DJ", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),

                new Ads("BVB", "Omo TVC", "42", "KDK 983A", "KDK 983A", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
                new Ads("FORTUNE", "Omo TVC", "42", "KDN 290K", "KDN 290K", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
                new Ads("UNSTOPPABLE", "Omo TVC", "42", "KDR 893A", "KDR 893A", "31", "JOGOO RD", 0, 0, false, true, "sim"),
                new Ads("EXPRESSO", "Omo TVC", "42", "KDM 087L", "KDM 087L", "31", "NGONG/THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("INTELLIGENCE", "Omo TVC", "42", "KDQ 474T", "KDQ 474T", "31", "NGONG/THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "Omo TVC", "42", "KDN 267J", "KDN 267J", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
                new Ads("FUNKADELICA", "Omo TVC", "42", "KDK 983A", "KDK 983A", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("INVISIBLE", "Omo TVC", "42", "KDN 101K", "KDN 101K", "31", "JOGOO RD", 0, 0, false, true, "sim"),
                new Ads("DRUID", "Omo TVC", "42", "KDP 584W", "KDP 584W", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("ARGENTINA", "Omo TVC", "42", "KDM 038D", "KDM 038D", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("DICE", "Omo TVC", "42", "KDR 806R", "KDR 806R", "31", "MOMBASA RD", 0, 0, false, true, "sim"),
                new Ads("REVELATION", "Omo TVC", "42", "KCK 827W", "KCK 827W", "31", "NGONG RD", 0, 0, false, true, "sim"),
                new Ads("AFTERMATH", "Omo TVC", "42", "KDK 619G", "KDK 619G", "31", "NGONG RD", 0, 0, false, true, "sim"),
                new Ads("NO FEAR", "Omo TVC", "42", "KDK 983A", "KDK 983A", "31", "JOGOO RD", 0, 0, false, true, "sim"),
                new Ads("ISAACHAR", "Omo TVC", "42", "KDQ 915A", "KDQ 915A", "31", "THIKA RD", 0, 0, false, true, "sim"),
                new Ads("MILITIA", "Omo TVC", "42", "KDM 039D", "KDM 039D", "31", "JOGOO RD", 0, 0, false, true, "sim"),
                new Ads("STEAMPUNK", "Omo TVC", "42", "KDA 087L", "KDA 087L", "31", "THIKA RD", 0, 0, false, true, "sim"),
                new Ads("CARTER IV", "Omo TVC", "42", "KDK 474T", "KDK 474T", "31", "THIKA RD", 0, 0, false, true, "sim"),
                new Ads("BIONIC", "Omo TVC", "42", "KDK O63K", "KDK O63K", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("SAVAGE", "Omo TVC", "42", "KCC 004F", "KCC 004F", "31", "THIKA RD", 0, 0, false, true, "sim"),

        new Ads("BVB", "Sunlight TVC", "42", "KDK 983A", "KDK 983A", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
                new Ads("FORTUNE", "Sunlight TVC", "42", "KDN 290K", "KDN 290K", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
                new Ads("UNSTOPPABLE", "Sunlight TVC", "42", "KDR 893A", "KDR 893A", "31", "JOGOO RD", 0, 0, false, true, "sim"),
                new Ads("EXPRESSO", "Sunlight TVC", "42", "KDM 087L", "KDM 087L", "31", "NGONG/THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("INTELLIGENCE", "Sunlight TVC", "42", "KDQ 474T", "KDQ 474T", "31", "NGONG/THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "Sunlight TVC", "42", "KDN 267J", "KDN 267J", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
                new Ads("FUNKADELICA", "Sunlight TVC", "42", "KDK 983A", "KDK 983A", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("INVISIBLE", "Sunlight TVC", "42", "KDN 101K", "KDN 101K", "31", "JOGOO RD", 0, 0, false, true, "sim"),
                new Ads("DRUID", "Sunlight TVC", "42", "KDP 584W", "KDP 584W", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("ARGENTINA", "Sunlight TVC", "42", "KDM 038D", "KDM 038D", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("DICE", "Sunlight TVC", "42", "KDR 806R", "KDR 806R", "31", "MOMBASA RD", 0, 0, false, true, "sim"),
                new Ads("REVELATION", "Sunlight TVC", "42", "KCK 827W", "KCK 827W", "31", "NGONG RD", 0, 0, false, true, "sim"),
                new Ads("AFTERMATH", "Sunlight TVC", "42", "KDK 619G", "KDK 619G", "31", "NGONG RD", 0, 0, false, true, "sim"),
                new Ads("NO FEAR", "Sunlight TVC", "42", "KDK 983A", "KDK 983A", "31", "JOGOO RD", 0, 0, false, true, "sim"),
                new Ads("ISAACHAR", "Sunlight TVC", "42", "KDQ 915A", "KDQ 915A", "31", "THIKA RD", 0, 0, false, true, "sim"),
                new Ads("MILITIA", "Sunlight TVC", "42", "KDM 039D", "KDM 039D", "31", "JOGOO RD", 0, 0, false, true, "sim"),
                new Ads("STEAMPUNK", "Sunlight TVC", "42", "KDA 087L", "KDA 087L", "31", "THIKA RD", 0, 0, false, true, "sim"),
                new Ads("CARTER IV", "Sunlight TVC", "42", "KDK 474T", "KDK 474T", "31", "THIKA RD", 0, 0, false, true, "sim"),
                new Ads("BIONIC", "Sunlight TVC", "42", "KDK O63K", "KDK 063K", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("SAVAGE", "Sunlight TVC", "42", "KCC 004F", "KCC 004F", "31", "THIKA RD", 0, 0, false, true, "sim")

                );

        adsRepository.saveAll(dataList);
        log.info("Data saved at: " + System.currentTimeMillis());
    }

    @Scheduled(cron = "0 0,15,30,45 18-23 * * *")
    public void executeTaskTwo() {
        List<Ads> dataList = Arrays.asList(
//
//                new Ads("FUNKADELICA", "USIKIMYE", "26", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("BVB", "USIKIMYE", "26", "KDA 087L", "KDA 087L", "31", "JOGOO/OUTERING ROAD", 0, 0, false, true, "sim"),
//                new Ads("G-UNIT", "USIKIMYE", "26", "KDN 267J", "KDN 267J", "31", "JOGOO/OUTERING ROAD", 0, 0, false, true, "sim"),
//                new Ads("FORTUNE", "USIKIMYE", "26", "KDN 101K", "KDN 101K", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("DRUID", "USIKIMYE", "26", "KDH 049C", "KDH 049C", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
//
//                new Ads("BVB", "COOP_BANK_FLOWER", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("BUMAYE", "COOP_BANK_FLOWER", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("G-UNIT", "COOP_BANK_FLOWER", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
//                new Ads("ISSACHAR", "COOP_BANK_FLOWER", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
//                new Ads("DROID", "COOP_BANK_FLOWER", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
//
//                new Ads("BVB", "COOP_BANK_DJ", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("BUMAYE", "COOP_BANK_DJ", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
//                new Ads("G-UNIT", "COOP_BANK_DJ", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
//                new Ads("ISSACHAR", "COOP_BANK_DJ", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
//                new Ads("DROID", "COOP_BANK_DJ", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),

                new Ads("CARTER IV", "CHROME TVC", "25", "KDK 983A", "KDK 983A", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
//                new Ads("FORTUNE", "CHROME TVC", "25", "KDN 290K", "KDN 290K", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
//                new Ads("BIONIC", "CHROME TVC", "25", "KDR 893A", "KDR 893A", "31", "WAIYAKI WAY", 0, 0, false, true, "sim"),
                new Ads("STEAMPANK", "CHROME TVC", "25", "KDA 087L", "KDA 087L", "31", "NGONG/THIKA ROAD", 0, 0, false, true, "sim"),
                new Ads("ISAACHAR", "CHROME TVC", "25", "KDQ 474T", "KDQ 474T", "31", "AIRPORT NORTH ROAD", 0, 0, false, true, "sim"),
                new Ads("G-UNIT", "CHROME TVC", "25", "KDN 267J", "KDN 267J", "31", "KIAMBU ROAD", 0, 0, false, true, "sim"),
                new Ads("NO FEAR", "CHROME TVC", "25", "KDK 983A", "KDK 983A", "31", "AIRPORT NORTH ROAD", 0, 0, false, true, "sim"),
                new Ads("DICE", "CHROME TVC", "25", "KDR 806R", "KDR 806R", "31", "WAIYAKI WAY", 0, 0, false, true, "sim"),
                new Ads("DRUID", "CHROME TVC", "25", "KDP 584W", "KDP 584W", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
                new Ads("MILITIA", "CHROME TVC", "25", "KDM 038D", "KDM 038D", "31", "KANGUNDO ROAD", 0, 0, false, true, "sim"),
                new Ads("AFTERMATH", "CHROME TVC", "25", "KDK 6I9G", "KDK 6I9G", "31", "KITENGELA", 0, 0, false, true, "sim"),
                new Ads("REVELATION", "CHROME TVC", "25", "KCK 827W", "KCK 827W", "31", "KITENGELA", 0, 0, false, true, "sim")
        );

        adsRepository.saveAll(dataList);
        log.info("Data saved at: " + System.currentTimeMillis());
    }
}
