import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class ControlDemoFrame extends JFrame
{
    JPanel mainPnl;
    JPanel crustPnl;
    JPanel radioPnl;
    JPanel checkPnl;
    JPanel comboPnl;
    JPanel controlPnl;

    JComboBox homeCB;

    JCheckBox gopherCB;
    JCheckBox monsterToeCB;
    JCheckBox shadeCB;
    JCheckBox bloodCB;
    JCheckBox heartCB;
    JCheckBox brainsCB;
    JCheckBox fangsCB;
    JCheckBox tearsCB;

    JRadioButton smallRB;
    JRadioButton mediumRB;
    JRadioButton largeRB;
    JRadioButton superRB;
    JRadioButton thinRB;
    JRadioButton regularRB;
    JRadioButton deepDishRB;


    JButton quitBtn;
    JButton displayChoicesBtn;
    JButton clearBtn;
    JTextArea receipt;

    public ControlDemoFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(2,3));

        createCrustPanel();
        mainPnl.add(crustPnl);

        createRadioPanel();
        mainPnl.add(radioPnl);

        receipt = new JTextArea(15,30);
        mainPnl.add(receipt);

        createCheckPanel();
        mainPnl.add(checkPnl);

        createComboPanel();
        mainPnl.add(comboPnl);

        createControlPanel();
        mainPnl.add(controlPnl);

        add(mainPnl);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createComboPanel()
    {
        comboPnl = new JPanel();
        comboPnl.setBorder(new TitledBorder(new EtchedBorder(),"Home"));

        homeCB = new JComboBox();
        homeCB.addItem("Narnia");
        homeCB.addItem("Barsoom");
        homeCB.addItem("Asgard");
        homeCB.addItem("Midgard");
        homeCB.addItem("Jotunheim");
        comboPnl.add(homeCB);


    }
    private void createCrustPanel()
    {
        crustPnl = new JPanel();
        crustPnl.setLayout(new GridLayout(1, 3));
        crustPnl.setBorder(new TitledBorder(new EtchedBorder(),"Crust Type"));


        thinRB  = new JRadioButton("Thin");
        regularRB = new JRadioButton("Regular");
        deepDishRB  = new JRadioButton("Deep-Dish");

        crustPnl.add(thinRB);
        crustPnl.add(regularRB);
        crustPnl.add(deepDishRB);

        regularRB.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(thinRB);
        group.add(regularRB);
        group.add(deepDishRB);


    }

    private void createRadioPanel()
    {
        radioPnl = new JPanel();
        radioPnl.setLayout(new GridLayout(1, 4));
        radioPnl.setBorder(new TitledBorder(new EtchedBorder(),"Radio Buttons"));


        smallRB  = new JRadioButton("Small");
        mediumRB = new JRadioButton("Medium");
        largeRB  = new JRadioButton("Large");
        superRB  = new JRadioButton("Super");

        radioPnl.add(smallRB);
        radioPnl.add(mediumRB);
        radioPnl.add(largeRB);
        radioPnl.add(superRB);

        mediumRB.setSelected(true);


        ButtonGroup group = new ButtonGroup();
        group.add(smallRB);
        group.add(mediumRB);
        group.add(largeRB);
        group.add(superRB);


    }

    private void createCheckPanel()
    {
        checkPnl = new JPanel();
        checkPnl.setLayout(new GridLayout(2,4));
        checkPnl.setBorder(new TitledBorder(new EtchedBorder(),"Checkboxes"));

        gopherCB = new JCheckBox("Gopher Guts");
        monsterToeCB = new JCheckBox("Monster Toes");
        shadeCB = new JCheckBox("Ghost Shade");
        bloodCB = new JCheckBox("Bitter Blood");
        heartCB = new JCheckBox("Tell Tale Heart");
        fangsCB = new JCheckBox("Vampire Fangs");
        brainsCB = new JCheckBox("Zombie Brains");
        tearsCB = new JCheckBox("Clown Tears");

        checkPnl.add(gopherCB);
        checkPnl.add(monsterToeCB);
        checkPnl.add(shadeCB);
        checkPnl.add(bloodCB);
        checkPnl.add(heartCB);
        checkPnl.add(fangsCB);
        checkPnl.add(brainsCB);
        checkPnl.add(tearsCB);

    }


    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(),"Controls"));

        displayChoicesBtn = new JButton("Order");
        displayChoicesBtn.addActionListener(
                (ActionEvent ae) ->
                {
                    // Generate a result string and then display it with a Message Diaplog
                    String res ="Form Details\n";
                    String crustType = "";
                    String pizzaSize = "";
                    String ingredients = "";
                    double subTotal = 0;
                    double tax;
                    double total;
                    DecimalFormat df = new DecimalFormat("#.00");
                    // get the size choice
                    res += "Crust Type: ";
                    if(thinRB.isSelected())
                    {
                        res += "Thin\n";
                        crustType = "Thin\n";
                    }
                    else if(regularRB.isSelected())
                    {
                        res += "Regular\n";
                        crustType = "Regular\n";
                    }
                    else if(deepDishRB.isSelected())
                    {
                        res += "Deep dish\n";
                        crustType = "Deep dish\n";
                    }
                    res += "Crust size: ";
                    if(smallRB.isSelected())
                    {
                        res += "Small\n";
                        subTotal += 8;
                        pizzaSize = "small                      $8\n";
                    }
                    else if(mediumRB.isSelected())
                    {
                        res += "Medium\n";
                        subTotal += 12;
                        pizzaSize = "Medium                     $12\n";
                    }
                    else if(largeRB.isSelected())
                    {
                        res += "Large\n";
                        subTotal += 16;
                        pizzaSize = "Large                      $16\n";
                    }
                    else if(superRB.isSelected())
                    {
                        res += "Super\n";
                        subTotal += 20;
                        pizzaSize = "Super                      $20\n";
                    }
                    // get the items
                    res += "With these gourmet toppings:\n";

                    if (gopherCB.isSelected())
                    {
                        res += "Gopher Guts\n";
                        subTotal += 1;
                        ingredients += "Gopher guts              $1\n";
                    }

                    if (monsterToeCB.isSelected())
                    {
                        res += "Monster Toes\n";
                        subTotal += 1;
                        ingredients += "Monster toes             $1\n";
                    }

                    if (shadeCB.isSelected())
                    {
                        res += "Ghost Shade\n";
                        subTotal += 1;
                        ingredients += "Ghost shade             $1\n";
                    }

                    if (bloodCB.isSelected())
                    {
                        res += "Bitter Blood\n";
                        subTotal += 1;
                        ingredients += "Bitter blood                $1\n";
                    }

                    if (fangsCB.isSelected())
                    {
                        res += "Vampire Fangs\n";
                        subTotal += 1;
                        ingredients += "Vampire Fangs         $1\n";
                    }

                    if (brainsCB.isSelected())
                    {
                        res += "Zombie Brains\n";
                        subTotal += 1;
                        ingredients += "Zombie Brains          $1\n";
                    }

                    if (tearsCB.isSelected())
                    {
                        res += "Clown Tears\n";
                        subTotal += 1;
                        ingredients += "Clown Tears             $1\n";
                    }

                    tax = subTotal*.07;
                    total = subTotal+tax;

                    res += "To be delivered to: ";

                    res += (String) homeCB.getSelectedItem();

                    res += "\n";

                    res += "Sub-total: $" + subTotal + "\n";

                    res += "Tax: $" + df.format(tax) + "\n";

                    res += "Total: $" + total;


                    // get the home
                    String subTotalStr = Double.toString(subTotal);
                    receipt.append("===========================\n");
                    receipt.append(crustType);
                    receipt.append(pizzaSize);
                    receipt.append(ingredients);
                    receipt.append("\n");
                    receipt.append("Sub-total                  $"+subTotalStr+"\n");
                    receipt.append("Tax                          $"+df.format(tax)+"\n");
                    receipt.append("------------------------------------------------\n");
                    receipt.append("Total                       $"+total+"\n");
                    receipt.append("===========================\n");
                    JOptionPane.showMessageDialog(mainPnl,res);
                }
        );

        clearBtn = new JButton("Clear");
        ButtonGroup crustButtons = new ButtonGroup();
        crustButtons.add(thinRB);
        crustButtons.add(regularRB);
        crustButtons.add(deepDishRB);
        ButtonGroup sizeButtons = new ButtonGroup();
        sizeButtons.add(smallRB);
        sizeButtons.add(mediumRB);
        sizeButtons.add(largeRB);
        sizeButtons.add(superRB);
        clearBtn.addActionListener(
                (ActionEvent ae) ->
                {
                    receipt.setText(null);
                    if(thinRB.isSelected()
                    || regularRB.isSelected()
                    || deepDishRB.isSelected())
                    {
                        crustButtons.clearSelection();
                    }
                    if(smallRB.isSelected()
                    ||mediumRB.isSelected()
                    ||largeRB.isSelected()
                    ||superRB.isSelected())
                    {
                        sizeButtons.clearSelection();
                    }
                    if(gopherCB.isSelected()) {
                        gopherCB.setSelected(false);
                    }
                    if(monsterToeCB.isSelected()) {
                        monsterToeCB.setSelected(false);
                    }
                    if(shadeCB.isSelected()) {
                        shadeCB.setSelected(false);
                    }
                    if(bloodCB.isSelected()) {
                        bloodCB.setSelected(false);
                    }
                    if(fangsCB.isSelected()) {
                        fangsCB.setSelected(false);
                    }
                    if(brainsCB.isSelected()) {
                        brainsCB.setSelected(false);
                    }
                    if(tearsCB.isSelected()) {
                        tearsCB.setSelected(false);
                    }
                    if(heartCB.isSelected()) {
                        heartCB.setSelected(false);
                    }

                }

    );


        quitBtn = new JButton("Quit!");
        quitBtn.addActionListener((ActionEvent ae) -> {
            int response;
            response = JOptionPane.showConfirmDialog(null, "Are you sure?", "Quit",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }


        });

        controlPnl.add(displayChoicesBtn);
        controlPnl.add(clearBtn);
        controlPnl.add(quitBtn);

    }
}