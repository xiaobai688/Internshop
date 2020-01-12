package lanseshuwu;

import javax.swing.*;
import java.awt.*;

public class ContactUs extends JFrame{
    JPanel jp1,jp2,jp3,jp4;
    JLabel JL1,JL2,JL3,JL4;
    ContactUs() {
        init();
        this.setTitle("关于我们");
        this.setBounds(950, 50, 530, 600);
        this.setVisible(true);
    }
    void init(){
        setLayout(new FlowLayout());
        JL1=new JLabel("如果您有什么问题，可以通过以下方式联系本店人员");
        JL1.setFont(new Font("宋体",Font.BOLD,20));
        JL2=new JLabel("手机号：188****9030                 ");
        JL2.setFont(new Font("宋体",Font.BOLD,20));
        JL3=new JLabel("QQ：396****32                       ");
        JL3.setFont(new Font("宋体",Font.BOLD,20));
        JL4=new JLabel("邮箱：396****32@qq.com              ");
        JL4.setFont(new Font("宋体",Font.BOLD,20));
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
    }
}
