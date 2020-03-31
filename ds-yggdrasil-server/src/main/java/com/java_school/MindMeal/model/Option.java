package com.java_school.MindMeal.model;

public class Option {

    private String id;
    private String name;
    private Double price;
    private Double connection_cost;
    private String description;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getConnection_cost() {
        return connection_cost;
    }

    public void setConnection_cost(Double connection_cost) {
        this.connection_cost = connection_cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
