package ui.frames;

import Modelo.ProductoCarrito;
import Modelo.Venta;
import Modelo.Ventas;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URL;

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
        etiTicket.setBackground(Color.white);
        etiTicket.setOpaque(true);
        add(etiTicket);
        setSize(new Dimension(400, 800));
    }

    private String generarHTML()  {
        String html = "<html><center>";
        try {
            URI p = getClass().getResource("/logop.png").toURI();
            html += "<table><tr><td>";
            html += String.format("<img width=113 height=150 src='%s'>", p);
            html += "</td><td>";
            html += "<center><h1>Papelería El \"Peque\"</h1>";
            html += "<h3>Le surtimos desde un clip hasta un tinaco</h3>";
            html += "<p>Insurgentes No. 157 Int, Col. Centro</p>";
            html += "<p>Xalapa, Ver. México</p>";
            html += "<p>C.P. 91000 RFC. LOGL040504UY7</p><center>";
            html += "</td></tr></table>";
            html += "<p style='margin-top:20px; margin-left:20px;margin-right:20px; border-top-color:#000000; border-top-style: dotted; border-top-width: 5px;'>&nbsp;</p>";
            html += "</center>";
            html += "<div style='margin-left:20px'>";
            html += String.format("<strong>Cliente:</strong> %s<br>", venta.getNombre());
            html += String.format("<p><b>Domicilio:</b> %s, <b>Colonia:</b> %s</p>", venta.getDomicilio(), venta.getColonia());
            html += String.format("<p><b>Ciudad:</b> %s, <b>Estado:</b> %s</p>", venta.getCiudad(), venta.getEstado());
            html += String.format("<p><b>Correo electrónico:</b> %s</p>", venta.getCorreoElectronico(), venta.getTelefono());
            html += String.format("<p><b>Teléfono:</b> %s</p>",  venta.getTelefono());
            html += "</div>";
            html += "<p style='margin-top:15px; margin-left:20px;margin-right:20px; border-top-color:#000000; border-top-style: dotted; border-top-width: 5px;'>&nbsp;</p>";
            html += "<table border=0 cellspacing=0 cellpadding=5 style='margin-left:20px;'><tr style='border-bottom:3px solid #000;'><td style='width:100px'><center>Producto</td><td style='width:60px'><center>Precio</td><td style='width:60px'><center>Cantidad</td><td style='width:60px'><center>Total</td></tr>";
            double ttotal=0;
            double tsubtotal=0;
            double tiva=0;
            for(ProductoCarrito prod : venta.getProductos()) {
                String precio = String.format("$ %5.2f", prod.getProductoOriginal().getPrecio());
                String cantidad = String.format("%3d", prod.getCantidadCompra());
                String total = String.format("$ %5.2f", prod.getProductoOriginal().getPrecio()*prod.getCantidadCompra());
                ttotal += prod.getProductoOriginal().getPrecio()*prod.getCantidadCompra();
                html += String.format("<tr style='border-bottom:1px solid #aaa;'><td style='width:100px'><center>%s</td><td style='width:60px'><center>%s</td><td style='width:60px'><center>%s</td><td style='width:60px'><center>%s</td></tr>", prod.getProductoOriginal().getNombre(), precio, cantidad, total);
            }
            tiva = ttotal / 1.16;
            tsubtotal = ttotal - tiva;
            html += "</table><br>";
            html += "<table><tr><td rowspan=3 width='200px'></td>";
            html += String.format("<td><font size=5>Subtotal:</font></td><td style='text-align:right'><font size=5> %6.2f</font>", tsubtotal);
            html += "</tr><tr>";
            html += String.format("<td><font size=5>IVA:</font></td><td style='text-align:right'><font size=5> %6.2f</font>", tiva);
            html += "</tr><tr>";
            html += String.format("<td><font size=6>Total:</font></td><td style='text-align:right'><font size=6> %6.2f</font>", ttotal);
            html += "</tr><tr>";
            html += "</table>";
            html += "<p><center>Agradecemos su confianza y esperamos verlo pronto</p>";
            html += "</html>";
        } catch (Exception e) {

        }
        return html;
    }
}
