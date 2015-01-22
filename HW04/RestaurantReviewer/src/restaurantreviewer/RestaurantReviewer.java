/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantreviewer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.*;
import java.io.*;

/**
 *
 * @author dub10_000
 */
public class RestaurantReviewer extends javax.swing.JFrame {

    /**
     * Creates new form RestaurantReviewer
     */
    private int star;
    private final ImageIcon s1 = new ImageIcon("C:\\Users\\dub10_000\\Documents\\Whitworth\\JavaAppDev\\CS372\\HW04\\RestaurantReviewer\\src\\restaurantreviewer\\Star1.png");
    private final ImageIcon s2 = new ImageIcon("C:\\Users\\dub10_000\\Documents\\Whitworth\\JavaAppDev\\CS372\\HW04\\RestaurantReviewer\\src\\restaurantreviewer\\Star2.png");
    String f;
    String f2;
    private HashMap<String, Review> h = new HashMap();

    public RestaurantReviewer() {
        initComponents();
    }

    private Review getReview(Restaurant r) {
        return new Review(r, ReviewArea.getText(), star);
        //return rev;

    }

    private void readRestaurants() {
        try {
            f = "Restaurants.txt";
            Display.setText("");
            BufferedReader rdr = new BufferedReader(new FileReader(f));
            String line;
            String n;
            String loc;
            String review;
            int str;
            Review rev = new Review();
            oldr.removeAllItems();
            oldr.addItem("Select a Restaurant");
            Restaurant r = new Restaurant();
            while ((line = rdr.readLine()) != null) {
                oldr.addItem(line);
                //f2=line+".txt";
                r.setName(line);
                n = line;
                if ((line = rdr.readLine()) != null) {
                    loc = line;
                    r.setLocation(loc);
                    if ((line = rdr.readLine()) != null) {
                        review = line;
                        if ((line = rdr.readLine()) != null) {
                            str = Integer.parseInt(line);
                            rev = new Review(r, review, str);
                        }

                    }h.put(n,rev);
                }
                Display.append(rev.toString()+"\n");
                /*try(BufferedReader rdr2 = new BufferedReader(new FileReader(f2))){
                 while((line = rdr2.readLine()) != null){
                 r.setLocation(line);
                        
                 if((line = rdr2.readLine()) != null){
                 loc=line;
                 if((line = rdr2.readLine()) != null){
                 str=Integer.parseInt(line);
                 }
                 }
                 }
                 rdr2.close();
                 }*/
            }
            rdr.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void writeRestaurants() {
        try {
            f = "Restaurants.txt";
            BufferedWriter wrtr = new BufferedWriter(new FileWriter(f, true));
            Set<String> s = h.keySet();

            //wrtr.newLine();
            Iterator it = s.iterator();
            while (it.hasNext()) {
                String line = (String) it.next();
                boolean exists = false;
                System.out.println("It goes in!!!!");
                for (int i = 0; i < oldr.getItemCount(); i++) {
                    if (line.equals(oldr.getItemAt(i))) {
                        exists = true;
                        //System.out.println("It EXITS!!!!");
                        return;
                    }
                }

                wrtr.write(line);
                wrtr.newLine();
                readRestaurants();

            }
            oldr.removeAllItems();
            //oldr.addItem("Select");
            wrtr.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void clearStars() {
        star = 0;
        star1.setIcon(s2);
        star2.setIcon(s2);
        star3.setIcon(s2);
        star4.setIcon(s2);
        star5.setIcon(s2);
    }

    public void setStars(int s) {
        clearStars();
        star = s;
        if (s == 0) {
            star1.setIcon(s2);
        } else {
            star1.setIcon(s1);
        }

        if (s > 1) {
            star2.setIcon(s1);
            if (s > 2) {
                star3.setIcon(s1);
                if (s > 3) {
                    star4.setIcon(s1);
                    if (s == 5) {
                        star5.setIcon(s1);
                    } else {
                        star5.setIcon(s2);
                    }
                } else {
                    star4.setIcon(s2);
                }

            } else {
                star3.setIcon(s2);
            }
        } else {
            star2.setIcon(s2);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Reviewer = new javax.swing.JFrame();
        star1 = new javax.swing.JLabel();
        star2 = new javax.swing.JLabel();
        star3 = new javax.swing.JLabel();
        star4 = new javax.swing.JLabel();
        star5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rName = new javax.swing.JLabel();
        rGetName = new javax.swing.JTextField();
        lName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReviewArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        locLabel = new javax.swing.JLabel();
        rGetLoc = new javax.swing.JTextField();
        loc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        addNew = new javax.swing.JButton();
        oldr = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        info1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Display = new javax.swing.JTextArea();

        star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantreviewer/Star2.png"))); // NOI18N
        star1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                star1MouseReleased(evt);
            }
        });

        star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantreviewer/Star2.png"))); // NOI18N
        star2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                star2MouseReleased(evt);
            }
        });

        star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantreviewer/Star2.png"))); // NOI18N
        star3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                star3MouseReleased(evt);
            }
        });

        star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantreviewer/Star2.png"))); // NOI18N
        star4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                star4MouseReleased(evt);
            }
        });

        star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantreviewer/Star2.png"))); // NOI18N
        star5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                star5MouseReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel4.setText("Beautiful Review");

        rName.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        rName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rName.setText(" ");

        rGetName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rGetName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rGetNameActionPerformed(evt);
            }
        });
        rGetName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rGetNameKeyReleased(evt);
            }
        });

        lName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lName.setText("Restaurant Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Star Rating:");

        ReviewArea.setColumns(20);
        ReviewArea.setLineWrap(true);
        ReviewArea.setRows(5);
        jScrollPane1.setViewportView(ReviewArea);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Review");

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Submit this review");
        info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        locLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        locLabel.setText("Location:");

        rGetLoc.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rGetLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rGetLocActionPerformed(evt);
            }
        });
        rGetLoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rGetLocKeyReleased(evt);
            }
        });

        loc.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        loc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loc.setText(" ");

        javax.swing.GroupLayout ReviewerLayout = new javax.swing.GroupLayout(Reviewer.getContentPane());
        Reviewer.getContentPane().setLayout(ReviewerLayout);
        ReviewerLayout.setHorizontalGroup(
            ReviewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ReviewerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ReviewerLayout.createSequentialGroup()
                .addGroup(ReviewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReviewerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ReviewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ReviewerLayout.createSequentialGroup()
                                .addGroup(ReviewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lName)
                                    .addComponent(locLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(33, 33, 33)
                                .addGroup(ReviewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rGetName, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(rGetLoc)))))
                    .addGroup(ReviewerLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReviewerLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(123, 123, 123))
            .addGroup(ReviewerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ReviewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(ReviewerLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(star1)
                        .addGap(0, 0, 0)
                        .addComponent(star2)
                        .addGap(0, 0, 0)
                        .addComponent(star3)
                        .addGap(0, 0, 0)
                        .addComponent(star4)
                        .addGap(0, 0, 0)
                        .addComponent(star5))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ReviewerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Submit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ReviewerLayout.setVerticalGroup(
            ReviewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewerLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loc)
                .addGap(13, 13, 13)
                .addGroup(ReviewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rGetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lName))
                .addGap(18, 18, 18)
                .addGroup(ReviewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rGetLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(ReviewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(star2)
                    .addComponent(star3)
                    .addComponent(star1)
                    .addComponent(star4)
                    .addComponent(star5))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Submit)
                .addGap(15, 15, 15))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel1.setText("The Beautiful Restaurant Reviewer");

        addNew.setText("Add Review To A New Restaurant");
        addNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewActionPerformed(evt);
            }
        });

        oldr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));

        jLabel2.setText("Current Restaurants:");

        add.setText("Add Review To An Existing Restaurant");
        add.setName(""); // NOI18N
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        info1.setText("Please select an Existing Restaurant");

        Display.setEditable(false);
        Display.setColumns(20);
        Display.setRows(5);
        jScrollPane2.setViewportView(Display);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(addNew)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(oldr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(add)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(info1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(info1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addNew)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewActionPerformed
        // TODO add your handling code here:
        rName.setText("");
        loc.setText("");
        star = 0;
        Reviewer.setVisible(true);
        lName.setVisible(true);
        rGetName.setVisible(true);
        rGetLoc.setVisible(true);
        Reviewer.setSize(Reviewer.getPreferredSize());
        info.setText("Submit This Review");
    }//GEN-LAST:event_addNewActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        if (((String) oldr.getSelectedItem()).equals("Select")) {
            info1.setText("Please Select an Existing Restaurant");
            Reviewer.setVisible(false);
            return;
        } else {
            info1.setText("");
        }

        star = 0;
        String r = (String) oldr.getSelectedItem();

        rName.setText(r);
        String l = h.get(r).getLoc();
        loc.setText((l));
        Reviewer.setVisible(true);
        lName.setVisible(false);
        locLabel.setVisible(false);
        rGetName.setVisible(false);
        rGetLoc.setVisible(false);
        Reviewer.setSize(Reviewer.getPreferredSize());
        info.setText("Submit This Review");
    }//GEN-LAST:event_addActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
        String n = rName.getText();
        String l = loc.getText();
        if (n.equals("") || l.equals("")) {
            info.setText("Please Enter A Restaurant Name and Location");
            Reviewer.setSize(Reviewer.getPreferredSize());
            return;
        }
        if (star == 0) {
            info.setText("Please Enter A Valid Star Rating");
            Reviewer.setSize(Reviewer.getPreferredSize());
            return;
        }
        Restaurant r = new Restaurant(n, l);
        //Review rev= getReview(r);
        h.put(n, getReview(r));
        Reviewer.setVisible(false);
        info.setText("Submit This Review");
        writeRestaurants();
        readRestaurants();
        clearStars();
    }//GEN-LAST:event_SubmitActionPerformed

    private void rGetNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rGetNameKeyReleased
        // TODO add your handling code here:
        rName.setText(rGetName.getText());
        Reviewer.setSize(Reviewer.getPreferredSize());
    }//GEN-LAST:event_rGetNameKeyReleased

    private void rGetNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rGetNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rGetNameActionPerformed

    private void star5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_star5MouseReleased
        setStars(5);
    }//GEN-LAST:event_star5MouseReleased

    private void star4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_star4MouseReleased
        setStars(4);
    }//GEN-LAST:event_star4MouseReleased

    private void star3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_star3MouseReleased
        setStars(3);
    }//GEN-LAST:event_star3MouseReleased

    private void star2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_star2MouseReleased
        setStars(2);
    }//GEN-LAST:event_star2MouseReleased

    private void star1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_star1MouseReleased
        setStars(1);
    }//GEN-LAST:event_star1MouseReleased

    private void rGetLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rGetLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rGetLocActionPerformed

    private void rGetLocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rGetLocKeyReleased
        loc.setText("@ " + rGetLoc.getText());
        Reviewer.setSize(Reviewer.getPreferredSize());
    }//GEN-LAST:event_rGetLocKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        readRestaurants();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RestaurantReviewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurantReviewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurantReviewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurantReviewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurantReviewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Display;
    private javax.swing.JTextArea ReviewArea;
    private javax.swing.JFrame Reviewer;
    private javax.swing.JButton Submit;
    private javax.swing.JButton add;
    private javax.swing.JButton addNew;
    private javax.swing.JLabel info;
    private javax.swing.JLabel info1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel loc;
    private javax.swing.JLabel locLabel;
    private javax.swing.JComboBox oldr;
    private javax.swing.JTextField rGetLoc;
    private javax.swing.JTextField rGetName;
    private javax.swing.JLabel rName;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star2;
    private javax.swing.JLabel star3;
    private javax.swing.JLabel star4;
    private javax.swing.JLabel star5;
    // End of variables declaration//GEN-END:variables
}
