import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUIa
{
    JFrame frame;
    JButton butA;
    JButton butB;
    JLabel labA;

    public static void main(String[] args){
        SimpleGUIa gui = new SimpleGUIa();
        gui.go();
    }
    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labA = new JLabel("It's label");
        butA = new JButton("Change colors");
        butB = new JButton("Change label");
        butA.addActionListener(new ColorActionListener());
        butB.addActionListener(new LabelActionListener());
        myDrawPanel panelA = new myDrawPanel();

        frame.getContentPane().add(BorderLayout.WEST, labA);
        frame.getContentPane().add(BorderLayout.SOUTH, butA);
        frame.getContentPane().add(BorderLayout.EAST, butB);
        frame.getContentPane().add(BorderLayout.CENTER, panelA);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    class ColorActionListener implements ActionListener{            // inner class
        public void actionPerformed(ActionEvent event){             // ActionEvent handler
            frame.repaint();
        }
    }
    class LabelActionListener implements ActionListener{            // inner class
        public void actionPerformed(ActionEvent event){             // ActionEvent handler
            labA.setText("Ouch!!!");
        }
    }
}

class myDrawPanel extends JPanel
{
    public void paintComponent(Graphics g){
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        Color randomColor = new Color(red,green,blue);
        g.setColor(randomColor);
        g.fillOval(20,20,50,50);

        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(50,50,Color.blue, 80,80,Color.orange);
        g2d.setPaint(gradient);
        g2d.fillOval(50,50,50,50);
    }
}
