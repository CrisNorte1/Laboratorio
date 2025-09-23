package uy.edu.fing.tse.servicios;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import uy.edu.fing.tse.api.HistoriaClinicaService;
import uy.edu.fing.tse.entidades.HistoriaClinica;
import uy.edu.fing.tse.api.HistoriaClinicaDAO;

import java.util.List;

@Stateless
public class HistoriaClinicaServiceBean implements HistoriaClinicaService {

    @EJB
    private HistoriaClinicaDAO persistence;

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
    public List<HistoriaClinica> listar() {
        return persistence.listarTodas();
    }
}
