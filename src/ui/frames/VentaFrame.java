package ui.frames;

import Modelo.*;
import ui.components.PHTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentaFrame extends JFrame {
    private JLabel namelbl;
    private PHTextField nametct;
    private JLabel dresslbl;
    private  PHTextField dresstxt;
    private JLabel estadolbl;
    private JComboBox estadotxt;
    private JLabel ciudadlbl;
    private PHTextField ciudadtxt;
    private JPanel left;
    private JPanel right;
    private JLabel CPlbl;
    private PHTextField CPtxt;
    private JLabel colonialbl;
    private PHTextField coloniatxt;
    private JLabel telefonolbl;
    private PHTextField telefonotxt;
    private JLabel correolbl;
    private PHTextField correotxt;
    private JButton pagar;
    private  JButton cancelar;
    private Font tipoLetra=new Font("Arial",Font.BOLD,20);
    private Font tipoLetra2=new Font("Arial",Font.PLAIN,15);
    private Color colorGrisClaro = new Color(235,235, 235);
    public VentaFrame(ArrayList<ProductoCarrito> lista,PrincipalFrame pf){
        initComponents(lista,pf);
    }
    public void initComponents(ArrayList<ProductoCarrito> lista,PrincipalFrame pf){

        GridBagLayout grid=new GridBagLayout();
        GridBagConstraints bc;
        setLayout(grid);
        setTitle("Datos de Venta");

        setSize(850,500);
        setResizable(false);
        ///setUndecorated(true);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.white);


        bc = new GridBagConstraints();
        bc.gridx = 0;
        bc.gridy = 0;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 1.0;

        namelbl=new JLabel("Nombre: ");
        namelbl.setFont(tipoLetra);
        namelbl.setHorizontalAlignment(SwingConstants.RIGHT);
        namelbl.setPreferredSize(new Dimension(150,30));
        add(namelbl, bc);

        bc = new GridBagConstraints();
        bc.gridx = 1;
        bc.gridy = 0;
        bc.gridwidth = 5;
        bc.gridheight = 1;
        bc.weightx = 5.0;
        bc.insets = new Insets(10,10,10,10);
        bc.fill = GridBagConstraints.HORIZONTAL;

        nametct=new PHTextField();
        nametct.setPlaceholder("Nombre completo");
        nametct.setPreferredSize(new Dimension(200,30));
        nametct.setFont(tipoLetra2);
        nametct.setBackground(colorGrisClaro);
        add(nametct, bc);


        bc = new GridBagConstraints();
        bc.gridx = 0;
        bc.gridy = 1;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 1;

        dresslbl=new JLabel("Domicilio: ");
        dresslbl.setHorizontalAlignment(SwingConstants.RIGHT);
        dresslbl.setPreferredSize(new Dimension(150,30));
        dresslbl.setFont(tipoLetra);
        add(dresslbl, bc);

        bc = new GridBagConstraints();
        bc.gridx = 1;
        bc.gridy = 1;
        bc.gridwidth = 5;
        bc.gridheight = 1;
        bc.weightx = 5.0;
        bc.insets = new Insets(10,10,10,10);
        bc.fill = GridBagConstraints.HORIZONTAL;

        dresstxt=new PHTextField();
        dresstxt.setPlaceholder("Domicilio");
        dresstxt.setPreferredSize(new Dimension(200,30));
        dresstxt.setFont(tipoLetra2);
        dresstxt.setBackground(colorGrisClaro);
        add(dresstxt, bc);

        bc = new GridBagConstraints();
        bc.gridx = 0;
        bc.gridy = 2;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 1.0;

        estadolbl = new JLabel("Estado: ");
        estadolbl.setHorizontalAlignment(SwingConstants.RIGHT);
        estadolbl.setPreferredSize(new Dimension(150,30));
        estadolbl.setFont(tipoLetra);

        add(estadolbl, bc);

        bc = new GridBagConstraints();
        bc.gridx = 1;
        bc.gridy = 2;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 1.0;
        bc.insets = new Insets(10,10,10,10);
        bc.fill = GridBagConstraints.HORIZONTAL;

        estadotxt=new JComboBox<String>();
        estadotxt.setBackground(Color.white);
        estadotxt.setFont(tipoLetra2);
        estadotxt.addItem("CDMX");
        estadotxt.addItem("Puebla");
        estadotxt.addItem("Veracruz");
        estadotxt.setPreferredSize(new Dimension(200,30));
        estadotxt.setBackground(colorGrisClaro);
        add(estadotxt, bc);

        bc = new GridBagConstraints();
        bc.gridx = 2;
        bc.gridy = 2;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 1.0;

        ciudadlbl=new JLabel("Ciudad: ");
        ciudadlbl.setHorizontalAlignment(SwingConstants.RIGHT);
        ciudadlbl.setPreferredSize(new Dimension(100,30));
        ciudadlbl.setFont(tipoLetra);
        add(ciudadlbl, bc);

        bc = new GridBagConstraints();
        bc.gridx = 3;
        bc.gridy = 2;
        bc.gridwidth = 3;
        bc.gridheight = 1;
        bc.weightx = 3.0;
        bc.insets = new Insets(10,10,10,10);
        bc.fill = GridBagConstraints.HORIZONTAL;

        ciudadtxt=new PHTextField();
        ciudadtxt.setFont(tipoLetra2);
        ciudadtxt.setPreferredSize(new Dimension(200,30));
        ciudadtxt.setPlaceholder("Ciudad");
        ciudadtxt.setBackground(colorGrisClaro);
        add(ciudadtxt, bc);

        bc = new GridBagConstraints();
        bc.gridx = 0;
        bc.gridy = 3;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 1.0;

        colonialbl=new JLabel("Colonia");
        colonialbl.setHorizontalAlignment(SwingConstants.RIGHT);
        colonialbl.setPreferredSize(new Dimension(100,30));
        colonialbl.setFont(tipoLetra);
        add(colonialbl, bc);

        bc = new GridBagConstraints();
        bc.gridx = 1;
        bc.gridy = 3;
        bc.gridwidth = 3;
        bc.gridheight = 1;
        bc.weightx = 3.0;
        bc.insets = new Insets(10,10,10,10);

        coloniatxt=new PHTextField();
        coloniatxt.setFont(tipoLetra2);
        coloniatxt.setPreferredSize(new Dimension(400,30));
        coloniatxt.setPlaceholder("Colonia");
        coloniatxt.setBackground(colorGrisClaro);
        add(coloniatxt, bc);

        bc = new GridBagConstraints();
        bc.gridx = 4;
        bc.gridy = 3;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 1.0;

        CPlbl=new JLabel("C.P.");
        CPlbl.setPreferredSize(new Dimension(50,15));
        CPlbl.setFont(tipoLetra);
        add(CPlbl, bc);

        bc = new GridBagConstraints();
        bc.gridx = 5;
        bc.gridy = 3;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 1.0;
        bc.insets = new Insets(10,10,10,10);
        bc.fill = GridBagConstraints.HORIZONTAL;

        CPtxt=new PHTextField();
        CPtxt.setFont(tipoLetra2);
        CPtxt.setPreferredSize(new Dimension(150,30));
        CPtxt.setPlaceholder("Codigo Postal");
        CPtxt.setBackground(colorGrisClaro);
        add(CPtxt, bc);



        /*
        correolbl=new JLabel("Correo electrónico");
        correolbl.setPreferredSize(new Dimension(100,15));
        correolbl.setFont(tipoLetra);
        add(correolbl, bc);

        telefonolbl=new JLabel("Celular");
        telefonolbl.setPreferredSize(new Dimension(100,15));
        telefonolbl.setFont(tipoLetra);
        add(telefonolbl, bc);

        correotxt=new PHTextField();
        correotxt.setPreferredSize(new Dimension(150,18));
        correotxt.setPlaceholder("Correo electrónico");
        add(correotxt, bc);

        telefonotxt=new PHTextField();
        telefonotxt.setPlaceholder("Celular");
        telefonotxt.setPreferredSize(new Dimension(150,18));
        add(telefonotxt, bc);*/

        bc = new GridBagConstraints();
        bc.gridx = 0;
        bc.gridy = 5;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 0;
        bc.insets = new Insets(10,10,10,10);
        bc.fill = GridBagConstraints.HORIZONTAL;

        cancelar=new JButton("Cancelar");
        cancelar.setPreferredSize(new Dimension(80,20));
        cancelar.setFont(tipoLetra);
        cancelar.setForeground(Color.WHITE);
        cancelar.setBackground(new Color(140,10,10));
        add(cancelar, bc);

        bc = new GridBagConstraints();
        bc.gridx = 5;
        bc.gridy = 5;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 0;
        bc.insets = new Insets(10,10,10,10);
        //bc.fill = GridBagConstraints.HORIZONTAL;

        pagar=new JButton("Pagar");
        pagar.setFont(tipoLetra);
        pagar.setPreferredSize(new Dimension(110,20));
        pagar.setForeground(Color.white);
        pagar.setBackground(new Color(10,100,10));
        add(pagar, bc);

        cancelar.addActionListener(evt->{
            coloniatxt.setText("");
            nametct.setText("");
            dresstxt.setText("");
            CPtxt.setText("");
            ciudadtxt.setText("");
            this.setVisible(false);
        });
        pagar.addActionListener(evt->{

                Ventas vs=new Ventas();
                vs.registrarVenta(lista);
            pf.pagado();
            this.setVisible(false);
        });
    }

}
