package dev.esdras.guivendas.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // Notação responsável por fazer o mapeamento dos dados Orientados à Objetos para os de paradigma Relacional
@Table(name = "tb_sales") // Especifica o nome da tabela no banco onde estão os dados que serão mapeados com esta classe
public class Sale {

    @Id // Indica ao banco de dados que esse atributo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que este atributo é autoincrementável
    private Long id;

    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;

    /**
     * Composição das entidades Sale & Seller
     */
    @ManyToOne // Cardinalidade Muitos para Um
    @JoinColumn(name = "seller_id") // Especifica a chave estrangeira
    private Seller seller; // No modelo conceitual: Sale possui 1 Seller

    public Sale() {}

    public Sale(Long id, Integer visited, Integer deals, Double amount, LocalDate date, Seller seller) {
        this.id = id;
        this.visited = visited;
        this.deals = deals;
        this.amount = amount;
        this.date = date;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVisited() {
        return visited;
    }

    public void setVisited(Integer visited) {
        this.visited = visited;
    }

    public Integer getDeals() {
        return deals;
    }

    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
