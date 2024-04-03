package net.transcom.transtv.services;

import net.transcom.transtv.entities.Ads;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdsService{

    Ads saveAd(Ads ads);
    Page<Ads> getLatestAdsByStatus(String status, String client, int page, int size);
    List<String> getListOfMatatus(String status, String client);
//    List<Object[]> getAdsByLast7Days(String status);
    List<Object[]> getAdsByRoute(String status, String client);
    List<Object[]> getAdsByVideoName(String status, String client);
    List<Object[]> getAdsByMatatu(String status, String client);
    List<Object[]> getAdsByDays(String status, String client);

}
