package com.lambdaschool.piggybank.models;

import javax.persistence.*;

@Entity
@Table(name = "coins")
public class CoinModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long coinid;

    private String name;
    private String nameplural;
    private double value;
    private int quantity;

    public CoinModel(String name, String nameplural, double value, int quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.nameplural = nameplural;
    }

    public CoinModel() {
    }

    //#region getters / setters

    public long getCoinid() {
        return coinid;
    }

    public void setCoinid(long coinid) {
        this.coinid = coinid;
    }

    public String getCoinname() {
        return name;
    }

    public void setCoinname(String name) {
        this.name = name;
    }

    public String getNameplural() { return nameplural; }

    public void setNameplural( String nameplural ) { this.nameplural = nameplural; }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    #endregion


    @Override
    public String toString() {
        return "CoinModel{" +
                "coinname='" + name + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}
