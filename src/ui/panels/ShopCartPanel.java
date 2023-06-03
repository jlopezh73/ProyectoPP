package ui.panels;

import Modelo.Producto;
import Modelo.ProductoCarrito;
import Modelo.Productos;
import Modelo.Venta;
import ui.frames.PrincipalFrame;
import ui.frames.VentaFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShopCartPanel extends JPanel {
    private JLabel title;
    private JLabel etiqueta;
    private JButton pagar;
    VentaFrame vf;
    private ArrayList<ProductoCarrito> lista;
    private JScrollPane scroll;
    private JPanel productos;
    private Font tipoTitulo1=new Font("Arial",Font.BOLD,18);
    public ShopCartPanel(PrincipalFrame pf) {
        initComponentes(pf);
    }

    private void initComponentes(PrincipalFrame pf) {
        setLayout(new FlowLayout());
        lista=new ArrayList<>();
        this.setPreferredSize(new Dimension(250,600));
        title = new JLabel("<html><h1>Carrito de Compras</h1></html>");
        add(title);

        etiqueta=new JLabel();
        etiqueta.setPreferredSize(new Dimension(200,25));
        etiqueta.setFont(tipoTitulo1);
        double total=0;
        for(ProductoCarrito r:lista){
            Producto v=r.getProductoOriginal();
            total+=v.getPrecio()*r.getCantidadCompra();
        }
        String ra="Total a pagar:$"+total;
        etiqueta.setText(ra);
        add(etiqueta);

        pagar=new JButton("Pagar");
        pagar.setBackground(Color.orange);
        pagar.setPreferredSize(new Dimension(100,25));
        pagar.setFont(tipoTitulo1);
        add(pagar);

        productos=new JPanel();
        productos.setBackground(Color.white);
        scroll=new JScrollPane(productos);
        scroll.setBorder(null);
        scroll.setPreferredSize(new Dimension(280,700));
        scroll.setBackground(Color.WHITE);
        add(scroll);

        pagar.addActionListener(evt->{
            vf=new VentaFrame(lista,pf);
            vf.setVisible(true);
        });


    }
    public void eliminaProducto(ProductoCarrito b,PrincipalFrame pf){
        lista.remove(b);
        productos.removeAll();
        for(ProductoCarrito n:lista){
            ShoppingCartProductPanel m=new ShoppingCartProductPanel(n,pf);
            productos.add(m);
        }
        double total=0;
        for(ProductoCarrito r:lista){
            Producto v=r.getProductoOriginal();
            total+=v.getPrecio()*r.getCantidadCompra();
        }
        String ra="Total a pagar:$"+total;
        etiqueta.setText(ra);
        if(lista.isEmpty()){
            pf.hideShoppingCart();
        }
        productos.updateUI();
    }
    public void agregarProducto(Producto l,PrincipalFrame pf){
        boolean bandera=false;
        ProductoCarrito g=new ProductoCarrito(l,1);
        for(ProductoCarrito aux:lista){
            Producto vs=aux.getProductoOriginal();
            if(vs.getNombre().equals(l.getNombre())){
                bandera=true;
            }
        }
        if(bandera==false) {
            ProductoCarrito vs1=new ProductoCarrito(l,1);
            lista.add(vs1);
        }
        else{
            ProductoCarrito v= new ProductoCarrito(l,1);
            ArrayList<ProductoCarrito> auxl=new ArrayList<>();
            for(ProductoCarrito auxiliar:lista){
                Producto vsa=auxiliar.getProductoOriginal();
                if(vsa.getNombre().equals(l.getNombre())){
                    int cant=auxiliar.getCantidadCompra()+1;
                    Productos help=new Productos();
                    if(help.cantidad(vsa,cant))
                    auxiliar.setCantidadCompra(cant);

                }

                auxl.add(auxiliar);

            }
            lista.clear();
            for(ProductoCarrito auxi:auxl){
                lista.add(auxi);
            }


        }
        productos.removeAll();
        productos.setPreferredSize(new Dimension(280, lista.size()*150));
        for(ProductoCarrito n:lista){
            ShoppingCartProductPanel m=new ShoppingCartProductPanel(n,pf);
            productos.add(m);
        }
        double total=0;
        for(ProductoCarrito r:lista){
            Producto p=r.getProductoOriginal();
            total+=p.getPrecio()*r.getCantidadCompra();
        }
        String ra="Total a pagar:$"+total;
        etiqueta.setText(ra);
        productos.updateUI();
    }
    public void actualizaTotal(){
        double total=0;
        for(ProductoCarrito r:lista){
            Producto p=r.getProductoOriginal();
            total+=p.getPrecio()*r.getCantidadCompra();
        }
        String ra="Total a pagar:$"+total;
        etiqueta.setText(ra);
        this.updateUI();
    }
    public void renueva(){
        lista.clear();
    }
}
