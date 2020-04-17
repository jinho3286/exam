import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Project extends JFrame{

    public void main(){
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel northPanel = new JPanel(new GridLayout(0,3));
        northPanel.add(new MenuPanel("imagePath"));
        northPanel.add(new MenuPanel("imagePath"));
        northPanel.add(new MenuPanel("imagePath"));

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(northPanel,BorderLayout.NORTH);
        this.setVisible(true);
    }

    ///상단부
    public class MenuPanel extends JPanel {
        JButton button1= new JButton("+");
        JButton button2= new JButton("-");

        public MenuPanel(String imagePath) {
            this.setLayout(new BorderLayout());
            JLabel label= new JLabel(imagePath);
            this.add(label,BorderLayout.NORTH);
            this.setBorder(new LineBorder(Color.BLACK));

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(button2);
            buttonPanel.add(button1);
            this.add(buttonPanel,BorderLayout.SOUTH);
        }

    //중간
        public class statusPanel extends JPanel {
    JButton button3 = new JButton("입력");

    public statusPanel(){
        this.setLayout(new BorderLayout());
        JLabel current = new JLabel();
        this.add(current,BorderLayout.CENTER);
    }
    }






    //하단

    }



    public static void main(String args[]) {

        Project project = new Project();
        project.main();

    }

}

