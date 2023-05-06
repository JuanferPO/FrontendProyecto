package ProyectoProgramacion.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Especialista")
public class Especialista {
    Long id;
    private String nombre;
    private String especialidad;
    private String horario;
    private LocalTime horarioInicio;
    private LocalTime horarioFin;
    private byte horarioInicioH;
    private byte horarioInicioM;
    private String horarioInicioA;
    private byte horarioFinH;
    private byte horarioFinM;
    private String horarioFinA;
    private boolean[] horarioDia = new boolean[7];
    public void generarHorario() {
        this.generarHorarioInicio();
        this.generarHorarioFin();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("h':'mm a");
        String dias="";
        int contDias=0;
        for (int i=0; i<7; i++){
            if(this.horarioDia[i]){
                contDias++;
            }
        }
        int totalDias=contDias;
        if(this.horarioDia[0]){
            dias = "Lunes";
            contDias--;
        }
        if((this.horarioDia[1])&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Martes";
            } else if (contDias==1) {
                dias = dias + " y martes";
            } else {
                dias = dias + ", martes";
            }
            contDias--;
        }
        if((this.horarioDia[2])&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Miércoles";
            } else if (contDias==1) {
                dias = dias + " y miércoles";
            } else {
                dias = dias + ", miércoles";
            }
            contDias--;
        }
        if((this.horarioDia[3])&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Jueves";
            } else if (contDias==1) {
                dias = dias + " y jueves";
            } else {
                dias = dias + ", jueves";
            }
            contDias--;
        }
        if((this.horarioDia[4])&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Viernes";
            } else if (contDias==1) {
                dias = dias + " y viernes";
            } else {
                dias = dias + ", viernes";
            }
            contDias--;
        }
        if((this.horarioDia[5])&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Sábados";
            } else if (contDias==1) {
                dias = dias + " y sábados";
            } else {
                dias = dias + ", sábados";
            }
            contDias--;
        }
        if((this.horarioDia[6])&(contDias!=0)){
            if(contDias==totalDias){
                dias = "Domingos";
            } else if (contDias==1) {
                dias = dias + " y domingos";
            }
        }
        this.horario = this.getHorarioInicio().format(formato)+" a "+this.getHorarioFin().format(formato)+"\n"
                +dias;
    }

    private void generarHorarioInicio() {
        int hora=this.getHorarioInicioH();
        if (hora==12){
            hora=0;
        }
        if (this.getHorarioInicioA().equals("p.m.")){
            hora+=12;
        }
        this.horarioInicio = LocalTime.of(hora,this.getHorarioInicioM());
    }

    private void generarHorarioFin() {
        int hora=this.getHorarioFinH();
        if (hora==12){
            hora=0;
        }
        if (this.getHorarioFinA().equals("p.m.")){
            hora+=12;
        }
        this.horarioFin = LocalTime.of(hora,this.getHorarioFinM());
    }
}
