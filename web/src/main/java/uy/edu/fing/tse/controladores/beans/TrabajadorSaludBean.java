package uy.edu.fing.tse.controladores.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import uy.edu.fing.tse.api.TrabajadorSaludServiceLocal;
import uy.edu.fing.tse.entidades.TrabajadorSalud;

@Named("trabajadorSaludBean")
@ViewScoped
public class TrabajadorSaludBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private TrabajadorSaludServiceLocal trabajadorService; // proxy EJB serializable

    private List<TrabajadorSalud> trabajadores;
    private TrabajadorSalud nuevoTrabajador;

    private String cedulaBusqueda;
    private TrabajadorSalud trabajadorEncontrado;

    @PostConstruct
    public void init() {
        this.nuevoTrabajador = new TrabajadorSalud();
        this.cargarLista();
    }

    private void cargarLista() {
        this.trabajadores = trabajadorService.obtenerTodosLosTrabajadores();
    }

    public String darDeAlta() {
        try {
            this.nuevoTrabajador.setFechaIngreso(LocalDate.now());
            trabajadorService.altaTrabajador(this.nuevoTrabajador);
            this.nuevoTrabajador = new TrabajadorSalud(); // limpia form
            this.cargarLista(); // refresca tabla
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Trabajador creado."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo crear el trabajador."));
        }
        return null; // permanecer en la misma vista
    }

    public String buscarPorCedula() {
        this.trabajadorEncontrado = trabajadorService.obtenerTrabajadorPorCedula(this.cedulaBusqueda);
        if (this.trabajadorEncontrado == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "No encontrado",
                            "No existe un trabajador con esa cédula."));
        }
        return null;
    }

    public List<TrabajadorSalud> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<TrabajadorSalud> t) {
        this.trabajadores = t;
    }

    public TrabajadorSalud getNuevoTrabajador() {
        return nuevoTrabajador;
    }

    public void setNuevoTrabajador(TrabajadorSalud t) {
        this.nuevoTrabajador = t;
    }

    public String getCedulaBusqueda() {
        return cedulaBusqueda;
    }

    public void setCedulaBusqueda(String cedulaBusqueda) {
        this.cedulaBusqueda = cedulaBusqueda;
    }

    public TrabajadorSalud getTrabajadorEncontrado() {
        return trabajadorEncontrado;
    }

    public void setTrabajadorEncontrado(TrabajadorSalud t) {
        this.trabajadorEncontrado = t;
    }
}
