import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeLogin extends JFrame
{
    private final JLabel lblLogin;
    private final JTextField txtLogin;

    private final JLabel lblEmail;
    private final JTextField txtEmail;

    private final JLabel lblSenha;
    private final JPasswordField txtSenha;

    private final JButton btnEntrar;

    private final JLabel lblNotificacoes;

    public TelaDeLogin()
    {
        super("Tela de Cadastro");
        setLayout(new GridLayout(4,2,5,5));

        lblLogin = new JLabel("Apelido:");
        add(lblLogin);

        txtLogin = new JTextField(10);
        add(txtLogin);

        lblEmail = new JLabel("Email");
        add(lblEmail);

        txtEmail = new JTextField(10);
        add(txtEmail);

        lblSenha = new JLabel("Senha:");
        add(lblSenha);

        txtSenha = new JPasswordField(10);
        add(txtSenha);

        btnEntrar = new JButton("Entrar");
        add(btnEntrar);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        add(lblNotificacoes);

        btnEntrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtLogin.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Nome para o cadastro. Por favor, digite um nome e tente novamente."));
                        txtLogin.requestFocus();
                        return;
                    }

                    if (txtEmail.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Email para o cadastro. Por favor, digite um Email e tente novamente."));
                        txtEmail.requestFocus();
                        return;
                    }

                    if (String.valueOf(txtSenha.getPassword()).trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar uma Senha para o cadastro. Por favor, digite uma Senha e tente novamente."));
                        txtSenha.requestFocus();
                        return;
                    }

                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String strSqlEmail = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtEmail.getText() + "';";
                        Statement stmSqlEmail = conexao.createStatement();
                        ResultSet rstSqlEmail = stmSqlEmail.executeQuery(strSqlEmail);
                        if (rstSqlEmail.next()) {
                            lblNotificacoes.setText(setHtmlFormat("Ops! Já existe um usuário utilizando este email. Por favor, digite outro email e tente novamente."));
                        } else {
                            lblNotificacoes.setText(setHtmlFormat("Login liberado para cadastro."));
                            String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + txtLogin.getText() + "', '" + txtEmail.getText() + "', '" + String.valueOf(txtSenha.getPassword()) + "');";
                            Statement stmSqlCadastrar = conexao.createStatement();
                            stmSqlCadastrar.addBatch(strSqlCadastrar);
                            stmSqlCadastrar.executeBatch();
                            lblNotificacoes.setText(setHtmlFormat("Cadastro realizado com sucesso"));
                        }
                        stmSqlEmail.close();
                    } catch (Exception e) {
                        lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com o cadastro! Por favor, verifique e tente novamente."));
                        System.err.println("Erro: " + e);
                    }
                }
            }
        );
            
            setSize(170, 220);
            setVisible(true);
        }
        
        private String setHtmlFormat(String string) {
            return "<html>(body)" + string + "</body></html>";
        }

        public static void main(String[] args) {
        TelaDeLogin appTelaDeLogin = new TelaDeLogin();
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
        appTelaDeLogin.setLocationRelativeTo(null);
    }
}
