package ui.frames;
import Modelo.*;
import ui.components.PHPasswordField;
import ui.components.PHTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JPanel logoPanel;
    private JLabel error;
    private JPanel loginPanel;
    private JLabel logo;
    private JLabel title;
    private JLabel subtitle;
    private JButton button;
    private PHTextField userName;
    private PHPasswordField password;
    private final Color colorAmarillo = new Color(255,212,1);
    private final Color colorRojo=new Color(160,50,10);
    private final Font tipoTitulo1 = new Font("Arial", Font.BOLD,40);
    private final Font tipoTitulo2 = new Font("Arial", Font.BOLD,25);
    private final Font tipoTitulo3 = new Font("Arial", Font.BOLD,20);
    private final Font tipoTitulo4=new Font("Arial",Font.ITALIC,20);

    public LoginFrame() {
        initComponents();
    }

    private void initComponents() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(400,0));
        logoPanel.setBackground(colorAmarillo);

        logo = new JLabel("Papelería \"El Peque\"");
        logo.setVerticalTextPosition(SwingConstants.TOP);
        logo.setHorizontalTextPosition(SwingConstants.CENTER);
        logo.setIcon(new ImageIcon("res/logo.jpg"));
        logo.setPreferredSize(new Dimension(400, 600));
        logo.setFont(tipoTitulo1);
        logoPanel.add(logo);

        FlowLayout layout = new FlowLayout();
        loginPanel = new JPanel();
        loginPanel.setLayout(layout);

        title = new JLabel("Bienvenido");
        title.setFont(tipoTitulo2);
        title.setPreferredSize(new Dimension(380, 200));
        title.setVerticalAlignment(JLabel.BOTTOM);
        loginPanel.add(title);

        subtitle = new JLabel("Inicio de Sesión");
        subtitle.setFont(tipoTitulo3);
        subtitle.setPreferredSize(new Dimension(380, 30));
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        loginPanel.add(subtitle);

        JPanel empty0 = new JPanel();
        empty0.setPreferredSize(new Dimension(380, 20));
        loginPanel.add(empty0);

        userName = new PHTextField();
        userName.setPreferredSize(new Dimension(380, 40));
        userName.setFont(new Font("Arial", Font.PLAIN, 14));
        userName.setPlaceholder("Nombre de usuario");
        userName.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(userName);

        JPanel empty1 = new JPanel();
        empty1.setPreferredSize(new Dimension(400, 30));
        loginPanel.add(empty1);

        password = new PHPasswordField();
        password.setPreferredSize(new Dimension(380, 40));
        password.setFont(new Font("Arial", Font.PLAIN, 14));
        password.setPlaceholder("Contraseña");
        password.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(password);

        JPanel empty2 = new JPanel();
        empty2.setPreferredSize(new Dimension(400, 30));
        loginPanel.add(empty2);

        button = new JButton("Iniciar Sesión");
        button.setPreferredSize(new Dimension(250, 50));
        button.setBackground(colorAmarillo);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFont(tipoTitulo3);
        loginPanel.add(button);

        JPanel empty5 = new JPanel();
        empty5.setPreferredSize(new Dimension(380, 20));
        loginPanel.add(empty5);

        error=new JLabel();
        error.setFont(tipoTitulo4);
        error.setForeground(colorRojo);
        loginPanel.add(error);

        button.addActionListener( evt -> {
            Usuarios x=new Usuarios();
            String u,w;
            u=userName.getText();
            w=password.getText();
            if(x.validaUsuario(u,w)!=null) {
                PrincipalFrame principalFrame = new PrincipalFrame( x.validaUsuario(u,w));
                principalFrame.setVisible(true);
                error.setText("");
                setVisible(false);
            }
            else{
                    error.setText("Usuario o contraseña incorrecto(s)");
            }
        });


        add(logoPanel, BorderLayout.WEST);
        add(loginPanel, BorderLayout.CENTER);
    }
}
