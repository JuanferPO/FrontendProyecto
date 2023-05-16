package codigo.ProyectoProgramacion.Repositorio;

import codigo.ProyectoProgramacion.Modelo.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepositorio extends JpaRepository<Especialidad, Integer> {
}
