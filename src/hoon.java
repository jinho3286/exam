import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements MouseListener{

    public static int ham = 0;
    public static int coke = 0;
    public static int pizza = 0;


    public static int Num1 = 0;
    public static int Num2 = 0;
    public static int Num3 = 0;
    public static int Num4 = 0;
    public int val = 0;


    public JTextField j1 = new JTextField("0");
    public JTextField j2 = new JTextField("0");
    public JTextField j3 = new JTextField("0");
    public JTextField j4 = new JTextField("0");


    public JLabel JL1 = new JLabel("Hamburger amount");
    public JLabel JL2 = new JLabel("Coke amount");
    public JLabel JL3 = new JLabel("Pizza amount");



    public JButton HPlus = new JButton("Ham +");
    public JButton HMinus = new JButton("Ham -");
    public JButton CPlus = new JButton("Coke +");
    public JButton CMinus = new JButton("Coke -");
    public JButton PPlus = new JButton("Pizza +");
    public JButton PMinus = new JButton("Pizza -");


    
    
    public void main() {

        

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel NorthPanel = new JPanel(new BorderLayout());
        JPanel CenterPanel = new JPanel(new GridLayout(0, 3));
        JPanel SouthPanel = new JPanel(new BorderLayout());


        JLabel Title = new JLabel("Vending Machine");
        Title.setFont(Title.getFont().deriveFont(20.0f));
       Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setBounds(12, 10, 460, 29);
        this.getContentPane().add(Title);



        NorthPanel.add(Title, BorderLayout.NORTH);


        CenterPanel.add(new MenuPanel1("imagePath1", new HamburgerListener()));
        CenterPanel.add(new MenuPanel2("imagePath2", new CokeListener()));
        CenterPanel.add(new MenuPanel3("imagePath3", new PizzaListener()));



        SouthPanel.add(new ListPanel(), BorderLayout.CENTER);

        SouthPanel.add(new InputPanel(), BorderLayout.SOUTH);



        NorthPanel.setPreferredSize(new Dimension(50, 50));
        CenterPanel.setPreferredSize(new Dimension(250, 250));
        SouthPanel.setPreferredSize(new Dimension(150, 150));



        this.getContentPane().add(NorthPanel, BorderLayout.NORTH);             
        this.getContentPane().add(CenterPanel, BorderLayout.CENTER);
        this.getContentPane().add(SouthPanel, BorderLayout.SOUTH);          

        this.setVisible(true);
        start();
    }

    public void start(){
    	
        HPlus.addMouseListener(this);
        HMinus.addMouseListener(this);
        CPlus.addMouseListener(this);
        CMinus.addMouseListener(this);
        PPlus.addMouseListener(this);
        PMinus.addMouseListener(this);
        
      
  }




    public class HamburgerListener implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {

        }

    }



    public class CokeListener implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {


        }

    }



    public class PizzaListener implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {


        }

    }



    public class TotalListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


        }

    }





   
    public class MenuPanel1 extends JPanel {

        public MenuPanel1(String imagePath1, ActionListener listener) {

            this.setLayout(new BorderLayout());
            ImageIcon img = new ImageIcon("images/1.jpg");
            JLabel imageLabel1 = new JLabel(img);
            
            JLabel label = new JLabel(imagePath1);
            

            this.add(label, BorderLayout.CENTER);

            this.setBorder(new LineBorder(Color.BLACK));
            JLabel label1 = new JLabel(imagePath1);
            this.add(imageLabel1, BorderLayout.CENTER);


            JPanel buttonPanel = new JPanel();

            buttonPanel.add(HMinus);

            buttonPanel.add(HPlus);



            HMinus.addActionListener(listener);

            HPlus.addActionListener(listener);



            this.add(buttonPanel, BorderLayout.SOUTH);





        }

    }



    public class MenuPanel2 extends JPanel {



        public MenuPanel2(String imagePath2, ActionListener listener) {

            this.setLayout(new BorderLayout());
            ImageIcon img = new ImageIcon("images/2.jpg");
            JLabel imageLabel2 = new JLabel(img);
            JLabel label = new JLabel(imagePath2);

            this.add(imageLabel2, BorderLayout.CENTER);
            this.setBorder(new LineBorder(Color.BLACK));
            JLabel label2 = new JLabel(imagePath2);


            JPanel buttonPanel = new JPanel();
            buttonPanel.add(CMinus);
            buttonPanel.add(CPlus);


            CMinus.addActionListener(listener);
            CPlus.addActionListener(listener);



            this.add(buttonPanel, BorderLayout.SOUTH);

        }

    }





    public class MenuPanel3 extends JPanel {



        public MenuPanel3(String imagePath3, ActionListener listener) {
            this.setLayout(new BorderLayout());
            ImageIcon img = new ImageIcon("images/3.jpg");
            JLabel imageLabel3 = new JLabel(img);
            JLabel label = new JLabel(imagePath3);
           
            this.add(imageLabel3, BorderLayout.CENTER);
            this.setBorder(new LineBorder(Color.BLACK));



            JPanel buttonPanel = new JPanel();

            buttonPanel.add(PMinus);

            buttonPanel.add(PPlus);



            PMinus.addActionListener(listener);

            PPlus.addActionListener(listener);



            this.add(buttonPanel, BorderLayout.SOUTH);

        }

    }



   
    public class ListPanel extends JPanel {

        JPanel list = new JPanel(new GridLayout(2, 4));
        JTextField Total = new JTextField("total fee");
        JPanel BottomLabel = new JPanel(new BorderLayout());





        public ListPanel() {
        	
            this.setLayout(new BorderLayout());
            this.add(list, BorderLayout.CENTER);
            BottomLabel.add(Total, BorderLayout.EAST);
            this.add(BottomLabel, BorderLayout.SOUTH);



            list.setPreferredSize(new Dimension(100, 100));
            BottomLabel.setPreferredSize(new Dimension(50, 50));



            list.add(JL1);
            list.add(JL2);
            list.add(JL3);           
            list.add(j2);
            list.add(j3);
            list.add(j4);
      
            this.setVisible(true);


        }

    }



    public class InputPanel extends JPanel {

        JButton Purchase = new JButton("buy");
        


        public InputPanel() {

            this.setLayout(new BorderLayout());
            this.add(Purchase, BorderLayout.EAST);
            this.add(j1);

        }



    }


    public void mouseClicked(MouseEvent e) {

        

        
        if(e.getSource()==(JButton)HPlus){
               val = Integer.parseInt(j1.getText());	                
               val=val+3000;	              
               this.Num1=this.Num1+1;             
               j2.setText(String.valueOf(Num1));
               j1.setText(String.valueOf(val));
               }
        
        else if(e.getSource()==(JButton)HMinus){
               val = Integer.parseInt(j1.getText());	               
               val=val-3000;
               this.Num1=this.Num1-1;             
               j2.setText(String.valueOf(Num1));
               j1.setText(String.valueOf(val));
               }
        

        			else if(e.getSource()==(JButton)CPlus){
        			val = Integer.parseInt(j1.getText());
        			val=val+3500;
        			this.Num2=this.Num2+1;
        			j3.setText(String.valueOf(Num2));
        			j1.setText(String.valueOf(val));
        			}
        
        			else if(e.getSource()==(JButton)CMinus){
	          			val = Integer.parseInt(j1.getText());
	          			val=val-3500;
	          			this.Num2=this.Num2-1;
	          			j3.setText(String.valueOf(Num2));
	          			j1.setText(String.valueOf(val));
	          			}
        
        			else if(e.getSource()==(JButton)PPlus){
        			val = Integer.parseInt(j1.getText());
        			val=val+2500;
        			this.Num3=this.Num3+1;
        			j4.setText(String.valueOf(Num3));
        			j1.setText(String.valueOf(val));
                  }
        
        			else if(e.getSource()==(JButton)PMinus){
	          			val = Integer.parseInt(j1.getText());
	          			val=val-2500;
	          			this.Num3=this.Num3-1;
	          			j4.setText(String.valueOf(Num3));
	          			j1.setText(String.valueOf(val));
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



    public static void main(String args[]) {



        Project project = new Project();

        project.main();



    }



}
