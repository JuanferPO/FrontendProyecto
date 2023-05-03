package ProyectoProgramacion.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Especialista")
public class EspecialistaModelo {
    Long id;
    private String nombre;
    private String especialidad;
    private String horario;
    private LocalTime horarioInicio;
    private LocalTime horarioFin;
    private byte horarioInicioH;
    private byte horarioInicioM;
    private String horarioInicioP;
    private byte horarioFinH;
    private byte horarioFinM;
    private String horarioFinP;
    private boolean horarioDia1;
    private boolean horarioDia2;
    private boolean horarioDia3;
    private boolean horarioDia4;
    private boolean horarioDia5;
    private boolean horarioDia6;
    private boolean horarioDia7;
}
