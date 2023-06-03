package ui.panels;

import Modelo.Producto;
import ui.frames.PrincipalFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShoppingProductPanel extends JPanel {
    private JButton button;
    private ArrayList<Producto> lista;
    private Font tipoTitulo3 = new Font("Arial", Font.PLAIN,18);
    private PrincipalFrame pf;
    public ShoppingProductPanel(Producto f, PrincipalFrame pf) {
        String price=f.getPrecio()+"";
        String prod=f.getNombre();
        String photoPath="";
        this.pf = pf;
        ImageIcon imageIcon = new ImageIcon("res/"+"fotos/"+f.getID()+".jpg");
        Image image = imageIcon.getImage();
        double ancho = image.getWidth(null);
        double alto = image.getHeight(null);
        Image newimg = image.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        setPreferredSize(new Dimension(200, 300));
        FlowLayout fl = new FlowLayout();
        fl.setVgap(0);
        setLayout(fl);
        price="$"+price;
        button = new JButton(String.format("<html><center><h1>%s</h1><h3>%s</h3></center></html>", prod,price));
        button.setMargin(new Insets(10,10,10,10));
        button.setIcon(new ImageIcon(newimg));
        button.setPreferredSize(new Dimension(200,300));
        button.setBackground(Color.white);
        button.setOpaque(true);
        button.addActionListener(evt -> {
            pf.agregaProducto(f);
        });

        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        add(button);
    }
}
