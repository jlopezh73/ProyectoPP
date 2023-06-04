import Modelo.*;
import ui.frames.LoginFrame;
import ui.frames.PrincipalFrame;
import ui.frames.TicketFrame;
import ui.frames.VentaFrame;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {

        }

        PrincipalFrame pf = new PrincipalFrame(new Usuario("","","Juan Luis López Herrera",""));
        pf.show();
        //LoginFrame loginFrame = new LoginFrame();
        //loginFrame.setVisible(true);
        /*Productos productos = new Productos();
        List<ProductoCarrito> prods = new ArrayList<ProductoCarrito>();
        prods.add(new ProductoCarrito(new Producto("1","Cartulina",0,10.0,"",""), 3));
        prods.add(new ProductoCarrito(new Producto("1","Crayones",0,20.0,"",""), 3));
        prods.add(new ProductoCarrito(new Producto("1","Plumones",0,32.50,"",""), 3));
        prods.add(new ProductoCarrito(new Producto("1","Chocolate Carlos V",0,12.0,"",""), 3));
        prods.add(new ProductoCarrito(new Producto("1","Desodorante AXE Mosquito",0,75.30,"",""), 3));
        Venta venta = new Venta(1,"Juan Luis López Herrera",
                "Insurgentes No. 157 Int", "Centro", "91000", "Xalapa", "Veracruz",
                "jlopezh73@gmail.com", "2282693068", LocalDateTime.now(), prods);
        TicketFrame ticket = new TicketFrame(venta);
        ticket.show();*/
    }
}