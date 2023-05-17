package codigo.ProyectoProgramacion.Controlador;

import codigo.ProyectoProgramacion.Modelo.Consultorio;
import codigo.ProyectoProgramacion.Servicio.ConsultorioServicio;
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
public class ConsultorioControlador {

    @Autowired
    private ConsultorioServicio consultorioServicio;

    @GetMapping("/consultorios")
    public String listarConsultorios(Model model){
        List<Consultorio> consultorios = consultorioServicio.listarConsultorios();
        model.addAttribute("consultorios", consultorios);
        return "listaConsultorios";
    }

    @GetMapping("/consultorios/anadir")
    public String anadirConsultorio(Model model){
        model.addAttribute("consultorio", new Consultorio());
        return "formularioConsultorioAgregar";
    }

    @PostMapping("/consultorios/anadir/guardar")
    public String guardarConsultorioAnadir(@Validated Consultorio consultorio){
        consultorioServicio.guardarConsultorioAnadir(consultorio);
        return "redirect:/consultorios";
    }

    @GetMapping("/consultorios/editar/{id}")
    public String editarConsultorio(@PathVariable int id, Model model){
        Optional<Consultorio> consultorio = consultorioServicio.obtenerConsultorio(id);
        consultorioServicio.setConsultorioEditar(consultorio.get());
        model.addAttribute("consultorio", consultorio);
        return "formularioConsultorioModificar";
    }

    @PostMapping("/consultorios/editar/guardar")
    public String guardarConsultorioEditar(@Validated Consultorio consultorio){
        consultorioServicio.guardarConsultorioEditar(consultorio);
        return "redirect:/consultorios";
    }

    @GetMapping("/consultorios/eliminar/{id}")
    public String eliminarConsultorio(@PathVariable int id){
        consultorioServicio.eliminarConsultorio(id);
        return "redirect:/consultorios";
    }
}
