import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class QuizCardPlayer
{
    private JFrame frame;
    private JTextArea text;
    private JButton but;
    private ArrayList<QuizCard> cardlist;
    private QuizCard currentCard;
    private int currentindex = 0;
    private boolean isShowAns = false;
    private boolean isRestart = false;


    public static void main(String[] args){
        QuizCardPlayer player = new QuizCardPlayer();
        player.go();
    }

    // GUI
    public void go(){
        cardlist = new ArrayList<QuizCard>();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menubar= new JMenuBar();
        JMenu fMenu = new JMenu("File");
        JMenuItem openMenu = new JMenuItem("Open");
        openMenu.addActionListener(new OpenMenuListener());
        fMenu.add(openMenu);
        menubar.add(fMenu);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        text = new JTextArea(5,20);
        text.setLineWrap(true);
        JScrollPane scr = new JScrollPane(text);
        scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scr.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        but = new JButton("no card");
        but.setEnabled(false);
        but.addActionListener(new NextListener());
        panel.add(scr);
        panel.add(but);

        frame.setJMenuBar(menubar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300,500);
        frame.setVisible(true);
    }

    private class OpenMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            JFileChooser fileopen = new JFileChooser();
            fileopen.showOpenDialog(frame);
            loadFile(fileopen.getSelectedFile());
            showNextCard();
        }
    }
    private class NextListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            if(isRestart){
                currentindex = 0;
                isRestart = false;
                showNextCard();
            } else {
                if(isShowAns){
                    text.setText(currentCard.getAns());
                    but.setText("next card");
                    isShowAns = false; 
                } else {
                    if(currentindex < cardlist.size()){
                        showNextCard();
                    } else {
                        text.setText("the last card");
                        but.setText("restart?");
                        isRestart = true;
                    }
                }
            }
        }
    }
    
    private void loadFile(File f){
        try{
            cardlist.clear();
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = reader.readLine()) != null){
                makeCard(line);
            }
            reader.close();
        } catch(Exception ex){
            System.out.println("can't load file");
            ex.printStackTrace();
        }
        currentindex = 0;
        but.setEnabled(true);
        showNextCard();
    }
    private void makeCard(String l){
        String[] result = l.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardlist.add(card);
        System.out.println("create a card");
    }
    private void showNextCard(){
        currentCard = cardlist.get(currentindex);
        currentindex++;
        text.setText(currentCard.getQuiz());
        but.setText("show answer");
        isShowAns = true;
    }

}
