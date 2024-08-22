import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {
   private final JTextField textField1; 
   private final JTextField textField2; 

   private JLabel label1;
   private JLabel label2;

   private JButton btnCalcular;
   private JLabel lblNotificacao;

   String[] numeros = {"1","2","3","4","4","5","6","7","8","9","0"};

   public Calculator()
   {
      super("calculadora de soma");
      setLayout(new GridLayout(4,2,5,5));

      label1 = new JLabel("digite numero 1:", SwingConstants.RIGHT);
      add(label1);
      textField1 = new JTextField(10); 
      add(textField1); 

      label2 = new JLabel("digite numero 2:", SwingConstants.RIGHT);
      add(label2);
      textField2 = new JTextField(10);
      add(textField2);

      btnCalcular = new JButton("Calcular");
      add(btnCalcular);
      add(new JLabel());
      lblNotificacao = new JLabel("Resultado");
      add(lblNotificacao);
      
      TextFieldHandler handler = new TextFieldHandler();
      textField1.addActionListener(handler);
      textField2.addActionListener(handler);
   } 

   
   private class TextFieldHandler implements ActionListener 
   {
      
      @Override
      public void actionPerformed(ActionEvent event)
      {
            if (textField1.getText().trim().length() == 0) {
               //notificar usuario que o campo 1 esta vazio
               lblNotificacao.setText("O campo 1 esta vazio");
               textField1.requestFocus();
            } else {
               if (textField2.getText().trim().length() == 0); 
               //notificar usuario que o campo 2 esta vazio
               lblNotificacao.setText("O campo 2 esta vazio");
               textField2.requestFocus();
         }  {
               //aqui sera feita a soma
               try{
                  boolean achouNumero;
                  for (int c = 0; c < textField1.getText().length(); c++) {
                     achouNumero = false;
                     for (int n = 0; n < numeros.length; n++) {
                        if (!textField1.getText().substring(c, c).equals(numeros[n])) {
                           achouNumero = true;
                           break;
                        }
                     }
                     if (achouNumero) {
                        break;
                     }
                  }
                  int soma = Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText());
                  lblNotificacao.setText(String.format("Resultado: %s", soma));
               } catch (Exception e) {
                  lblNotificacao.setText("erro, use um numero inteiro");
               }
         }
      } 
   } 


public static void main(String[] args)
   { 
      Calculator Calculator = new Calculator(); 
      Calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Calculator.setSize(380, 200); 
      Calculator.setVisible(true); 
   } 
}
