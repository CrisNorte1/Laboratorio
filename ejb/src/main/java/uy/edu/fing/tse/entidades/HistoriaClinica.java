package uy.edu.fing.tse.entidades;

import java.time.LocalDateTime;

public class HistoriaClinica {
    private Long id;
    private Long idUsuarioSalud;
    private String numeroHistoria;
    private String especialidad;
    private String prestador;
    private LocalDateTime fechaCreacion;
    private String motivoConsulta;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Long id, Long idUsuarioSalud, String numeroHistoria,
                           String especialidad, String prestador, LocalDateTime fechaCreacion, String motivoConsulta) {
        this.id = id;
        this.idUsuarioSalud = idUsuarioSalud;
        this.numeroHistoria = numeroHistoria;
        this.especialidad = especialidad;
        this.prestador = prestador;
        this.fechaCreacion = fechaCreacion;
        this.motivoConsulta = motivoConsulta;
    }

    public HistoriaClinica(String motivoConsulta, String numeroHistoria, LocalDateTime fechaCreacion, Long idUsuarioSalud, Long id) {
        this.motivoConsulta = motivoConsulta;
        this.numeroHistoria = numeroHistoria;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioSalud = idUsuarioSalud;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuarioSalud() {
        return idUsuarioSalud;
    }

    public void setIdUsuarioSalud(Long idUsuarioSalud) {
        this.idUsuarioSalud = idUsuarioSalud;
    }

    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(String numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }
}
