package codigo.ProyectoProgramacion.Controlador;

import codigo.ProyectoProgramacion.Modelo.Especialista;
import codigo.ProyectoProgramacion.Servicio.EspecialistaServicio;
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
public class EspecialistaControlador {

    @Autowired
    private EspecialistaServicio especialistaServicio;

    @GetMapping("/especialistas")
    public String listarEspecialistas(Model model){
        List<Especialista>especialistas= especialistaServicio.listarEspecialistas();
        model.addAttribute("especialistas", especialistas);
        return "listaEspecialistas";
    }

    @GetMapping("/especialistas/anadir")
    public String anadirEspecialista(Model model){
        model.addAttribute("especialista", new Especialista());
        return "formularioEspecialistaAgregar";
    }

    @PostMapping("/especialistas/guardar")
    public String guardarEspecialista(@Validated Especialista especialista){
        especialistaServicio.guardarEspecialista(especialista);
        return "redirect:/especialistas";
    }

    @GetMapping("/especialistas/editar/{id}")
    public String editarEspecialista(@PathVariable Long id, Model model){
        Optional<Especialista> especialista = especialistaServicio.obtenerEspecialista(id);
        model.addAttribute("especialista", especialista);
        return "formularioEspecialistaModificar";
    }

    @GetMapping("/especialistas/eliminar/{id}")
    public String eliminarEspecialista(@PathVariable Long id){
        especialistaServicio.eliminarEspecialista(id);
        return "redirect:/especialistas";
    }
}
