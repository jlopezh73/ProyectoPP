package ui.frames;

import Modelo.Venta;
import Modelo.Ventas;

import javax.swing.*;
import java.awt.*;

public class TicketFrame extends JFrame {
    private Venta venta;
    JLabel etiTicket = new JLabel("");
    public TicketFrame(Venta venta) {
        this.venta = venta;
        initComponents();
    }

    private void initComponents() {
        String html = generarHTML();
        etiTicket = new JLabel(html);
        etiTicket.setPreferredSize(new Dimension(400, 700));
        etiTicket.setVerticalAlignment(SwingConstants.TOP);
        etiTicket.setHorizontalAlignment(SwingConstants.CENTER);
        add(etiTicket);
        setSize(new Dimension(400, 700));
    }

    private String generarHTML() {
        String html = "<html><center>";
        html +="<h1>Papelería El \"Peque\"</h1>";
        html +="<h3>Le surtimos desde un clip hasta un tinaco</h3>";
        html +="<p>Insurgentes No. 157 Int, Col. Centro</p>";
        html +="<p>Xalapa, Ver. México</p>";
        html +="<p>C.P. 91000 RFC. LOGL040504UY7</p>";
        html +="<p style='margin:20px; border-top-color:#000000; border-top-style: dotted; border-top-width: 5px;'>&nbsp;</p>";
        html += "</center>";
        html += "<div style='margin-left:20px'>";
        html +=String.format("<strong>Cliente:</strong> %s<br>", venta.getNombre());
        html +=String.format("<p><b>Domicilio:</b> %s, <b>Colonia:</b> %s</p>", venta.getDomicilio(), venta.getColonia());
        html +=String.format("<p><b>Ciudad:</b> %s, <b>Estado:</b> %s</p>", venta.getCiudad(), venta.getEstado());
        html +=String.format("<p><b>Correo electrónico:</b> %s, <b>Teléfono:</b> %s</p>", venta.getCorreoElectronico(), venta.getTelefono());
        html += "</div>";

        html += "</html>";
        return html;
    }
}
