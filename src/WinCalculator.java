import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WinCalculator extends JDialog {
	private JTextField tfResult; 
	private String strNum="";   //변수 생성
	
	private boolean bFirst=true;   //true: 첫번째 피연자이다. false: 두번째 피연산자이다.
	private String strNumber1="";  //피연산자1   10+20 일때 10저장
	private String strNumber2="";  //피연산자2   10+20 일때 20저장
	private String op="";  //연산자
	
	private boolean bPoint=false; //false:소수점이 찍히지 않았다.
	DecimalFormat df=new DecimalFormat("#.#####");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinCalculator dialog = new WinCalculator();
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
	public WinCalculator() {
		setTitle("계산기");
		setBounds(100, 100, 310, 380);
		
		tfResult = new JTextField();
		tfResult.setText("0");
		tfResult.setHorizontalAlignment(SwingConstants.RIGHT);
		tfResult.setFont(new Font("굴림", Font.BOLD, 20));
		getContentPane().add(tfResult, BorderLayout.NORTH);
		tfResult.setColumns(10);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnEtc1 = new JButton("%");
		panel.add(btnEtc1);
		
		JButton btnEtc2 = new JButton("CE");
		panel.add(btnEtc2);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfResult.setText("0");
				strNum="";
				bPoint=false;
			}
		});
		panel.add(btnClear);
		
		JButton btnDw = new JButton("/");
		btnDw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 strNumber1=tfResult.getText(); //strNum; 
				 clearTextfield();
				 op="/";
			}
		});
		btnDw.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnDw);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNum=tfResult.getText();
				if(!strNum.equals("0"))
					strNum=strNum+"7";
				else
					strNum="7";
				tfResult.setText(strNum);
				tfResult.setText(strNum);
			}
		});
		btn7.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNum=tfResult.getText();
				if(!strNum.equals("0"))
					strNum=strNum+"8";
				else
					strNum="8";
				tfResult.setText(strNum);
				tfResult.setText(strNum);
			}
		});
		btn8.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNum=tfResult.getText();
				if(!strNum.equals("0"))
					strNum=strNum+"9";
				else
					strNum="9";
				tfResult.setText(strNum);
				tfResult.setText(strNum);
			}
		});
		btn9.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btn9);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 strNumber1=tfResult.getText(); //strNum; 
				 clearTextfield();
				 op="*";
			}
		});
		btnMul.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnMul);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNum=tfResult.getText();
				if(!strNum.equals("0"))
					strNum=strNum+"4";
				else
					strNum="4";
				tfResult.setText(strNum);
				tfResult.setText(strNum);
			}
		});
		btn4.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNum=tfResult.getText();
				if(!strNum.equals("0"))
					strNum=strNum+"5";
				else
					strNum="5";
				tfResult.setText(strNum);
				tfResult.setText(strNum);
			}
		});
		btn5.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNum=tfResult.getText();
				if(!strNum.equals("0"))
					strNum=strNum+"6";
				else
					strNum="6";
				tfResult.setText(strNum);
				tfResult.setText(strNum);
			}
		});
		btn6.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btn6);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 strNumber1=tfResult.getText(); //strNum; 
				 clearTextfield();
				 op="-";
			}
		});
		btnSub.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnSub);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNum=tfResult.getText();
				if(!strNum.equals("0"))
					strNum=strNum+"1";
				else
					strNum="1";
				tfResult.setText(strNum);
				tfResult.setText(strNum);
			}
		});
		btn1.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNum=tfResult.getText();
				if(!strNum.equals("0"))
					strNum=strNum+"2";
				else
					strNum="2";
				tfResult.setText(strNum);
				tfResult.setText(strNum);
			}
		});
		btn2.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNum=tfResult.getText();
				if(!strNum.equals("0"))
					strNum=strNum+"3";
				else
					strNum="3";
				tfResult.setText(strNum);
			}
		});
		btn3.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btn3);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  strNumber1=tfResult.getText(); //strNum; 
				  clearTextfield();
				  op="+";
				
			}
		});
		btnAdd.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnAdd);
		
		JButton btnPM = new JButton("+/-");
		btnPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//양수<->음수(-) 양수(+부호 넣지 않음)
				String temp=tfResult.getText(); 
				
				Double dTemp=Double.parseDouble(temp);
				dTemp=-dTemp;
				tfResult.setText(df.format(dTemp)); 
			}
		});
		btnPM.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnPM);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tfResult.getText().equals("0")) {  //클리어에서 0여러번 누른다고 여러개 안나오도록
				strNum=strNum+"0";
				tfResult.setText(strNum);
				}
			}
		});
		btn0.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btn0);
		
		JButton btnPoint = new JButton(".");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bPoint==false) {
					
				if(strNum.equals(""))
					strNum=strNum+"0.";
				else
					strNum=strNum+".";
				
				tfResult.setText(strNum);
				bPoint=true;
				}
			}
		});
		btnPoint.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnPoint);
		
		JButton btnResult = new JButton("=");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNumber2=tfResult.getText();  //strNum;
				double result = 0;
				switch(op) {
				case "+":
				result= Double.parseDouble(strNumber1)+Double.parseDouble(strNumber2); break;
				case "-":
					result= Double.parseDouble(strNumber1)-Double.parseDouble(strNumber2); break;
				case "*":
					result= Double.parseDouble(strNumber1)*Double.parseDouble(strNumber2); break;
				case "/":
					if(!strNumber2.equals("0"))
						result= Double.parseDouble(strNumber1)/Double.parseDouble(strNumber2);
					else
						setTitle("0으로 나누면 오류");
					break;
				}
				tfResult.setText(df.format(result));
			}
		});
		btnResult.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnResult);

	}

	protected void clearTextfield() {
		tfResult.setText("");
		strNum="";
		bPoint=false;
		
	}

}
