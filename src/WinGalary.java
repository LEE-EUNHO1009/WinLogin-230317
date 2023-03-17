import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class WinGalary extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private JPanel panel;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      try {
         WinGalary dialog = new WinGalary();
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public WinGalary() {
      setTitle("사진보기");
      setBounds(100, 100, 809, 518);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(new BorderLayout(0, 0));
      {
         JButton btnNewButton = new JButton("파일보기");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               File file = new File("d:/kakao");
               File fileList[] = file.listFiles();
               for(int i=0;i<fileList.length;i++) {
                  System.out.println(fileList[i].getPath());
                  ImageIcon icon = new ImageIcon(fileList[i].getPath());
                  JButton lbl = new JButton(icon);
                  panel.add(lbl);
               }
               panel.revalidate();
            }
         });
         contentPanel.add(btnNewButton, BorderLayout.NORTH);
      }
      
      panel = new JPanel();
      contentPanel.add(panel, BorderLayout.CENTER);
      panel.setLayout(new GridLayout(0, 4, 0, 0));
   }

}