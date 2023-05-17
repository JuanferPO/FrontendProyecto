package codigo.ProyectoProgramacion.Servicio;

import codigo.ProyectoProgramacion.Modelo.Consultorio;
import codigo.ProyectoProgramacion.Repositorio.ConsultorioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultorioServicio {

    @Autowired
    private ConsultorioRepositorio consultorioRepositorio;
    private Consultorio consultorioEditar;

    public Consultorio guardarConsultorioAnadir(Consultorio consultorio){
        return consultorioRepositorio.save(consultorio);
    }

    public Consultorio guardarConsultorioEditar(Consultorio consultorio){
        consultorioRepositorio.delete(this.consultorioEditar);
        return this.guardarConsultorioAnadir(consultorio);
    }

    public Optional<Consultorio> obtenerConsultorio(int id){
        return consultorioRepositorio.findById(id);
    }

    public void eliminarConsultorio(int id){
        consultorioRepositorio.deleteById(id);
    }

    public List<Consultorio> listarConsultorios(){
        return consultorioRepositorio.findAll();
    }

    public void setConsultorioEditar(Consultorio consultorioEditar) {
        this.consultorioEditar = consultorioEditar;
    }
}
