import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EquationFrame extends Frame implements ActionListener {
    SquareEquation equation;

    TextField textA,textB,textC;
    TextArea showRoots;
    Button controlButton;
    public EquationFrame() {

        equation = new SquareEquation();

        textA = new TextField(8);
        textB = new TextField(8);
        textC = new TextField(8);

        showRoots = new TextArea();

        controlButton = new Button("确定");

        Panel pNorth = new Panel();

        pNorth.add(new Label("二次项系数:"));
        pNorth.add(textA);
        pNorth.add(new Label("一次项系数:"));
        pNorth.add(textB);
        pNorth.add(new Label("常数项系数:"));
        pNorth.add(textC);

        controlButton.addActionListener(this);

        pNorth.add(controlButton);

        add(pNorth, BorderLayout.NORTH);
        add(showRoots, BorderLayout.CENTER);
        setBounds(100, 100, 630, 160);
        setVisible(true);
        validate();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
                try{
                    double a=Double.parseDouble(textA.getText());//textAiB)A5 izSE8XA
                    double b=Double.parseDouble(textB.getText() );//textBj8A ;zEBSX2
                    double c=Double.parseDouble(textC.getText());//)A5 itEXTBJX4l
                    equation.setA(a);
                    equation.setB(b);
                    equation.setC(c);
                    textA.setText(""+a);
                    textB.setText(""+b);
                    textC.setText(""+c);
                    showRoots.append("\n根:"+equation.getRootOne());
                    showRoots.append("根: "+equation.getRootTwo());
                }catch(Exception ex) {
                    showRoots.append("\n" + ex + "\n");
                } catch (NoRealRootException ex) {
                    ex.printStackTrace();
                } catch (NoSquareEquationException ex) {
                    ex.printStackTrace();
                }
    }
}