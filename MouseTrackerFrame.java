import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTrackerFrame extends JFrame
{
   private final JPanel mousePanel; // painel no qual o evento do mouse ocorre
   private final JLabel statusBar; // exibe informações do evento

   // registra manipuladors de ebento do mouse
   public MouseTrackerFrame()
   {
      super("Demonstrating Mouse Events"); //titulo

      mousePanel = new JPanel(); 
      mousePanel.setBackground(Color.WHITE); 
      add(mousePanel, BorderLayout.CENTER); // adiciona painel para JFrame

      statusBar = new JLabel("Mouse outside JPanel"); 
      add(statusBar, BorderLayout.SOUTH); // adiciona label para JFrame

      // cria e registra listener para mouse e eventos de movimento do mouse
      MouseHandler handler = new MouseHandler(); 
      mousePanel.addMouseListener(handler); 
      mousePanel.addMouseMotionListener(handler); 
   } 

   private class MouseHandler implements MouseListener, 
      MouseMotionListener 
   {
      // manipuladores de evento MouseListener
      // sobre o evento: mouse soltou imediatamente apos precionar
      @Override
      public void mouseClicked(MouseEvent event)
      {
         statusBar.setText(String.format("Clicked at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      } 

      // sobre o evento: mouse precionou
      @Override
      public void mousePressed(MouseEvent event)
      {
         statusBar.setText(String.format("Pressed at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      }

      // sobre o evento: mouse soltou 
      @Override
      public void mouseReleased(MouseEvent event)
      {
         statusBar.setText(String.format("Released at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      }

      // sobre o evento: mouse entra na area
      @Override
      public void mouseEntered(MouseEvent event)
      {
         statusBar.setText(String.format("Mouse entered at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
         mousePanel.setBackground(Color.GREEN);
      }

      // sobrre o evento: mouse deixa a area
      @Override
      public void mouseExited(MouseEvent event)
      {
         statusBar.setText("Mouse outside JPanel");
         mousePanel.setBackground(Color.WHITE);
      }

      // manipuladores de evento MouseMotionListener
      // sobre o evento: quando o usuario arrastou o mouse com botão pressionado
      @Override
      public void mouseDragged(MouseEvent event)
      {
         statusBar.setText(String.format("Dragged at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      } 

      // sobre o evento: quano usuario moveu o mouse
      @Override
      public void mouseMoved(MouseEvent event)
      {
         statusBar.setText(String.format("Moved at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      } 
   } // encerra classe interna MouseHandler
} // encerra classe MouseTrackerFrame
