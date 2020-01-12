package lanseshuwu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalDetails extends JFrame implements ActionListener {
    JPanel jp1;
    JPanel jp2;
    JPanel jp3;
    JPanel jp4;
    JPanel jp5;
    JPanel jp6;
    JTextField text1;
    JTextField text2;
    JTextField text3;
    JRadioButton b1;
    JRadioButton b2;
    ButtonGroup group;
    JComboBox com;
    JButton b;
    JTextArea area;
    PersonalDetails(){
        init();
        this.setTitle("个人信息");
        this.setBounds(450, 50, 320, 600);
        this.setVisible(true);
    }
    void init() {
        setLayout(new FlowLayout());
        jp1=new JPanel();
        jp1.add(new JLabel("姓名："));
        text1=new JTextField(10);
        jp1.add(text1);
        jp1.setBounds(0, 0, 150, 30);
        add(jp1);
        jp2=new JPanel();
        jp2.add(new JLabel("性别："));
        b1=new JRadioButton("男");
        b2=new JRadioButton("女");
        group=new ButtonGroup();
        group.add(b1);
        group.add(b2);
        jp2.add(b1);
        jp2.add(b2);
        jp2.setBounds(0,0,150,30);
        add(jp2);
        jp3=new JPanel();
        jp3.add(new JLabel("学号："));
        text2=new JTextField(10);
        jp3.add(text2);
        jp3.setBounds(0, 0, 150, 30);
        add(jp3);
        jp4=new JPanel();
        jp4.add(new JLabel("院系："));
        com=new JComboBox();
        com.addItem("教育学院");
        com.addItem("会计学院");
        com.addItem("文传学院");
        com.addItem("信息学院");
        jp4.add(com);
        jp4.setBounds(0,0,150,30);
        add(jp4);
        jp5=new JPanel();
        jp5.add(new JLabel("班级："));
        text3=new JTextField(10);
        jp5.add(text3);
        jp5.setBounds(0, 0, 150, 30);
        b=new JButton("提交");
        b.addActionListener(this);
        jp5.add(b);
        add(jp5);
        jp6=new JPanel();
        area=new JTextArea(10,20);
        jp6.add(area);
        jp6.setBounds(0, 0, 150, 30);
        add(jp6);
    }
    public	void actionPerformed(ActionEvent e) {
        String s;
        s="姓名："+text1.getText()+"\n"+"性别：";
        if(b1.isSelected())
            s=s+b1.getText()+"\n"+"学号：";
        else
            s=s+b2.getText()+"\n"+"学号：";
        s=s+text2.getText()+"\n"+"院系："+com.getSelectedItem()+"\n"+"班级："+text3.getText();
        area.setFont(new Font("宋体",Font.BOLD,20));
        area.setText(s);
    }
}

