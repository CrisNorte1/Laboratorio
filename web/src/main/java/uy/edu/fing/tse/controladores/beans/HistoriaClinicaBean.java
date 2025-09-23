package uy.edu.fing.tse.controladores.beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import uy.edu.fing.tse.api.HistoriaClinicaService;
import uy.edu.fing.tse.entidades.HistoriaClinica;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Named("historiaClinicaBean")
@SessionScoped
public class HistoriaClinicaBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EJB
    private HistoriaClinicaService service;

    private HistoriaClinica nuevaHistoria = new HistoriaClinica();

    private HistoriaClinica historiaSeleccionada;

    private String buscarTexto;

    public void crear() {
        nuevaHistoria.setFechaCreacion(LocalDateTime.now());
        service.crear(nuevaHistoria);
        nuevaHistoria = new HistoriaClinica();
    }

    public void prepararEdicion(HistoriaClinica hc) {
        if (hc == null || hc.getId() == null) {
            historiaSeleccionada = new HistoriaClinica();
            return;
        }
        this.historiaSeleccionada = service.obtenerPorId(hc.getId());
    }

    public void actualizar() {
        if (historiaSeleccionada != null) {
            service.actualizar(historiaSeleccionada);
        }
    }

    public void eliminar(Long id) {
        if (id != null) {
            service.eliminar(id);
            if (historiaSeleccionada != null && id.equals(historiaSeleccionada.getId())) {
                historiaSeleccionada = null;
            }
        }
    }

    public void eliminarSeleccionado() {
        if (historiaSeleccionada != null && historiaSeleccionada.getId() != null) {
            service.eliminar(historiaSeleccionada.getId());
            historiaSeleccionada = null;
        }
    }

    public List<HistoriaClinica> getHistoriasFiltradas() {
        List<HistoriaClinica> todas = service.listar();
        if (buscarTexto == null || buscarTexto.isBlank()) {
            return todas;
        }
        String filtro = buscarTexto.toLowerCase();
        return todas.stream()
                .filter(h ->
                        (h.getNumeroHistoria() != null && h.getNumeroHistoria().toLowerCase().contains(filtro)) ||
                                (h.getMotivoConsulta() != null && h.getMotivoConsulta().toLowerCase().contains(filtro)) ||
                                (h.getEspecialidad() != null && h.getEspecialidad().toLowerCase().contains(filtro)) ||
                                (h.getPrestador() != null && h.getPrestador().toLowerCase().contains(filtro))
                )
                .toList();
    }

    /* -------------------- Getters / Setters -------------------- */
    public HistoriaClinica getNuevaHistoria() {
        return nuevaHistoria;
    }

    public void setNuevaHistoria(HistoriaClinica nuevaHistoria) {
        this.nuevaHistoria = nuevaHistoria;
    }

    public HistoriaClinica getHistoriaSeleccionada() {
        return historiaSeleccionada;
    }

    public void setHistoriaSeleccionada(HistoriaClinica historiaSeleccionada) {
        this.historiaSeleccionada = historiaSeleccionada;
    }

    public String getBuscarTexto() {
        return buscarTexto;
    }

    public void setBuscarTexto(String buscarTexto) {
        this.buscarTexto = buscarTexto;
    }
}
