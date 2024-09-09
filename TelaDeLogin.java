import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class TelaDeLogin extends JFrame
{
    private final JLabel lblSenha;
    private final JTextField txtSenha;
    private final JLabel lblLogin;
    private final JTextField txtLogin;
    private final JButton btnEntrar;
    private final JLabel lblNotificacoes;

    public TelaDeLogin()
    {
        super("Tela de login");
        setLayout(new FlowLayout());

        lblLogin = new JLabel("login");
        add(lblLogin);
        txtLogin = new JTextField(10);
        add(txtLogin);
        lblSenha = new JLabel("senha");
        add(lblSenha);
        txtSenha = new JPasswordField(20);
        add(txtSenha);
        btnEntrar = new JButton("entrar");
        add(btnEntrar);
        add(new JLabel("                    "));
        lblNotificacoes = new JLabel ("notificação", SwingConstants.CENTER);
        add(lblNotificacoes);
        setSize(150, 200);
        setVisible(true);
    }
    public static void main(String[] args)
    {
       TelaDeLogin telaDeLogin = new TelaDeLogin();
       telaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

}