package codigo.ProyectoProgramacion.Controlador;

import codigo.ProyectoProgramacion.Modelo.Especialidad;
import codigo.ProyectoProgramacion.Servicio.EspecialidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class EspecialidadControlador {

    @Autowired
    private EspecialidadServicio especialidadeservicio;

    @GetMapping("/especialidades")
    public String listarEspecialidades(Model model){
        List<Especialidad> especialidades = especialidadeservicio.listarEspecialidades();
        model.addAttribute("especialidades", especialidades);
        return "listaEspecialidades";
    }

    @GetMapping("/especialidades/anadir")
    public String anadirEspecialidad(Model model){
        model.addAttribute("especialidad", new Especialidad());
        return "formularioEspecialidadAgregar";
    }

    @PostMapping("/especialidades/anadir/guardar")
    public String guardarEspecialidadAnadir(@Validated Especialidad especialidad){
        especialidadeservicio.guardarEspecialidadAnadir(especialidad);
        return "redirect:/especialidades";
    }

    @GetMapping("/especialidades/editar/{id}")
    public String editarEspecialidad(@PathVariable int id, Model model){
        Optional<Especialidad> especialidad = especialidadeservicio.obtenerEspecialidad(id);
        especialidadeservicio.setEspecialidadEditar(especialidad.get());
        model.addAttribute("especialidad", especialidad);
        return "formularioEspecialidadModificar";
    }

    @PostMapping("/especialidades/editar/guardar")
    public String guardarEspecialidadEditar(@Validated Especialidad especialidad){
        especialidadeservicio.guardarEspecialidadEditar(especialidad);
        return "redirect:/especialidades";
    }

    @GetMapping("/especialidades/eliminar/{id}")
    public String eliminarEspecialidad(@PathVariable int id){
        especialidadeservicio.eliminarEspecialidad(id);
        return "redirect:/especialidades";
    }
}
