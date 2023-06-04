package ui.panels;

import Modelo.Producto;
import Modelo.ProductoCarrito;
import Modelo.Productos;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class AdjustPanel extends JPanel {
    private JTabbedPane tabs;
    private JPanel productsPanel;
    private JPanel usersPanel;
    private Color colorAmarillo = new Color(255,212,1);
    private Font tipoTitulo1 = new Font("Arial", Font.BOLD,40);
    private Font tipoTitulo2 = new Font("Arial", Font.BOLD,18);
    private Font tipoTitulo3 = new Font("Arial", Font.PLAIN,16);
    private JTable tableProducts;
    private JTable tableUsers;
    private JButton saveProducts;
    private JButton saveUsers;
    private JPanel buttonsPanel1;
    private Productos prods ;
    private List<Producto> listaProds;

    public AdjustPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        createProductsPanel();
        createUsersPanel();
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));


        tabs = new JTabbedPane();

        tabs.addTab("", productsPanel);
        tabs.addTab("", usersPanel);
        tabs.setBackground(Color.white);
        tabs.setBorder(null);
        JLabel label1 = new JLabel("Edición de Productos");
        label1.setFont(tipoTitulo2);
        label1.setPreferredSize(new Dimension(200,30));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label2 = new JLabel("Edición de Usuarios");
        label2.setFont(tipoTitulo2);
        label2.setPreferredSize(new Dimension(200,30));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        tabs.setTabComponentAt(0, label1);
        tabs.setTabComponentAt(1, label2);
        


        add(tabs, BorderLayout.CENTER);
    }

    private void createProductsPanel() {
        String[] columnNames = {"ID",
                "Nombre",
                "Departamento",
                "Apartamento",
                "Precio", "Existencias"};

        prods = new Productos();
        listaProds = (List<Producto>) prods.todosProductos();


        Object[][] data = new Object[listaProds.size()][6];
        int c = 0;
        for(Producto prod : listaProds) {
            data[c][0] = prod.getID();
            data[c][1] = prod.getNombre();
            data[c][2] = prod.getDepa();
            data[c][3] = prod.getApa();
            data[c][4] = prod.getPrecio();
            data[c][5] = prod.getPiezas();
            c++;
        }

        productsPanel = new JPanel();
        productsPanel.setBackground(Color.white);
        productsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        productsPanel.setPreferredSize(new Dimension(1000,500));
        productsPanel.setLayout(new BorderLayout());

        tableProducts = new JTable(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        tableProducts.getColumnModel().getColumn(0).setMaxWidth(50);
        tableProducts.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableProducts.getColumnModel().getColumn(2).setPreferredWidth(100);
        tableProducts.getColumnModel().getColumn(3).setPreferredWidth(100);
        tableProducts.setBorder(BorderFactory.createEtchedBorder());
        tableProducts.setFont(tipoTitulo3);
        tableProducts.setRowHeight(30);
        tableProducts.setRowSelectionAllowed(true);
        tableProducts.getTableHeader().setFont(tipoTitulo2);
        tableProducts.getTableHeader().setBackground(Color.black);
        tableProducts.getTableHeader().setForeground(Color.white);
        tableProducts.setEditingColumn(0);
        tableProducts.setCellEditor(null);
        tableProducts.setEditingColumn(2);


        productsPanel.add(tableProducts.getTableHeader(), BorderLayout.PAGE_START);
        productsPanel.add(new JScrollPane(tableProducts), BorderLayout.CENTER);

        JButton edit = new JButton("Modificar Producto");
        edit.setBackground(Color.blue);
        edit.setForeground(Color.white);
        edit.setOpaque(true);
        edit.setBorderPainted(false);
        edit.setPreferredSize(new Dimension(200, 30));

        JButton delete = new JButton("Eliminar Producto");
        delete.setBackground(Color.red);
        delete.setForeground(Color.white);
        delete.setOpaque(true);
        delete.setBorderPainted(false);
        delete.setPreferredSize(new Dimension(200, 30));

        buttonsPanel1 = new JPanel();
        buttonsPanel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        buttonsPanel1.setLayout(new FlowLayout());
        buttonsPanel1.add(edit);
        buttonsPanel1.add(delete);

        productsPanel.add(buttonsPanel1, BorderLayout.SOUTH);
    }

    private void createUsersPanel() {
        String[] columnNames = {"Usuario",
                "Nombre Completo",
                "Contraseña"};

        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };

        usersPanel = new JPanel();
        usersPanel.setBackground(Color.white);
        usersPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        usersPanel.setPreferredSize(new Dimension(1000,500));
        usersPanel.setLayout(new BorderLayout());

        tableUsers = new JTable(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        tableUsers.setBorder(BorderFactory.createEtchedBorder());
        tableUsers.setFont(tipoTitulo3);
        tableUsers.setRowHeight(30);
        tableUsers.setRowSelectionAllowed(true);
        tableUsers.getTableHeader().setFont(tipoTitulo2);
        tableUsers.getTableHeader().setBackground(Color.black);
        tableUsers.getTableHeader().setForeground(Color.white);
        tableUsers.setEditingColumn(0);
        tableUsers.setCellEditor(null);
        tableUsers.setEditingColumn(2);

        usersPanel.add(tableUsers.getTableHeader(), BorderLayout.PAGE_START);
        usersPanel.add(tableUsers, BorderLayout.CENTER);
    }
}
