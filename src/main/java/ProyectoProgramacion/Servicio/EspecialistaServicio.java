package ProyectoProgramacion.Servicio;

import ProyectoProgramacion.Modelo.Especialista;
import ProyectoProgramacion.Repositorio.EspecialistaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialistaServicio {

    @Autowired
    private EspecialistaRepositorio especialistaRepositorio;

    public Especialista guardarEspecialista(Especialista especialista){
        especialista.generarHorario();
        return especialistaRepositorio.save(especialista);
    }

    public Optional<Especialista> obtenerEspecialista(Long id){
        return especialistaRepositorio.findById(id);
    }

    public void eliminarEspecialista(Long id){
        especialistaRepositorio.deleteById(id);
    }

    public List<Especialista> listarEspecialistas(){
        return especialistaRepositorio.findAll();
    }
}
