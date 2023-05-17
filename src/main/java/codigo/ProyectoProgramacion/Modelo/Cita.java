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
@Table(name = "Cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    private String nombrePaciente;
    private String procedimiento;
    private String nombreEspecialista;
    private String fechaAtencion;
    private String horaAtencion;
    private String consultorio;
    private LocalTime horaAtencionInicio;
    private LocalTime horaAtencionFin;
    private int fechaAtencionDia;
    private int fechaAtencionMes;
    private int fechaAtencionAno;
    private int horaAtencionInicioH;
    private int horaAtencionInicioM;
    private boolean horaAtencionInicioA;
    private int horaAtencionFinH;
    private int horaAtencionFinM;
    private boolean horaAtencionFinA;
}
