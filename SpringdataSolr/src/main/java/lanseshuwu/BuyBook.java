package lanseshuwu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyBook extends JFrame {
    static int BuyNumber;
    JPanel jp1;
    JPanel jp2;
    JPanel jp3;
    JPanel jp4;
    JPanel jp5;
    JPanel jp6;
    static JTextField text1;
    static JTextField text2;
    static JTextField text3;
    static JTextArea Area1,Area2;
    JButton b1,b2;
    BuymenuListener1 listener1;
    BuymenuListener2 listener2;
    BuyBook() {
        init();
        this.setTitle("购书信息");
        this.setBounds(900, 50, 400, 600);
        this.setVisible(true);
    }
    void init() {
        setLayout(new FlowLayout());
        listener1=new BuymenuListener1();
        listener2=new BuymenuListener2();
        jp1=new JPanel();
        jp1.add(new JLabel("所选书籍："));
        Area1=new JTextArea(5,20);
        jp1.add(Area1);
        jp1.setBounds(0,0,150,30);
        add(jp1);
        jp2=new JPanel();
        jp2.add(new JLabel("新增书籍："));
        text1=new JTextField(15);
        jp2.add(text1);
        b1=new JButton("添加");
        b1.addActionListener(listener1);
        jp2.add(b1);
        jp2.setBounds(0, 0, 150, 30);
        add(jp2);
        jp3=new JPanel();
        jp3.add(new JLabel("购书数量："));
        text2=new JTextField(15);
        jp3.add(text2);
        jp3.add(new JLabel("本              "));
        add(jp3);
        jp4=new JPanel();
        jp4.add(new JLabel("单价："));
        text3=new JTextField(14);
        jp4.add(text3);
        jp4.add(new JLabel("元"));
        jp4.setBounds(0, 0, 150, 30);
        add(jp4);
        jp5=new JPanel();
        b2=new JButton("提交");
        b2.addActionListener(listener2);
        jp5.add(b2);
        jp5.setBounds(0,100, 150, 30);
        add(jp5);
        jp6=new JPanel();
        jp6.add(new JLabel("总金额："));
        Area2=new JTextArea(1,22);
        jp6.add(Area2);
        jp6.setBounds(0, 0, 150, 30);
        add(jp6);

    }
}

