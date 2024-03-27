package net.transcom.transtv.services;

import net.transcom.transtv.entities.Ads;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdsService{
    Ads saveAd(Ads ads);
    Page<Ads> getLatestAdsByStatus(String status, int page, int size);
    List<String> getListOfMatatus();
}
