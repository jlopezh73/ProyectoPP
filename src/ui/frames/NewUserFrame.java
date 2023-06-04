package ui.frames;

import Modelo.Usuario;
import Modelo.Usuarios;
import Modelo.Venta;
import Modelo.Ventas;
import ui.components.PHPasswordField;
import ui.components.PHTextField;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class NewUserFrame extends JFrame {
    private JLabel namelbl;
    private JLabel loginlbl;
    private JLabel passwordlbl;
    private PHTextField nametxt;
    private  PHTextField logintxt;
    private PHPasswordField passwordtxt;

    private JButton createUserBtn;
    private  JButton cancelButton;
    private Font tipoLetra=new Font("Arial",Font.BOLD,18);
    private Font tipoLetra2=new Font("Arial",Font.PLAIN,15);
    private Color colorGrisClaro = new Color(235,235, 235);
    public NewUserFrame(){
        initComponents();
    }
    public void initComponents(){

        GridBagLayout grid=new GridBagLayout();
        GridBagConstraints bc;
        setLayout(grid);
        setTitle("Datos de Venta");

        setSize(850,250);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.white);

        bc = new GridBagConstraints();
        bc.gridx = 0;
        bc.gridy = 0;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 1;

        loginlbl =new JLabel("Usuario: ");
        loginlbl.setHorizontalAlignment(SwingConstants.RIGHT);
        loginlbl.setPreferredSize(new Dimension(150,30));
        loginlbl.setFont(tipoLetra);
        add(loginlbl, bc);

        bc = new GridBagConstraints();
        bc.gridx = 1;
        bc.gridy = 0;
        bc.gridwidth = 2;
        bc.gridheight = 1;
        bc.weightx = 5.0;
        bc.insets = new Insets(10,10,10,10);
        bc.fill = GridBagConstraints.HORIZONTAL;

        logintxt =new PHTextField();
        logintxt.setPlaceholder("Password");
        logintxt.setPreferredSize(new Dimension(200,30));
        logintxt.setFont(tipoLetra2);
        logintxt.setBackground(colorGrisClaro);
        add(logintxt, bc);

        bc = new GridBagConstraints();
        bc.gridx = 3;
        bc.gridy = 0;
        bc.gridwidth = 1;
        bc.gridheight = 1;
        bc.weightx = 1.0;


        passwordlbl =new JLabel("Contraseña: ");
        passwordlbl.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordlbl.setPreferredSize(new Dimension(120,30));
        passwordlbl.setFont(tipoLetra);
        add(passwordlbl, bc);

        bc = new GridBagConstraints();
        bc.gridx = 4;
        bc.gridy = 0;
        bc.gridwidth = 3;
        bc.gridheight = 1;
        bc.weightx = 3.0;
        bc.insets = new Insets(10,10,10,10);
        bc.fill = GridBagConstraints.HORIZONTAL;

        passwordtxt =new PHPasswordField();
        passwordtxt.setFont(tipoLetra2);
        passwordtxt.setPreferredSize(new Dimension(200,30));
        passwordtxt.setPlaceholder("Password");
        passwordtxt.setBackground(colorGrisClaro);
        add(passwordtxt, bc);

        bc = new GridBagConstraints();
        bc.gridx = 0;
        bc.gridy = 1;
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
        bc.gridy = 1;
        bc.gridwidth = 6;
        bc.gridheight = 1;
        bc.weightx = 6.0;
        bc.insets = new Insets(10,10,10,10);
        bc.fill = GridBagConstraints.HORIZONTAL;

        nametxt =new PHTextField();
        nametxt.setPlaceholder("Nombre completo");
        nametxt.setPreferredSize(new Dimension(200,30));
        nametxt.setFont(tipoLetra2);
        nametxt.setBackground(colorGrisClaro);
        add(nametxt, bc);





        bc = new GridBagConstraints();
        bc.gridx = 3;
        bc.gridy = 5;
        bc.gridwidth = 2;
        bc.gridheight = 1;
        bc.weightx = 0;
        bc.insets = new Insets(10,10,10,10);
        //bc.fill = GridBagConstraints.HORIZONTAL;

        createUserBtn=new JButton("Nuevo usuario");
        createUserBtn.setFont(tipoLetra);
        createUserBtn.setPreferredSize(new Dimension(170,30));
        createUserBtn.setForeground(Color.white);
        createUserBtn.setBackground(new Color(10,100,10));
        add(createUserBtn, bc);

        createUserBtn.addActionListener(evt->{
            if (validarDatos()) {
                Usuario user = new Usuario(
                        logintxt.getTextPH(),
                        passwordtxt.getText(),
                        nametxt.getTextPH(),
                        "0");
                Usuarios us = new Usuarios();
                us.agregarUsuario(user);
                this.dispose();
            }
        });

        bc = new GridBagConstraints();
        bc.gridx = 5;
        bc.gridy = 5;
        bc.gridwidth = 2;
        bc.gridheight = 1;
        bc.weightx = 0;
        bc.insets = new Insets(10,10,10,10);

        cancelButton=new JButton("Cancelar");
        cancelButton.setPreferredSize(new Dimension(120,30));
        cancelButton.setFont(tipoLetra);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(new Color(140,10,10));
        add(cancelButton, bc);

        cancelButton.addActionListener(evt->{
            nametxt.setText("");
            logintxt.setText("");
            passwordtxt.setText("");
            this.dispose();
        });

    }

    private boolean validarDatos() {
        boolean errors = false;
        String messages = "";
        String name = nametxt.getTextPH();
        String address = logintxt.getTextPH();
        String city =  passwordtxt.getText();


        if (name.trim().length() == 0)
            messages += "* El nombre del cliente no puede estar vacío\n";
        if (address.trim().length() == 0)
            messages += "* El domicilio del cliente no puede estar vacío\n";
        if (city.trim().length() == 0)
            messages += "* La ciudad del domicilio del cliente no puede estar vacío\n";
        errors = messages.length() > 0;
        if (errors) {
            JOptionPane.showMessageDialog(null, messages, "Error en la onformación", JOptionPane.ERROR_MESSAGE);
        }
        return !errors;
    }

}
