package codigo.ProyectoProgramacion.Repositorio;

import codigo.ProyectoProgramacion.Modelo.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Integer> {
}
