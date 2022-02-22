import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class PizzaGUIRunner extends JFrame
{
    JPanel mainPnl;
    JPanel subMain;

    JPanel radioPnl;
    JPanel checkPnl;
    JPanel comboPnl;
    JPanel displayPnl;
    JPanel controlPnl;

    //displaying
    JTextArea displayTA;
    JScrollPane scroller;

    //crusts
    ButtonGroup radioGroup = new ButtonGroup();
    JRadioButton thinRB;
    JRadioButton regularRB;
    JRadioButton deepDishRB;

    //size
    JComboBox pizzaSizeCB;
    String smallCB = "Small";
    double smallCBPrice = 8;
    String mediumCB = "Medium";
    double mediumCBPrice = 12;
    String largeCB = "Large";
    double largeCBPrice = 16;
    String superCB = "Super";
    double superCBPrice = 20;

    //toppings
    JCheckBox soulEssenceCB;
    JCheckBox bloodMutagenCB;
    JCheckBox goblinToesCB;
    JCheckBox wolfEarsCB;
    JCheckBox trollNailCB;
    JCheckBox dragonScaleCB;

    JButton orderBtn;
    JButton clearBtn;
    JButton quitBtn;

    public PizzaGUIRunner()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(4,2));
        subMain = new JPanel();
        subMain.setLayout(new GridLayout(1, 2));

        //createRadioPanel();
        createCheckPanel();
        //mainPnl.add(radioPnl);
        mainPnl.add(checkPnl);

        //createCheckPanel();
        createRadioPanel();
        //mainPnl.add(checkPnl, BorderLayout.WEST);
        subMain.add(radioPnl, BorderLayout.WEST);

        createComboPanel();
        //mainPnl.add(comboPnl, BorderLayout.EAST);
        subMain.add(comboPnl, BorderLayout.EAST);
        mainPnl.add(subMain, BorderLayout.CENTER);

        createDisplayPanel();
        mainPnl.add(displayPnl);

        createControlPanel();
        mainPnl.add(controlPnl);

        add(mainPnl);
        setSize(600,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    ButtonGroup group = new ButtonGroup();
    private void createRadioPanel()
    {
        radioPnl = new JPanel();
        radioPnl.setLayout(new GridLayout(1, 3));
        radioPnl.setBorder(new TitledBorder(new EtchedBorder(), "Crust Type"));

        thinRB = new JRadioButton("Thin");
        regularRB = new JRadioButton("Regular");
        deepDishRB = new JRadioButton("Deep-dish");

        radioPnl.add(thinRB);
        radioPnl.add(regularRB);
        radioPnl.add(deepDishRB);

        radioGroup.add(thinRB);
        radioGroup.add(regularRB);
        radioGroup.add(deepDishRB);
    }

    private void createCheckPanel()
    {
        checkPnl = new JPanel();
        checkPnl.setLayout(new GridLayout(2,3));
        checkPnl.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));

        soulEssenceCB = new JCheckBox("Soul Essence");
        bloodMutagenCB = new JCheckBox("Blood Mutagen");
        goblinToesCB = new JCheckBox("Goblin Toes");
        wolfEarsCB = new JCheckBox("Wolf Ears");
        trollNailCB = new JCheckBox("Troll Nail");
        dragonScaleCB = new JCheckBox("Dragon Scale");

        checkPnl.add(soulEssenceCB);
        checkPnl.add(bloodMutagenCB);
        checkPnl.add(goblinToesCB);
        checkPnl.add(wolfEarsCB);
        checkPnl.add(trollNailCB);
        checkPnl.add(dragonScaleCB);
    }

    private void createComboPanel()
    {
        comboPnl = new JPanel();
        comboPnl.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Size"));

        pizzaSizeCB = new JComboBox();
        pizzaSizeCB.addItem(smallCB);
        pizzaSizeCB.addItem(mediumCB);
        pizzaSizeCB.addItem(largeCB);
        pizzaSizeCB.addItem(superCB);

        comboPnl.add(pizzaSizeCB);
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayPnl.setBorder(new TitledBorder(new EtchedBorder(), "Order"));
        displayTA = new JTextArea(6,40);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }

    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(), "Controls"));

        orderBtn = new JButton("Order");
        controlPnl.add(orderBtn);
        orderBtn.addActionListener((ActiveEvent_ae) ->
        {
            //vars
            String crustType = "";
            double sizePrice = 0;
            String pizzaSize = "";
            double toppingPrice = 0;
            String toppingRec = "";
            double subTotal = 0;
            double tax;
            double taxCalc = 1.07;
            double taxPercent = 0.07;
            double total = 0;

            String rec = "=".repeat(50) + "\n";

            //check crust type
            if(thinRB.isSelected()){crustType = "Thin";}
            else if(regularRB.isSelected()){crustType = "Regular";}
            else if(deepDishRB.isSelected()){crustType = "Deep-dish";}

            //check pizza size
            if(pizzaSizeCB.getSelectedItem() == smallCB)
            {
                pizzaSize = smallCB;
                sizePrice = smallCBPrice;
            }
            else if(pizzaSizeCB.getSelectedItem() == mediumCB)
            {
                pizzaSize = mediumCB;
                sizePrice = mediumCBPrice;
            }
            else if(pizzaSizeCB.getSelectedItem() == largeCB)
            {
                pizzaSize = largeCB;
                sizePrice = largeCBPrice;
            }
            else if(pizzaSizeCB.getSelectedItem() == superCB)
            {
                pizzaSize = superCB;
                sizePrice = superCBPrice;
            }

            rec += "Type of Crust & Size:                               " + sizePrice + "\n" ;

            rec += "     Crust: " + crustType + "\n" + "     Size: " + pizzaSize + "\n";


            //check pizza ingredients
            if(soulEssenceCB.isSelected())
            {
                toppingPrice++;
                toppingRec += "     Soul Essence\n";
            }
            if(bloodMutagenCB.isSelected())
            {
                toppingPrice++;
                toppingRec += "     Blood Mutagen\n";
            }
            if(goblinToesCB.isSelected())
            {
                toppingPrice++;
                toppingRec += "     Goblin Toes\n";
            }
            if(wolfEarsCB.isSelected())
            {
                toppingPrice++;
                toppingRec += "     Wolf Ears\n";
            }
            if(trollNailCB.isSelected())
            {
                toppingPrice++;
                toppingRec += "     Troll Nail\n";
            }
            if(dragonScaleCB.isSelected())
            {
                toppingPrice++;
                toppingRec += "     Dragon Scale\n";
            }

            //ingredients
            rec += "Ingredient(s):                                              " + toppingPrice + "\n";
            rec += toppingRec + "\n";


            //subTotal and ta
            subTotal = sizePrice + toppingPrice;
            rec += "Sub-total:                                                 " + subTotal + "\n";
            tax = subTotal * taxPercent;
            String taxRes = String.format("%.2f", tax);
            rec += "Tax:                                                           " + taxRes + "\n";

            rec += "-".repeat(90) + "\n";

            //total
            total = subTotal * taxCalc;
            String result = String.format("%.2f", total);
            //rec += String.format("%-10s%-10s", "Total:", total + "\n");
            rec += "Total:                                                        " + result + "\n";

            rec += "=".repeat(50) + "\n";

            displayTA.append(rec);
        });


        clearBtn = new JButton("Clear");
        controlPnl.add(clearBtn);

        clearBtn.addActionListener((ActiveEvent_ae) ->
        {
            radioGroup.clearSelection();

            soulEssenceCB.setSelected(false);
            bloodMutagenCB.setSelected(false);
            goblinToesCB.setSelected(false);
            wolfEarsCB.setSelected(false);
            trollNailCB.setSelected(false);
            dragonScaleCB.setSelected(false);

            pizzaSizeCB.setSelectedIndex(0);
            displayTA.selectAll();
            displayTA.replaceSelection("");
        });

        quitBtn = new JButton("Quit");
        controlPnl.add(quitBtn);
        quitBtn.addActionListener((ActiveEvent_ae) ->
        {
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?","Select an Option", JOptionPane.YES_NO_CANCEL_OPTION);
            if(input == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        });


    }
}
