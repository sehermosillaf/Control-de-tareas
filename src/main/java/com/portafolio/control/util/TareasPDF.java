package com.portafolio.control.util;

import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.portafolio.control.modelo.Tarea;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import com.lowagie.text.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.servlet.http.HttpServletResponse;


@Component
public class TareasPDF {
    private List<Tarea> tareaList;

    public TareasPDF(List<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

    public TareasPDF() {
    }

    public void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Numero de Tarea", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Nombre", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Descripcion", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Fecha de Creacion", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Fecha de Inicio", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Fecha de Termino", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Asignado", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Creador", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Unidad", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Estado", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Tarea tarea : tareaList) {
            table.addCell(String.valueOf(tarea.getId()));
            table.addCell(tarea.getNombre());
            table.addCell(tarea.getDescripcion());
            table.addCell(tarea.getFechaCreacion().toString());
            table.addCell(tarea.getFechaInicio().toString());
            table.addCell(tarea.getFechaTermino().toString());
            table.addCell(tarea.getUsuarioResponsable().getNombre());
            table.addCell(tarea.getUsuarioCreador().toString());
            table.addCell(tarea.getUnidad().toString());
            table.addCell(tarea.getEstado().getNombre());
        }
    }
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Lista de tareas", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);
        document.close();
    }


}
