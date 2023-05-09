package codigo.ProyectoProgramacion.Modelo;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
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
}
