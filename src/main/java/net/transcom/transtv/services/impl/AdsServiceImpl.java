package net.transcom.transtv.services.impl;

import lombok.RequiredArgsConstructor;
import net.transcom.transtv.entities.Ads;
import net.transcom.transtv.repository.AdsRepository;
import net.transcom.transtv.services.AdsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {

    private final AdsRepository adsRepository;

    public Ads saveAd(Ads ads){

//        Ads ad = new Ads();
//        ad.setEntity_name(ads.getEntity_name());
//        ad.setVideo_name(ads.getVideo_name());
//        ad.setCustomerId(ads.getCustomerId());
//        ad.setEntity_identity(ads.getEntity_identity());
//        ad.setSerial_no(ads.getSerial_no());
//        ad.setEstimpressions(ads.getEstimpressions());
//        ad.setRoute(ads.getRoute());
//        ad.setLatitude(ads.getLatitude());
//        ad.setLongitude(ads.getLongitude());
//        ad.setDeleted(ads.isDeleted());
//        ad.setActive(ads.isActive());
//        ad.setStatus(ads.getStatus());

        return adsRepository.save(ads);
    }

}
