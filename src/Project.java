import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Project extends JFrame {
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

        //프레임 설정
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel NorthPanel = new JPanel(new BorderLayout());
        JPanel CenterPanel = new JPanel(new GridLayout(0, 3));
        JPanel SouthPanel = new JPanel(new BorderLayout());

// 상단부

        JLabel Title = new JLabel("Vending Machine");
        Title.setFont(Title.getFont().deriveFont(20.0f));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setBounds(12, 10, 460, 29);
        this.getContentPane().add(Title);

        NorthPanel.add(Title, BorderLayout.NORTH);

        CenterPanel.add(new MenuPanel1("imagePath", new HamburgerListener()));
        CenterPanel.add(new MenuPanel2("imagePath", new CokeListener()));
        CenterPanel.add(new MenuPanel3("imagePath", new PizzaListener()));

        SouthPanel.add(new ListPanel(), BorderLayout.CENTER);
        SouthPanel.add(new InputPanel(), BorderLayout.SOUTH);

        NorthPanel.setPreferredSize(new Dimension(50, 50));
        CenterPanel.setPreferredSize(new Dimension(250, 250));
        SouthPanel.setPreferredSize(new Dimension(150, 150));

        this.getContentPane().add(NorthPanel, BorderLayout.NORTH);             // 상단부
        this.getContentPane().add(CenterPanel, BorderLayout.CENTER);
        this.getContentPane().add(SouthPanel, BorderLayout.SOUTH);          // 하단부분
        this.setVisible(true);
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


    ///중단부
    public class MenuPanel1 extends JPanel {
        public MenuPanel1(String imagePath, ActionListener listener) {
            this.setLayout(new BorderLayout());
            JLabel label = new JLabel(imagePath);
            this.add(label, BorderLayout.CENTER);
            this.setBorder(new LineBorder(Color.BLACK));

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(HMinus);
            buttonPanel.add(HPlus);

            HMinus.addActionListener(listener);
            HPlus.addActionListener(listener);

            this.add(buttonPanel, BorderLayout.SOUTH);


        }
    }

    public class MenuPanel2 extends JPanel {

        public MenuPanel2(String imagePath, ActionListener listener) {
            this.setLayout(new BorderLayout());
            JLabel label = new JLabel(imagePath);
            this.add(label, BorderLayout.CENTER);
            this.setBorder(new LineBorder(Color.BLACK));

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(CMinus);
            buttonPanel.add(CPlus);

            CMinus.addActionListener(listener);
            CPlus.addActionListener(listener);

            this.add(buttonPanel, BorderLayout.SOUTH);
        }
    }


    public class MenuPanel3 extends JPanel {

        public MenuPanel3(String imagePath, ActionListener listener) {
            this.setLayout(new BorderLayout());
            JLabel label = new JLabel(imagePath);
            this.add(label, BorderLayout.CENTER);
            this.setBorder(new LineBorder(Color.BLACK));

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(PMinus);
            buttonPanel.add(PPlus);

            PMinus.addActionListener(listener);
            PPlus.addActionListener(listener);

            this.add(buttonPanel, BorderLayout.SOUTH);
        }
    }

    //하단
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
            list.add(j1);
            list.add(j2);
            list.add(j3);


            this.setVisible(true);


        }


    }


    public class InputPanel extends JPanel {
        JButton Purchase = new JButton("buy");
        JTextField Price = new JTextField("blabla");

        public InputPanel() {
            this.setLayout(new BorderLayout());
            this.add(Purchase, BorderLayout.EAST);
            this.add(Price, BorderLayout.CENTER);
        }

    }


    public static void main(String args[]) {

        Project project = new Project();
        project.main();

    }

}

