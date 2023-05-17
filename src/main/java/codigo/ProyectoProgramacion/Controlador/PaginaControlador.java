package codigo.ProyectoProgramacion.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PaginaControlador {
    @GetMapping("/")
    public String irInicio(){
        return "inicio";
    }
}
