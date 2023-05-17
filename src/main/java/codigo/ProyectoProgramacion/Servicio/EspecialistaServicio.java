package codigo.ProyectoProgramacion.Servicio;

import codigo.ProyectoProgramacion.Modelo.Especialista;
import codigo.ProyectoProgramacion.Repositorio.EspecialistaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialistaServicio {

    @Autowired
    private EspecialistaRepositorio especialistaRepositorio;
    private Especialista especialistaEditar;

    public Especialista guardarEspecialistaAnadir(Especialista especialista){
        generarHorario(especialista);
        return especialistaRepositorio.save(especialista);
    }

    public Especialista guardarEspecialistaEditar(Especialista especialista){
        especialistaRepositorio.delete(this.especialistaEditar);
        return this.guardarEspecialistaAnadir(especialista);
    }

    public Optional<Especialista> obtenerEspecialista(int id){
        return especialistaRepositorio.findById(id);
    }

    public void eliminarEspecialista(int id){
        especialistaRepositorio.deleteById(id);
    }

    public List<Especialista> listarEspecialistas(){
        return especialistaRepositorio.findAll();
    }

    private void generarHorario(Especialista especialista) {
        generarHorarioInicio(especialista);
        generarHorarioFin(especialista);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("h':'mm a");
        String dias="";
        int contDias=0;
        if(especialista.isHorarioDia1()){
            contDias++;
        }
        if(especialista.isHorarioDia2()){
            contDias++;
        }
        if(especialista.isHorarioDia3()){
            contDias++;
        }
        if(especialista.isHorarioDia4()){
            contDias++;
        }
        if(especialista.isHorarioDia5()){
            contDias++;
        }
        if(especialista.isHorarioDia6()){
            contDias++;
        }
        if(especialista.isHorarioDia7()){
            contDias++;
        }
        int totalDias=contDias;
        if(especialista.isHorarioDia1()){
            dias = "Lunes";
            contDias--;
        }
        if((especialista.isHorarioDia2())&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Martes";
            } else if (contDias==1) {
                dias = dias + " y martes";
            } else {
                dias = dias + ", martes";
            }
            contDias--;
        }
        if((especialista.isHorarioDia3())&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Miércoles";
            } else if (contDias==1) {
                dias = dias + " y miércoles";
            } else {
                dias = dias + ", miércoles";
            }
            contDias--;
        }
        if((especialista.isHorarioDia4())&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Jueves";
            } else if (contDias==1) {
                dias = dias + " y jueves";
            } else {
                dias = dias + ", jueves";
            }
            contDias--;
        }
        if((especialista.isHorarioDia5())&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Viernes";
            } else if (contDias==1) {
                dias = dias + " y viernes";
            } else {
                dias = dias + ", viernes";
            }
            contDias--;
        }
        if((especialista.isHorarioDia6())&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Sábados";
            } else if (contDias==1) {
                dias = dias + " y sábados";
            } else {
                dias = dias + ", sábados";
            }
            contDias--;
        }
        if((especialista.isHorarioDia7())&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Domingos";
            } else if (contDias==1) {
                dias = dias + " y domingos";
            }
        }
        especialista.setHorario(especialista.getHorarioInicio().format(formato)+" a "+especialista.getHorarioFin().format(formato)+"\n"
                +dias);
    }

    private void generarHorarioInicio(Especialista especialista) {
        int hora=especialista.getHorarioInicioH();
        if (hora==12){
            hora=0;
        }
        if (especialista.isHorarioInicioA()){
            hora+=12;
        }
        especialista.setHorarioInicio(LocalTime.of(hora,especialista.getHorarioInicioM()));
    }

    private void generarHorarioFin(Especialista especialista) {
        int hora=especialista.getHorarioFinH();
        if (hora==12){
            hora=0;
        }
        if (especialista.isHorarioFinA()){
            hora+=12;
        }
        especialista.setHorarioFin(LocalTime.of(hora,especialista.getHorarioFinM()));
    }

    public void setEspecialistaEditar(Especialista especialistaEditar) {
        this.especialistaEditar = especialistaEditar;
    }
}
