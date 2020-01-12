package lanseshuwu;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class BookStore extends JFrame {
    JPanel jp1,jp2;
    JLabel JL1,JL2;
    JTextArea Area;
    JButton b;
    BookStore() {
        init();
        this.setTitle("书店评价");
        this.setBounds(950, 50, 400, 600);
        this.setVisible(true);
    }
    void init() {
        setLayout(new FlowLayout());
        JL1=new JLabel("亲，请您对本店进行评价");
        JL1.setFont(new Font("宋体",Font.BOLD,30));
        jp1=new JPanel();
        jp1.add(JL1);
        jp1.setBounds(0, 0, 150, 30);
        add(jp1);
        Area=new JTextArea(2,25);
        add(Area);
        jp2=new JPanel();
        b=new JButton("提交");
        jp2.add(b);
        jp2.setBounds(0, 0, 150, 30);
        add(jp2);
    }
}
