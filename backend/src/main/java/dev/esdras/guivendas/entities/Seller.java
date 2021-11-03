package dev.esdras.guivendas.entities;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private Long id;
    private String name;

    /**
     * Composição das entidades Seller & Sale
     */
    private List<Sale> sales = new ArrayList<>(); // No modelo conceitual: Seller possui * (vários) Sale's

    public Seller() {}

    public Seller(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sale> getSales() {
        return sales;
    }
}
