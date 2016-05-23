package org.parabot.crandor.fishing.resources;

/**
 * @author EricTurner
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    /**
     * Create the frame.
     */
    public GUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBankOrPowerfish = new JLabel("Bank or PowerFish");
        lblBankOrPowerfish.setBounds(36, 34, 109, 14);
        contentPane.add(lblBankOrPowerfish);

        final JRadioButton rdbtnBank = new JRadioButton("Bank");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnBank);
        rdbtnBank.setBounds(36, 65, 109, 23);
        contentPane.add(rdbtnBank);

        final JRadioButton rdbtnPowerfish = new JRadioButton("PowerFish");
        buttonGroup.add(rdbtnPowerfish);
        rdbtnPowerfish.setBounds(36, 91, 109, 23);
        contentPane.add(rdbtnPowerfish);

        JLabel lblWhichFish = new JLabel("Which Fishing type");
        lblWhichFish.setBounds(316, 34, 89, 14);
        contentPane.add(lblWhichFish);

        final JComboBox comboBox = new JComboBox();
        comboBox.setBounds(308, 66, 97, 20);
        contentPane.add(comboBox);
        comboBox.addItem("Net");
        comboBox.addItem("Cage");
        comboBox.addItem("Harpoon");

        JButton btnStart = new JButton("Start");

        final JCheckBox chckbxAutoProgression = new JCheckBox("Auto Progression");
        chckbxAutoProgression.setBounds(147, 191, 128, 23);
        contentPane.add(chckbxAutoProgression);


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chckbxAutoProgression.isSelected()) {
                    Variables.setAutoProgression(true);
                } else {
                    switch (comboBox.getSelectedItem().toString()) {
                        case "Net":
                            Variables.setFish(Fish.SHRIMP);
                            Variables.setToSpot(Constants.toDockOne);
                            break;
                        case "Cage":
                            Variables.setFish(Fish.LOBSTER);
                            Variables.setToSpot(Constants.toDockTwo);
                            break;
                        case "Harpoon":
                            Variables.setFish(Fish.TUNASWORDFISH);
                            Variables.setToSpot(Constants.toDockTwo);
                            break;
                        case "Rocktail":
                            Variables.setFish(Fish.ROCKTAIL);
                            Variables.setToSpot(Constants.toDockTwo);
                            break;
                    }
                }
                if (rdbtnBank.isSelected())
                    Variables.setBanking(true);

                if (rdbtnPowerfish.isSelected())
                    Variables.setDropping(true);


                GUI.this.setVisible(false);
                GUI.this.dispose();

            }
        });
        btnStart.setBounds(298, 228, 89, 23);
        contentPane.add(btnStart);
    }
}
