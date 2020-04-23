
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements MouseListener{


    int [] unit= {50000,10000,1000,500,100,50,10,1};
    String[] str= {"금액","오만원","만원","천원","500원","100원","50원","10원","1원"};
    JLabel la=new JLabel();
    JTextField tf=new JTextField(9);
    JButton btn=new JButton("계산");
    Container c=getContentPane();
    public static int Num1 = 0;
    public static int Num2 = 0;
    public static int Num3 = 0;
    public int gap=5;
    public int val = 0,k3value;
    public int input=0;
    public JTextField j1 = new JTextField("0");
    public JTextField j2 = new JTextField("0");
    public JTextField j3 = new JTextField("0");
    public JTextField j4 = new JTextField("0");
    public JTextField j5 = new JTextField("0");
    public JTextField e1=new JTextField("");
    public JLabel JL1 = new JLabel("Modongsoop amount");
    public JLabel JL2 = new JLabel("StarCubby amount");
    public JLabel JL3 = new JLabel("Super Mario amount");

    public JButton HPlus = new JButton("+");
    public JButton HMinus = new JButton("-");
    public JButton CPlus = new JButton("+");
    public JButton CMinus = new JButton("-");
    public JButton PPlus = new JButton("+");
    public JButton PMinus = new JButton("-");

    JButton Purchase = new JButton("buy");
    JLabel 금액=new JLabel("투입금액");

    public void main() {

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon img1 = new ImageIcon("images/9.jpg");
        this.setIconImage(img1.getImage());


        JPanel NorthPanel = new JPanel(new BorderLayout());
        JPanel CenterPanel = new JPanel(new GridLayout(0, 3));
        JPanel SouthPanel = new JPanel(new BorderLayout());

        JLabel Title = new JLabel("Vending Machine");
        Title.setFont(Title.getFont().deriveFont(20.0f));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setBounds(12, 10, 460, 29);
        this.getContentPane().add(Title);

        NorthPanel.add(Title, BorderLayout.NORTH);

        CenterPanel.add(new MenuPanel1());
        CenterPanel.add(new MenuPanel2());
        CenterPanel.add(new MenuPanel3());

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

    public class MenuPanel1 extends JPanel {

        public MenuPanel1() {

            this.setLayout(new BorderLayout());
            ImageIcon img = new ImageIcon("images/1.1.jpg");
            JLabel imageLabel1 = new JLabel(img);

            JPanel buttonPanel = new JPanel();

            JLabel label1 = new JLabel();
            JLabel much1 = new JLabel("63504원");
            label1.setLayout(new BorderLayout());
            label1.add(imageLabel1, BorderLayout.CENTER);
            label1.add(much1,BorderLayout.SOUTH);
            much1.setHorizontalAlignment(SwingConstants.CENTER);

            this.add(label1, BorderLayout.CENTER);
            this.setBorder(new LineBorder(Color.BLACK));

            buttonPanel.add(HMinus);
            buttonPanel.add(HPlus);

            this.add(buttonPanel, BorderLayout.SOUTH);

        }

    }

    public class MenuPanel2 extends JPanel {

        public MenuPanel2() {

            this.setLayout(new BorderLayout());
            ImageIcon img = new ImageIcon("images/2.2.jpg");
            img.getIconWidth();
            JLabel imageLabel2 = new JLabel(img);

            this.setBorder(new LineBorder(Color.BLACK));

            JLabel label2 = new JLabel();
            JLabel much2 = new JLabel("16980원");
            label2.setLayout(new BorderLayout());
            label2.add(imageLabel2, BorderLayout.CENTER);
            label2.add(much2,BorderLayout.SOUTH);
            much2.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(label2, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(CMinus);
            buttonPanel.add(CPlus);

            this.add(buttonPanel, BorderLayout.SOUTH);

        }

    }

    public class MenuPanel3 extends JPanel {


        public MenuPanel3() {
            this.setLayout(new BorderLayout());
            ImageIcon img = new ImageIcon("images/3.3.jpg");
            JLabel imageLabel3 = new JLabel(img);
            JPanel buttonPanel = new JPanel();

            this.setBorder(new LineBorder(Color.BLACK));

            JLabel label3 = new JLabel();
            JLabel much3 = new JLabel("52390원");
            label3.setLayout(new BorderLayout());
            label3.add(imageLabel3, BorderLayout.CENTER);
            label3.add(much3,BorderLayout.SOUTH);
            much3.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(label3, BorderLayout.CENTER);

            buttonPanel.add(PMinus);
            buttonPanel.add(PPlus);

            this.add(buttonPanel, BorderLayout.SOUTH);

        }

    }


    public class ListPanel extends JPanel {

        JPanel list = new JPanel(new GridLayout(2, 3));
        JPanel Total = new JPanel();
        JPanel BottomLabel = new JPanel(new BorderLayout());
        public ListPanel() {

            this.setLayout(new BorderLayout());
            this.add(list, BorderLayout.CENTER);
            BottomLabel.add(j1, BorderLayout.CENTER);
            this.add(BottomLabel, BorderLayout.SOUTH);

            list.setPreferredSize(new Dimension(100, 100));
            BottomLabel.setPreferredSize(new Dimension(50, 50));


            list.add(JL1);
            list.add(JL2);
            list.add(JL3);
            list.add(j2);
            list.add(j3);
            list.add(j4);
            JOptionPane.showMessageDialog(null,"수량을 다 선택한 뒤 투입금액을 입력하고 buy를 눌러주세요");
            this.setVisible(true);

        }

    }

    public void mouseClicked(MouseEvent e) {



        if(e.getSource()==(JButton)HPlus){
            val = Integer.parseInt(j1.getText());
            val=val+63504;
            this.Num1=this.Num1+1;
            j2.setText(String.valueOf(Num1));
            j1.setText(String.valueOf(val));
        }

        else if(e.getSource()==(JButton)HMinus && Num1>=1){
            val = Integer.parseInt(j1.getText());
            val=val-63504;
            this.Num1=this.Num1-1;

            j2.setText(String.valueOf(Num1));
            j1.setText(String.valueOf(val));


        }



        else if(e.getSource()==(JButton)CPlus){
            val = Integer.parseInt(j1.getText());
            val=val+16980;
            this.Num2=this.Num2+1;
            j3.setText(String.valueOf(Num2));
            j1.setText(String.valueOf(val));
        }

        else if(e.getSource()==(JButton)CMinus && Num2>=1){
            val = Integer.parseInt(j1.getText());
            val=val-16980;
            this.Num2=this.Num2-1;
            j3.setText(String.valueOf(Num2));
            j1.setText(String.valueOf(val));
        }

        else if(e.getSource()==(JButton)PPlus){
            val = Integer.parseInt(j1.getText());
            val=val+52390;
            this.Num3=this.Num3+1;
            j4.setText(String.valueOf(Num3));
            j1.setText(String.valueOf(val));
        }

        else if(e.getSource()==(JButton)PMinus && Num3>=1){
            val = Integer.parseInt(j1.getText());
            val=val-52390;
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

    public class InputPanel extends JPanel {

        JButton Purchase = new JButton("buy");
        JLabel 금액=new JLabel("                    투입금액:");
        JPanel list2 = new JPanel(new GridLayout(1, 3));

        JTextField e1=new JTextField("");
        public InputPanel() {

            this.add(list2, BorderLayout.CENTER);

            list2.add(금액);
            list2.add(e1);
            list2.add(Purchase);

            list2.setPreferredSize(new Dimension(400, 30));

            Purchase.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    input=Integer.parseInt(j1.getText());
                    if(input==0)
                        return;

                    int m;
                    int a,b,c,d,k,f,g,h,i,j;
                    int an=0,bn=0,cn=0,dn=0,kn=0,fn=0,gn=0,hn=0,in=0,jn=0;
                    k3value=Integer.parseInt(e1.getText());
                    k3value-=val;
                    int money=k3value;

                    while(money>=50000) {
                        money-=50000;
                        an++;
                    }
                    while(money>=10000) {
                        money-=10000;
                        bn++;
                    }
                    while(money>=1000) {
                        money-=1000;
                        cn++;
                    }
                    while(money>=500) {
                        money=money-500;
                        dn++;
                    }
                    while(money>=100) {
                        money=money-100;
                        kn++;
                    }
                    while(money>=50) {
                        money=money-50;
                        fn++;
                    }
                    while(money>=10) {
                        money=money-10;
                        gn++;
                    }
                    while(money>=1) {
                        money=money-1;
                        hn++;
                    }


                    JOptionPane.showMessageDialog( null,"잔돈은"+k3value+"원"+"\n50000원은: "+an+"장\n"+"10000원은: "
                            +bn+"장\n"+"1000원은:   "+cn+"장\n"+"500원은:     "+dn+"장\n"+"100원은:     "+kn+"장\n"+"50원은:       "
                            +fn+"장\n"+"10원은:       "+gn+"장\n"+"1원은:         "+hn+"장\n","",JOptionPane.PLAIN_MESSAGE);

                }
            });

        }



    }
    public static void main(String args[]) {



        Project project = new Project();

        project.main();



    }


}

