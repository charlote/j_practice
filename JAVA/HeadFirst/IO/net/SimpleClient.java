import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class SimpleClient
{
    JFrame frame;
    JTextArea textAll;
    JTextField textMe;
    BufferedReader reader;
    PrintWriter writer;
    Socket soc;

    public static void main(String[] args){
        SimpleClient client = new SimpleClient();
        client.go();
    }
    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textAll = new JTextArea();
        textAll.setLineWrap(true);
        textAll.setWrapStyleWord(true);
        textAll.setEditable(false);
        JScrollPane scrAll = new JScrollPane(textAll);
        scrAll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrAll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel panel = new JPanel();
        textMe = new JTextField(15);
        JButton but = new JButton("send");
        but.addActionListener(new SendListener());
        panel.add(textMe);
        panel.add(but);

        Thread readerThread = new Thread(new textReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, scrAll);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setSize(300,500);
        frame.setVisible(true);

        setUpNetworking();
    }

    private class SendListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ev){
            String mesg = textMe.getText();
            textMe.setText("");
            writer.println(mesg);
        }
    }
    private class textReader implements Runnable
    {
        public void run(){
            String mesg;
            try{
                while((mesg = reader.readLine()) != null){
                    System.out.println("read " + mesg);
                    textAll.append(mesg);
                } 
            } catch(Exception ex){
                    ex.printStackTrace();
            }
        }
    }

    private void setUpNetworking(){
        try{
            soc = new Socket("127.0.0.1",4242);
            reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            writer = new PrintWriter(soc.getOutputStream());
            System.out.println("network build");
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
