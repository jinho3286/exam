import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import javax.swing.border.LineBorder;


public class Project1 extends JFrame {


    public void main() {


        //������ ����

        this.setSize(500, 500);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel NorthPanel = new JPanel(new BorderLayout());

        JPanel CenterPanel = new JPanel(new GridLayout(0, 3));

        JPanel SouthPanel = new JPanel(new BorderLayout());


// ��ܺ�


        JLabel Title = new JLabel("Vending Machine");


        Title.setFont(Title.getFont().deriveFont(20.0f));

        Title.setHorizontalAlignment(SwingConstants.CENTER);

        Title.setBounds(12, 10, 460, 29);

        this.getContentPane().add(Title);


        CenterPanel.add(new MenuPanel1("imagePath1"));
        CenterPanel.add(new MenuPanel2("imagePath2"));
        CenterPanel.add(new MenuPanel3("imagePath3"));


        SouthPanel.add(new ListPanel(), BorderLayout.CENTER);

        SouthPanel.add(new InputPanel(), BorderLayout.SOUTH);


        NorthPanel.setPreferredSize(new Dimension(50, 50));

        CenterPanel.setPreferredSize(new Dimension(250, 250));

        SouthPanel.setPreferredSize(new Dimension(150, 150));


        this.getContentPane().add(NorthPanel, BorderLayout.NORTH);             // ��ܺ�

        this.getContentPane().add(CenterPanel, BorderLayout.CENTER);

        this.getContentPane().add(SouthPanel, BorderLayout.SOUTH);          // �ϴܺκ�

        this.setVisible(true);

    }


    ///�ߴܺ�

    public class MenuPanel1 extends JPanel {

        JButton button1 = new JButton("buy");

        JButton button2 = new JButton("reduce");


        public MenuPanel1(String imagePath1) {


            ImageIcon img = new ImageIcon("images/1.jpg");
            JLabel imageLabel1 = new JLabel(img);


            this.setLayout(new BorderLayout());

            JLabel label1 = new JLabel(imagePath1);

            this.add(imageLabel1, BorderLayout.CENTER);

            this.setBorder(new LineBorder(Color.BLACK));


            JPanel buttonPanel = new JPanel();

            buttonPanel.add(button2);

            buttonPanel.add(button1);

            this.add(buttonPanel, BorderLayout.SOUTH);

        }
    }

    public class MenuPanel2 extends JPanel {

        JButton button1 = new JButton("buy");

        JButton button2 = new JButton("reduce");


        public MenuPanel2(String imagePath1) {
            ImageIcon img2 = new ImageIcon("images/2.jpg");
            JLabel imageLabel2 = new JLabel(img2);


            this.setLayout(new BorderLayout());

            JLabel label2 = new JLabel(imagePath1);


            this.add(imageLabel2, BorderLayout.CENTER);

            this.setBorder(new LineBorder(Color.BLACK));


            JPanel buttonPanel = new JPanel();

            buttonPanel.add(button2);

            buttonPanel.add(button1);

            this.add(buttonPanel, BorderLayout.SOUTH);

        }
    }

    public class MenuPanel3 extends JPanel {

        JButton button1 = new JButton("buy");

        JButton button2 = new JButton("reduce");


        public MenuPanel3(String imagePath1) {
            ImageIcon img3 = new ImageIcon("images/3.jpg");
            JLabel imageLabel3 = new JLabel(img3);


            this.setLayout(new BorderLayout());

            JLabel label3 = new JLabel(imagePath1);


            this.add(imageLabel3, BorderLayout.CENTER);

            this.setBorder(new LineBorder(Color.BLACK));


            JPanel buttonPanel = new JPanel();

            buttonPanel.add(button2);

            buttonPanel.add(button1);

            this.add(buttonPanel, BorderLayout.SOUTH);

        }


    }


    //�ϴ�

    public class ListPanel extends JPanel {

        JTextField List = new JTextField("contents");

        JTextField Total = new JTextField("total fee");

        JPanel BottomLabel = new JPanel(new BorderLayout());


        public ListPanel() {

            this.setLayout(new BorderLayout());

            this.add(List, BorderLayout.CENTER);

            BottomLabel.add(Total, BorderLayout.EAST);

            this.add(BottomLabel, BorderLayout.SOUTH);


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

