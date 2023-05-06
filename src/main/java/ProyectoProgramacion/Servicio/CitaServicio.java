package ProyectoProgramacion.Servicio;

import ProyectoProgramacion.Repositorio.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ProyectoProgramacion.Modelo.Cita;
import java.util.List;
import java.util.Optional;

@Service
public class CitaServicio {

    @Autowired
    private CitaRepositorio citaRepositorio;

    public Cita guardarCita(Cita cita){
        cita.generarFechaAtencion();
        cita.generarHoraAtencion();
        return citaRepositorio.save(cita);
    }

    public Optional<Cita> obtenerCita(Long id){
        return citaRepositorio.findById(id);
    }

    public void eliminarCita(Long id){
        citaRepositorio.deleteById(id);
    }

    public List<Cita> listarCitas(){
        return citaRepositorio.findAll();
    }
}
