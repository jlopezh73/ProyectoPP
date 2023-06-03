package ui.panels;

import Modelo.Producto;
import ui.frames.PrincipalFrame;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class ShoppingProductsPanel extends JPanel {
    private String subDepartment;
    private List<ShoppingProductPanel> products;
    private PrincipalFrame pf;
    public ShoppingProductsPanel(String subDepartment, PrincipalFrame pf) {
        this.subDepartment = subDepartment;
        this.pf = pf;
        initComponents();
    }

    private void initComponents() {
        GridLayout gl = new GridLayout();
        gl.setHgap(20);
        gl.setVgap(20);
        setLayout(gl);
    }

    public void loadProducts(List<Producto> prods) {
        removeAll();;
        products= new ArrayList<ShoppingProductPanel>();
        for (Producto prod : prods) {
            ShoppingProductPanel product = new ShoppingProductPanel(prod, pf);
            products.add(product);
            add(product);
        }
        updateUI();

    }
}
