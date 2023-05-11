package codigo.ProyectoProgramacion.Controlador;

import codigo.ProyectoProgramacion.Modelo.Cita;
import codigo.ProyectoProgramacion.Servicio.CitaServicio;
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
public class CitaControlador {

    @Autowired
    private CitaServicio citaServicio;

    @GetMapping("/citas")
    public String listarCitas(Model model){
        List<Cita> citas = citaServicio.listarCitas();
        model.addAttribute("citas", citas);
        return "listaCitas";
    }

    @GetMapping("/citas/anadir")
    public String anadirCita(Model model){
        model.addAttribute("cita", new Cita());
        return "formularioCitaSolicitar";
    }

    @PostMapping("/citas/anadir/guardar")
    public String guardarCitaAnadir(@Validated Cita cita){
        citaServicio.guardarCitaAnadir(cita);
        return "redirect:/citas";
    }

    @GetMapping("/citas/editar/{id}")
    public String editarCita(@PathVariable int id, Model model){
        Optional<Cita> cita = citaServicio.obtenerCita(id);
        citaServicio.setCitaEditar(cita.get());
        model.addAttribute("cita", cita);
        return "formularioCitaModificar";
    }

    @PostMapping("/citas/editar/guardar")
    public String guardarCitaEditar(@Validated Cita cita){
        citaServicio.guardarCitaEditar(cita);
        return "redirect:/citas";
    }

    @GetMapping("/citas/eliminar/{id}")
    public String eliminarCita(@PathVariable int id){
        citaServicio.eliminarCita(id);
        return "redirect:/citas";
    }
}
