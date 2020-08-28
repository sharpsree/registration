package com.vms.registration.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Vehicledetails", schema = "vms")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vehicledetails {

    @Column(name="Vinnumber")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vinNumber;

    @Column(name="Vehiclemodel")
    private String vehicleModel;


    @Column(name="Vehiclemake")
    private String vehicleMake;

    @JsonIgnore
    @ManyToOne(targetEntity = CustomerDetails.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_vehicle",
            joinColumns = @JoinColumn(name = "Vinnumber"),
            inverseJoinColumns = @JoinColumn(name = "Customerid"))
    CustomerDetails customer;

    public Integer getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(Integer vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    @JsonIgnore
    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }
}
