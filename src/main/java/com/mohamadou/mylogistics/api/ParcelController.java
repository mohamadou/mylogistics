package com.mohamadou.mylogistics.api;


import com.mohamadou.mylogistics.entity.Parcel;
import com.mohamadou.mylogistics.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/parcel")
public class ParcelController {

    ParcelService parcelService;

    public ParcelController() {
    }

    @Autowired
    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @GetMapping
    public List<Parcel> getAllParcel() {
        return parcelService.getAllParcel();
    }

    @GetMapping(path = "{parcelId}")
    public Parcel getParcelById(@PathVariable Long parcelId) {
        return parcelService.getParcelById(parcelId);
    }

    @PostMapping
    public void createParcel(@RequestBody Parcel parcel) {
        parcelService.createParcel(parcel);
    }

    @DeleteMapping(path = "{parcelId}")
    public void deleteParcel(@PathVariable Long parcelId) {
        parcelService.deleteParcel(parcelId);
    }

    @PutMapping()
    public void updateParcel(@RequestBody Parcel parcel) {
        parcelService.updateParcel(parcel);
    }


}

