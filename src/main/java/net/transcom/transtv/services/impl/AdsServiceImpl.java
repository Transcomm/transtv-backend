package net.transcom.transtv.services.impl;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.entities.Ads;
import net.transcom.transtv.repository.AdsRepository;
import net.transcom.transtv.services.AdsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {

    private final AdsRepository adsRepository;

    public Ads saveAd(Ads ads){
        ads.setEntityName(ads.getEntityName().toUpperCase());
        return adsRepository.save(ads);
    }

    public Page<Ads> getLatestAdsByStatus(String status, String client, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return adsRepository.findByStatusAndCustomerIdOrderByCreatedAtDesc(status,client,pageable);
    }

    public List<Ads> getAllAds(String status, String client){
        return adsRepository.findByStatusAndCustomerIdOrderByCreatedAtDesc(status, client);
    }

    public List<String> getListOfMatatus(String status, String client){
        return adsRepository.findDistinctByEntityName(status,client);
    }

    public List<Object[]> getAdsByLast7Days(String status, String client){
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(new Date());

        Calendar startDate = Calendar.getInstance();
        startDate.setTime(endDate.getTime());
        startDate.add(Calendar.DAY_OF_MONTH, -6); // 7 days ago
        return adsRepository.findAdCountByLast7Days(status, client, startDate.getTime(), endDate.getTime());
    }

    public List<Object[]> getAdsByRoute(String status, String client){
        return adsRepository.findAdCountByRoute(status, client);
    }

    public List<Object[]> getAdsByVideoName(String status, String client){
        return adsRepository.findAdCountByVideoName(status, client);
    }

    public List<Object[]> getAdsByMatatu(String status, String client){
        return adsRepository.findAdCountByMatatu(status, client);
    }

    public List<Object[]> getAdsByDays(String status, String client){
        return adsRepository.findAdCountByDay(status, client);
    }

}
