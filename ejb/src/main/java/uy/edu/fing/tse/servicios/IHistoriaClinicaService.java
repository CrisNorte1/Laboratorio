package uy.edu.fing.tse.servicios;

import jakarta.ejb.Local;
import uy.edu.fing.tse.entidades.HistoriaClinica;

import java.util.List;

@Local
public interface IHistoriaClinicaService {
    HistoriaClinica crear(HistoriaClinica historia);
    HistoriaClinica actualizar(HistoriaClinica historia);
    void eliminar(Long id);
    HistoriaClinica obtenerPorId(Long id);
    List<HistoriaClinica> listarTodas();
}
