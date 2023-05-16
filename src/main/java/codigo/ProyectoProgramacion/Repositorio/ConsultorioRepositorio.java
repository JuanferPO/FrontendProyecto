package codigo.ProyectoProgramacion.Repositorio;

import codigo.ProyectoProgramacion.Modelo.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorioRepositorio extends JpaRepository<Consultorio, Integer> {
}
