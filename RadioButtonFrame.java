import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonFrame extends JFrame
{
    private JTextField textField; // usado para exibir mudanças de fontes

    private Font plainFont; // fonte para texto plain
    private Font boldFont; // fonte para texto bold
    private Font italicFont; // fonte para texto italic
    private Font boldItalicFont; // fonte para texto bold and italic

    private Color blueColor; // torna texto azul
    private Color redColor; // torna texto vermelho
    private Color yellowColor; // torna texto amarelo
    private Color blackColor; // torna texto preto

    private JRadioButton plainJRadioButton; // seleciona texto em plain 
    private JRadioButton boldJRadioButton; // seleciona texto em bold 
    private JRadioButton italicJRadioButton; // seleciona texto em italic 
    private JRadioButton boldItalicJRadioButton; // seleciona texto em bold and italic
    private ButtonGroup radioGroup; // botão grupo que segura botões radio

    private JRadioButton blueJRadioButton; // seleciona texto em cor azul
    private JRadioButton redJRadioButton; // seleciona texto em cor vermelha
    private JRadioButton yellowJRadioButton; // seleciona texto em cor amarelo
    private JRadioButton blackJRadioButton; // seleciona texto em cor preto
    private ButtonGroup colorRadioGroup; // botão grupo que segura botões radio de cor

     // construtor RadioButtonFrame adiciona JRadioButtons para JFrame
    public RadioButtonFrame()
    {
        super("RadioButton Test"); 
        setLayout(new FlowLayout()); // titulo

        textField = new JTextField("Watch the font style change", 25);
        add(textField); // adiciona textField para JFrame

        // cria botões de radio
        plainJRadioButton = new JRadioButton("Plain", true);
        boldJRadioButton = new JRadioButton("Bold", false);
        italicJRadioButton = new JRadioButton("Italic", false);
        boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
        add(plainJRadioButton); // adiciona botão plain para JFrame
        add(boldJRadioButton); // adiciona botão bold para JFrame
        add(italicJRadioButton); // adiciona botão italic para JFrame
        add(boldItalicJRadioButton); // adiciona botão bold and italic para JFrame   

       // cria relacionamento logico entre JRadioButtons
      radioGroup = new ButtonGroup(); // cria ButtonGroup
      radioGroup.add(plainJRadioButton); // adicona plain para o grupo
      radioGroup.add(boldJRadioButton); // adiciona bold 
      radioGroup.add(italicJRadioButton); // adiciona italic 
      radioGroup.add(boldItalicJRadioButton); // adiciona bold and italic

       // cria objeto font
        blueJRadioButton = new JRadioButton("Blue", false);
        redJRadioButton = new JRadioButton("Red", false);
        yellowJRadioButton = new JRadioButton("Yellow", false);
        blackJRadioButton = new JRadioButton("Black", true);
        add(blueJRadioButton);
        add(redJRadioButton);
        add(yellowJRadioButton);
        add(blackJRadioButton);

        colorRadioGroup = new ButtonGroup();
        colorRadioGroup.add(blueJRadioButton);
        colorRadioGroup.add(redJRadioButton);
        colorRadioGroup.add(yellowJRadioButton);
        colorRadioGroup.add(blackJRadioButton);

        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        textField.setFont(plainFont);

        blueColor = new Color(0, 0, 255);
        redColor = new Color(255, 0, 0);
        yellowColor = new Color(255, 255, 0);
        blackColor = new Color(0, 0, 0);

        // registra eventos para JRadioButtons
        plainJRadioButton.addItemListener(
                new RadioButtonHandler(plainFont));
        boldJRadioButton.addItemListener(
                new RadioButtonHandler(boldFont));
        italicJRadioButton.addItemListener(
                new RadioButtonHandler(italicFont));
        boldItalicJRadioButton.addItemListener(
                new RadioButtonHandler(boldItalicFont));

        blueJRadioButton.addItemListener(
                new ColorRadioButtonHandler(blueColor));
        redJRadioButton.addItemListener(
                new ColorRadioButtonHandler(redColor));
        yellowJRadioButton.addItemListener(
                new ColorRadioButtonHandler(yellowColor));
        blackJRadioButton.addItemListener(
                new ColorRadioButtonHandler(blackColor));
    }

    private class RadioButtonHandler implements ItemListener
    {
        private Font font;

        public RadioButtonHandler(Font f) {
            font = f;
        }

        @Override
        public void itemStateChanged(ItemEvent event) {
            textField.setFont(font);
        }
    }

    private class ColorRadioButtonHandler implements ItemListener
    {
        private Color color;

        public ColorRadioButtonHandler(Color c) {
            color = c;
        }

        @Override
        public void itemStateChanged(ItemEvent event) {
            textField.setForeground(color);
        }
    }
} // encerra classe radio