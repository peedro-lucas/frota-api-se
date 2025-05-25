package com.xwz.frota.frota_api.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "tipo",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Moto.class, name = "MOTO"),
        @JsonSubTypes.Type(value = Carro.class, name = "CARRO")
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modelo;
    private String fabricante;
    private int ano;
    private double preco;
    private String cor;
    private String tipo;

    public Veiculo() {
    }

    public Veiculo(String modelo, String fabricante, int ano, double preco, String cor, String tipo) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
        this.preco = preco;
        this.cor = cor;
        this.tipo = tipo;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {
        if (tipo != null) {
            this.tipo = tipo.toLowerCase();
        } else {
            this.tipo = null;
        }
    }
}
