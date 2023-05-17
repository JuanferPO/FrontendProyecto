package codigo.ProyectoProgramacion.Servicio;

import codigo.ProyectoProgramacion.Modelo.Departamento;
import codigo.ProyectoProgramacion.Repositorio.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServicio {

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;
    private Departamento departamentoEditar;

    public Departamento guardarDepartamentoAnadir(Departamento departamento){
        return departamentoRepositorio.save(departamento);
    }

    public Departamento guardarDepartamentoEditar(Departamento departamento){
        departamentoRepositorio.delete(this.departamentoEditar);
        return this.guardarDepartamentoAnadir(departamento);
    }

    public Optional<Departamento> obtenerDepartamento(int id){
        return departamentoRepositorio.findById(id);
    }

    public void eliminarDepartamento(int id){
        departamentoRepositorio.deleteById(id);
    }

    public List<Departamento> listarDepartamentos(){
        return departamentoRepositorio.findAll();
    }

    public void setDepartamentoEditar(Departamento departamentoEditar) {
        this.departamentoEditar = departamentoEditar;
    }
}
