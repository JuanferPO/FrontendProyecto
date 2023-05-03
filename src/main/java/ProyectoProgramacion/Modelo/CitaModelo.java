package ProyectoProgramacion.Modelo;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cita")
public class CitaModelo {
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
    private byte fechaAtencionDia;
    private String fechaAtencionMes;
    private short fechaAtencionAno;
    private byte horaAtencionInicioH;
    private byte horaAtencionInicioM;
    private String horaAtencionInicioP;
    private byte horaAtencionFinH;
    private byte horaAtencionFinM;
    private String horaAtencionFinP;
}
