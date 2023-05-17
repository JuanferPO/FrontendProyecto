package codigo.ProyectoProgramacion.Servicio;

import codigo.ProyectoProgramacion.Modelo.Procedimiento;
import codigo.ProyectoProgramacion.Repositorio.ProcedimientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProcedimientoServicio {

    @Autowired
    private ProcedimientoRepositorio procedimientoRepositorio;
    private Procedimiento procedimientoEditar;

    public Procedimiento guardarProcedimientoAnadir(Procedimiento procedimiento){
        return procedimientoRepositorio.save(procedimiento);
    }

    public Procedimiento guardarProcedimientoEditar(Procedimiento procedimiento){
        procedimientoRepositorio.delete(this.procedimientoEditar);
        return this.guardarProcedimientoAnadir(procedimiento);
    }

    public Optional<Procedimiento> obtenerProcedimiento(int id){
        return procedimientoRepositorio.findById(id);
    }

    public void eliminarProcedimiento(int id){
        procedimientoRepositorio.deleteById(id);
    }

    public List<Procedimiento> listarProcedimientos(){
        return procedimientoRepositorio.findAll();
    }

    public void setProcedimientoEditar(Procedimiento procedimientoEditar) {
        this.procedimientoEditar = procedimientoEditar;
    }
}
