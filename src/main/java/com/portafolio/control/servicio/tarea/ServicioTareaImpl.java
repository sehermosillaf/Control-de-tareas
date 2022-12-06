package com.portafolio.control.servicio.tarea;

import com.portafolio.control.dao.TareaRechazadaDAO;
import com.portafolio.control.dto.TareaDTO;
import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.ITareaRepo;
import com.portafolio.control.repositorio.ITareaSubordiandaRepo;
import com.portafolio.control.repositorio.IUsuarioRepo;
import com.portafolio.control.servicio.estado.ServicioEstadoImpl;
import com.portafolio.control.servicio.mail.EnvioMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServicioTareaImpl implements IServicioTarea {

    @Autowired
    private ITareaRepo tareaRepo;

    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Autowired
    private EnvioMail email;

    @Override
    public List<Tarea> obtenerTodasLasTareas() {
        return tareaRepo.findAll();
    }

    @Override
    public Optional<Tarea> obtenerTareaPorID(Long id) {
        return tareaRepo.findById(id);
    }

    @Override
    public List<Tarea> obtenerTareasPorUsuario(Long id) {
        return tareaRepo.findTareasByUsuarioResponsable(id);
    }

    @Override
    public int tareasRechazadasPorUnidad(Long id) {
        return tareaRepo.tareasRechazadasPorUnidad(id);
    }

    @Override
    public int tareasAtrasadasPorUnidad(Long id) {
        return tareaRepo.tareasAtrasadasPorUnidad(id);
    }

    @Override
    public int tareasTerminadasPorUnidad(Long id) {
        return tareaRepo.tareasTerminadasPorUnidad(id);
    }

    @Override
    public int tareasAlertasPorUnidad(Long id) {
        return tareaRepo.tareasAlertasPorUnidad(id);
    }

    @Override
    public int tareasBuenasPorUnidad(Long id) {
        return tareaRepo.tareasBuenasPorUnidad(id);
    }

    @Override
    public ResponseEntity<Tarea> guardarTarea(Tarea tarea) {
        Tarea newTask = tareaRepo.save(tarea);
        return ResponseEntity.ok(newTask);
    }

    @Override
    public void insertarTarea(TareaDTO tareaDTO) {
        try{
        tareaRepo.insertarTarea(tareaDTO.getNombre(), tareaDTO.getDescripcion(), tareaDTO.getFechaCreacion(), tareaDTO.getFechaInicio(), tareaDTO.getFechaTermino(), tareaDTO.getUsuarioResponsable(),tareaDTO.getUsuarioCreador(),tareaDTO.getUnidadID());
        String correo = usuarioRepo.findEmailbyUsuarioID(tareaDTO.getUsuarioResponsable());
        Usuario usuario =usuarioRepo.findUsuarioByEmail(correo);
        System.out.println(correo);
        String asunto = "Tiene una nueva tarea asignada";
        String contenido =
                "Estimado, " + usuario.getNombre() +" " + usuario.getApellido() + "\n" +
                "Le han asignado una tarea con nombre '" + tareaDTO.getNombre() +"' con un plazo de inicio el dia " + tareaDTO.getFechaInicio() + " y fecha de termino limite " + tareaDTO.getFechaTermino() + "\n" +
                "Control de tareas - Process SPA";
        email.SendEmail(correo,asunto,contenido);
        } catch(Exception e) {
        }
    }

    @Override
    public ResponseEntity<Tarea> eliminarTarea(Long id) {
        Tarea tareaPorEliminar = tareaRepo.findById(id).orElse(null);
        if (tareaPorEliminar == null) {
            return (ResponseEntity<Tarea>) ResponseEntity.notFound();
        }
        tareaRepo.delete(tareaPorEliminar);
        return ResponseEntity.ok(tareaPorEliminar);
    }

    @Override
    //Todo: Verificar usuario responsable email
    public void rechazarTarea(TareaRechazadaDAO tarea) {
        tareaRepo.rechazarTarea(tarea.getIdTarea(),tarea.getJustificacion(),tarea.getIdResponsable());
        String correo = usuarioRepo.findEmailbyUsuarioID(tarea.getIdResponsable());
        Usuario usuario = usuarioRepo.findUsuarioByEmail(correo);
        Tarea task = tareaRepo.findTareasById(tarea.getIdTarea());
        String contenido = "La tarea '" + task.getNombre() + "' a sido rechazada por el usuario " + usuario.getNombre() + " " + usuario.getApellido() + "\nJustificación: " + tarea.getJustificacion();
        email.SendEmail(correo,"Tarea rechazada",contenido);
    }

    @Override
    public ResponseEntity<Tarea> actualizarTarea(Long id, Tarea tarea) {
        //Todo:Crear excepcion personalizada
        Tarea tareaPorActualizar = tareaRepo.findById(id).get();
        tareaPorActualizar.setNombre(tarea.getNombre());
        tareaPorActualizar.setDescripcion(tarea.getDescripcion());
        tareaPorActualizar.setSubtareas(tarea.getSubtareas());
        tareaPorActualizar.setEstado(tarea.getEstado());
        tareaPorActualizar.setFechaInicio(tarea.getFechaInicio());
        tareaPorActualizar.setFechaTermino(tarea.getFechaTermino());
        tareaRepo.save(tareaPorActualizar);
        return ResponseEntity.ok(tarea);
    }

    @Override
    public void terminarTarea(Long id) {
        tareaRepo.terminarTarea(id);
    }

    @Override
    public void actualizarEstadoTarea() {
        tareaRepo.actualizarEstado();
    }

    @Override
    public int obtenerUsuarioCreador(Long idTarea) {
        return tareaRepo.obtenerUsuarioCreador(idTarea);
    }

}
