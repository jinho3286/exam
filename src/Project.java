import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class Project extends JFrame{
    public static int ham=0;
    public static int coke=0;
    public static int pizza=0;


    public void main(){

        //프레임 설정
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel NorthPanel = new JPanel(new BorderLayout());
        JPanel CenterPanel = new JPanel(new GridLayout(0,3));
        JPanel SouthPanel = new JPanel(new BorderLayout());

// 상단부

        JLabel Title = new JLabel("Vending Machine");
        Title.setFont(Title.getFont().deriveFont(20.0f));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setBounds(12, 10, 460, 29);
        this.getContentPane().add(Title);

        NorthPanel.add(Title,BorderLayout.NORTH);

        CenterPanel.add(new MenuPanel("imagePath", new HamburgerListener()));
        CenterPanel.add(new MenuPanel("imagePath", new CokeListener()));
        CenterPanel.add(new MenuPanel("imagePath", new PizzaListener()));

        SouthPanel.add(new ListPanel(),BorderLayout.CENTER);
        SouthPanel.add(new InputPanel(),BorderLayout.SOUTH);

        NorthPanel.setPreferredSize(new Dimension(50,50));
        CenterPanel.setPreferredSize(new Dimension(250,250));
        SouthPanel.setPreferredSize(new Dimension(150,150));

        this.getContentPane().add(NorthPanel,BorderLayout.NORTH);             // 상단부
        this.getContentPane().add(CenterPanel,BorderLayout.CENTER);
        this.getContentPane().add(SouthPanel,BorderLayout.SOUTH);          // 하단부분
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
            if(e.getActionCommand().equals("reduce")) {
                System.out.println("Coke --");
            } else {
                System.out.println("Coke ++");
            }
        }
    }

    public class PizzaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("reduce")) {
                System.out.println("Pizza --");
            } else {
                System.out.println("Pizza ++");
            }
        }
    }



    ///중단부
    public class MenuPanel extends JPanel {
        JButton button1 = new JButton("buy");
        JButton button2 = new JButton("reduce");

        public MenuPanel(String imagePath, ActionListener listener) {
            this.setLayout(new BorderLayout());
            JLabel label = new JLabel(imagePath);
            this.add(label, BorderLayout.CENTER);
            this.setBorder(new LineBorder(Color.BLACK));

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(button2);
            buttonPanel.add(button1);

            button1.addActionListener(listener);
            button2.addActionListener(listener);

            this.add(buttonPanel, BorderLayout.SOUTH);
        }
    }


    //하단
public class ListPanel extends JPanel{
        JTextField List = new JTextField("contents");
        JTextField Total = new JTextField("total fee");
        JPanel BottomLabel = new JPanel(new BorderLayout());

        public ListPanel() {
            this.setLayout(new BorderLayout());
            this.add(List,BorderLayout.CENTER);
           BottomLabel.add(Total,BorderLayout.EAST);
            this.add(BottomLabel,BorderLayout.SOUTH);

        }
    }


    public class InputPanel extends  JPanel {
        JButton Purchase = new JButton("buy");
        JTextField Price = new JTextField("blabla");

        public InputPanel(){
            this.setLayout(new BorderLayout());
            this.add(Purchase,BorderLayout.EAST);
            this.add(Price,BorderLayout.CENTER);
        }
    }














    public static void main(String args[]) {

        Project project = new Project();
        project.main();

    }

}

