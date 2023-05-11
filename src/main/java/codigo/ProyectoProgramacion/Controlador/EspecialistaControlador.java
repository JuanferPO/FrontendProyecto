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
        List<Especialista> especialistas = especialistaServicio.listarEspecialistas();
        model.addAttribute("especialistas", especialistas);
        return "listaEspecialistas";
    }

    @GetMapping("/especialistas/anadir")
    public String anadirEspecialista(Model model){
        model.addAttribute("especialista", new Especialista());
        return "formularioEspecialistaAgregar";
    }

    @PostMapping("/especialistas/anadir/guardar")
    public String guardarEspecialistaAnadir(@Validated Especialista especialista){
        especialistaServicio.guardarEspecialistaAnadir(especialista);
        return "redirect:/especialistas";
    }

    @GetMapping("/especialistas/editar/{id}")
    public String editarEspecialista(@PathVariable int id, Model model){
        Optional<Especialista> especialista = especialistaServicio.obtenerEspecialista(id);
        especialistaServicio.setEspecialistaEditar(especialista.get());
        model.addAttribute("especialista", especialista);
        return "formularioEspecialistaModificar";
    }

    @PostMapping("/especialistas/editar/guardar")
    public String guardarEspecialistaEditar(@Validated Especialista especialista){
        especialistaServicio.guardarEspecialistaEditar(especialista);
        return "redirect:/especialistas";
    }

    @GetMapping("/especialistas/eliminar/{id}")
    public String eliminarEspecialista(@PathVariable int id){
        especialistaServicio.eliminarEspecialista(id);
        return "redirect:/especialistas";
    }
}
