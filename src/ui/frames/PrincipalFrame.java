package ui.frames;


import Modelo.Producto;
import Modelo.ProductoCarrito;
import Modelo.Productos;
import Modelo.Usuario;
import ui.panels.AdjustPanel;
import ui.panels.ShopCartPanel;
import ui.panels.ShoppingDepartmentPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrincipalFrame extends JFrame {
    public static final int SHOPPING_OP = 1;
    public static final int REPORTS_OP = 2;
    public static final int ADJUSTS_OP = 3;
    private JPanel toolsPanel;
    private final Color coloramarillofuerte= new Color(235,192,0);
    private JPanel shoppingPanel;
    private JLabel bienvenido;
    private JPanel reportsPanel;
    private JPanel ajustsPanel;
    private ShopCartPanel shopCartPanel;
    private JLabel logo;
    private JButton bShopping;
    private JButton bReports;
    private JButton bAdjusts;
    private JButton bExit;
    private JTabbedPane departmentTabs;
    private int selectedOp=SHOPPING_OP;

    private JButton salesReportButton;
    private JButton inventoryReportButton;
    private reportesFrame rf;
    private Color colorAmarillo = new Color(255,212,1);
    private Font tipoTitulo1 = new Font("Arial", Font.BOLD,40);
    private Font tipoTitulo2 = new Font("Arial", Font.BOLD,18);
    private Font tipoTitulo3 = new Font("Arial", Font.PLAIN,16);

    public PrincipalFrame(Usuario c) {
        initComponents(c);
    }

    private void initComponents(Usuario c) {
        this.setSize(1224, 768);
        this.setLayout(new BorderLayout());
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        createToolsPanel();
        createShoppingPanel();
        createShoppingCart();
        createReportsPanel();
        createAdjustsPanel();

        bienvenido=new JLabel("Bienvenido "+c.getNombreCompleto());
        bienvenido.setFont(tipoTitulo2);
        bienvenido.setPreferredSize(new Dimension(800,40));
        bienvenido.setAlignmentX(Component.RIGHT_ALIGNMENT);
        bienvenido.setOpaque(true);
        bienvenido.setBackground(coloramarillofuerte);
        add(bienvenido,BorderLayout.NORTH);

        add(toolsPanel, BorderLayout.WEST);
        add(shoppingPanel, BorderLayout.CENTER);
    }

    private void createAdjustsPanel() {
        ajustsPanel = new AdjustPanel();
    }

    private void createReportsPanel() {
        reportsPanel = new JPanel();
        reportsPanel.setLayout(null);
        reportsPanel.setMaximumSize(new Dimension(300,300));
        salesReportButton = new JButton("Reporte de Ventas");
        salesReportButton.setBounds(200,200,250,250);
        salesReportButton.setBackground(colorAmarillo);
        salesReportButton.setOpaque(true);
        salesReportButton.setIcon(new ImageIcon("res/reporte2.png"));
        salesReportButton.setFont(tipoTitulo2);
        salesReportButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        salesReportButton.setHorizontalTextPosition(SwingConstants.CENTER);
        salesReportButton.setBorderPainted(false);
        salesReportButton.addActionListener(evt ->  {
            rf=new reportesFrame();
            rf.setVisible(true);
        });

        inventoryReportButton = new JButton("Reporte de Inventarios");
        inventoryReportButton.setBounds(600,200,250,250);
        inventoryReportButton.setBackground(colorAmarillo);
        inventoryReportButton.setOpaque(true);
        inventoryReportButton.setIcon(new ImageIcon("res/reporte2.png"));
        inventoryReportButton.setFont(tipoTitulo2);
        inventoryReportButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        inventoryReportButton.setHorizontalTextPosition(SwingConstants.CENTER);
        inventoryReportButton.setBorderPainted(false);
        inventoryReportButton.addActionListener(evt ->  {

        });

        reportsPanel.add(salesReportButton);
        reportsPanel.add(inventoryReportButton);
    }

    private void createShoppingCart() {
        shopCartPanel = new ShopCartPanel(this);
        shopCartPanel.setPreferredSize(new Dimension(300,0));
        shopCartPanel.setBackground(Color.white);
    }

    public void showShoppingCart() {
        remove(shoppingPanel);
        departmentTabs.setPreferredSize(new Dimension(750,768));
        shoppingPanel.setPreferredSize(new Dimension(750,0));
        add(shoppingPanel, BorderLayout.CENTER);
        add(shopCartPanel, BorderLayout.EAST);

        shoppingPanel.updateUI();
        shopCartPanel.updateUI();
    }
    public void agregaProducto(Producto o){
        showShoppingCart();
        shopCartPanel.agregarProducto(o,this);
    }

    public void hideShoppingCart() {
        remove(shopCartPanel);
        departmentTabs.setPreferredSize(new Dimension(1050,768));
        shoppingPanel.setPreferredSize(new Dimension(1050,0));
        shoppingPanel.updateUI();
        shopCartPanel.updateUI();
    }
    public void actualiza(){
        shopCartPanel.actualizaTotal();
    }
    public void elimina(ProductoCarrito v){
        shopCartPanel.eliminaProducto(v,this);
    }

    private void createShoppingPanel() {
        String []stationarySubs = new String[] {"Escritura","Artes","Papeles","Regalos"};
        String []healthSubs = new String[] {"Jabones y Shampoos","Desodorantes y Perfumes","Cremas y Faciales","Tintes y Cabello"};
        String []candyShopSubs = new String[] {"Chocolates","Dulces Salados","Dulces","Bebidas"};
        JPanel stationaryPanel = new ShoppingDepartmentPanel(1, this, stationarySubs);
        JPanel healthPanel = new ShoppingDepartmentPanel(2, this, healthSubs);
        JPanel candyShopPanel = new ShoppingDepartmentPanel(3, this, candyShopSubs);

        shoppingPanel = new JPanel();
        shoppingPanel.setBackground(new Color(230, 230, 230));
        UIManager.put("TabbedPane.selected", colorAmarillo);
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));

        departmentTabs = new JTabbedPane();
        JLabel label1 = new JLabel("Papelería");
        label1.setFont(tipoTitulo2);
        label1.setPreferredSize(new Dimension(200,30));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label2 = new JLabel("Salud y belleza");
        label2.setFont(tipoTitulo2);
        label2.setPreferredSize(new Dimension(200,30));
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label3 = new JLabel("Dulceria");
        label3.setFont(tipoTitulo2);
        label3.setPreferredSize(new Dimension(200,30));
        label3.setHorizontalAlignment(SwingConstants.CENTER);

        JTabbedPane tabbedPane = new JTabbedPane();

        departmentTabs.addTab("", stationaryPanel);
        departmentTabs.addTab("", healthPanel);
        departmentTabs.addTab("", candyShopPanel);
        departmentTabs.setBackground(Color.white);
        departmentTabs.setFont(tipoTitulo3);
        departmentTabs.setBorder(null);
        departmentTabs.setTabComponentAt(0, label1);
        departmentTabs.setTabComponentAt(1, label2);
        departmentTabs.setTabComponentAt(2, label3);

        shoppingPanel.add(departmentTabs);
        departmentTabs.setPreferredSize(new Dimension(1050,768));
        shoppingPanel.setPreferredSize(new Dimension(1050,0));
        shoppingPanel.setMinimumSize(new Dimension(1050,0));
    }

    private void createToolsPanel() {
        toolsPanel = new JPanel();
        toolsPanel.setPreferredSize(new Dimension(100,0));
        toolsPanel.setMinimumSize(new Dimension(100,0));
        toolsPanel.setBackground(colorAmarillo);

        logo = new JLabel();
        logo.setIcon(new ImageIcon("res/logo2.png"));
        logo.setPreferredSize(new Dimension(100, 100));
        logo.setFont(tipoTitulo1);
        toolsPanel.add(logo);


        JPanel empty = new JPanel();
        empty.setBackground(null);
        empty.setPreferredSize(new Dimension(100,150));
        toolsPanel.add(empty);

        bShopping = new JButton();
        bShopping.setIcon(new ImageIcon("res/carrito_p.png"));
        bShopping.setBorder(null);
        bShopping.setToolTipText("Selección y compra de productos");

        bShopping.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cleanButtons();
                bShopping.setIcon(new ImageIcon("res/carrito_p.png"));
                bShopping.setBorder(null);
                selectedOp = SHOPPING_OP;
                PrincipalFrame.this.remove(PrincipalFrame.this.reportsPanel);
                PrincipalFrame.this.remove(PrincipalFrame.this.ajustsPanel);
                PrincipalFrame.this.add(PrincipalFrame.this.shoppingPanel);
                PrincipalFrame.this.reportsPanel.updateUI();
                PrincipalFrame.this.ajustsPanel.updateUI();
                PrincipalFrame.this.shoppingPanel.updateUI();
            }


            @Override
            public void mouseEntered(MouseEvent e) {
                bShopping.setIcon(new ImageIcon("res/carrito_p.png"));
                bShopping.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selectedOp != SHOPPING_OP) {
                    bShopping.setIcon(new ImageIcon("res/carrito.png"));
                    bShopping.setBorder(null);
                }
            }
        });
        toolsPanel.add(bShopping);


        JPanel empty1 = new JPanel();
        empty1.setBackground(null);
        empty1.setPreferredSize(new Dimension(100,20));
        toolsPanel.add(empty1);

        bReports = new JButton();
        bReports.setIcon(new ImageIcon("res/reporte.png"));
        bReports.setBackground(colorAmarillo);
        bReports.setBorderPainted(false);
        bReports.setOpaque(true);
        bReports.setBorder(null);
        bReports.setToolTipText("Generación de reportes");
        bReports.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cleanButtons();
                bReports.setIcon(new ImageIcon("res/reporte_p.png"));
                bReports.setBorder(null);
                selectedOp = REPORTS_OP;
                PrincipalFrame.this.remove(PrincipalFrame.this.shoppingPanel);
                PrincipalFrame.this.remove(PrincipalFrame.this.ajustsPanel);
                PrincipalFrame.this.add(PrincipalFrame.this.reportsPanel);
                PrincipalFrame.this.reportsPanel.updateUI();
                PrincipalFrame.this.ajustsPanel.updateUI();
                PrincipalFrame.this.shoppingPanel.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bReports.setIcon(new ImageIcon("res/reporte_p.png"));
                bReports.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selectedOp != REPORTS_OP) {
                    bReports.setIcon(new ImageIcon("res/reporte.png"));
                    bReports.setBorder(null);
                }
            }
        });
        toolsPanel.add(bReports);

        JPanel empty2 = new JPanel();
        empty2.setBackground(null);
        empty2.setPreferredSize(new Dimension(100,20));
        toolsPanel.add(empty2);


        bAdjusts = new JButton();
        bAdjusts.setIcon(new ImageIcon("res/ajuste.png"));
        bAdjusts.setBackground(colorAmarillo);
        bAdjusts.setBorderPainted(false);
        bAdjusts.setOpaque(true);
        bAdjusts.setBorder(null);
        bAdjusts.setToolTipText("Edición y modificación de productos y usuarios");
        bAdjusts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cleanButtons();
                bAdjusts.setIcon(new ImageIcon("res/ajuste_p.png"));
                bAdjusts.setBorder(null);
                selectedOp = ADJUSTS_OP;
                PrincipalFrame.this.remove(PrincipalFrame.this.shoppingPanel);
                PrincipalFrame.this.remove(PrincipalFrame.this.reportsPanel);
                PrincipalFrame.this.add(PrincipalFrame.this.ajustsPanel);
                PrincipalFrame.this.reportsPanel.updateUI();
                PrincipalFrame.this.ajustsPanel.updateUI();
                PrincipalFrame.this.shoppingPanel.updateUI();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bAdjusts.setIcon(new ImageIcon("res/ajuste_p.png"));
                bAdjusts.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selectedOp != ADJUSTS_OP) {
                    bAdjusts.setIcon(new ImageIcon("res/ajuste.png"));
                    bAdjusts.setBorder(null);
                }
            }
        });
        toolsPanel.add(bAdjusts);

        JPanel empty3 = new JPanel();
        empty3.setBackground(null);
        empty3.setPreferredSize(new Dimension(100,130));
        toolsPanel.add(empty3);

        bExit = new JButton();
        bExit.setIcon(new ImageIcon("res/salir.png"));
        bExit.setBackground(colorAmarillo);
        bExit.setBorderPainted(false);
        bExit.setOpaque(true);
        bExit.setBorder(null);
        bExit.setToolTipText("Salir de la aplicación");
        bExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cleanButtons();
                bExit.setIcon(new ImageIcon("res/salir_p.png"));
                bExit.setBorder(null);
                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de querer salir del sistema", "Advertencia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bExit.setIcon(new ImageIcon("res/salir_p.png"));
                bExit.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selectedOp != ADJUSTS_OP) {
                    bExit.setIcon(new ImageIcon("res/salir.png"));
                    bExit.setBorder(null);
                }
            }
        });
        toolsPanel.add(bExit);
    }

    private void cleanButtons() {
        bShopping.setIcon(new ImageIcon("res/carrito.png"));
        bShopping.setBorder(null);
        bReports.setIcon(new ImageIcon("res/reporte.png"));
        bReports.setBorder(null);
        bAdjusts.setIcon(new ImageIcon("res/ajuste.png"));
        bAdjusts.setBorder(null);
    }
    public void pagado(){
        hideShoppingCart();
        shopCartPanel.renueva();
    }
}
