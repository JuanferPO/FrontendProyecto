package codigo.ProyectoProgramacion.Controlador;

import codigo.ProyectoProgramacion.Modelo.Departamento;
import codigo.ProyectoProgramacion.Servicio.DepartamentoServicio;
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
public class DepartamentoControlador {

    @Autowired
    private DepartamentoServicio departamentoServicio;

    @GetMapping("/departamentos")
    public String listarDepartamentos(Model model){
        List<Departamento> departamentos = departamentoServicio.listarDepartamentos();
        model.addAttribute("departamentos", departamentos);
        return "listaDepartamentos";
    }

    @GetMapping("/departamentos/anadir")
    public String anadirDepartamento(Model model){
        model.addAttribute("departamento", new Departamento());
        return "formularioDepartamentoAgregar";
    }

    @PostMapping("/departamentos/anadir/guardar")
    public String guardarDepartamentoAnadir(@Validated Departamento departamento){
        departamentoServicio.guardarDepartamentoAnadir(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/departamentos/editar/{id}")
    public String editarDepartamento(@PathVariable int id, Model model){
        Optional<Departamento> departamento = departamentoServicio.obtenerDepartamento(id);
        departamentoServicio.setDepartamentoEditar(departamento.get());
        model.addAttribute("departamento", departamento);
        return "formularioDepartamentoModificar";
    }

    @PostMapping("/departamentos/editar/guardar")
    public String guardarDepartamentoEditar(@Validated Departamento departamento){
        departamentoServicio.guardarDepartamentoEditar(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/departamentos/eliminar/{id}")
    public String eliminarDepartamento(@PathVariable int id){
        departamentoServicio.eliminarDepartamento(id);
        return "redirect:/departamentos";
    }
}
