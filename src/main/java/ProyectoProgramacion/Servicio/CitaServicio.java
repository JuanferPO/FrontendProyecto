package ProyectoProgramacion.Servicio;

import ProyectoProgramacion.Repositorio.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ProyectoProgramacion.Modelo.Cita;
import java.util.List;

@Service
public class CitaServicio {

    @Autowired
    private CitaRepositorio citaRepositorio;

    public Cita guardarCita(Cita cita){
        cita.generarFechaAtencion();
        cita.generarHoraAtencion();
        return citaRepositorio.save(cita);
    }

    public void borrarCita(Long id){
        citaRepositorio.deleteById(id);
    }

    public List<Cita> listarCitas(){
        return citaRepositorio.findAll();
    }
}
