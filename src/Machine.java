import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	 
	
	 
	
	public class Machine extends JFrame implements MouseListener{
	    private JPanel Border = new JPanel(new BorderLayout());
	    private JPanel Flow = new JPanel(new FlowLayout());
	   
	    private JButton Ramen = new JButton("Ramen : 3000");
	    private JButton Ham = new JButton("Ham : 3500");
	    private JButton Coke = new JButton("Coke : 2500");
	    private JButton Decision = new JButton("Decision");
	    
	    
	    private JTextField j1 = new JTextField("0");  //�Ǹűݾ�
	    private JTextField j2 = new JTextField("0");  //Ramen �Ǹż�
	    private JTextField j3 = new JTextField("0");  //Ham �Ǹż�
	    private JTextField j4 = new JTextField("0");  //Coke ��

	    private JLabel JL1 = new JLabel("Ramen");
	    private JLabel JL2 = new JLabel("Ham");
	    private JLabel JL3 = new JLabel("Coke");
	    ImageIcon img = new ImageIcon("images/���Ǳ�.png"); 
		JLabel imageLabel = new JLabel(img);
	
	    
	    private static int Num1=0;       //Ramen �Ѱ���
	    private static int Num2=0;       //Ham �Ѱ���
	    private static int Num3=0;       //Coke �Ѱ���
	    private static int Num4=0;       //�Ѱ���
	    
	    public Machine(){
	          super("���Ǳ�");
	          init();
	          start();
	    }
	    
	  
	    public void init(){
	          this.setSize(550,400);     
	          
	          Flow.add(Ramen);              //Ramen ��ư�� �߰�.
	          Flow.add(Ham);             //Ham ��ư�� �߰�.
	          Flow.add(Coke);              //Coke ��ư�� �߰�.
	          Flow.add(Decision);              //Decision
	          Flow.add(imageLabel);                           
	          
	          
	          this.add("North",Flow);
	          this.add("South",j1);
	
	          this.setVisible(true);
	    }
	    
	    public void start(){
	         
	          Ramen.addMouseListener(this);
	          Ham.addMouseListener(this);
	          Coke.addMouseListener(this);
	          Decision.addMouseListener(this);
	    }
	    
	
	    public void mouseClicked(MouseEvent e) {
	         
	          int val=0;
	          if(e.getSource()==(JButton)Ramen){
	                 val = Integer.parseInt(j1.getText());
	                 
	                 //���ݿ� Ramen+
	                 val=val+3000;
	                 //Ramen ����
	                 this.Num1=this.Num1+1;
	                 
	                 j2.setText(String.valueOf(Num1));
	                 j1.setText(String.valueOf(val));
	                 }
	          			else if(e.getSource()==(JButton)Ham){
	          			val = Integer.parseInt(j1.getText());
	          			//���ݿ� Ham+
	          			val=val+3500;
	          			//Ham ����
	          			this.Num2=this.Num2+1;
	          			j3.setText(String.valueOf(Num2));
	          			j1.setText(String.valueOf(val));
	          			}
	          			else if(e.getSource()==(JButton)Coke){
	          			val = Integer.parseInt(j1.getText());
	          			//���ݿ� Coke+
	          			val=val+2500;
	          			//Coke ����
	          			this.Num3=this.Num3+1;
	          			j4.setText(String.valueOf(Num3));
	          			j1.setText(String.valueOf(val));
	                    }
	          			else if(e.getSource()==(JButton)Decision){
	                	  this.Num4=this.Num4+1;
	                	  j1.setText(String.valueOf(val)); //Decision
	              
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