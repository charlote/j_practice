import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class QuizCardBuilder
{
    private JFrame frame;
    private JTextArea textQue, textAns;
    private ArrayList<QuizCard> cardlist;


    public static void main(String[] args){
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }

    // GUI
    public void go(){
        cardlist = new ArrayList<QuizCard>();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menubar= new JMenuBar();
        JMenu fMenu = new JMenu("File");
        JMenuItem newMenu = new JMenuItem("New");
        newMenu.addActionListener(new NewMenuListener());
        JMenuItem saveMenu = new JMenuItem("Save");
        saveMenu.addActionListener(new SaveMenuListener());
        fMenu.add(newMenu);
        fMenu.add(saveMenu);
        menubar.add(fMenu);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel labA = new JLabel("Question:");
        textQue = new JTextArea(5,20);
        textQue.setLineWrap(true);
        JScrollPane scrQue = new JScrollPane(textQue);
        scrQue.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrQue.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JLabel labB = new JLabel("Answer:");
        textAns = new JTextArea(5,20);
        textAns.setLineWrap(true);
        JScrollPane scrAns = new JScrollPane(textAns);
        scrAns.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrAns.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JButton but = new JButton("Next Card");
        but.addActionListener(new NextListener());
        panel.add(labA);
        panel.add(scrQue);
        panel.add(labB);
        panel.add(scrAns);
        panel.add(but);

        frame.setJMenuBar(menubar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300,500);
        frame.setVisible(true);
    }

    private class NewMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            cardlist.clear();
            clearCard();
        }
    }
    private class SaveMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            QuizCard card = new QuizCard(textQue.getText(), textAns.getText());
            cardlist.add(card);
            JFileChooser fSave = new JFileChooser();
            fSave.showSaveDialog(frame);
            saveFile(fSave.getSelectedFile());
        }
    }
    private class NextListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            QuizCard card = new QuizCard(textQue.getText(), textAns.getText());
            cardlist.add(card);
            clearCard();
        }
    }
    
    private void clearCard(){
        textQue.setText("");
        textAns.setText("");
        textQue.requestFocus();
    }
    private void saveFile(File f){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            for(QuizCard card:cardlist){
                writer.write(card.getQuiz() + "/");
                writer.write(card.getAns() + "\n");
            }
            writer.close();
        } catch(IOException ex){
            System.out.println("couldn't write out");
            ex.printStackTrace();
        }
    }

}
