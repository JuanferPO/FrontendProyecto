package ProyectoProgramacion.Repositorio;

import ProyectoProgramacion.Modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, Long> {
}
