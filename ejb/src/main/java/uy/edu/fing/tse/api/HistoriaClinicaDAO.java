package uy.edu.fing.tse.api;

import jakarta.ejb.Local;
import uy.edu.fing.tse.entidades.HistoriaClinica;

import java.util.List;

@Local
public interface HistoriaClinicaDAO {
    HistoriaClinica crear(HistoriaClinica historia);
    HistoriaClinica actualizar(HistoriaClinica historia);
    void eliminar(Long id);
    HistoriaClinica obtenerPorId(Long id);
    List<HistoriaClinica> listarTodas();
}
