package lanseshuwu;

import javax.swing.*;
import java.awt.*;

public class FictionBook extends JFrame {
    JPanel jp1,jp2,jp3,jp4,jp5;
    JPanel jp6,jp7,jp8,jp9,jp10;
    JPanel jp11,jp12,jp13,jp14,jp15;
    JPanel jp16,jp17,jp18,jp19,jp20;
    JLabel JL1,JL2,JL3,JL4,JL5;
    JLabel JL6,JL7,JL8,JL9,JL10;
    JLabel JL11,JL12,JL13,JL14,JL15;
    JLabel JL16,JL17,JL18,JL19,JL20;
    JRadioButton b1,b2,b3,b4,b5;
    JRadioButton b6,b7,b8,b9,b10;
    JRadioButton b11,b12,b13,b14,b15;
    JRadioButton b16,b17,b18,b19,b20;
    JRadioButton b21,b22,b23,b24,b25;
    JRadioButton b26,b27,b28,b29,b30;
    JRadioButton b31,b32,b33,b34,b35;
    JRadioButton b36,b37,b38,b39,b40;
    FictionBook() {
        this.setTitle("小说类");
        this.setBounds(900, 50, 770, 700);
        this.setVisible(true);
        init();

    }
    void init() {
        setLayout(new FlowLayout());
        JL1=new JLabel("      武林外传                   ");
        JL1.setFont(new Font("宋体",Font.BOLD,15));
        JL2=new JLabel("      斗罗大陆                   ");
        JL2.setFont(new Font("宋体",Font.BOLD,15));
        JL3=new JLabel("      摆渡人                      ");
        JL3.setFont(new Font("宋体",Font.BOLD,15));
        JL4=new JLabel("    荒莽纪                         ");
        JL4.setFont(new Font("宋体",Font.BOLD,15));
        JL5=new JLabel("       三国演义                 ");
        JL5.setFont(new Font("宋体",Font.BOLD,15));
        JL6=new JLabel("       西游记                    ");
        JL6.setFont(new Font("宋体",Font.BOLD,15));
        JL7=new JLabel("         心                        ");
        JL7.setFont(new Font("宋体",Font.BOLD,15));
        JL8=new JLabel("       隋唐演义                ");
        JL8.setFont(new Font("宋体",Font.BOLD,15));
        JL9=new JLabel("       使者                      ");
        JL9.setFont(new Font("宋体",Font.BOLD,15));
        JL10=new JLabel("       红楼梦              ");
        JL10.setFont(new Font("宋体",Font.BOLD,15));
        JL11=new JLabel("       水浒传                 ");
        JL11.setFont(new Font("宋体",Font.BOLD,15));
        JL12=new JLabel("         意林                     ");
        JL12.setFont(new Font("宋体",Font.BOLD,15));
        JL13=new JLabel("            大主宰                ");
        JL13.setFont(new Font("宋体",Font.BOLD,15));
        JL14=new JLabel("            一念永恒           ");
        JL14.setFont(new Font("宋体",Font.BOLD,15));
        JL15=new JLabel("            亮剑                ");
        JL15.setFont(new Font("宋体",Font.BOLD,15));
        b1=new JRadioButton("购买");
        b2=new JRadioButton("借阅");
        b3=new JRadioButton("购买");
        b4=new JRadioButton("借阅");
        b5=new JRadioButton("购买");
        b6=new JRadioButton("借阅");
        b7=new JRadioButton("购买");
        b8=new JRadioButton("借阅");
        b9=new JRadioButton("购买");
        b10=new JRadioButton("借阅");
        b11=new JRadioButton("购买");
        b12=new JRadioButton("借阅");
        b13=new JRadioButton("购买");
        b14=new JRadioButton("借阅");
        b15=new JRadioButton("购买");
        b16=new JRadioButton("借阅");
        b17=new JRadioButton("购买");
        b18=new JRadioButton("借阅");
        b19=new JRadioButton("购买");
        b20=new JRadioButton("借阅");
        b21=new JRadioButton("购买");
        b22=new JRadioButton("借阅");
        b23=new JRadioButton("购买");
        b24=new JRadioButton("借阅");
        b25=new JRadioButton("购买");
        b26=new JRadioButton("借阅");
        b27=new JRadioButton("购买");
        b28=new JRadioButton("借阅");
        b29=new JRadioButton("购买");
        b30=new JRadioButton("借阅");
        jp1=new JPanel();
        jp1.add(JL1);
        jp1.add(b1);
        jp1.add(b2);
        jp1.setBounds(0,0,150,20);
        add(jp1);
        jp2=new JPanel();
        jp2.add(JL2);
        jp2.add(b3);
        jp2.add(b4);
        jp2.setBounds(0,0,150,20);
        add(jp2);
        jp3=new JPanel();
        jp3.add(JL3);
        jp3.add(b5);
        jp3.add(b6);
        jp3.setBounds(0,0,150,20);
        add(jp3);
        jp4=new JPanel();
        jp4.add(JL4);
        jp4.add(b7);
        jp4.add(b8);
        jp4.setBounds(0,0,150,20);
        add(jp4);
        jp5=new JPanel();
        jp5.add(JL5);
        jp5.add(b9);
        jp5.add(b10);
        jp5.setBounds(0,0,150,20);
        add(jp5);
        jp6=new JPanel();
        jp6.add(JL6);
        jp6.add(b11);
        jp6.add(b12);
        jp6.setBounds(0,0,150,20);
        add(jp6);
        jp7=new JPanel();
        jp7.add(JL7);
        jp7.add(b13);
        jp7.add(b14);
        jp7.setBounds(0,0,150,20);
        add(jp7);
        jp8=new JPanel();
        jp8.add(JL8);
        jp8.add(b15);
        jp8.add(b16);
        jp8.setBounds(0,0,150,30);
        add(jp8);
        jp9=new JPanel();
        jp9.add(JL9);
        jp9.add(b17);
        jp9.add(b18);
        jp9.setBounds(0,0,150,30);
        add(jp9);
        jp10=new JPanel();
        jp10.add(JL10);
        jp10.add(b19);
        jp10.add(b20);
        jp10.setBounds(0,0,150,30);
        add(jp10);
        jp11=new JPanel();
        jp11.add(JL11);
        jp11.add(b21);
        jp11.add(b22);
        jp11.setBounds(0,0,150,30);
        add(jp11);
        jp12=new JPanel();
        jp12.add(JL12);
        jp12.add(b23);
        jp12.add(b24);
        jp12.setBounds(0,0,150,30);
        add(jp12);
        jp13=new JPanel();
        jp13.add(JL13);
        jp13.add(b25);
        jp13.add(b26);
        jp13.setBounds(0,0,150,30);
        add(jp13);
        jp14=new JPanel();
        jp14.add(JL14);
        jp14.add(b27);
        jp14.add(b28);
        jp14.setBounds(0,0,150,30);
        add(jp14);
        jp15=new JPanel();
        jp15.add(JL15);
        jp15.add(b29);
        jp15.add(b30);
        jp15.setBounds(0,0,150,30);
        add(jp15);
        add(jp20);
    }
}
