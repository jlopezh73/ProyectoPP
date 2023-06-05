package ui.panels;

import Modelo.*;
import ui.components.PHTextField;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class AdjustPanel extends JPanel {
    private JTabbedPane tabs;
    private PHTextField cbDepartment2;
    private JPanel productsPanel;
    private PHTextField cbApartment2;
    private PHTextField txtName2;
    private JPanel usersPanel;
    private Color colorAmarillo = new Color(255,212,1);
    private Font tipoTitulo1 = new Font("Arial", Font.BOLD,40);
    private Font tipoTitulo2 = new Font("Arial", Font.BOLD,18);
    private Font tipoTitulo21 = new Font("Arial", Font.PLAIN,18);
    private Font tipoTitulo3 = new Font("Arial", Font.PLAIN,16);
    private JTable tableProducts;
    private JTable tableUsers;
    private JButton saveProducts;
    private JButton saveUsers;
    private JPanel editProductPanel;
    private JPanel buttonsPanel1;
    private JPanel editUserPanel;
    private JPanel buttonsPanel2;
    private Productos prods;
    private List<Producto> listaProds;
    private JTextField txtName;
    private JComboBox cbDepartment;
    private JComboBox cbApartment;
    private JSpinner spPrice;
    private JSpinner spQuantity;

    private JPanel tablePanel1;

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

        tableProducts = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        tableProducts.setModel(new DefaultTableModel(data, columnNames));

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

        tablePanel1 = new JPanel();
        tablePanel1.setLayout(new BorderLayout());
        tablePanel1.add(new JScrollPane(tableProducts), BorderLayout.CENTER);
        productsPanel.add(tablePanel1, BorderLayout.CENTER);

        JButton edit = new JButton("Modificar Producto");
        edit.setBackground(Color.blue);
        edit.setForeground(Color.white);
        edit.setOpaque(true);
        edit.setBorderPainted(false);
        edit.setPreferredSize(new Dimension(200, 30));
        edit.addActionListener(evt -> {
            int i = tableProducts.getSelectedRow();
            if (i >= 0) {
                tableProducts.setEnabled(false);
                Producto prod = listaProds.get(i);
                loadProduct(prod);

                productsPanel.remove(buttonsPanel1);
                buttonsPanel1.updateUI();
                productsPanel.add(editProductPanel, BorderLayout.SOUTH);
                editProductPanel.updateUI();
            }
        });

        JButton delete = new JButton("Eliminar Producto");
        delete.setBackground(Color.red);
        delete.setForeground(Color.white);
        delete.setOpaque(true);
        delete.setBorderPainted(false);
        delete.setPreferredSize(new Dimension(200, 30));
        delete.addActionListener(evt -> {
            int i = tableProducts.getSelectedRow();
            if (i >= 0) {
                Producto prod = listaProds.get(i);
                loadProduct(prod);
                if (JOptionPane.showConfirmDialog(null, "¿Está segur@ de eliminar el producto "+prod.getNombre()+"?", "Advertencia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    var x = (DefaultTableModel)tableProducts.getModel();
                    x.removeRow(i);
                    prods.eliminaProducto(Integer.parseInt(prod.getID()));
                }
            }
        });

        buttonsPanel1 = new JPanel();
        buttonsPanel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        buttonsPanel1.setLayout(new FlowLayout());
        buttonsPanel1.add(edit);
        buttonsPanel1.add(delete);

        editProductPanel = new JPanel();
        editProductPanel.setLayout(new FlowLayout());
        editProductPanel.setBorder(BorderFactory.createTitledBorder("Edición de Producto"));
        editProductPanel.setPreferredSize(new Dimension(1050,170));
        editProductPanel.setBackground(colorAmarillo);

        JLabel lblName = new JLabel("Nombre");
        lblName.setFont(tipoTitulo2);
        lblName.setPreferredSize(new Dimension(130,30));

        JLabel lblDepartment = new JLabel("Departamento");
        lblDepartment.setFont(tipoTitulo2);
        lblDepartment.setPreferredSize(new Dimension(130,30));

        JLabel lblApartment = new JLabel("Apartamento");
        lblApartment.setFont(tipoTitulo2);
        lblApartment.setPreferredSize(new Dimension(130,30));

        JLabel lblQuantity = new JLabel("Existencia");
        lblQuantity.setFont(tipoTitulo2);
        lblQuantity.setPreferredSize(new Dimension(130,30));

        JLabel lblPrice = new JLabel("Precio");
        lblPrice.setFont(tipoTitulo2);
        lblPrice.setPreferredSize(new Dimension(130,30));

        txtName = new PHTextField();
        txtName.setFont(tipoTitulo21);
        txtName.setPreferredSize(new Dimension(850,30));

        cbDepartment = new JComboBox();
        cbDepartment.setFont(tipoTitulo21);
        cbDepartment.setPreferredSize(new Dimension(350,30));
        cbDepartment.addActionListener(evt -> {
            String apartamntos[][]={
                    {"Escritura","Artes","Papeles","Regalos"},
                    {"Shampoo y jabones","desodorantes y perfumes","Cremas y faciales","Tintes y cabello"},
                    {"Chocolates","Dulces","Dulces salados","Bebidas"}
            };
            cbApartment.removeAllItems();
            String []arr = apartamntos[cbDepartment.getSelectedIndex()];
            for (String ap: arr) {
                cbApartment.addItem(ap);
            }
        });

        cbApartment = new JComboBox();
        cbApartment.setFont(tipoTitulo21);
        cbApartment.setPreferredSize(new Dimension(350,30));
        cbDepartment.addItem("Papeleria");
        cbDepartment.addItem("Salud y belleza");
        cbDepartment.addItem("Dulces y bebidas");

        spPrice = new JSpinner();
        spPrice.setFont(tipoTitulo21);
        spPrice.setPreferredSize(new Dimension(350,30));

        spQuantity = new JSpinner();
        spQuantity.setFont(tipoTitulo21);
        spQuantity.setPreferredSize(new Dimension(350,30));

        JButton accept = new JButton("Aceptar");
        accept.setBackground(Color.black);
        accept.setForeground(Color.white);
        accept.setOpaque(true);
        accept.setBorderPainted(false);
        accept.setPreferredSize(new Dimension(200, 30));
        accept.addActionListener(evt-> {
            int row = tableProducts.getSelectedRow();
            tableProducts.getModel().setValueAt(txtName.getText(), row, 1);
            tableProducts.getModel().setValueAt(cbDepartment.getSelectedItem(), row, 2);
            tableProducts.getModel().setValueAt(cbApartment.getSelectedItem(), row, 3);
            tableProducts.getModel().setValueAt(spPrice.getValue(), row, 4);
            tableProducts.getModel().setValueAt(spQuantity.getValue(), row, 5);

            Producto anterior = listaProds.get(row);
            Producto nuevo = new Producto(anterior.getID(),
                    txtName.getText(),
                    (int) spQuantity.getValue(),
                    (double)spPrice.getValue(),
                    String.valueOf(cbDepartment.getSelectedIndex()+1),
                    String.valueOf(cbApartment.getSelectedIndex()+1));

            prods.modificarProducto(anterior, nuevo);

            productsPanel.remove(editProductPanel);
            buttonsPanel1.updateUI();
            productsPanel.add(buttonsPanel1, BorderLayout.SOUTH);
            buttonsPanel1.updateUI();
            tablePanel1.updateUI();
            tableProducts.setEnabled(true);
        });

        JButton cancel = new JButton("Cancelar");
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.white);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setPreferredSize(new Dimension(200, 30));
        cancel.addActionListener(evt-> {
            productsPanel.remove(editProductPanel);
            buttonsPanel1.updateUI();
            productsPanel.add(buttonsPanel1, BorderLayout.SOUTH);
            buttonsPanel1.updateUI();
            tablePanel1.updateUI();
            tableProducts.setEnabled(true);
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(null);
        panel.add(accept);
        panel.add(cancel);

        editProductPanel.add(lblName);
        editProductPanel.add(txtName);
        editProductPanel.add(lblDepartment);
        editProductPanel.add(cbDepartment);
        editProductPanel.add(lblApartment);
        editProductPanel.add(cbApartment);
        editProductPanel.add(lblPrice);
        editProductPanel.add(spPrice);
        editProductPanel.add(lblQuantity);
        editProductPanel.add(spQuantity);
        editProductPanel.add(panel);


        productsPanel.add(buttonsPanel1, BorderLayout.SOUTH);
    }

    private void loadProduct(Producto prod) {
        if (prod != null) {
            txtName.setText(prod.getNombre());
            cbDepartment.setSelectedItem(prod.getDepa());
            cbApartment.setSelectedItem(prod.getApa());
            spPrice.setValue(prod.getPrecio());
            spQuantity.setValue(prod.getPiezas());
        }
    }
    private void loadUsuario(Usuario u){
        if(u!=null){
            txtName2.setText(u.getNombre());
            cbDepartment2.setText(u.getNombreCompleto());
            cbApartment2.setText(u.getContraseña());
        }
    }

    private void createUsersPanel() {
        String[] columnNames = {"Usuario",
                "Nombre Completo",
                "Contraseña"};
        Usuarios usu=new Usuarios();
        ArrayList < Usuario> lista=usu.todosUsuarios();
        Object[][] data=new Object[lista.size()][3];
        int j=0;
        for(Usuario t:lista){
            data[j][0]=t.getNombre();
            data[j][1]=t.getNombreCompleto();
            data[j][2]=t.getContraseña();
            j++;
        }

        usersPanel = new JPanel();
        usersPanel.setBackground(Color.white);
        usersPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        usersPanel.setPreferredSize(new Dimension(1000,500));
        usersPanel.setLayout(new BorderLayout());

        tableUsers = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        tableUsers.setModel(new DefaultTableModel(data, columnNames));
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

        JButton edit2 = new JButton("Modificar usuario");
        edit2.setBackground(Color.blue);
        edit2.setForeground(Color.white);
        edit2.setOpaque(true);
        edit2.setBorderPainted(false);
        edit2.setPreferredSize(new Dimension(200, 30));
        edit2.addActionListener(evt -> {
            int i = tableUsers.getSelectedRow();
            if (i >= 0) {
                tableUsers.setEnabled(false);
                Usuarios d=new Usuarios();
                ArrayList <Usuario> listaUsers=d.todosUsuarios();
                Usuario user=listaUsers.get(i);
                loadUsuario(user);

                usersPanel.remove(buttonsPanel2);
                buttonsPanel2.updateUI();
                usersPanel.add(editUserPanel, BorderLayout.SOUTH);
                editUserPanel.updateUI();
            }
        });

        JButton delete2 = new JButton("Eliminar Usuario");
        delete2.setBackground(Color.red);
        delete2.setForeground(Color.white);
        delete2.setOpaque(true);
        delete2.setBorderPainted(false);
        delete2.setPreferredSize(new Dimension(200, 30));
        delete2.addActionListener(evt -> {
            int i = tableUsers.getSelectedRow();
            if (i >= 0) {
                Usuarios op=new Usuarios();
                ArrayList<Usuario> listar=op.todosUsuarios();
                Usuario user=listar.get(i);
                loadUsuario(user);
                if (JOptionPane.showConfirmDialog(null, "¿Está segur@ de eliminar el usuario "+user.getNombre()+"?", "Advertencia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    var x = (DefaultTableModel)tableUsers.getModel();
                    x.removeRow(i);

                    op.eliminaUsuario(Integer.parseInt(user.getID()));
                }
            }
        });

        buttonsPanel2 = new JPanel();
        buttonsPanel2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        buttonsPanel2.setLayout(new FlowLayout());
        buttonsPanel2.add(edit2);
        buttonsPanel2.add(delete2);

        editUserPanel = new JPanel();
        editUserPanel.setLayout(new FlowLayout());
        editUserPanel.setBorder(BorderFactory.createTitledBorder("Edición de Usuario"));
        editUserPanel.setPreferredSize(new Dimension(1050,170));
        editUserPanel.setBackground(colorAmarillo);

        JLabel lblName2 = new JLabel("Nombre de usuario:");
        lblName2.setFont(tipoTitulo2);
        lblName2.setPreferredSize(new Dimension(130,30));

        JLabel lblDepartment2 = new JLabel("Contraseña:");
        lblDepartment2.setFont(tipoTitulo2);
        lblDepartment2.setPreferredSize(new Dimension(130,30));

        JLabel lblApartment2 = new JLabel("Nombre completo:");
        lblApartment2.setFont(tipoTitulo2);
        lblApartment2.setPreferredSize(new Dimension(130,30));

        txtName2 = new PHTextField();
        txtName2.setFont(tipoTitulo21);
        txtName2.setPreferredSize(new Dimension(850,30));

        cbDepartment2 = new PHTextField();
        cbDepartment2.setFont(tipoTitulo21);
        cbDepartment2.setPreferredSize(new Dimension(350,30));

        cbApartment2 = new PHTextField();
        cbApartment2.setFont(tipoTitulo21);
        cbApartment2.setPreferredSize(new Dimension(350,30));

        JButton accept2 = new JButton("Aceptar");
        accept2.setBackground(Color.black);
        accept2.setForeground(Color.white);
        accept2.setOpaque(true);
        accept2.setBorderPainted(false);
        accept2.setPreferredSize(new Dimension(200, 30));
        accept2.addActionListener(evt-> {
            int row = tableUsers.getSelectedRow();
            tableUsers.getModel().setValueAt(txtName2.getText(), row, 0);
            tableUsers.getModel().setValueAt(cbDepartment2.getText(), row, 1);
            tableUsers.getModel().setValueAt(cbApartment2.getText(), row, 2);

            Usuarios io=new Usuarios();
            ArrayList <Usuario> list=io.todosUsuarios();
            Usuario anterior = list.get(row);
            Usuario nuevo = new Usuario(txtName2.getText(), cbDepartment2.getText(),cbApartment2.getText(),anterior.getID());

            io.modificarusuario(anterior,nuevo);

            usersPanel.remove(editUserPanel);
            buttonsPanel2.updateUI();
            usersPanel.add(buttonsPanel2, BorderLayout.SOUTH);
            buttonsPanel2.updateUI();

            tableUsers.setEnabled(true);
        });

        JButton cancel2 = new JButton("Cancelar");
        cancel2.setForeground(Color.black);
        cancel2.setBackground(Color.white);
        cancel2.setOpaque(true);
        cancel2.setBorderPainted(false);
        cancel2.setPreferredSize(new Dimension(200, 30));
        cancel2.addActionListener(evt-> {
            usersPanel.remove(editUserPanel);
            buttonsPanel2.updateUI();
            usersPanel.add(buttonsPanel2, BorderLayout.SOUTH);
            buttonsPanel2.updateUI();
            usersPanel.setEnabled(true);
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(null);
        panel.add(accept2);
        panel.add(cancel2);

        editUserPanel.add(lblName2);
        editUserPanel.add(txtName2);
        editUserPanel.add(lblDepartment2);
        editUserPanel.add(cbDepartment2);
        editUserPanel.add(lblApartment2);
        editUserPanel.add(cbApartment2);
        editUserPanel.add(panel);

        usersPanel.add(buttonsPanel2, BorderLayout.SOUTH);
    }
}
