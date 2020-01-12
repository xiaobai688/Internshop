package lanseshuwu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuymenuListener1 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String st;
        st=BuyBook.Area1.getText()+"\n"+BuyBook.text1.getText();

        BuyBook.Area1.setFont(new Font("宋体", Font.BOLD,20));
        BuyBook.Area1.setText(st);
    }
}
