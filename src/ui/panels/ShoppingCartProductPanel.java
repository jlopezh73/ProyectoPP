package ui.panels;

import Modelo.Producto;
import Modelo.ProductoCarrito;
import Modelo.Productos;
import ui.frames.PrincipalFrame;

import javax.swing.*;
import java.awt.*;

public class ShoppingCartProductPanel extends JPanel {
    private JLabel nombre;
    private JLabel imagen;
    private JLabel precioUno;
    private JSpinner cantidad;
    private JLabel total;
    private JButton button;
    private Font tipoTitulo3 = new Font("Arial", Font.ITALIC,20);
    private Font tipotitulo2=new Font("Arial",Font.BOLD,22);
    private Font tipoTitulo1 = new Font("Arial",Font.BOLD,25);
    private PrincipalFrame pf;
    public ShoppingCartProductPanel(ProductoCarrito pc, PrincipalFrame pf) {
        this.pf = pf;
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createDashedBorder(Color.darkGray));
        setBackground(Color.white);
        setPreferredSize(new Dimension(270,180));
        Producto j=pc.getProductoOriginal();
        nombre=new JLabel(j.getNombre());
        nombre.setPreferredSize(new Dimension(250,25));
        nombre.setFont(tipoTitulo1);
        nombre.setAlignmentX(CENTER_ALIGNMENT);
        add(nombre);

        ImageIcon imageIcon = new ImageIcon("res/"+"/"+j.getNombre()+".jpg");
        Image image = imageIcon.getImage();
        double ancho = image.getWidth(null);
        double alto = image.getHeight(null);
        Image newimg = image.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH);

        imagen=new JLabel();
        imagen.setIcon(new ImageIcon(newimg));
        nombre.setAlignmentX(CENTER_ALIGNMENT);
        add(imagen);

        String h="$"+j.getPrecio()+"";
        precioUno=new JLabel(h);
        precioUno.setPreferredSize(new Dimension(250,20));
        nombre.setFont(tipoTitulo3);
        nombre.setAlignmentX(CENTER_ALIGNMENT);
        add(precioUno);

        cantidad=new JSpinner();
        cantidad.setValue(pc.getCantidadCompra());
        cantidad.setPreferredSize(new Dimension(250,20));
        cantidad.setFont(tipoTitulo3);
        nombre.setAlignmentX(CENTER_ALIGNMENT);
        add(cantidad);

        total=new JLabel();
        total.setPreferredSize(new Dimension(250,25));
        total.setFont(tipoTitulo1);
        double c=j.getPrecio()*(int)cantidad.getValue();
        String n="Total: $"+c;
        total.setText(n);
        nombre.setAlignmentX(CENTER_ALIGNMENT);
        add(total);

        button=new JButton();
        button.setFont(tipotitulo2);
        button.setPreferredSize(new Dimension(20,20));
        button.setBackground(new Color(200,20,40, 0));
        button.setBorderPainted(false);
        nombre.setAlignmentX(CENTER_ALIGNMENT);

        ImageIcon imageicon = new ImageIcon("res/basura.png");
        Image imagen = imageicon.getImage();

        Image y = imagen.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(y));

        add(button);

        button.addActionListener(evt->{
            pf.elimina(pc);
        });
        cantidad.addChangeListener(evt->{
            int b=(int)cantidad.getValue();
            Productos ayuda=new Productos();
            Producto ayudita=pc.getProductoOriginal();
            if(ayuda.cantidad(ayudita,b)) {
                pc.setCantidadCompra((int) cantidad.getValue());
            }
            else{
                Producto ayudota=ayuda.encuentra(ayudita.getID());
                cantidad.setValue(ayudota.getPiezas());
            }
            if(b<1){
                cantidad.setValue(1);
            }
            b=(int)cantidad.getValue();
            double s=j.getPrecio()*b;
            String e="Total: $"+s;
            pf.actualiza();
            total.setText(e);
        });
    }
}
