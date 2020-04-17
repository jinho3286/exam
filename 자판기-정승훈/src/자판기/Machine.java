package ���Ǳ�;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 

 

public class Machine extends JFrame implements MouseListener{
    private JPanel Border = new JPanel(new BorderLayout());
    private JPanel Flow = new JPanel(new FlowLayout());
   
    private JButton ��g� = new JButton("��� : 3000");
    private JButton �ܹ��� = new JButton("�ܹ��� : 3500");
    private JButton �ݶ� = new JButton("�ݶ� : 2500");
    private JButton ���� = new JButton("����");
    
    
    private JTextField j1 = new JTextField("0");  //�Ǹűݾ�
    private JTextField j2 = new JTextField("0");  //��� �Ǹż�
    private JTextField j3 = new JTextField("0");  //�ܹ��� �Ǹż�
    private JTextField j4 = new JTextField("0");  //�ݶ� �Ǹż�
 
    private JLabel JL1 = new JLabel("���");
    private JLabel JL2 = new JLabel("�ܹ���");
    private JLabel JL3 = new JLabel("�ݶ�");
    ImageIcon img = new ImageIcon("images/���Ǳ�.png"); 
	JLabel imageLabel = new JLabel(img);

    
    private static int Num1=0;       //��� �Ѱ���
    private static int Num2=0;       //�ܹ��� �Ѱ���
    private static int Num3=0;       //�ݶ� �Ѱ���
    private static int Num4=0;       //�Ѱ���
    
    public Machine(){
          super("���Ǳ�");
          init();
          start();
    }
    
  
    public void init(){
          this.setSize(550,400);     
          
          Flow.add(���);              //��� ��ư�� �߰�.
          Flow.add(�ܹ���);             //�ܹ��� ��ư�� �߰�.
          Flow.add(�ݶ�);              //�ݶ� ��ư�� �߰�.
          Flow.add(����);              //����
          Flow.add(imageLabel);                           
          
          
          this.add("North",Flow);
          this.add("South",j1);

          this.setVisible(true);
    }
    
    public void start(){
         
          ���.addMouseListener(this);
          �ܹ���.addMouseListener(this);
          �ݶ�.addMouseListener(this);
          ����.addMouseListener(this);
    }
    

    public void mouseClicked(MouseEvent e) {
         
          int val=0;
          if(e.getSource()==(JButton)���){
                 val = Integer.parseInt(j1.getText());
                 
                 //���ݿ� ���+
                 val=val+3000;
                 //��� ����
                 this.Num1=this.Num1+1;
                 
                 j2.setText(String.valueOf(Num1));
                 j1.setText(String.valueOf(val));
                 }
          			else if(e.getSource()==(JButton)�ܹ���){
          			val = Integer.parseInt(j1.getText());
          			//���ݿ� �ܹ���+
          			val=val+3500;
          			//�ܹ��� ����
          			this.Num2=this.Num2+1;
          			j3.setText(String.valueOf(Num2));
          			j1.setText(String.valueOf(val));
          			}
          			else if(e.getSource()==(JButton)�ݶ�){
          			val = Integer.parseInt(j1.getText());
          			//���ݿ� �ݶ�+
          			val=val+2500;
          			//�ݶ� ����
          			this.Num3=this.Num3+1;
          			j4.setText(String.valueOf(Num3));
          			j1.setText(String.valueOf(val));
                    }
          			else if(e.getSource()==(JButton)����){
                	  this.Num4=this.Num4+1;
                	  j1.setText(String.valueOf(val)); //����
              
          }     
        
    }

  
    public void mouseEntered(MouseEvent e) {
     
    }
    public void mouseExited(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e) {
   
    }
    public void mouseReleased(MouseEvent e) {
          
    }
    public static void main(String[] args) {
   
        Machine machine=new Machine();
    }

}