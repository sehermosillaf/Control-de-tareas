package com.portafolio.control.controlador;

import com.lowagie.text.DocumentException;
import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.servicio.tarea.IServicioTarea;
import com.portafolio.control.util.TareasPDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/pdf/tareas")
public class PdfControlador {
    @Autowired
    private IServicioTarea servicioTarea;

    @GetMapping
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=tareas.pdf";
        response.setHeader(headerKey, headerValue);

        List<Tarea> tareaList = servicioTarea.obtenerTodasLasTareas();

        TareasPDF exporter = new TareasPDF(tareaList);
        exporter.export(response);
    }
}
