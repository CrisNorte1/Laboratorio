package uy.edu.fing.tse.controladores;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uy.edu.fing.tse.entidades.HistoriaClinica;
import uy.edu.fing.tse.servicios.IHistoriaClinicaService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/historiaClinica")
public class HistoriaClinicaServlet extends HttpServlet {

    @EJB
    private IHistoriaClinicaService historiaClinicaService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<HistoriaClinica> historias = historiaClinicaService.listarTodas();

        request.setAttribute("historias", historias);

        request.getRequestDispatcher("/vistas/historiaClinica.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pacienteId = request.getParameter("pacienteId");
        String motivoConsulta = request.getParameter("motivoConsulta");
        String especialidad = request.getParameter("especialidad");
        String prestador = request.getParameter("prestador");

        HistoriaClinica hc = new HistoriaClinica();
        hc.setIdUsuarioSalud(Long.parseLong(pacienteId));
        hc.setMotivoConsulta(motivoConsulta);
        hc.setPrestador(prestador);
        hc.setEspecialidad(especialidad);
        hc.setFechaCreacion(LocalDate.now().atStartOfDay());

        historiaClinicaService.crear(hc);

        response.sendRedirect("historiaClinica");
    }
}
