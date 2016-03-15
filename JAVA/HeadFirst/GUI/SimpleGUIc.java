import javax.swing.*;
import java.awt.*;

public class SimpleGUIc
{
    public static void main(String[] args){
        SimpleGUIc gui = new SimpleGUIc();
        gui.go();
    }
    public void go(){
        JFrame frame = new JFrame();                                // default layout_manager of frame is border
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));    // default layout_manager of panel is Flow, setLayout() alow panel change layout
        JButton butA = new JButton("shock me");
        JButton butB = new JButton("bliss");
        JButton butC = new JButton("huh???");
        panel.add(butA);
        panel.add(butB);
        panel.add(butC);

        frame.setContentPane(panel);                                // replace the layout manager of frame by overread frame with panel
//        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
