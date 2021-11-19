package com.mohamadou.mylogistics.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

   /* @OneToMany()
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;*/

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "delivery_address_id", referencedColumnName = "id")
    private Address deliveryAddress;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "pickup_address_id", referencedColumnName = "id")
    private Address pickupAddress;

    @OneToOne
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;


    @Transient
    private Long customerId;
    @Transient
    private Long carrierId;
    @Transient
    private Long parcelId;
    @Transient
    private Long pickupAddressId;
    @Transient
    private Long deliveryAddressId;


    public Delivery() {
    }

    public Delivery(Customer customer, LocalDate dateCreated, Carrier carrier, Address deliveryAddress, Address pickupAddress, Parcel parcel) {
        this.customer = customer;
        this.dateCreated = dateCreated;
        this.carrier = carrier;
        this.deliveryAddress = deliveryAddress;
        this.pickupAddress = pickupAddress;
        this.parcel = parcel;
    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
    }

    public Long getParcelId() {
        return parcelId;
    }

    public void setParcelId(Long parcelId) {
        this.parcelId = parcelId;
    }

    public Long getPickupAddressId() {
        return pickupAddressId;
    }

    public void setPickupAddressId(Long pickupAddressId) {
        this.pickupAddressId = pickupAddressId;
    }

    public Long getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(Long deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(Address pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

}
