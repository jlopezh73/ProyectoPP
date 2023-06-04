package ui.frames;

import Modelo.Producto;
import Modelo.Productos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InventarioFrame extends JFrame {
    private JComboBox departamentos;
    private JPanel panel1;
    private Font tipoTitulo1 = new Font("Arial", Font.BOLD,40);
    private Font tipoTitulo2 = new Font("Arial", Font.BOLD,18);
    private Font tipoTitulo21 = new Font("Arial", Font.PLAIN,18);
    private Font tipoTitulo3 = new Font("Arial", Font.PLAIN,16);
    private JComboBox apartados;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JTable tabla;
    public InventarioFrame(){
        setSize(900,500);
        setLayout(new FlowLayout());
        setTitle("Reporte de inventario");

        etiqueta1=new JLabel("Departamento:");
        etiqueta1.setPreferredSize(new Dimension(150,30));
        etiqueta1.setFont(tipoTitulo2);
        add(etiqueta1);

        departamentos = new JComboBox();
        departamentos.setFont(tipoTitulo21);
        departamentos.setPreferredSize(new Dimension(150,30));
        departamentos.addActionListener(evt -> {
            String apartamntos[][]={
                    {"Escritura","Artes","Papeles","Regalos"},
                    {"Shampoo y jabones","desodorantes y perfumes","Cremas y faciales","Tintes y cabello"},
                    {"Chocolates","Dulces","Dulces salados","Bebidas"}
            };
            apartados.removeAllItems();
            String []arr = apartamntos[departamentos.getSelectedIndex()];
            for (String ap: arr) {
                apartados.addItem(ap);
            }
        });

        apartados = new JComboBox();
        apartados.setFont(tipoTitulo21);
        apartados.setPreferredSize(new Dimension(150,30));
        departamentos.addItem("Papeleria");
        departamentos.addItem("Salud y belleza");
        departamentos.addItem("Dulces y bebidas");

        add(departamentos);

        etiqueta2=new JLabel("Apartado");
        etiqueta2.setPreferredSize(new Dimension(150,30));
        etiqueta2.setFont(tipoTitulo2);
        add(etiqueta2);
        add(apartados);

        panel1=new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setPreferredSize(new Dimension(850,500));
        panel1.setBackground(Color.white);
        add(panel1);

        int depa=departamentos.getSelectedIndex();
        int apa=apartados.getSelectedIndex();
        depa++;
        apa++;
        String d=depa+"";
        String a=apa+"";
        Productos b=new Productos();
        ArrayList<Producto> lista=b.Aparta(d,a);

        String cads[]={"ID", "Nombre","Piezas","Precio"};
        Object filas[][]=new String[lista.size()][4];
        int i=0;
        for(Producto l:lista){
            filas[i][0]=l.getID();
            filas[i][1]=l.getNombre();
            String aux=l.getPiezas()+"";
            filas[i][2]=aux;
            aux=l.getPrecio()+"";
            filas[i][3]=aux;
            i++;
        }
        tabla=new JTable(filas,cads);
        tabla.setBackground(Color.white);
        tabla.getColumnModel().getColumn(0).setMaxWidth(200);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
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
        panel1.setBackground(Color.white);
        panel1.add(new JScrollPane(tabla),BorderLayout.CENTER);

        apartados.addActionListener(evt->{
            int auxi1,auxi2;
            auxi1=departamentos.getSelectedIndex();
            auxi1++;
            auxi2=apartados.getSelectedIndex();
            auxi2++;
            String x,y;
            x=auxi1+"";
            y=auxi2+"";
            construyeTabla(x,y);
        });

    }
    public void construyeTabla(String x,String y){
        Productos p=new Productos();
        ArrayList <Producto> lista=p.Aparta(x,y);
        String cads[]={"ID", "Nombre","Piezas","Precio"};
        Object filas[][]=new String[lista.size()][4];
        int i=0;
        for(Producto l:lista){
            filas[i][0]=l.getID();
            filas[i][1]=l.getNombre();
            String aux=l.getPiezas()+"";
            filas[i][2]=aux;
            aux=l.getPrecio()+"";
            filas[i][3]=aux;
            i++;
        }
        panel1.removeAll();
        tabla=new JTable(filas,cads);
        tabla.setBackground(Color.white);
        tabla.getColumnModel().getColumn(0).setMaxWidth(200);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
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
        tabla.setBackground(Color.white);
        panel1.setBackground(Color.white);
        panel1.add(new JScrollPane(tabla),BorderLayout.CENTER);
        panel1.updateUI();
    }
}
