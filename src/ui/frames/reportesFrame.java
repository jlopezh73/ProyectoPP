package ui.frames;

import Modelo.Producto;
import Modelo.ProductoCarrito;
import Modelo.Venta;
import Modelo.Ventas;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class reportesFrame extends JFrame {
    private JTable tabla;
    private Font tipoTitulo1 = new Font("Arial", Font.BOLD,40);
    private Font tipoTitulo2 = new Font("Arial", Font.BOLD,18);
    private Font tipoTitulo21 = new Font("Arial", Font.PLAIN,18);
    private Font tipoTitulo3 = new Font("Arial", Font.PLAIN,16);
    ArrayList<Venta>  ventas;
    private JSpinner fechas;
    private JSpinner hasta;
    private JPanel panel1;
    private JTable tablanueva;
    LocalDateTime f1;
    LocalDateTime f2;
    public reportesFrame(){
        setSize(800,500);
        setLayout(new FlowLayout());
        setTitle("Reporte de ventas");
    Ventas g=new Ventas();
    fechas=new JSpinner(new SpinnerDateModel());
    fechas.setFont(tipoTitulo3);
    fechas.setPreferredSize(new Dimension(300,30));
    add(fechas);

        Date f12=(Date) fechas.getValue();

        f1=LocalDateTime.ofInstant(f12.toInstant(), ZoneId.systemDefault());

    hasta=new JSpinner(new SpinnerDateModel());
    hasta.setFont(tipoTitulo3);
    hasta.setPreferredSize(new Dimension(300,30));
    add(hasta);
    Date f13=(Date) hasta.getValue();
    f2=LocalDateTime.ofInstant(f13.toInstant(),ZoneId.systemDefault());
        fechas.addChangeListener(evt->{
            Date f123=(Date) fechas.getValue();
            f1=LocalDateTime.ofInstant(f123.toInstant(),ZoneId.systemDefault());
            construyeTabla(f1,f2);
        });
        hasta.addChangeListener(evt->{
            Date f132=(Date) hasta.getValue();
            f2=LocalDateTime.ofInstant(f132.toInstant(),ZoneId.systemDefault());
            construyeTabla(f1,f2);
        });
        panel1=new JPanel();
        panel1.setPreferredSize(new Dimension(750,500));
        panel1.setLayout(new BorderLayout());
        add(panel1);
        initComponents(g.encuentraFechas(f1,f2));
    }
    public void initComponents(ArrayList<Venta> lista){
        String nombres[]={"Numero de venta","Fecha","Total"};
        Object filas[][]= new Object[lista.size()][3];
        int i=0;
        for(Venta v:lista){
            double total=0;

            String aux=total+"";
            filas[i][0]=v.getNumVenta();
            String fecha=v.getFecha().getDayOfMonth()+" "+v.getFecha().getMonth()+" of "+v.getFecha().getYear();
            filas[i][1]=fecha;
            filas[i][2]=v.getTotal();
        }
        tabla=new JTable(filas,nombres);
        tabla.setBackground(Color.white);
        tabla.getColumnModel().getColumn(0).setMaxWidth(200);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.setBorder(BorderFactory.createEtchedBorder());
        tabla.setFont(tipoTitulo3);
        tabla.setRowHeight(30);
        tabla.setRowSelectionAllowed(true);
        tabla.getTableHeader().setFont(tipoTitulo2);
        tabla.getTableHeader().setBackground(Color.black);
        tabla.getTableHeader().setForeground(Color.white);
        tabla.setEditingColumn(0);
        tabla.setCellEditor(null);
        tabla.setEditingColumn(2);

        tabla.setPreferredSize(new Dimension(750,600));
        panel1.add(new JScrollPane(tabla),BorderLayout.CENTER);
        panel1.updateUI();
    }
    public void construyeTabla(LocalDateTime d1,LocalDateTime d2){
        tablanueva=tabla;
        String nombres[]={"Numero de venta","Fecha","Total"};
        Ventas g=new Ventas();
        ArrayList <Venta> lista=g.encuentraFechas(d1,d2);
        Object filas[][]= new Object[lista.size()][3];
        int i=0;
        for(Venta v:lista){
            filas[i][0]=v.getNumVenta();
            String fecha=v.getFecha().getMonth()+" "+v.getFecha().getDayOfMonth()+", "+v.getFecha().getYear();
            filas[i][1]=fecha;
            filas[i][2]=v.getTotal();
            i++;
        }
        panel1.removeAll();
        panel1.setBackground(Color.white);
        tabla=new JTable(filas,nombres);
        tabla.setBackground(Color.white);
        tabla.getColumnModel().getColumn(0).setMaxWidth(200);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.setBorder(BorderFactory.createEtchedBorder());
        tabla.setFont(tipoTitulo3);
        tabla.setRowHeight(30);
        tabla.setRowSelectionAllowed(true);
        tabla.getTableHeader().setFont(tipoTitulo2);
        tabla.getTableHeader().setBackground(Color.black);
        tabla.getTableHeader().setForeground(Color.white);
        tabla.setEditingColumn(0);
        tabla.setCellEditor(null);
        tabla.setEditingColumn(2);

        panel1.add(new JScrollPane(tabla),BorderLayout.CENTER);
        panel1.updateUI();

    }
}
