package codigo.ProyectoProgramacion.Servicio;

import codigo.ProyectoProgramacion.Modelo.Especialidad;
import codigo.ProyectoProgramacion.Repositorio.EspecialidadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServicio {

    @Autowired
    private EspecialidadRepositorio especialidadRepositorio;
    private Especialidad especialidadEditar;

    public Especialidad guardarEspecialidadAnadir(Especialidad especialidad){
        return especialidadRepositorio.save(especialidad);
    }

    public Especialidad guardarEspecialidadEditar(Especialidad especialidad){
        especialidadRepositorio.delete(this.especialidadEditar);
        return this.guardarEspecialidadAnadir(especialidad);
    }

    public Optional<Especialidad> obtenerEspecialidad(int id){
        return especialidadRepositorio.findById(id);
    }

    public void eliminarEspecialidad(int id){
        especialidadRepositorio.deleteById(id);
    }

    public List<Especialidad> listarEspecialidades(){
        return especialidadRepositorio.findAll();
    }

    public void setEspecialidadEditar(Especialidad especialidadEditar) {
        this.especialidadEditar = especialidadEditar;
    }
}
