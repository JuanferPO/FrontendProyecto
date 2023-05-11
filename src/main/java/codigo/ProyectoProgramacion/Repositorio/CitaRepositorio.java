package codigo.ProyectoProgramacion.Repositorio;

import codigo.ProyectoProgramacion.Modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, Integer> {
}
