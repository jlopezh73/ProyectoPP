package ui.frames;

import Modelo.Producto;
import Modelo.ProductoCarrito;
import Modelo.Venta;
import Modelo.Ventas;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class reportesFrame extends JFrame {
    private JTable tabla;
    ArrayList<Venta>  ventas;
    private JSpinner fechas;
    private JSpinner hasta;
    LocalDateTime f1;
    LocalDateTime f2;
    public reportesFrame(){
        setSize(800,500);
    Ventas g=new Ventas();
    fechas=new JSpinner(new SpinnerDateModel());
    fechas.setPreferredSize(new Dimension(300,20));
    add(fechas);

        Date f12=(Date) fechas.getValue();

        f1=LocalDateTime.ofInstant(f12.toInstant(), ZoneId.systemDefault());

    hasta=new JSpinner(new SpinnerDateModel());
    hasta.setPreferredSize(new Dimension(300,20));
    add(hasta);
    Date f13=(Date) hasta.getValue();
    f2=LocalDateTime.ofInstant(f13.toInstant(),ZoneId.systemDefault());
        fechas.addChangeListener(evt->{
            Date f123=(Date) fechas.getValue();
            f1=LocalDateTime.ofInstant(f123.toInstant(),ZoneId.systemDefault());
            initComponents(g.encuentraFechas(f1,f2));
        });
        hasta.addChangeListener(evt->{
            Date f132=(Date) hasta.getValue();
            f2=LocalDateTime.ofInstant(f132.toInstant(),ZoneId.systemDefault());
            initComponents(g.encuentraFechas(f1,f2));
        });

        initComponents(g.encuentraFechas(f1,f2));
    }
    public void initComponents(ArrayList<Venta> lista){
        String nombres[]={"Numero de venta","Fecha","Total"};
        Object filas[][]= new Object[lista.size()][3];
        int i=0;
        for(Venta v:lista){
            double total=0;
            for(ProductoCarrito p:v.getProductos()) {
                Producto s=p.getProductoOriginal();
                total +=p.getCantidadCompra()*s.getPrecio();
            }
            String aux=total+"";
            filas[i][0]=v.getNumVenta();
            filas[i][1]=v.getFecha();
            filas[i][2]=aux;
        }
        tabla=new JTable(filas,nombres);
        tabla.setPreferredSize(new Dimension(750,600));
        add(tabla);
    }
}
