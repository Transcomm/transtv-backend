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

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {

    private final AdsRepository adsRepository;

    public Ads saveAd(Ads ads){
        ads.setEntityName(ads.getEntityName().toUpperCase());
        return adsRepository.save(ads);
    }

    public Page<Ads> getLatestAdsByStatus(String status, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return adsRepository.findByStatusOrderByCreatedAtDesc(status, pageable);
    }

    public List<String> getListOfMatatus(){
        return adsRepository.findDistinctByEntityName();
    }

}
