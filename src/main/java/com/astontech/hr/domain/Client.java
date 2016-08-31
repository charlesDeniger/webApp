package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by chardeni1 on 8/30/2016.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client extends Person{

    @OneToMany
    private List<Address> addressList;

    public Client() {

    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
