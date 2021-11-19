package com.mohamadou.mylogistics.service;

import com.mohamadou.mylogistics.entity.Parcel;
import com.mohamadou.mylogistics.repository.DeliveryRepository;
import com.mohamadou.mylogistics.repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParcelService {

    private ParcelRepository parcelRepository;

    public ParcelService() {

    }

    @Autowired
    public ParcelService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    public List<Parcel> getAllParcel() {
        return parcelRepository.findAll();
    }

    public Parcel getParcelById(Long parcelId) {
        Optional<Parcel> parcelOption = parcelRepository.findById(parcelId);

        Parcel parcel = null;
        if(parcelOption.isPresent()) {
            parcel = parcelOption.get();
        }

        return parcel;
    }

    public void deleteParcel(Long parcelId) {
        boolean parcelExist = parcelRepository.existsById(parcelId);

        if (parcelExist){
            parcelRepository.deleteById(parcelId);
        }
        throw new RuntimeException("Parcel with id:"+parcelId+" does not exist");
    }

    public Parcel createParcel(Parcel parcel) {
        return parcelRepository.save(parcel);
    }

    public Parcel updateParcel(Parcel parcel) {
        return parcelRepository.save(parcel);
    }
}
