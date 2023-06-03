package ui.frames;

import Modelo.Ventas;

import javax.swing.*;
import java.awt.*;

public class TicketFrame extends JFrame {
    private Ventas venta;
    JLabel etiTicket = new JLabel("");
    public TicketFrame(Ventas venta) {
        this.venta = venta;
        initComponents();
    }

    private void initComponents() {
        String html = "<html>";
        html += "<html>";
        etiTicket = new JLabel(html);
        setSize(new Dimension(300, 700));
    }
}
