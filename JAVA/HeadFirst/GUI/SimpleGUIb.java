import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUIb
{
    JFrame frame;
    int x = 70;
    int y = 70;

    public static void main(String[] args){
        SimpleGUIb gui = new SimpleGUIb();
        gui.go();
    }
    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myDrawPanel panelA = new myDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, panelA);
        frame.setSize(300,300);
        frame.setVisible(true);

        for(int i=0;i<130;i++){
            x++;
            y++;
            panelA.repaint();
            try{
                Thread.sleep(50);
            } catch(Exception ex){}
        }
    }
    class myDrawPanel extends JPanel
    {
        public void paintComponent(Graphics g){
            //g.setColor(Color.blue);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            int red = (int)(Math.random()*256);
            int green = (int)(Math.random()*256);
            int blue = (int)(Math.random()*256);
            Color randomColor = new Color(red,green,blue);
            g.setColor(randomColor);
            g.fillOval(x,y,30,30);
        }
    }
}
