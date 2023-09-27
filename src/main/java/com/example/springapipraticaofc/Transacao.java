package com.example.springapipraticaofc;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "transacao")
public class Transacao {

    public Transacao(){}
    public Transacao(int id, String descricao, double valor, String data_transacao, String tipo_transacao) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data_transacao = data_transacao;
        this.tipo_transacao = tipo_transacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data_transacao")
    private String data_transacao;

    @Column(name = "tipo_transacao")
    private String tipo_transacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(String data_transacao) {
        this.data_transacao = data_transacao;
    }

    public String getTipo_transacao() {
        return tipo_transacao;
    }

    public void setTipo_transacao(String tipo_transacao) {
        this.tipo_transacao = tipo_transacao;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data_transacao=" + data_transacao +
                ", tipo_transacao='" + tipo_transacao + '\'' +
                '}';
    }
}
