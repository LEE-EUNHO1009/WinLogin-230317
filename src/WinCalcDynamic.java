import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.SwingConstants;
//.오류 남->연속으로는 안찍히는 데 3.5.2 이런식으로는 가능하게 됨2
public class WinCalcDynamic extends JDialog {
   private JTextField tfResult;
   protected boolean bPoint = false;
   protected boolean bOp = false;
   private int count = 0;
   int prevIndex = -1;
   boolean bFirst = true;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               WinCalcDynamic dialog = new WinCalcDynamic();
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
   public WinCalcDynamic() {
      setTitle("계산기");
      setBounds(100, 100, 318, 466);
      
      tfResult = new JTextField();
      tfResult.setHorizontalAlignment(SwingConstants.RIGHT);
      tfResult.setFont(new Font("굴림", Font.BOLD, 20));
      getContentPane().add(tfResult, BorderLayout.NORTH);
      tfResult.setColumns(10);
      
      JPanel panel = new JPanel();
      getContentPane().add(panel, BorderLayout.EAST);
      panel.setLayout(new GridLayout(0, 4, 0, 0));
      
      String symbol[] = {
            "(",")","C","←",
            "1/x","x²","√x","/",
            "7","8","9","*",
            "4","5","6","-",
            "1","2","3","+",
            "+/-","0",".","="
            };
      for(int i=0;i<symbol.length;i++) {
         JButton btn = new JButton(symbol[i]);
         btn.setFont(new Font("굴림", Font.BOLD, 16));
         if(symbol[i].charAt(symbol[i].length()-1) >= '0' && symbol[i].charAt(symbol[i].length()-1) <= '9')
            btn.setBackground(Color.WHITE);
         else if(symbol[i].equals("="))
            btn.setBackground(Color.CYAN);
         else
            btn.setBackground(Color.GRAY);         
         panel.add(btn);         
         btn.addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
               JButton btn1 = (JButton)e.getSource();
               //System.out.println("click : " + btn1.getText());
               
               String btnText = btn1.getText();
               String strExp = tfResult.getText();
               double dValue = 0;
               switch(btnText) {
               case "+/-":
                  if(bFirst) {
                     if(strExp.charAt(0) == '-') {
                        strExp = strExp.substring(1);
                        count--;
                     }else{
                        strExp = "-" + strExp;
                        count++;
                     }
                     tfResult.setText(strExp);   
                  }
                  else if(bOp) {
                     String strPrev = strExp.substring(0,prevIndex+1);
                     System.out.println(strPrev);
                     String temp = strExp.substring(prevIndex+1);
                     System.out.println(temp);
                     if(temp.charAt(0) == '-') {
                        temp = temp.substring(1);
                        count--;
                     }else {
                        temp = "-" + temp;
                        count++;
                     }
                     tfResult.setText(strPrev + temp);
                  }
                  
                  break;
               case ".":
                  if(bPoint==false) {  // 소수점이 안 찍혀있었다면 찍고, 아니면 못 찍고
                     bPoint = true;
                     strExp = strExp + btnText;
                     tfResult.setText(strExp);
                  }                  
                  break;
               case "√x":
                  dValue = Math.sqrt(Double.parseDouble(strExp));
                  tfResult.setText(Double.toString(dValue));
                  break;
               case "x²":
                  dValue = Double.parseDouble(strExp) * Double.parseDouble(strExp);
                  tfResult.setText(Double.toString(dValue));
                  break;
               case "1/x":
                  dValue = 1 / Double.parseDouble(strExp);
                  tfResult.setText(Double.toString(dValue));
                  break;
               case "%":
                  dValue = Double.parseDouble(strExp) * 0.01;
                  tfResult.setText(Double.toString(dValue));
                  break;
               case "←":
                  count--;
                  strExp = strExp.substring(0,strExp.length()-1);
                  tfResult.setText(strExp);
                  break;
               case "C":
                  count=0;
                  bPoint = false;
                  bOp = true;
                  bFirst = true;
                  strExp = "";
                  tfResult.setText(strExp);
                  break;      
               case "=":
                  count=0;
                  tfResult.setText(getCalculate(strExp));
                  count = tfResult.getText().length();
//                  StringTokenizer st = new StringTokenizer(strExp, " ");
//                  while(st.hasMoreTokens()) {
//                     System.out.println(st.nextToken());
//                  }
                  break;
               case "+":
               case "-":
               case "*":
               case "/":
               case "(":
               case ")":
                  bFirst = false;                              
                  strExp = strExp + " " + btnText;                  
                  count = count + 2;
                  prevIndex = count;      
                  System.out.println(strExp.substring(prevIndex));
                  tfResult.setText(strExp);
                  bOp = false;  //연산자면 false, 숫자면 true
                  break;
               default:  //숫자
                  bPoint = false;
                  if(bOp == false) {
                     if(bFirst) {
                        strExp = strExp + btnText;
                        count++;
                     }else {
                        strExp = strExp + " " + btnText;
                        count = count + 2;
                     }                     
                  }
                  else {
                     strExp = strExp + btnText;
                     count = count + 1;
                  }
                  bOp = true;
                  tfResult.setText(strExp);
                  System.out.println(count);
               }
               
            }
         });
      }
   }

   
   
   
   
   
   
   static boolean checkCorrectBracket(ArrayList str) {
         Stack<String> check = new Stack<>();      
         for(int i = 0; i < str.size(); i++) {
            if(str.get(i).equals("(")) {
               check.push("(");
            }else if(str.get(i).equals(")")) {
               if(!check.isEmpty()) {
                  check.pop();
               }else {
                  return false;
               }
            }
         }
         
         if(check.isEmpty()) {
            return true;
         }else {
            return false;
         }
      }
      
      static String getCalculate(String str) {
         String operation[] = {"+", "-", "*", "/", "(", ")"};
         
         ArrayList<String> postfix = new ArrayList<>();
         Stack<String> opStack = new Stack<>();
         Stack<String> calStack = new Stack<>();
         ArrayList<String> strArr = new ArrayList<>();
         String num = "";
         
         StringTokenizer st = new StringTokenizer(str, " ");
         while(st.hasMoreTokens())
            strArr.add(st.nextToken());
         
         
         if(str.charAt(0) == '-') {
            str = "0" + str;
         }
         
         if(!checkCorrectBracket(strArr)) { 
            return "Bracket Error";
         }
         System.out.println(strArr);
         for(int i = 0; i < strArr.size(); i++) {
            boolean checkOp = false;
            for(int j = 0; j < operation.length; j++) {
               if(strArr.get(i).equals(operation[j])) {               
                  checkOp = true;               
                  if(!num.equals("")) {
                     postfix.add(num);
                     num = "";
                  }               
                  if(operation[j].equals("(")) { 
                     opStack.push(operation[j]);
                  }else if(operation[j].equals(")")) { 
                     while(!opStack.peek().equals("(") && !opStack.isEmpty()) {
                        postfix.add(opStack.pop().toString());
                     }                  
                     opStack.pop(); // '(' pop
                  }else {
                     if(opStack.isEmpty()) {
                        opStack.push(operation[j]);
                     }else {
                        if(opOrder(opStack.peek()) < opOrder(operation[j])) {
                           opStack.push(operation[j]);
                        }else {
                           postfix.add(opStack.pop().toString());
                           opStack.push(operation[j]);
                        }
                     }
                  }
               }
            }         
            if(!checkOp) {
               num += strArr.get(i);
            }         
         }
         
         if(!num.equals("")) {
            postfix.add(num);
         }      
         while(!opStack.isEmpty()) {
            postfix.add(opStack.pop().toString());
         }
         System.out.println(postfix);
         
         for(int i = 0; i < postfix.size(); i++) {
            calStack.push(postfix.get(i));         
            for(int j = 0; j < operation.length; j++) {
               if(postfix.get(i).equals(operation[j])) {
                  String re = "";
                  if(j!=6) {
                     calStack.pop();
                     Double n2 = Double.parseDouble(calStack.pop());                                 
                     Double n1 = Double.parseDouble(calStack.pop());
                     
                     if(operation[j].equals("+")) {
                        re = Double.toString(n1 + n2);
                     }else if(operation[j].equals("-")) {
                        re = Double.toString(n1 - n2);
                     }else if(operation[j].equals("*")) {
                        re = Double.toString(n1 * n2);
                     }else if(operation[j].equals("/")) {
                        re = Double.toString(n1 / n2);
                     }                  
                     calStack.push(re);
                  }else {
                     calStack.pop();
                     Double n2 = Double.parseDouble(calStack.pop());
                     re = Double.toString(-n2);
                     calStack.push(re);
                  }
               }
            }
         }
         
         double result = Double.parseDouble(calStack.pop());      
         return Double.toString(result);
      }
      
      static int opOrder(String string) {
         switch(string) {
            case "+":
            case "-":
               return 1;
            case "*":
            case "/":
               return 2;
            default:
               return -1;
         }
      }
}