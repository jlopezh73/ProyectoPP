package ui.panels;

import Modelo.Producto;
import Modelo.Productos;
import ui.frames.PrincipalFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingDepartmentPanel extends JPanel {
    private int i;
    private int department;
    private String[] subDepartaments;
    private JPanel subDepartmentsToolBar;
    private Color colorAmarillo2 = new Color(250,250, 240);
    Font tipoTitulo3 = new Font("Arial", Font.BOLD,14);
    private String subDepartmentSelected;
    private List<JButton>buttons = new ArrayList<JButton>();
    private ShoppingProductsPanel productsPanel;
    private PrincipalFrame pf;
    public ShoppingDepartmentPanel(int department, PrincipalFrame pf, String []subDepartaments) {
        this.department = department;
        this.pf = pf;
        this.subDepartaments = subDepartaments;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        subDepartmentsToolBar = new JPanel();
        subDepartmentsToolBar.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(subDepartmentsToolBar, BorderLayout.NORTH);
        i=1;
        for(String subDepartment : subDepartaments) {
            Integer ii = i;
            JButton bSubDepartment = new JButton(subDepartment);
            bSubDepartment.setPreferredSize(new Dimension(200, 40));
            bSubDepartment.setMargin(new Insets(20,20,20,20));
            bSubDepartment.setAlignmentX(Component.RIGHT_ALIGNMENT);
            bSubDepartment.setBackground(colorAmarillo2);
            bSubDepartment.setOpaque(true);
            bSubDepartment.setBorderPainted(false);
            bSubDepartment.setFont(tipoTitulo3);
            bSubDepartment.addActionListener(evt -> {
                cleanButtons();
                selectButton(bSubDepartment);
                String x,y;
                x=department+"";
                y=ii+"";
                Productos po=new Productos();
                ArrayList<Producto> lista=po.Aparta(x,y);
                productsPanel.loadProducts(lista);
            });
            buttons.add(bSubDepartment);
            subDepartmentsToolBar.add(bSubDepartment);
            i++;
        }
        selectButton(buttons.get(0));
        Productos c=new Productos();
        String x,y;
        x=department+"";
        y="1";
        List<Producto> products = c.Aparta(x,y);

        productsPanel = new ShoppingProductsPanel("papeleria", pf);
        productsPanel.loadProducts(products);
        add(productsPanel, BorderLayout.CENTER);
    }

    private void cleanButtons() {
        for(JButton button : buttons) {
            button.setBackground(colorAmarillo2);
            button.setBorder(null);
            button.setForeground(Color.black);
        }
    }

    private void selectButton(JButton button) {
        subDepartmentSelected = button.getText();
        button.setBackground(Color.black);
        button.setBorder(null);
        button.setForeground(Color.white);

    }
}
