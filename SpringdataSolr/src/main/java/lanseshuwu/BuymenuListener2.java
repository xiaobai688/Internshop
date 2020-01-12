package lanseshuwu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuymenuListener2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String s;
        double m;
        float t2,t3;
        t2=Float.parseFloat(BuyBook.text2.getText());
        t3=Float.parseFloat(BuyBook.text3.getText());
        m=t2*t3;
        s=m+"";
        BuyBook.Area2.setFont(new Font("宋体", Font.BOLD,20));
        BuyBook.Area2.setText(s);
    }
}
