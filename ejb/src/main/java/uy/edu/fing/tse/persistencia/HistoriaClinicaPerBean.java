package uy.edu.fing.tse.persistencia;

import jakarta.ejb.Singleton;
import uy.edu.fing.tse.entidades.HistoriaClinica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class HistoriaClinicaPerBean implements
        IHistoriaClinicaDAO {

    private static final Map<Long, HistoriaClinica> DATA = new HashMap<>();
    private static final AtomicLong SEQ = new AtomicLong(1);

    @Override
    public HistoriaClinica crear(HistoriaClinica historia) {
        Long id = SEQ.getAndIncrement();
        historia.setId(id);
        DATA.put(id, historia);
        return historia;
    }

    @Override
    public HistoriaClinica actualizar(HistoriaClinica historia) {
        if (historia.getId() == null || !DATA.containsKey(historia.getId())) {
            throw new IllegalArgumentException("Historia clínica no encontrada para actualizar");
        }
        DATA.put(historia.getId(), historia);
        return historia;
    }

    @Override
    public void eliminar(Long id) {
        DATA.remove(id);
    }

    @Override
    public HistoriaClinica obtenerPorId(Long id) {
        return DATA.get(id);
    }

    @Override
    public List<HistoriaClinica> listarTodas() {
        return new ArrayList<>(DATA.values());
    }
}