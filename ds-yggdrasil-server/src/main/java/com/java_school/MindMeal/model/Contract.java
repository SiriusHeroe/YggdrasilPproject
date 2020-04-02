package com.java_school.MindMeal.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(schema = "ds_contract",name = "t_contract")
public class Contract {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(name = "number")
    private String number;

    @Column(name = "customer_id")
    private String customer_id;

    @Column(name = "tariff_id")
    private String tariff_id;

    @Column(name = "total_price")
    private Double total_price;

    @Column(name = "option_list_id")
    private String option_list_id;

    @Column(name = "deleted")
    private Boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getOption_list_id() {
        return option_list_id;
    }

    public void setOption_list_id(String option_list_id) {
        this.option_list_id = option_list_id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getTariff_id() {
        return tariff_id;
    }

    public void setTariff_id(String tariff_id) {
        this.tariff_id = tariff_id;
    }
}
