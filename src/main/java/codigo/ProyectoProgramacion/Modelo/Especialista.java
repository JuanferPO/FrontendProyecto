package codigo.ProyectoProgramacion.Modelo;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Especialista")
public class Especialista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    private String nombre;
    private String especialidad;
    private String horario;
    private LocalTime horarioInicio;
    private LocalTime horarioFin;
    private int horarioInicioH;
    private int horarioInicioM;
    private boolean horarioInicioA;
    private int horarioFinH;
    private int horarioFinM;
    private boolean horarioFinA;
    private boolean horarioDia1;
    private boolean horarioDia2;
    private boolean horarioDia3;
    private boolean horarioDia4;
    private boolean horarioDia5;
    private boolean horarioDia6;
    private boolean horarioDia7;
}
