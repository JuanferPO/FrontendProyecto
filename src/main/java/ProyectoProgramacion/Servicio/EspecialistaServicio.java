package ProyectoProgramacion.Servicio;

import ProyectoProgramacion.Modelo.Especialista;
import ProyectoProgramacion.Repositorio.EspecialistaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EspecialistaServicio {

    @Autowired
    private EspecialistaRepositorio especialistaRepositorio;

    public Especialista guardarEspecialista(Especialista especialista){
        especialista.generarHorario();
        return especialistaRepositorio.save(especialista);
    }

    public void borrarEspecialista(Long id){
        especialistaRepositorio.deleteById(id);
    }

    public List<Especialista> listarEspecialistas(){
        return especialistaRepositorio.findAll();
    }
}
