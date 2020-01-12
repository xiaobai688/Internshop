package lanseshuwu;

import javax.swing.*;
import java.awt.*;

public class BookStoreInformation extends JFrame{

        JPanel jp1,jp2,jp3,jp4,jp5;
        JLabel JL1,JL2,JL3,JL4,JL5;
        BookStoreInformation() {
            init();
            this.setTitle("书店信息");
            this.setBounds(900, 50, 550, 600);
            this.setVisible(true);
        }
        void init() {
            setLayout(new FlowLayout());
            JL1=new JLabel("    蓝色书屋内装饰风格典雅，设有雅座供读者阅");
            JL1.setFont(new Font("宋体",Font.BOLD,20));
            JL2=new JLabel("读，内有图书200册，虽不多，但各方面都有涉及。");
            JL2.setFont(new Font("宋体", Font.BOLD,20));
            JL3=new JLabel("联系电话：022*****81                       ");
            JL3.setFont(new Font("宋体",Font.BOLD,20));
            JL4=new JLabel("地址：江西省南昌市八一广场的百货大楼旁 ");
            JL4.setFont(new Font("宋体",Font.BOLD,20));
            JL5=new JLabel("营业时间：周一至周日 12:00-22：00     ");
            JL5.setFont(new Font("宋体",Font.BOLD,20));
            jp1=new JPanel();
            jp1.add(JL1);
            jp1.setBounds(0,0,150,30);
            add(jp1);
            jp2=new JPanel();
            jp2.add(JL2);
            jp2.setBounds(0,0,150,30);
            add(jp2);
            jp3=new JPanel();
            jp3.add(JL3);
            jp3.setBounds(0,0,150,30);
            add(jp3);
            jp4=new JPanel();
            jp4.add(JL4);
            jp4.setBounds(0,0,150,35);
            add(jp4);
            jp5=new JPanel();
            jp5.add(JL5);
            jp5.setBounds(0,0,150,35);
            add(jp5);
        }
}
