import Modelo.ProductoCarrito;
import Modelo.Productos;
import Modelo.Venta;
import ui.frames.LoginFrame;
import ui.frames.VentaFrame;

import javax.swing.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {

        }
        //LoginFrame loginFrame = new LoginFrame();
        //loginFrame.setVisible(true);
        VentaFrame vf = new VentaFrame(new ArrayList<ProductoCarrito>(), null);
        vf.show();
    }
}