import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox;
   private final JLabel label;

   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   private final Icon[] icons = { 
      new ImageIcon(getClass().getResource(names[0])),
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};

   // construor ComboBoxFrame adiciona JComboBox para JFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox");
      setLayout(new FlowLayout()); // titulo     

      imagesJComboBox = new JComboBox<String>(names); // seleciona JComboBox
      imagesJComboBox.setMaximumRowCount(4); // exibe 3 linhas

      imagesJComboBox.addItemListener(
         new ItemListener() // classe anonima
         {
            @Override
            public void itemStateChanged(ItemEvent event)
            {
               // determina se o item selecionado
               if (event.getStateChange() == ItemEvent.SELECTED)
                  label.setIcon(icons[
                     imagesJComboBox.getSelectedIndex()]);
            } 
         } // encerra classe anonima
      ); // encerra chamado para addItemListener

      add(imagesJComboBox); // adiciona combobox para JFrame
      label = new JLabel(icons[0]); // exibe primeiro item
      add(label); // adiciona label para JFrame
   }
} // encerra classe ComboBoxFrame