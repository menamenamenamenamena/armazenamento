import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultipleSelectionFrame extends JFrame 
{
   private final JList<String> colorJList; // lista para buscar nome das cores
   private final JList<String> copyJList; // lista para busacar nomes das cores copiados
   private final JList<String> copyJList2; // lista para busacar nomes das cores copiados
   private JButton copyJButton; // botao para copiar cores selecionadas
   private JButton copyJButton2; // botao para copiar cores selecionadas
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"}; // cores

   // construtor MultipleSelectionFrame 
   public MultipleSelectionFrame()
   {
      super("Multiple Selection Lists");
      setLayout(new FlowLayout());

      colorJList = new JList<String>(colorNames); // lista de nomes das cores
      colorJList.setVisibleRowCount(5); // exibe 5 linhas
      colorJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(colorJList)); // adiciona lista com scroll

      copyJButton = new JButton("Copy >>>"); 
      copyJButton.addActionListener(
         new ActionListener() // classe anonima
         {  
            // handle button event
            @Override
            public void actionPerformed(ActionEvent event)
            {
               // adiciona valor selecionado na copyJList
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray(
                     new String[0]));
            }
         } 
      ); 

      add(copyJButton); // adiciona botão de copia para JFrame

      copyJList = new JList<String>(); // lista para manter nomes das cores selecionadas
      copyJList.setVisibleRowCount(5); // exibe 5 linhas
      copyJList.setFixedCellWidth(100); // define largura
      copyJList.setFixedCellHeight(15); // sdefine altura
      copyJList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList)); // adiciona lista com scroll


      copyJButton2 = new JButton("Copy >>>"); 
      copyJButton2.addActionListener(
         new ActionListener() // classe anonima
         {  
            // handle button event
            @Override
            public void actionPerformed(ActionEvent event)
            {
               // adiciona valor selecionado na copyJList
               copyJList2.setListData(
                  colorJList.getSelectedValuesList().toArray(
                     new String[0]));
            }
         } 
      ); 

      add(copyJButton2); // adiciona segundo botão de copia para JFrame

      copyJList2 = new JList<String>(); // lista para manter nomes das cores selecionadas
      copyJList2.setVisibleRowCount(5); // exibe 5 linhas
      copyJList2.setFixedCellWidth(100); // define largura
      copyJList2.setFixedCellHeight(15); // sdefine altura
      copyJList2.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList2)); // adiciona lista com scroll
      
   } 
} // end class MultipleSelectionFrame

