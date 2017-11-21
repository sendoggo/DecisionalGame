
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francesco
 */
public class GameUI extends javax.swing.JPanel {

    /**
     * Creates new form GameUI
     */
    private static QuestionStruct [] test;
    private static int index = 0;
    public GameUI() {
        initComponents();
        
        popPB.setValue(50);
        earnPB.setValue(50);
        jLabel3.setText("50");
        jLabel4.setText("50");
        
        
        SimpleAttributeSet attribs = new SimpleAttributeSet(); 
        StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_CENTER);
        questionTF.setParagraphAttributes(attribs,true);
        answer1.setParagraphAttributes(attribs,true);
        answer2.setParagraphAttributes(attribs,true);
        
        
        
        questionTF.setText(test[0].getQuestion());
        answer1.setText(test[0].getAnswer1());
        answer2.setText(test[0].getAnswer2());
        
        answer1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(index == 10){
            
            JOptionPane.showMessageDialog(null, "Game finished");
            System.exit(0);
        }
        
        int temp, temp2;
        temp = popPB.getValue()+(test[index].getAnswer1points()[0]);
        temp2 = earnPB.getValue()+(test[index].getAnswer1points()[1]);
        if(temp >= 0 && temp <= 100 && temp2 >= 0 && temp2 <= 100){
            popPB.setValue(temp);
            earnPB.setValue(temp2);
            jLabel3.setText(String.valueOf(temp));
            jLabel4.setText(String.valueOf(temp2));
            index++;
            if(index < 10){
            questionTF.setText(test[index].getQuestion());
            answer1.setText(test[index].getAnswer1());
            answer2.setText(test[index].getAnswer2());
            }
        }
        else{
            popPB.setValue(temp);
            earnPB.setValue(temp2);
            
            
            JOptionPane.showMessageDialog(null, "Game Failed");
            System.exit(0);
        }
            }
        });
        
        answer2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(index == 10){
            
            
            JOptionPane.showMessageDialog(null, "Game finished");
            System.exit(0);
        }
        
        int temp = 0, temp2 = 0;
        if(index < 10){
        temp = (popPB.getValue()+(test[index].getAnswer2points()[0]));
        temp2 = earnPB.getValue()+(test[index].getAnswer2points()[1]);
        }
        if(temp >= 0 && temp <= 100 && temp2 >= 0 && temp2 <= 100){
            popPB.setValue(temp);
            earnPB.setValue(temp2);
            jLabel3.setText(String.valueOf(temp));
            jLabel4.setText(String.valueOf(temp2));
            index++;
            if(index < 10){
            questionTF.setText(test[index].getQuestion());
            answer1.setText(test[index].getAnswer1());
            answer2.setText(test[index].getAnswer2());
            }
        }
        else{
            popPB.setValue(temp);
            earnPB.setValue(temp2);
            
            
            
            JOptionPane.showMessageDialog(null, "Game Failed");
            System.exit(0);
        }
        }
        });
        test = new QuestionStruct[10];
        for(int i = 0; i<10; i++){
            test[i] = new QuestionStruct();
        }
        test[0].setQuestion("Employees are complaining of sore backs in the work place due to old seats.");
        test[0].setAnswer1("Invest in new seats");
        test[0].setAnswer2("Ignore the complaints");
        test[0].setAnswer1points(10, -10);
        test[0].setAnswer2points(15, 0);
        
        test[1].setQuestion("Company profits are running low due to unpredicted drops in the market. You need to make a decision to improve company finances and minimize the deficit.");
        test[1].setAnswer1("Cut the hours of workers a minimal amount, reducing what we spend.");
        test[1].setAnswer2("Fire two employees. We'll be much better off with less people to pay.");
        test[1].setAnswer1points(-10, 10);
        test[1].setAnswer2points(-30, 30);
        
        test[2].setQuestion("You have been receiving reports of office workers leaving rubbish at their desk how would you proceed. ");
        test[2].setAnswer1("Give the worker a warning about not keeping their desk up to standards");
        test[2].setAnswer2("Give the cleaner more hours so they can Allocate more time to cleaning that side of the office");
        test[2].setAnswer1points(-5, 0);
        test[2].setAnswer2points(0, -5);
        
        test[3].setQuestion("The computers in the office are outdated and running slow. Workers have started to complain as they can't do simple tasks without the internal systems crashing.");
        test[3].setAnswer1("Upgrade the office computers with the latest technology to ensure performance isn't an issue for years to come.");
        test[3].setAnswer2("The computers are fine, employees are just being overdramatic. You can get on Google with no problems and browse Facebook on your lunch.");
        test[3].setAnswer1points(30, -20);
        test[3].setAnswer2points(-20, 30);
        
        test[4].setQuestion("Workers have started to complain that they don't have enough desk-space to work with as the advertisement stands by the window on a busy street take up a lot of office room.");
        test[4].setAnswer1("They're right, remove the stands and attach posters to the windows instead. Each employee now has more space.");
        test[4].setAnswer2("The stands are necessary for advertisement – posters are so much smaller and a lot less noticeable!");
        test[4].setAnswer1points(20, -20);
        test[4].setAnswer2points(-20, 20);
       
        test[5].setQuestion("Your department has received some budget cuts and you have to make some cut backs to accommodate this.");
        test[5].setAnswer1("Stop the free office coffee program.");
        test[5].setAnswer2("Stop the free office parking program.");
        test[5].setAnswer1points(5, -5);
        test[5].setAnswer2points(25, -20);
        
        test[6].setQuestion("Head office are rolling out new software that will improve the way your employees work in a maintainable and sustainable system. The software is a bit more complex to understand than current processes that are followed in the office.");
        test[6].setAnswer1("Provide training for each employee, slowly rolling out to 20% of staff per week. This will give the workers space to learn and the opportunity to get help from others.");
        test[6].setAnswer2("We can't afford to take people away from their jobs to learn the new system. They will have to learn through failure and get to know the system individually.");
        test[6].setAnswer1points(20, -10);
        test[6].setAnswer2points(-30, 10);
        
        test[7].setQuestion("Halloween is coming up and you have room in the budget to reward your workers.");
        test[7].setAnswer1("Throw a budget Halloween party at the office to celebrate their good work.");
        test[7].setAnswer2("Award workers with a bonus for their work.");
        test[7].setAnswer1points(20, 0);
        test[7].setAnswer2points(20, -5);
        
        test[8].setQuestion("It's a busy period during summer and a majority of staff holidays have been allocated over the space of three weeks. This means that there are a lot of customers but not many workers there.");
        test[8].setAnswer1("Remove holidays from the last few employees that booked to make sure there are enough members of staff present at all times. First come, first serve.");
        test[8].setAnswer2("Employ temporary staff for the duration of summer so that everything is covered and nobody has to worry about their shifts.");
        test[8].setAnswer1points(-20, 0);
        test[8].setAnswer2points(30, -30);
        
        test[9].setQuestion("One of your workers has come up with an idea that would change the company for the better.");
        test[9].setAnswer1("Take the idea as your own and present it to the higher ups.");
        test[9].setAnswer2("Inform the higher ups about the idea and allow your worker to present it.");
        test[9].setAnswer1points(50, -50);
        test[9].setAnswer2points(0, 40);
        
        /*for(int i = 0; i < 10; i++)
        {  
            System.out.println(test[i].toString());
        } */
        
        /* Create and display the form */
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        earnPB = new javax.swing.JProgressBar();
        popPB = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        questionTF = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        answer1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        answer2 = new javax.swing.JTextPane();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        earnPB.setForeground(new java.awt.Color(255, 255, 51));

        jLabel2.setText("Earnings");

        jLabel1.setText("Popularity");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(popPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(earnPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(popPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(earnPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        questionTF.setEditable(false);
        jScrollPane2.setViewportView(questionTF);

        answer1.setEditable(false);
        answer1.setBackground(new java.awt.Color(0, 102, 102));
        jScrollPane1.setViewportView(answer1);

        answer2.setEditable(false);
        answer2.setBackground(new java.awt.Color(0, 153, 153));
        jScrollPane3.setViewportView(answer2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane answer1;
    private javax.swing.JTextPane answer2;
    private javax.swing.JProgressBar earnPB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JProgressBar popPB;
    private javax.swing.JTextPane questionTF;
    // End of variables declaration//GEN-END:variables
}
