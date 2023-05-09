package ProyectoProgramacion.Servicio;

import ProyectoProgramacion.Repositorio.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ProyectoProgramacion.Modelo.Cita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CitaServicio {

    @Autowired
    private CitaRepositorio citaRepositorio;

    public Cita guardarCita(Cita cita){
        generarFechaAtencion(cita);
        generarHoraAtencion(cita);
        return citaRepositorio.save(cita);
    }

    public Optional<Cita> obtenerCita(Long id){
        return citaRepositorio.findById(id);
    }

    public void eliminarCita(Long id){
        citaRepositorio.deleteById(id);
    }

    public List<Cita> listarCitas(){
        return citaRepositorio.findAll();
    }
    
    public void generarFechaAtencion(Cita cita) {
        int mes;
        switch (cita.getFechaAtencionMes()){
            case "enero":
                mes=1;
                break;
            case "febrero":
                mes=2;
                break;
            case "marzo":
                mes=3;
                break;
            case "abril":
                mes=4;
                break;
            case "mayo":
                mes=5;
                break;
            case "junio":
                mes=6;
                break;
            case "julio":
                mes=7;
                break;
            case "agosto":
                mes=8;
                break;
            case "septiembre":
                mes=9;
                break;
            case "octubre":
                mes=10;
                break;
            case "noviembre":
                mes=11;
                break;
            case "diciembre":
                mes=12;
                break;
            default:
                throw new RuntimeException();
        }
        cita.setFechaAtencion(LocalDate.of(cita.getFechaAtencionAno(),mes,cita.getFechaAtencionDia()));
    }

    private void generarHoraAtencion(Cita cita) {
        generarHoraAtencionInicio(cita);
        generarHoraAtencionFin(cita);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("h':'mm a");
        cita.setHoraAtencion(cita.getHoraAtencionInicio().format(formato)+" a "+cita.getHoraAtencionFin().format(formato));
    }

    private void generarHoraAtencionInicio(Cita cita) {
        int hora=cita.getHoraAtencionInicioH();
        if (hora==12){
            hora=0;
        }
        if (cita.getHoraAtencionInicioA().equals("p.m.")){
            hora+=12;
        }
        cita.setHoraAtencionInicio(LocalTime.of(hora,cita.getHoraAtencionInicioM()));
    }

    private void generarHoraAtencionFin(Cita cita) {
        int hora=cita.getHoraAtencionFinH();
        if (hora==12){
            hora=0;
        }
        if (cita.getHoraAtencionFinA().equals("p.m.")){
            hora+=12;
        }
        cita.setHoraAtencionFin(LocalTime.of(hora,cita.getHoraAtencionFinM()));
    }

}
