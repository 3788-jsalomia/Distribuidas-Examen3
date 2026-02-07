package org.edu.espe.mspoliza.models;

import jakarta.persistence.*;

@Entity
@Table(name = "polizas")
public class Poliza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeroPoliza", nullable = false)
    private Long numeroPoliza;

    @Column(name = "fechaInicio", nullable = false)
    private String fechaInicio;

    @Column(name="fechaFin", nullable = true)
    private String fechaFin;

    @Column(name = "primaMensual", nullable = false)
    private Long primaMensual;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(Long numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getPrimaMensual() {
        return primaMensual;
    }

    public void setPrimaMensual(Long primaMensual) {
        this.primaMensual = primaMensual;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
