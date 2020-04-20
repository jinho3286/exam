
	

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	 


	public class plusminus extends JFrame implements MouseListener{
	    private JPanel Border = new JPanel(new BorderLayout());
	    private JPanel Flow = new JPanel(new FlowLayout());
	    private JPanel jp2 = new JPanel(new GridLayout(2,4));
	    		
	    private JButton RPlus = new JButton("Ramen +");
	    private JButton RMinus = new JButton("Ramen -");
	    private JButton HPlus = new JButton("Ham +");
	    private JButton HMinus = new JButton("Ham -");
	    private JButton CPlus = new JButton("Coke +");
	    private JButton CMinus = new JButton("Coke -");
	    private JButton Decision = new JButton("Decision");

	    


	    private JTextField j1 = new JTextField("0");  
	    private JTextField j2 = new JTextField("0");  
	    private JTextField j3 = new JTextField("0");  
	    private JTextField j4 = new JTextField("0"); 

	 

	    private JLabel JL1 = new JLabel("Ramen");
	    private JLabel JL2 = new JLabel("Hambuger");
	    private JLabel JL3 = new JLabel("Coke");
	    private JLabel JL4 = new JLabel("Amount");




	    private static int Num1=0;       
	    private static int Num2=0;       
	    private static int Num3=0;       
	    private static int Num4=0;      

	    

	    public plusminus(){
	          super("VendingMachine");
	          init();
	          start();

	    }

	    


	    public void init(){
	          this.setSize(650,320);     

	          
	          Flow.add(RPlus);    
	          Flow.add(RMinus);  
	          Flow.add(HPlus);    
	          Flow.add(HMinus);     
	          Flow.add(CPlus);   
	          Flow.add(CMinus);  
	          Flow.add(Decision);              
	     
	         
	          this.add("Center",Flow);
	          this.add("South",j1);
	          this.add("South",jp2);
	             jp2.add(JL1);
	             jp2.add(JL2);
	             jp2.add(JL3);
	             jp2.add(JL4);
	             jp2.add(j2);	             
	             jp2.add(j3);
	             jp2.add(j4);
	             jp2.add(j1);
	          this.setVisible(true);

	    }

	    

	    public void start(){

	          RPlus.addMouseListener(this);
	          RMinus.addMouseListener(this);
	          CPlus.addMouseListener(this);
	          CMinus.addMouseListener(this);
	          HPlus.addMouseListener(this);
	          HMinus.addMouseListener(this);
	          
	          Decision.addMouseListener(this);
	    }

	    

	

	    public void mouseClicked(MouseEvent e) {

	         

	          int val=0;
	          if(e.getSource()==(JButton)RPlus){
	                 val = Integer.parseInt(j1.getText());	                
	                 val=val+3000;	              
	                 this.Num1=this.Num1+1;             
	                 j2.setText(String.valueOf(Num1));
	                 j1.setText(String.valueOf(val));
	                 }
	          
	          else if(e.getSource()==(JButton)RMinus){
	                 val = Integer.parseInt(j1.getText());	               
	                 val=val-3000;
	                 this.Num1=this.Num1-1;             
	                 j2.setText(String.valueOf(Num1));
	                 j1.setText(String.valueOf(val));
	                 }
	          

	          			else if(e.getSource()==(JButton)HPlus){
	          			val = Integer.parseInt(j1.getText());
	          			val=val+3500;
	          			this.Num2=this.Num2+1;
	          			j3.setText(String.valueOf(Num2));
	          			j1.setText(String.valueOf(val));
	          			}
	          
	          			else if(e.getSource()==(JButton)HMinus){
		          			val = Integer.parseInt(j1.getText());
		          			val=val-3500;
		          			this.Num2=this.Num2-1;
		          			j3.setText(String.valueOf(Num2));
		          			j1.setText(String.valueOf(val));
		          			}
	          
	          			else if(e.getSource()==(JButton)CPlus){
	          			val = Integer.parseInt(j1.getText());
	          			val=val+2500;
	          			this.Num3=this.Num3+1;
	          			j4.setText(String.valueOf(Num3));
	          			j1.setText(String.valueOf(val));
	                    }
	          
	          			else if(e.getSource()==(JButton)CMinus){
		          			val = Integer.parseInt(j1.getText());
		          			val=val-2500;
		          			this.Num3=this.Num3-1;
		          			j4.setText(String.valueOf(Num3));
		          			j1.setText(String.valueOf(val));
		                    }

	          			else if(e.getSource()==(JButton)Decision){
	                	
	                	  j1.setText(String.valueOf(val));  
	                	  val=0; this.Num1=0;
	                	  j2.setText(String.valueOf(val)); 
	                	  val=0; this.Num2=0;
	                	  j3.setText(String.valueOf(val)); 
	                	  val=0; this.Num3=0;
	                	  j4.setText(String.valueOf(val)); 
	                	  val=0; this.Num4=0;
	                	  
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
	  
	        plusminus m = new plusminus();
	    }


	}