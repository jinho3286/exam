package ���Ǳ�;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VendingMachine extends JFrame{
   private TitleLabel tl = new TitleLabel(); //���Ǳ� ���� Ÿ��Ʋ(��� �׸� �������� �г�)
   private MoneyHole mh = new MoneyHole();   //�� ���� �г�
   private FoodButtons fm = new FoodButtons();      //�޴� ��ư �г�
   private Chages ch = new Chages();    //�ܵ� ��ȯ �г�
   
   private MyDialog dialog;   //��й�ȣ�� �Է��ϴ� ���̾�α� ����
   
   static int UserMoneySum = 0;  //�̿��� �� �ʱ�ȭ
   private int [] foodPrice = {1500,1500,1500,1700,1700,1700,1900,1900,1900};  //�� ����� ����
   private int [] foodNum = {10,10,10,10,10,10,10,10,10};  //����� �� ������ 10���� �ʱ�ȭ
   private int MoneySum = 0;  //�� ���� �ʱ�ȭ
   private int [] cell = {0,0,0,0,0,0,0,0,0}; //��� �Ǹ� ���� �ʱ�ȭ

   static JLabel sumLabel = new JLabel("     Now " + UserMoneySum + "  won" );   //�پ��� �гε鿡�� ��ü������ ������ ���絷�� ǥ�õǵ��� static ����
   
   static ImageIcon [] images = { new ImageIcon("images\\�Ŷ�����.png"), new ImageIcon("images\\�ȼ��������.png"),new ImageIcon("images\\��������.png")
         ,new ImageIcon("images\\�ʱ�������.png"),new ImageIcon("images\\¥�İ�Ƽ����.png"),new ImageIcon("images\\�Ҵߺ��������.png")
         ,new ImageIcon("images\\��«�ͺ���.png"),new ImageIcon("images\\���ĸ�����.png"),new ImageIcon("images\\����������.png")
   };  // ���Ǳ� �޴��� ��Ÿ���� ��� ���� �̹���
   static ImageIcon [] imagesF = { new ImageIcon("images\\�Ŷ������.png"), new ImageIcon("images\\�ȼ���������.png"),new ImageIcon("images\\���������.png")
         ,new ImageIcon("images\\�ʱ�������.png"),new ImageIcon("images\\¥�İ�Ƽ����.png"),new ImageIcon("images\\�Ҵߺ���������.png")
         ,new ImageIcon("images\\��«������.png"),new ImageIcon("images\\���ĸ�����.png"),new ImageIcon("images\\�����������.png")
   };  // ���Ǳ� �޴��� ���� �� ��Ÿ���� �ϼ��� ��� �̹���
   
   private String passWord = "123456";  //���� �� �Ǹ���Ȳ �޴��� ���� ���� ��й�ȣ ����
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public VendingMachine() 
   {
      setTitle("��� ���Ǳ�");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(null);
      
      createMenu();
      
      setSize(800,800);
      
      tl.setBounds(0, 0, getWidth(), 100);           //��  �гε��� �������� ũ�⿡ �°� ������.
      mh.setBounds(0, 100, getWidth(), 50);
      fm.setBounds(0, 150, getWidth(), 500);
      ch.setBounds(0, 680, getWidth(), 300);
      
      dialog = new MyDialog(this, "��й�ȣ �Է�");          //���̾�α� ����
      
      c.add(tl);
      c.add(mh);
      c.add(fm);
      c.add(ch);
      
      setVisible(true);
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   class MyDialog extends JDialog {      //��й�ȣ �Է��� ���� ���̾� �α�
      private JTextField tf = new JTextField(10);          //���̾�α� �Է� ���� (10)
      private JButton okButton = new JButton("OK");    //OK��ư ����

      public MyDialog(JFrame frame, String title) {
         super(frame,title);
         setLayout(new FlowLayout());
         add(tf);
         add(okButton);
         setSize(200, 100);

         okButton.addActionListener(new ActionListener() {        //OK��ư�� ������ ������
            public void actionPerformed(ActionEvent e) {
               setVisible(false);
               if(passWord.equals( dialog.getInput()))         //������ �н�����(line 32)�� ���̾�α� �ؽ�Ʈ �ʵ忡 �Է��� ���� ������ ���� �� �Ǹ���Ȳ�� ����.
               {
                  new Sales();
                  tf.setText("");       //���̾� �α׿� �Է��� �Է�â(���̺�)�� ��ĭ���� ����
               }
               else if(tf.getText().length() == 0)
               {
                  JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����� �ʾҽ��ϴ�. �Է��� �ּ���", "��й�ȣ ����!", JOptionPane.ERROR_MESSAGE);   //��й�ȣ�� �Է����� ������ ���޼��� ���
                   setVisible(true);
                   tf.setText("");      //���̾� �α׿� �Է��� �Է�â(���̺�)�� ��ĭ���� ����
               }
               else
                {
                   JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ���ϴ�. �ٽ� �Է��� �ּ���", "��й�ȣ ����!", JOptionPane.ERROR_MESSAGE);   //Ʋ���� ���޼��� ���
                   setVisible(true);
                   tf.setText("");      //���̾� �α׿� �Է��� �Է�â(���̺�)�� ��ĭ���� ����
                }
            }
         });
      }
      
      public String getInput() {
         if(tf.getText().length() == 0) return null;    //���̾�α׿� �Է¹޴� ���� ȣ�� �� �� �ֵ��� �޼ҵ� ����
         else return tf.getText();
      }

   }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

   private void createMenu()    // "���� �� �Ǹ���Ȳ" , "������" �ΰ��� �޴��� ����� �޼ҵ�
   {
      JMenuBar mb = new JMenuBar();
      JMenuItem [] menuItem = new JMenuItem[2];
      String [] itemTitle = {"���� �� �Ǹ���Ȳ" , "������"};         
      JMenu screenMenu = new JMenu("�޴�");
      
      MenuActionListener listener = new MenuActionListener();
      for(int i=0; i<menuItem.length; i++)              //�� �޴��������� �޴��� �����ʿ� �ޱ� 
      {
         menuItem[i] = new JMenuItem(itemTitle[i]);   
         menuItem[i].addActionListener(listener);     //�����ʴޱ�
         screenMenu.add(menuItem[i]);                 //�޴��� ����
      }
      mb.add(screenMenu);      //�޴��ٿ� ����
      setJMenuBar(mb);
   }
   
   class MenuActionListener implements ActionListener {
       public void actionPerformed(ActionEvent e)
       {
          String cmd = e.getActionCommand();
          switch(cmd)
          {
             case "���� �� �Ǹ���Ȳ" :                     //�ش� �޴��� �����ϸ� �ٷ� ���� �� �Ǹ���Ȳ�� ��Ÿ���� �ʰ� ���̾�αװ� ����Ǿ� <��й�ȣ>�� �Է� �� �� ����.
                dialog.setVisible(true);
                break;
                
             case "������" :
                System.exit(0);         //���α׷� ����
                break;
          }
       }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   class Sales extends JFrame {
      private JPanel jp1 = new JPanel();       //���Ǳ� �޴��� �� ������ ��� �� �Ǹŷ� (�г�)
      private JPanel jp2 = new JPanel();       //��� �ʱ�ȭ �� �� ���� ��Ȳ (�г�)
      private JLabel [] num =  new JLabel[9]; 
      private JLabel money;
      private JButton reset;
      
      public Sales() 
      {
         setTitle("���� �� �Ǹ���Ȳ");
         setLayout(new BorderLayout(0,20));
         jp1.setLayout(new GridLayout(3, 3, 5,5));
         for(int i = 0 ; i<9; i++ ) 
         {
            num[i] = new JLabel("<html>�Ǹ� ����: " +cell[i]+ "  ��" + "<br><br>   ���: " + foodNum[i]+ "  ��", images[i] , SwingConstants.CENTER);   
            jp1.add(num[i]);      //�ǸŰ��� �� ��� ��Ȳ ���� �ϸ�俬�ϰ� Ȯ�� �� �� ����  <html>/ <br>�� �ҽ��ڵ�� �� ���� �ؽ�Ʈ�� ���� �����.
         }
         //
         reset = new JButton("��� �ʱ�ȭ (10��)");
         reset.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               for(int i = 0 ; i<9; i++ ) 
               {
               foodNum[i] = 10;    //��� 10���� �ʱ�ȭ �����ִ� �ڵ�
               num[i].setText("<html>�Ǹ� ����: " +cell[i]+ "  ��" + "<br><br>   ���: " + foodNum[i]+ "  ��");
               }
            }             //��� ��� 10���� ���� �����ָ�/ ���°� ���ÿ� (���»��·�)�ؽ�Ʈ ����
         });
         //
         
         money = new JLabel("          �� �Ǹ� ������  " + MoneySum + "  �Դϴ�.          ");     //�� �ǸŸ����� �����ִ� ��
         money.setOpaque(true);
         money.setBackground(Color.LIGHT_GRAY);
         
         jp2.add(reset);     
         jp2.add(money);    //�Ʒ� �гο� ���¹�ư�� ������Ȳ ���� �߰� ��Ų��.
         
         add(jp1,BorderLayout.CENTER);
         add(jp2,BorderLayout.SOUTH);
      
         setSize(1100,600);
         setVisible(true);
      }
      
   }

   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   class TitleLabel extends JPanel {
      
      private ImageIcon icon = new ImageIcon("images\\Ÿ��Ʋ.png");          //��� ���Ǳ� �������� �Ǿ��ִ� �̹��� (���Ǳ� ���� ��� �гο� ����)
      private Image img = icon.getImage();
      
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g);
         g.drawImage(img, 0, 0, getWidth(), getHeight(), this);  
      }
      
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   class MoneyHole extends JPanel {
   
      private JButton [] btn = { new JButton("10,000 won"), new JButton("5,000 won"), new JButton("1,000 won"),new JButton("500 won")};   //���� ������ �� �ֵ��� �� �ݾ׺� ��ư�� ����
      
      public MoneyHole() {
         MyMoneyListener listener = new MyMoneyListener();
         for(int i=0; i<4; i++)              //�� ���� ��ư (10,000�� , 5,000��, 1,000�� , 500��) 
         {
            btn[i].setBackground(Color.ORANGE);
            btn[i].setFont(new Font("Arial", Font.BOLD, 20));
            add(btn[i]);
            btn[i].addActionListener(listener);
         }
         sumLabel.setFont(new Font("Arial", Font.BOLD, 20));
         add(sumLabel);    //�̿����� ���� ǥ�õǴ� �� ����
         
         setBackground(Color.YELLOW);
      }
      
      class MyMoneyListener implements ActionListener {        // �ݾ� ��ư�� ������ �ش� �ݾ� ��ŭ �̿����� ���� �ö󰣴�.
         
         public void actionPerformed(ActionEvent e)
         {
            JButton b = (JButton)e.getSource();
            if(b == btn[0])
            {
               UserMoneySum += 10000;     //10000�� ����
            }
            else if(b == btn[1])
            {
               UserMoneySum += 5000;     //5000�� ����
            }
            else if(b == btn[2])
            {
               UserMoneySum += 1000;     //1000�� ����
            }
            else
            {
               UserMoneySum += 500;     //500�� ����
            }
            sumLabel.setText("     Now " + UserMoneySum + "  won");      //�̿����� ���� ���Աݾ��� �� �� �ֵ��� ����
         }
      }
      
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   class FoodButtons extends JPanel {
      private JButton [] btn = new JButton[9];
      private JLabel [] la = new JLabel[9];
      
      public FoodButtons() 
      {
         setLayout(new GridLayout(3, 3, 5, 5));
         int price = 1500;
         MyMenuListener listener = new MyMenuListener();
         
         for(int i = 0 ; i<9; i++ )       // ���Ǳ⿡ �ǸŵǴ� ���(�̹���)�� ���� ���� 
         {
            if(i>2) price = 1700;     //���� ���� ĭ 1500��, �ι�° ĭ 1700��, ����° ĭ1900��
            if(i>5) price = 1900;
            
            btn[i] = new JButton(price+"��", images[i]);   
            add(btn[i]);
            btn[i].addActionListener(listener);    //���Ǳ� �޴� ��ư�� ������ �ޱ�
         }
         
         setBackground(Color.ORANGE);
         }
      class MyMenuListener implements ActionListener{
         
         public void actionPerformed(ActionEvent e)
         {
            
            for(int i = 0 ; i<9; i++ )
            {
               if(UserMoneySum >= foodPrice[i])
               {
                  JButton b = (JButton)e.getSource();
                  if(b == btn[i])
                     {
                     if(foodNum[i] > 0) 
                        {
                        Foods fd = new Foods();         //�޴� ��ư�� ������ �ش� ����� �ϼ�ǰ�� ���ο� �����Ӱ� �Բ� �������� ����
                        fd.add(new JLabel(imagesF[i]));  //������ ����� �ϼ�ǰ �̹���
                        
                        UserMoneySum -= foodPrice[i];    //�̿����� ���� ������ �޴��� �׼���ŭ ����
                        foodNum[i]--;                 //��� �ݿ�
                        MoneySum += foodPrice[i];         //���� �ݿ�
                        cell[i]++;                 //�Ǹ� ���� �ݿ�
                        
                        sumLabel.setText("     Now " + UserMoneySum + "  won");        //�̿����� ���� ���Ӱ� set(����)
                        break;
                        }
                     else 
                        {
                        JOptionPane.showMessageDialog(null, "��� �����ϴ�. ��ǰ�� ä�� ��������.", "��� ����!", JOptionPane.ERROR_MESSAGE);
                        break; //��� ������ ä��������� ��� �޼��� ���̾�α�
                        }
                     }      
               }
               else 
               {
                  JOptionPane.showMessageDialog(null, "�ݾ��� �����մϴ�! ���� �� �����ϼ���", "�ܾ� ����!", JOptionPane.ERROR_MESSAGE);
                  break;  //�ݾ��� �����ϸ� ���� �����϶�� ��� �޼��� ���̾�α�
               }
            }   
            
         }
      }
}
   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   class Foods extends JFrame {           //������ ����� �ϼ�ǰ�� �� �����ӿ��� ����
      public Foods() 
      {
         setTitle("��� �ϼ�!  ���ְ� �弼��~!");
         Container c = getContentPane();
         c.setLayout(new FlowLayout());
         
         setSize(400,300);
         setVisible(true);
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   class Chages extends JPanel {
      private JButton btn = new JButton("�ܵ� ��ȯ");              // ���Ǳ� ���� �ϴܺ� �гο� �ܵ� ��ȯ ��ư
      private JLabel la = new JLabel("");
      public Chages() 
      {   
         btn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) 
            {
               la.setFont(new Font("Arial", Font.ITALIC, 20));
               
               if(UserMoneySum > 0)      //�̿����� �ݾ��� 0������ ������ �ش� �ݾ��� ��ȯ�Ǿ��ٴ� ���� ���
               {
                  la.setText(UserMoneySum + " won returned!  Thank you for using...");      
                  UserMoneySum=0;     //���� ��°� �Բ� ���Ǳ⿡ ���̴� �̿��� �ݾ��� 0������ ����
                  sumLabel.setText("     Now " + UserMoneySum + "  won");
               }
               else 
                  la.setText("NO MONEY!   Please use after confirmation...");       //���Ǳ⿡ �̿����� ���� ������ ���� ������ Ȯ���� �̿��� �޶�� ���� ���
            }
         });
         
         btn.setBackground(Color.LIGHT_GRAY);
         setBackground(Color.GRAY);
         add(btn); add(la);
      }
      
      
   }
   
////////////////////////////////////////////////////////  
   public static void main(String[] args) {
      new VendingMachine();

   }

}
