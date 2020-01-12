import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CloseHandler extends WindowAdapter {
    CloseHandler() {
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
