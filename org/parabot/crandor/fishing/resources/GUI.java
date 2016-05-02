package org.parabot.crandor.fishing.resources;

/**
 * Created by Eric on 4/29/2016.
 */

import org.parabot.crandor.fishing.Main;
import org.parabot.crandor.fishing.strategies.Fishing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private final ButtonGroup BankorDrop = new ButtonGroup();
    private JPanel contentPane;


    /**
     * Create the frame.
     */
    public GUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBankOrPowerfish = new JLabel("Bank or PowerFish");
        lblBankOrPowerfish.setBounds(36, 34, 109, 14);
        contentPane.add(lblBankOrPowerfish);

        final JRadioButton rdbtnBank = new JRadioButton("Bank");
        BankorDrop.add(rdbtnBank);
        rdbtnBank.setBounds(36, 65, 109, 23);
        contentPane.add(rdbtnBank);

        final JRadioButton rdbtnPowerfish = new JRadioButton("PowerFish");
        BankorDrop.add(rdbtnPowerfish);
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
                switch (comboBox.getSelectedItem().toString()) {
                    case "Net":
                        Constants.setNetFishing(true);
                        Constants.setFishingSpotId(Constants.FishingTypes.NET.getSpotId());
                        Constants.setFishingAnim(Constants.FishingTypes.NET.getAnimId());
                        Constants.setInteractOption(Constants.FishingTypes.NET.getOption());
                        Constants.setFishingToolId(Constants.FishingTypes.NET.getToolId());
                        break;
                    case "Cage":
                        Constants.setCageFishing(true);
                        Constants.setFishingSpotId(Constants.FishingTypes.CAGE.getSpotId());
                        Constants.setFishingAnim(Constants.FishingTypes.CAGE.getAnimId());
                        Constants.setInteractOption(Constants.FishingTypes.CAGE.getOption());
                        Constants.setFishingToolId(Constants.FishingTypes.CAGE.getToolId());
                        break;
                    case "Harpoon":
                        Constants.setHarpoonFishing(true);
                        Constants.setFishingSpotId(Constants.FishingTypes.HARPOON.getSpotId());
                        Constants.setFishingAnim(Constants.FishingTypes.HARPOON.getAnimId());
                        Constants.setInteractOption(Constants.FishingTypes.HARPOON.getOption());
                        Constants.setFishingToolId(Constants.FishingTypes.HARPOON.getToolId());
                        break;
                }
                if (rdbtnBank.isSelected())
                    Constants.setBanking(true);

                if (rdbtnPowerfish.isSelected())
                    Constants.setDropping(true);


                /*if (chckbxAutoProgression.isSelected())
                    Constants.setAutoProgression(true);*/

                GUI.this.setVisible(false);
                GUI.this.dispose();

                Constants.setRunning(true);

            }
        });
        btnStart.setBounds(298, 228, 89, 23);
        contentPane.add(btnStart);
    }
}
