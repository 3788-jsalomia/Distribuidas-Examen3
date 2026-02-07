package org.edu.espe.msplanseguro.models;

import jakarta.persistence.*;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name="tipo", nullable = true)
    private String tipo;

    @Column(name = "primaBase", nullable = false)
    private String primaBase;

    @Column(name = "coberturaMax", nullable = false)
    private String coberturaMax;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrimaBase() {
        return primaBase;
    }

    public void setPrimaBase(String primaBase) {
        this.primaBase = primaBase;
    }

    public String getCoberturaMax() {
        return coberturaMax;
    }

    public void setCoberturaMax(String coberturaMax) {
        this.coberturaMax = coberturaMax;
    }
}
