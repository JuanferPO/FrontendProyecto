package codigo.ProyectoProgramacion.Controlador;

import codigo.ProyectoProgramacion.Modelo.Procedimiento;
import codigo.ProyectoProgramacion.Servicio.ProcedimientoServicio;
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
public class ProcedimientoControlador {

    @Autowired
    private ProcedimientoServicio procedimientoServicio;

    @GetMapping("/procedimientos")
    public String listarProcedimientos(Model model){
        List<Procedimiento> procedimientos = procedimientoServicio.listarProcedimientos();
        model.addAttribute("procedimientos", procedimientos);
        return "listaProcedimientos";
    }

    @GetMapping("/procedimientos/anadir")
    public String anadirProcedimiento(Model model){
        model.addAttribute("procedimiento", new Procedimiento());
        return "formularioProcedimientoAgregar";
    }

    @PostMapping("/procedimientos/anadir/guardar")
    public String guardarProcedimientoAnadir(@Validated Procedimiento procedimiento){
        procedimientoServicio.guardarProcedimientoAnadir(procedimiento);
        return "redirect:/procedimientos";
    }

    @GetMapping("/procedimientos/editar/{id}")
    public String editarProcedimiento(@PathVariable int id, Model model){
        Optional<Procedimiento> procedimiento = procedimientoServicio.obtenerProcedimiento(id);
        procedimientoServicio.setProcedimientoEditar(procedimiento.get());
        model.addAttribute("procedimiento", procedimiento);
        return "formularioProcedimientoModificar";
    }

    @PostMapping("/procedimientos/editar/guardar")
    public String guardarProcedimientoEditar(@Validated Procedimiento procedimiento){
        procedimientoServicio.guardarProcedimientoEditar(procedimiento);
        return "redirect:/procedimientos";
    }

    @GetMapping("/procedimientos/eliminar/{id}")
    public String eliminarProcedimiento(@PathVariable int id){
        procedimientoServicio.eliminarProcedimiento(id);
        return "redirect:/procedimientos";
    }
}
