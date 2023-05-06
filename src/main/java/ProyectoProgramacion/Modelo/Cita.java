package ProyectoProgramacion.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    private String nombrePaciente;
    private String procedimiento;
    private String nombreEspecialista;
    private LocalDate fechaAtencion;
    private String horaAtencion;
    private String consultorio;
    private LocalTime horaAtencionInicio;
    private LocalTime horaAtencionFin;
    private int fechaAtencionDia;
    private String fechaAtencionMes;
    private int fechaAtencionAno;
    private int horaAtencionInicioH;
    private int horaAtencionInicioM;
    private String horaAtencionInicioA;
    private int horaAtencionFinH;
    private int horaAtencionFinM;
    private String horaAtencionFinA;

    public void generarFechaAtencion() {
        int mes;
        switch (this.getFechaAtencionMes()){
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
        this.fechaAtencion = LocalDate.of(this.getFechaAtencionAno(),mes,this.getFechaAtencionDia());
    }

    public void generarHoraAtencion() {
        this.generarHoraAtencionInicio();
        this.generarHoraAtencionFin();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("h':'mm a");
        this.horaAtencion = this.getHoraAtencionInicio().format(formato)+" a "+this.getHoraAtencionFin().format(formato);
    }

    private void generarHoraAtencionInicio() {
        int hora=this.getHoraAtencionInicioH();
        if (hora==12){
            hora=0;
        }
        if (this.getHoraAtencionInicioA().equals("p.m.")){
            hora+=12;
        }
        this.horaAtencionInicio = LocalTime.of(hora,this.getHoraAtencionInicioM());
    }

    private void generarHoraAtencionFin() {
        int hora=this.getHoraAtencionFinH();
        if (hora==12){
            hora=0;
        }
        if (this.getHoraAtencionFinA().equals("p.m.")){
            hora+=12;
        }
        this.horaAtencionFin = LocalTime.of(hora,this.getHoraAtencionFinM());
    }
}
