# Project


### 기본패널 만들기
---
* 기본 `Frame`에 `Pane`,`Panel`을 덧대어 원하는 레이아웃을 꾸며 보았다. (상세한 부분은 생략)

```
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
   ```
   
   ### Button 만들기
   ---
   * `MouseListener` 기능을 Implement하여 `mouseClicked` 메소드를 수정하였다. 
   
   ```
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
 ```
 
  ### 잔돈계산
 ---
  * 이벤트 창에 잔돈을 표기한다. **Greedy Algorithm** 을 기반으로 ,**큰 단위의 지폐**가 우선적으로 나올 수 있게끔  코드를 구성하였다. 
    (Greedy 이기 떄문에 잔돈 지폐 수가 최소가 되지 않을 수 있다.  다음번엔 동적계산 알고리즘을 시도해봐야겠다.)
    
 ```
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

 ```
    
    
    
### 결과물
---
    
![결과물](https://user-images.githubusercontent.com/62733838/80172629-72bca180-8628-11ea-911e-228dc731d40f.JPG)

    
    
    
    
### 소감
---  
    
* 전진호
 SWING에 대해 지식이 전무했었는데, 처음이라 시간은 오래걸렸지만 정말 편리하고 재미있는 기능이라는 것을 알게되었다.
 앞으로는 좀 더 자신있게 더 많은 프로젝트를 할 수 있을 것 같다는 생각이 들었다. 그리고 이번 기회를 통해 조금이나마
 Git으로 팀원들간에 코드를 공유하고 병합,수정하는 과정들을 배울 수 있던 것도 너무 좋았다.
    
* 정승훈
 그리디 알고리즘이란 것을 처음 보고 배우면서 처음엔 막막했지만, 팀원들과 함께 프로젝트를 만드면서 조금 더 쉽게 이해가
 되었고, 처음하는 SWING도 하다보니 신기하고 재밌었다. 그리고 GIT이라는 새로운 기능을 통해 팀원들과 함께 더 손쉬운
 프로젝트를 공유하고 수정하는 법도 배워 많은 것을 배운 것같다.
* 장석빈
SWING으로 팀프로젝트를 한다 했을때 자바도 잘모르고 스윙도 처음 들어봐가지고 팀 프로젝트를 하는데 민폐가 되지 않을까
생각했는데 직접 공부해보고 팀원들간 코드를 공부해보면서 스윙에 대한 지식도 늘었고 팀 프로젝트도 잘 할 수 있다는
자신감을 얻게 되었고 무엇보다도 Git에서 수정,병합 할 수 있는 많은 것들을 배울 수 있는게 제일 좋았다.  

 
