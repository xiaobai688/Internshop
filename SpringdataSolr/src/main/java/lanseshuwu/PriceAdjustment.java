package lanseshuwu;

import javax.swing.*;
import java.awt.*;

public class PriceAdjustment extends JFrame {
    JPanel jp1,jp2,jp3,jp4,jp5;
    JLabel JL1,JL2,JL3,JL4,JL5;
    PriceAdjustment() {
        init();
        this.setTitle("价格调整通知");
        this.setBounds(950, 50, 400, 600);
        this.setVisible(true);
    }
    void init(){
        setLayout(new FlowLayout());
        JL1=new JLabel("通知");
        JL1.setFont(new Font("宋体",Font.BOLD,40));
        JL2=new JLabel("由于暑假的到来，本店决定：");
        JL2.setFont(new Font("宋体",Font.BOLD,20));
        JL3=new JLabel("在2019年6月29日到2019年9月2日内，");
        JL3.setFont(new Font("宋体",Font.BOLD,20));
        JL4=new JLabel("凡在本店购买书本，一律8折，再送精 ");
        JL4.setFont(new Font("宋体",Font.BOLD,20));
        JL5=new JLabel("美礼品一份。                     ");
        JL5.setFont(new Font("宋体", Font.BOLD,20));
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
        jp4.setBounds(0,0,150,30);
        add(jp4);
        jp5=new JPanel();
        jp5.add(JL5);
        jp5.setBounds(0,0,150,30);
        add(jp5);
    }
}

