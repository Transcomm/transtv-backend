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
//    @Scheduled(cron = "0 0,15,30,45 05-23 * * *")
//    public void executeTask() {
//        List<Ads> dataList = Arrays.asList(
//
////                new Ads("FUNKADELICA", "SHOWMAX TVC", "35", "KDK 983A", "KDK 983A", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
////                new Ads("BVB", "SHOWMAX TVC", "35", "KDA 087L", "KDA 087L", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
////                new Ads("G-UNIT", "SHOWMAX TVC", "35", "KDN 267J", "KDN 267J", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
////                new Ads("FORTUNE", "SHOWMAX TVC", "35", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
////                new Ads("DRUID", "SHOWMAX TVC", "35", "KDH 049C", "KDH 049C", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
//
////                new Ads("FUNKADELICA", "KRA", "27", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("BVB", "KRA", "27", "KDA 087L", "KDA 087L", "31", "JOGOO/OUTERING ROAD", 0, 0, false, true, "sim"),
////                new Ads("G-UNIT", "KRA", "27", "KDN 267J", "KDN 267J", "31", "JOGOO/OUTERING ROAD", 0, 0, false, true, "sim"),
////                new Ads("FORTUNE", "KRA", "27", "KDN 101K", "KDN 101K", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("DRUID", "KRA", "27", "KDH 049C", "KDH 049C", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
////
////                new Ads("BVB", "COOP_BANK_FLOWER", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("BUMAYE", "COOP_BANK_FLOWER", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("G-UNIT", "COOP_BANK_FLOWER", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
////                new Ads("ISSACHAR", "COOP_BANK_FLOWER", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
////                new Ads("DROID", "COOP_BANK_FLOWER", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
////
////                new Ads("BVB", "COOP_BANK_DJ", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("BUMAYE", "COOP_BANK_DJ", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("G-UNIT", "COOP_BANK_DJ", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
////                new Ads("ISSACHAR", "COOP_BANK_DJ", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
////                new Ads("DROID", "COOP_BANK_DJ", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
//
//                new Ads("BVB", "Demo TVC", "34", "KDK 983A", "KDK 983A", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
//                new Ads("FORTUNE", "Demo TVC", "34", "KDN 290K", "KDN 290K", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
//                new Ads("UNSTOPPABLE", "Demo TVC", "34", "KDR 893A", "KDR 893A", "31", "WAIYAKI WAY", 0, 0, false, true, "sim"),
//                new Ads("EXPRESSO", "Demo TVC", "34", "KDA 087L", "KDA 087L", "31", "NGONG/THIKA ROAD", 0, 0, false, true, "sim"),
//                new Ads("INTELLIGENCE", "Demo TVC", "34", "KDQ 474T", "KDQ 474T", "31", "NGONG/THIKA ROAD", 0, 0, false, true, "sim"),
//                new Ads("G-UNIT", "Demo TVC", "34", "KDN 267J", "KDN 267J", "31", "KIAMBU ROAD", 0, 0, false, true, "sim"),
//                new Ads("FUNKADELICA", "Demo TVC", "34", "KDK 983A", "KDK 983A", "31", "KIAMBU ROAD", 0, 0, false, true, "sim"),
//                new Ads("INVISIBLE", "Demo TVC", "34", "KDN 101K", "KDN 101K", "31", "WAIYAKI WAY", 0, 0, false, true, "sim"),
//                new Ads("DRUID", "Demo TVC", "34", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
//                new Ads("ARGENTINA", "Demo TVC", "34", "KDM 038D", "KDM 038D", "31", "MOMBASA ROAD", 0, 0, false, true, "sim")
//        );
//
//        adsRepository.saveAll(dataList);
//        log.info("Data saved at: " + System.currentTimeMillis());
//    }

//    @Scheduled(cron = "0 0,15,30,45 18-23 * * *")
//    public void executeTaskTwo() {
//        List<Ads> dataList = Arrays.asList(
////
////                new Ads("FUNKADELICA", "USIKIMYE", "26", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("BVB", "USIKIMYE", "26", "KDA 087L", "KDA 087L", "31", "JOGOO/OUTERING ROAD", 0, 0, false, true, "sim"),
////                new Ads("G-UNIT", "USIKIMYE", "26", "KDN 267J", "KDN 267J", "31", "JOGOO/OUTERING ROAD", 0, 0, false, true, "sim"),
////                new Ads("FORTUNE", "USIKIMYE", "26", "KDN 101K", "KDN 101K", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("DRUID", "USIKIMYE", "26", "KDH 049C", "KDH 049C", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
////
////                new Ads("BVB", "COOP_BANK_FLOWER", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("BUMAYE", "COOP_BANK_FLOWER", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("G-UNIT", "COOP_BANK_FLOWER", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
////                new Ads("ISSACHAR", "COOP_BANK_FLOWER", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
////                new Ads("DROID", "COOP_BANK_FLOWER", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
////
////                new Ads("BVB", "COOP_BANK_DJ", "24", "KDK 983A", "KDK 983A", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("BUMAYE", "COOP_BANK_DJ", "24", "KDA 087L", "KDA 087L", "31", "NGONG ROAD", 0, 0, false, true, "sim"),
////                new Ads("G-UNIT", "COOP_BANK_DJ", "24", "KDN 267J", "KDN 267J", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
////                new Ads("ISSACHAR", "COOP_BANK_DJ", "24", "KDN 101K", "KDN 101K", "31", "JOGOO ROAD", 0, 0, false, true, "sim"),
////                new Ads("DROID", "COOP_BANK_DJ", "24", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
//
//                new Ads("CARTER IV", "CHROME TVC", "25", "KDK 983A", "KDK 983A", "31", "THIKA ROAD", 0, 0, false, true, "sim"),
////                new Ads("FORTUNE", "CHROME TVC", "25", "KDN 290K", "KDN 290K", "31", "LANGATA ROAD", 0, 0, false, true, "sim"),
////                new Ads("UNSTOPPABLE", "CHROME TVC", "25", "KDR 893A", "KDR 893A", "31", "WAIYAKI WAY", 0, 0, false, true, "sim"),
////                new Ads("EXPRESSO", "CHROME TVC", "25", "KDA 087L", "KDA 087L", "31", "NGONG/THIKA ROAD", 0, 0, false, true, "sim"),
//                new Ads("ISAACHAR", "CHROME TVC", "25", "KDQ 474T", "KDQ 474T", "31", "AIRPORT NORTH ROAD", 0, 0, false, true, "sim"),
//  //              new Ads("G-UNIT", "CHROME TVC", "25", "KDN 267J", "KDN 267J", "31", "KIAMBU ROAD", 0, 0, false, true, "sim"),
//                new Ads("NO FEAR", "CHROME TVC", "25", "KDK 983A", "KDK 983A", "31", "AIRPORT NORTH ROAD", 0, 0, false, true, "sim"),
//    //            new Ads("INVISIBLE", "CHROME TVC", "25", "KDN 101K", "KDN 101K", "31", "WAIYAKI WAY", 0, 0, false, true, "sim"),
//      //          new Ads("DRUID", "CHROME TVC", "25", "KDH 049C", "KDH 049C", "31", "MOMBASA ROAD", 0, 0, false, true, "sim"),
//                new Ads("MILITIA", "CHROME TVC", "25", "KDM 038D", "KDM 038D", "31", "KANGUNDO ROAD", 0, 0, false, true, "sim"),
//                new Ads("AFTERMATH", "CHROME TVC", "25", "KDK 6I9G", "KDK 6I9G", "31", "KITENGELA", 0, 0, false, true, "sim"),
//                new Ads("REVELATION", "CHROME TVC", "25", "KCK 827W", "KCK 827W", "31", "KITENGELA", 0, 0, false, true, "sim")
//        );
//
//        adsRepository.saveAll(dataList);
//        log.info("Data saved at: " + System.currentTimeMillis());
//    }
}
