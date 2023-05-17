package codigo.ProyectoProgramacion.Servicio;

import codigo.ProyectoProgramacion.Repositorio.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import codigo.ProyectoProgramacion.Modelo.Cita;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CitaServicio {

    @Autowired
    private CitaRepositorio citaRepositorio;
    private Cita citaEditar;

    public Cita guardarCitaAnadir(Cita cita){
        generarFechaAtencion(cita);
        generarHoraAtencion(cita);
        return citaRepositorio.save(cita);
    }

    public Cita guardarCitaEditar(Cita cita){
        citaRepositorio.delete(this.citaEditar);
        return this.guardarCitaAnadir(cita);
    }

    public Optional<Cita> obtenerCita(int id){
        return citaRepositorio.findById(id);
    }

    public void eliminarCita(int id){
        citaRepositorio.deleteById(id);
    }

    public List<Cita> listarCitas(){
        return citaRepositorio.findAll();
    }
    
    public void generarFechaAtencion(Cita cita) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d ' de 'MMMM ' de ' yyyy").withLocale(new Locale("es"));
        cita.setFechaAtencion(LocalDate.of(cita.getFechaAtencionAno(),cita.getFechaAtencionMes()+1,cita.getFechaAtencionDia()).format(formato));
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
        if (cita.isHoraAtencionInicioA()){
            hora+=12;
        }
        cita.setHoraAtencionInicio(LocalTime.of(hora,cita.getHoraAtencionInicioM()));
    }

    private void generarHoraAtencionFin(Cita cita) {
        int hora=cita.getHoraAtencionFinH();
        if (hora==12){
            hora=0;
        }
        if (cita.isHoraAtencionFinA()){
            hora+=12;
        }
        cita.setHoraAtencionFin(LocalTime.of(hora,cita.getHoraAtencionFinM()));
    }

    public void setCitaEditar(Cita citaEditar) {
        this.citaEditar = citaEditar;
    }
}
