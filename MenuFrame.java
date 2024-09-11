import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame 
{
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};   
   private final JRadioButtonMenuItem[] colorItems; // menu de itens para cores
   private final JRadioButtonMenuItem[] fonts; // menu de itens para fonte
   private final JCheckBoxMenuItem[] styleItems; // menu de itens para estilo da fonte
   private final JLabel displayJLabel; // exibe exemplo de texto
   private final ButtonGroup fontButtonGroup; // menu de itens para gerenciar fontes
   private final ButtonGroup colorButtonGroup; // menu de itens para gerenciar cores
   private int style; // usado para criar estilo de fonte para a fonte

   public MenuFrame()
   {
      super("Using JMenus");     

      JMenu fileMenu = new JMenu("File"); // cria arquivo do menu
      fileMenu.setMnemonic('F'); // set mnemonic para F

      // cria About... itens de menu
      JMenuItem aboutItem = new JMenuItem("About...");
      aboutItem.setMnemonic('A'); // define mnemonic para A
      fileMenu.add(aboutItem); // adiciona about item para menu de arquivo
      aboutItem.addActionListener(
         new ActionListener() // classe interna anonima
         {  
            // exibe mensagem quando usuario usar About...
            @Override
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(MenuFrame.this,
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 
 
      JMenuItem exitItem = new JMenuItem("Exit"); // cria item Exit
      exitItem.setMnemonic('x'); // define mnemonic para x
      fileMenu.add(exitItem); // adiciona item exit para menu de arquivos
      exitItem.addActionListener(
         new ActionListener() // classe interna anonima
         {  
            // encerra aplicação quando usuario clica exitItem
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0); // encerra aplicação
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar(); // cria barra de menu
      setJMenuBar(bar); // adiona barra de menu a aaplicação
      bar.add(fileMenu); // adiciona menu de arquivo a barra de menu

      JMenu formatMenu = new JMenu("Format"); // create format menu
      formatMenu.setMnemonic('r'); // define mnemonic para r

      // string para variedade de cores
      String[] colors = {"Black", "Blue", "Red", "Green"};

      JMenu colorMenu = new JMenu("Color"); // cria menu de cores
      colorMenu.setMnemonic('C'); // define mnemonic para C

      // cria itens de menu  com botão radio para cores
      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup(); // gerencia cores
      ItemHandler itemHandler = new ItemHandler(); // manipulador para cores

      // cria menu de itens para cores com botões radio
      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); // cria item
         colorMenu.add(colorItems[count]); // adiciona item para o menu de cores
         colorButtonGroup.add(colorItems[count]); // adiciona ao grupo
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true); // seleciona primeiro item Color

      formatMenu.add(colorMenu); // adiciona menu de cor ao menu de formato
      formatMenu.addSeparator(); // adiciona separador ao menu

      // fontes
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};
      JMenu fontMenu = new JMenu("Font"); // cria menu de fonte
      fontMenu.setMnemonic('n'); // define mnemonic para n

      // cria menu de itens para nome das fontes com botões radio
      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup(); // gerencia o nome das fontes

      // cria menu de itens com botões radio
      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]); // adicona fonte ao menu de fontes
         fontButtonGroup.add(fonts[count]); // adiciona ao grupo de botões
         fonts[count].addActionListener(itemHandler); // adicona manipulador
      } 

      fonts[0].setSelected(true); // seleciona primeira Font do menu de itens
      fontMenu.addSeparator(); // adiciona barra separadora para o menu fonte

      String[] styleNames = {"Bold", "Italic"}; // nome dos estilos
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler(); // manipulador de estilo

      // cria estilo de checkbox do menu de itens
      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); // para estilo
         fontMenu.add(styleItems[count]); // adiciona para menu fonte
         styleItems[count].addItemListener(styleHandler); // manipulador do estilo
      }

      formatMenu.add(fontMenu); // adicona Font menu para Format menu
      bar.add(formatMenu); // adiciona Format menu para a barra de menu
     
      // define label para display text
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]);
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));

      getContentPane().setBackground(Color.CYAN); // define background
      add(displayJLabel, BorderLayout.CENTER); // adiciona displayJLabel
   } // encerra construtor MenuFrame

   // classe interna para handle ação de eventos do menu de itens
   private class ItemHandler implements ActionListener 
   {
      // processa seleção de cores e fonte
      @Override
      public void actionPerformed(ActionEvent event)
      {
         // processa seleção de cores
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

         // processa seleção de fonte
         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72));
            }
         }

         repaint(); // repinta aplicação
      } 
   } // encerra classe ItemHandler

   // classe interna para manipulador de eventos de item do menu de itens checkbox
   private class StyleHandler implements ItemListener 
   {
      // processa estilo de fonte selecionado
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); // fonte atual
         Font font; // nova fonte baseada na seleção do usuario

         // determina qual CheckBoxes é observada e cria Font
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font);
         repaint(); // repinta a aplicação
      } 
   } // encerra a classe StyleHandler
} // encerra a classe MenuFrame