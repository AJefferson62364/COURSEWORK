package resources;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class quizzle extends JFrame implements ActionListener{
    JPanel panel;
    JPanel panelresult;
    JRadioButton choice1;
    JRadioButton choice2;
    JRadioButton choice3;
    JRadioButton choice4;
    ButtonGroup bg;
    JLabel questiondisplay;
    JButton btnext;
    String[][] questionanswers;
    String[][] questioncorrectanswer;
    int questionid;
    HashMap<Integer, String> map;

    quizzle(){
        initializedata();
        setTitle("Quiz Program");
        setSize(768,768);
        setLocation(890, 220);
        setResizable(false);
        Container cont=getContentPane();
        cont.setLayout(null);
        bg=new ButtonGroup();
        choice1=new JRadioButton("Choice1",true);
        choice2=new JRadioButton("Choice2",false);
        choice3=new JRadioButton("Choice3",false);
        choice4=new JRadioButton("Choice4",false);
        bg.add(choice1);
        bg.add(choice2);
        bg.add(choice3);
        bg.add(choice4);
        questiondisplay =new JLabel("Choose a correct anwswer");
        btnext=new JButton("Next");
        btnext.addActionListener(this);
        panel=new JPanel();
        panel.setSize(400,300);
        panel.setLocation(200, 200);
        panel.setLayout(new GridLayout(6,2));
        panel.add(questiondisplay);
        panel.add(choice1);
        panel.add(choice2);
        panel.add(choice3);
        panel.add(choice4);
        panel.add(btnext);
        cont.add(panel);
        setVisible(true);
        questionid =0;
        readqa(questionid);

    }

    public void actionPerformed(ActionEvent e){

        if(btnext.getText().equals("Next")){
            if(questionid <9){

                map.put(questionid,getSelection());
                questionid++;
                readqa(questionid);
            }
            else {
                map.put(questionid,getSelection());
                btnext.setText("Show answers");

            }
        }
        else if(btnext.getText().equals("Show answers"))
            new Report();


    }


    public void initializedata(){
        //qpa stores pairs of question and its possible answers
        questionanswers=new String[10][5];

        questionanswers[0][0]="Goku is a...?";
        questionanswers[0][1]="Human";
        questionanswers[0][2]="Saiyan";
        questionanswers[0][3]="Namekian";
        questionanswers[0][4]="Monkey";

        questionanswers[1][0]="Who is Goku's first rival?";
        questionanswers[1][1]="Krillin";
        questionanswers[1][2]="Yamcha";
        questionanswers[1][3]="Vegeta";
        questionanswers[1][4]="Beerus";

        questionanswers[2][0]="Who of the following is NOT a member or the Red Ribbon Army?";
        questionanswers[2][1]="Dr Gero";
        questionanswers[2][2]="General Blue";
        questionanswers[2][3]="Android 21";
        questionanswers[2][4]="Mercenary Tao";

        questionanswers[3][0]="Who is the most powerful character in Dragon Ball Z?";
        questionanswers[3][1]="Goku";
        questionanswers[3][2]="Kid Buu";
        questionanswers[3][3]="Vegeta";
        questionanswers[3][4]="Cell";

        questionanswers[4][0]="Which of these villains was in a movie AND the anime?";
        questionanswers[4][1]="Cooler";
        questionanswers[4][2]="Broly";
        questionanswers[4][3]="Garlic Jr";
        questionanswers[4][4]="Android 13.";

        questionanswers[5][0]="Which universe is Zamasu from?";
        questionanswers[5][1]="10";
        questionanswers[5][2]="6";
        questionanswers[5][3]="7";
        questionanswers[5][4]="11";

        questionanswers[6][0]="Whis and Vados are...?";
        questionanswers[6][1]="Dating";
        questionanswers[6][2]="Married";
        questionanswers[6][3]="Siblings";
        questionanswers[6][4]="Father and Daughter";

        questionanswers[7][0]="Which Super Saiyan form was NOT designed by Toriyama?";
        questionanswers[7][1]="Super Saiyan God";
        questionanswers[7][2]="Super Saiyan 3";
        questionanswers[7][3]="Super Saiyan Blue";
        questionanswers[7][4]="Super Saiyan 4";

        questionanswers[8][0]="Who joined Goku in his search for the Black Star Dragon Balls?";
        questionanswers[8][1]="Bulma and Oolong";
        questionanswers[8][2]="Trunks and Goten";
        questionanswers[8][3]="Tien and Chiaotzu";
        questionanswers[8][4]="Trunks and Pan";

        questionanswers[9][0]="Which character's name was pronounced incorrectly in the english dub of Xenoverse 2?";
        questionanswers[9][1]="Tien";
        questionanswers[9][2]="Champa";
        questionanswers[9][3]="Monaka";
        questionanswers[9][4]="Cooler";


        //qca stores pairs of question and its correct answer
        questioncorrectanswer=new String[10][2];

        questioncorrectanswer[0][0]="Goku is a...?";
        questioncorrectanswer[0][1]="Saiyan";

        questioncorrectanswer[1][0]="Who is Goku's first rival?";
        questioncorrectanswer[1][1]="Krillin";

        questioncorrectanswer[2][0]="Who of the following is NOT a member or the Red Ribbon Army?";
        questioncorrectanswer[2][1]="Mercenary Tao";

        questioncorrectanswer[3][0]="Who is the most powerful character in Dragon Ball Z?";
        questioncorrectanswer[3][1]="Kid Buu";

        questioncorrectanswer[4][0]="Which of these villains was in a movie AND the anime?";
        questioncorrectanswer[4][1]="Garlic Jr";

        questioncorrectanswer[5][0]="Which universe is Zamasu from?";
        questioncorrectanswer[5][1]="10";

        questioncorrectanswer[6][0]="Whis and Vados are...?";
        questioncorrectanswer[6][1]="Siblings";

        questioncorrectanswer[7][0]="Which Super Saiyan form was NOT designed by Toriyama?";
        questioncorrectanswer[7][1]="Super Saiyan 4";

        questioncorrectanswer[8][0]="Who joined Goku in his search for the Black Star Dragon Balls?";
        questioncorrectanswer[8][1]="Trunks and Pan";

        questioncorrectanswer[9][0]="Which character's name was pronounced incorrectly in the english dub of Xenoverse 2?";
        questioncorrectanswer[9][1]="Monaka";


        //create a map object to store pairs of question and selected answer
        map=new HashMap<Integer, String>();

    }

    public String getSelection(){
        String selectedChoice=null;
        Enumeration<AbstractButton> buttons=bg.getElements();
        while(buttons.hasMoreElements())
        {
            JRadioButton temp=(JRadioButton)buttons.nextElement();
            if(temp.isSelected())
            {
                selectedChoice=temp.getText();
            }
        }
        return(selectedChoice);
    }

    public void readqa(int qid){
        questiondisplay.setText("  "+questionanswers[qid][0]);
        choice1.setText(questionanswers[qid][1]);
        choice2.setText(questionanswers[qid][2]);
        choice3.setText(questionanswers[qid][3]);
        choice4.setText(questionanswers[qid][4]);
        choice1.setSelected(true);
    }

    public void reset(){
        questionid =0;
        map.clear();
        readqa(questionid);
        btnext.setText("Next");
    }

    public int calCorrectAnswer(){
        int qnum=10;
        int count=0;
        for(int qid=0;qid<qnum;qid++)
            if(questioncorrectanswer[qid][1].equals(map.get(qid))) count++;
        return count;
    }

    public class Report extends JFrame{
        Report(){
            setTitle("Answers");
            setSize(850,550);
            addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    dispose();
                    reset();
                }
            });
            Draw d=new Draw();
            add(d);
            setVisible(true);
        }

        class Draw extends Canvas{
            public void paint(Graphics g){
                int qnum=10;
                int x=10;
                int y=20;
                for(int i=0;i<qnum;i++){
                    //print the 1st column
                    g.drawString(i+1+". "+questioncorrectanswer[i][0], x,y);
                    y+=30;
                    g.drawString("      Correct answer:"+questioncorrectanswer[i][1], x,y);
                    y+=30;
                    g.drawString("      Your answer:"+map.get(i), x,y);
                    y+=30;
                    //print the 2nd column
                    if(y>400)
                    {y=20;
                        x=450;
                    }

                }
                //Show number of correct answers
                int numc=calCorrectAnswer();
                g.drawString("Number of correct answers:"+numc,300,500);


            }
        }

    }




}





