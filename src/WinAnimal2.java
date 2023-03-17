import java.awt.EventQueue;
import java.awt.Image;
//라용엽
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class WinAnimal2 extends JDialog {
   private JLabel lblPic;
   private JSpinner spinner;
private JButton btnRun;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               WinAnimal2 dialog = new WinAnimal2();
               dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
               dialog.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the dialog.
    */
   public WinAnimal2() {
      setTitle("년도 => 동물 보이기");
      setBounds(100, 100, 352, 363);
      getContentPane().setLayout(null);
      
      JLabel lblYear = new JLabel("연도:");
      lblYear.setBounds(12, 14, 57, 15);
      getContentPane().add(lblYear);
      
      btnRun = new JButton("실행");
      btnRun.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            showAnimal();
         }
      });
      btnRun.setBounds(226, 10, 97, 23);
      getContentPane().add(btnRun);
      
      lblPic = new JLabel("");
      lblPic.setBounds(61, 64, 200, 250);
      getContentPane().add(lblPic);
      
      spinner = new JSpinner();
      spinner.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
            showAnimal();
         }
      });
      spinner.setModel(new SpinnerNumberModel(2023, 1, 2200, 1));
      spinner.setBounds(39, 11, 145, 22);
      getContentPane().add(spinner);
      
   }

   protected void showAnimal() {
      String Animal[]= {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
      
      String sibgan[] = {"갑","을","병","정","무","기","경","신","임","계"};
      String cheongan[] = {"자","축","인","묘","진","사","오","미","신","유","술","해"};
      
      int year =  (int)spinner.getValue();
      String sixagenary = sibgan[(((year-1504)%60)%10)]+cheongan[(((year-1504)%60)%12)];
      
      ImageIcon img = new ImageIcon("src/images/" + Animal[year%12] + ".png");
      Image image = img.getImage();
      image = image.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
      ImageIcon pic = new ImageIcon(image);
      lblPic.setIcon(pic);
      btnRun.setText(sixagenary+"년");
   }
}