package dev.esdras.guivendas.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // Notação responsável por fazer o mapeamento dos dados Orientados à Objetos para os de paradigma Relacional
@Table(name = "tb_sellers") // Especifica o nome da tabela no banco onde estão os dados que serão mapeados com esta classe
public class Seller {

    @Id // Indica ao banco de dados que esse atributo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que este atributo é autoincrementável
    private Long id;

    private String name;

    /**
     * Composição das entidades Seller & Sale
     */
    @OneToMany(mappedBy = "seller") // Cardinalidade Um para Muitos
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
