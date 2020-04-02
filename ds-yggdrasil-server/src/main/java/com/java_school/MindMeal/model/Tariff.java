package com.java_school.MindMeal.model;

public class Tariff {

    private String id;
    private String name;
    private String description;
    private Double price;
    private String option_list_id;
    private Boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

}
