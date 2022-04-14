/*          Deveolp By : Bushra Aboubida Ahmed          */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class Main extends JFrame {

    JScrollBar redScroller;
    JScrollBar greenScroller;
    JScrollBar blueScroller;
    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;
    JPanel selectedColorSquare;
    JLabel selectedColorValue;
    JButton about;

    public Main() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        setTitle("Color Picker");
        redLabel = new JLabel("Red");
        greenLabel = new JLabel("Green");
        blueLabel = new JLabel("Blue");
        redScroller = new JScrollBar(JScrollBar.HORIZONTAL, 127, 1, 0, 256);
        greenScroller = new JScrollBar(JScrollBar.HORIZONTAL, 127, 1, 0, 256);
        blueScroller = new JScrollBar(JScrollBar.HORIZONTAL, 127, 1, 0, 256);
        selectedColorSquare = new JPanel();
        selectedColorValue = new JLabel("Color: 127, 127, 127", JLabel.CENTER);
        about = new JButton("About");

        redLabel.setBounds(40, 40, 40, 25);
        greenLabel.setBounds(40, 80, 40, 25);
        blueLabel.setBounds(40, 120, 40, 25);
        redScroller.setBounds(100, 40, 300, 25);
        greenScroller.setBounds(100, 80, 300, 25);
        blueScroller.setBounds(100, 120, 300, 25);
        selectedColorSquare.setBounds(420, 40, 145, 80);
        selectedColorValue.setBounds(420, 125, 145, 25);
        about.setBounds(450, 170, 80, 25);

        redScroller.setBackground(Color.red);
        greenScroller.setBackground(Color.green);
        blueScroller.setBackground(Color.blue);
        selectedColorSquare.setBackground(new Color(127, 127, 127));

        add(redLabel);
        add(greenLabel);
        add(blueLabel);
        add(redScroller);
        add(greenScroller);
        add(blueScroller);
        add(selectedColorSquare);
        add(selectedColorValue);
        add(about);

        
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About().setVisible(true);
                //this.setVisible(false);
            }
            });
        
        AdjustmentListener al = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {

                Color c = new Color(redScroller.getValue(), greenScroller.getValue(), blueScroller.getValue());

                selectedColorSquare.setBackground(c);

                selectedColorValue.setText("Color: " + c.getRed() + ", " + c.getGreen() + ", " + c.getBlue());

            }
        };

        redScroller.addAdjustmentListener(al);
        greenScroller.addAdjustmentListener(al);
        blueScroller.addAdjustmentListener(al);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 240);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);

    }

           
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

}
