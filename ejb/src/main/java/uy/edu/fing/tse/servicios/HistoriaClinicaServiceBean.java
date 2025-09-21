package uy.edu.fing.tse.servicios;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import uy.edu.fing.tse.entidades.HistoriaClinica;
import uy.edu.fing.tse.persistencia.IHistoriaClinicaDAO;

import java.util.List;

@Stateless
public class HistoriaClinicaServiceBean implements  IHistoriaClinicaService{

    @EJB
    private IHistoriaClinicaDAO persistence;

    @Override
    public HistoriaClinica crear(HistoriaClinica historia) {
        return persistence.crear(historia);
    }

    @Override
    public HistoriaClinica actualizar(HistoriaClinica historia) {
        return persistence.actualizar(historia);
    }

    @Override
    public void eliminar(Long id) {
        persistence.eliminar(id);
    }

    @Override
    public HistoriaClinica obtenerPorId(Long id) {
        return persistence.obtenerPorId(id);
    }

    @Override
    public List<HistoriaClinica> listarTodas() {
        return persistence.listarTodas();
    }
}
