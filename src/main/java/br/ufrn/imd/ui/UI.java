package br.ufrn.imd.ui;

import br.ufrn.imd.file.Console;
import br.ufrn.imd.file.XLSX;
import br.ufrn.imd.math.SortTypes;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class UI implements ActionListener {

    ImageIcon logo = new ImageIcon(getClass().getResource("/logo2.jpg"));
    ImageIcon icon = new ImageIcon(getClass().getResource("/icon.jpeg"));


    private String path;
    private int amnt = -1;
    private JTextField amountInput;
    JFrame frame;
    JFrame secondFrame;
    JFrame ui3;
    public UI(){
        InitialUI();
        //SecondUI();
    }

    private void InitialUI(){
        JLabel title = new JLabel();
        //title.setText("AVERAGE FUEL");
        title.setIcon(logo);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.TOP);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(new Color(0xFFFFFF));
        title.setFont(new Font("Arial", Font.BOLD, 150));
        title.setIconTextGap(100);

        JButton fileChooserButton = new JButton();
        fileChooserButton.setBounds(540, 335, 200, 50);
        fileChooserButton.addActionListener(e -> PromptFileChooser());
        fileChooserButton.setText("Choose file");
        fileChooserButton.setFocusable(false);
        fileChooserButton.setFont(new Font("Arial", Font.BOLD, 20));
        fileChooserButton.setForeground(new Color(0x000000));

        frame = new JFrame();
        frame.setTitle("Average Fuel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(1280, 720);
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(0xFFFFFF));

        frame.add(fileChooserButton);
        frame.add(title);
    }

    private JButton CreateButton(String Text, int CAmount, SortTypes CTYPE, int CSortOrder, int x, int y, int w, int h){
        JButton btn = new JButton();
        btn.setBounds(x, y, w, h);
        btn.addActionListener(e -> {
            try {
                Compile(amnt, CTYPE, CSortOrder);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        btn.setText(Text);
        btn.setFocusable(false);
        btn.setFont(new Font("Arial", Font.BOLD, 15));
        btn.setForeground(new Color(0x000000));
        return btn;

    }

    private void SecondUI(){
        JLabel title = new JLabel();
        title.setIcon(logo);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.TOP);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(new Color(0xFFFFFF));
        title.setFont(new Font("Arial", Font.BOLD, 150));
        title.setIconTextGap(100);

        JButton CFA = CreateButton("Compile Fleet Ascending", amnt, SortTypes.FLEET, 1, 100, 100, 325, 50);
        JButton CFD = CreateButton("Compile Fleet Descending", amnt, SortTypes.FLEET, -1, 800, 100, 325, 50);
        JButton CLA = CreateButton("Compile Liter Ascending", amnt, SortTypes.LITERS, 1, 100, 200, 325, 50);
        JButton CLD = CreateButton("Compile Liter Descending", amnt, SortTypes.LITERS, -1,800 , 200, 325, 50);
        JButton CTCA = CreateButton("Compile Total Cost Ascending", amnt, SortTypes.TOTALCOST, 1, 100, 300, 325, 50);
        JButton CTCD = CreateButton("Compile Total Cost Descending", amnt, SortTypes.TOTALCOST, -1,800 , 300, 325, 50);
        JButton CACA = CreateButton("Compile Average LT Cost Ascending", amnt, SortTypes.AVGLTCOST, 1, 100, 400, 325, 50);
        JButton CACD = CreateButton("Compile Average LT Cost Descending", amnt, SortTypes.AVGLTCOST, -1,800 , 400, 325, 50);
        JButton CKLA = CreateButton("Compile Km Per Liter Ascending", amnt, SortTypes.KMPERLITER, 1, 100, 500, 325, 50);
        JButton CKLD = CreateButton("Compile Km Per Liter Descending", amnt, SortTypes.KMPERLITER, -1,800 , 500, 325, 50);


        JLabel amountInputExplanation = new JLabel();
        amountInputExplanation.setBounds(540,460, 150, 50);
        amountInputExplanation.setForeground(new Color(0x000000));
        amountInputExplanation.setText("[-1] ALL | [>0] RANGE");
        amountInputExplanation.setFont(new Font("Arial", Font.BOLD, 15));

        amountInput = new JTextField("-1");
        amountInput.setHorizontalAlignment(JTextField.CENTER);
        amountInput.setBounds(540,500, 150, 50);
        amountInput.setActionCommand("UpdateAmount");
        amountInput.addActionListener(this);

        JButton ConfirmAmount = new JButton();
        ConfirmAmount.setHorizontalAlignment(JTextField.CENTER);
        ConfirmAmount.setBounds(540,600, 150, 50);
        ConfirmAmount.setActionCommand("ConfirmAmount");
        ConfirmAmount.setText("CONFIRM");
        ConfirmAmount.setFont(new Font("Arial", Font.BOLD, 20));
        ConfirmAmount.addActionListener(this);

        secondFrame = new JFrame();
        secondFrame.setTitle("Average Fuel");
        secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondFrame.setResizable(false);
        secondFrame.setVisible(true);
        secondFrame.setSize(1280, 720);
        secondFrame.setIconImage(icon.getImage());
        secondFrame.getContentPane().setBackground(new Color(0xFFFFFF));

        secondFrame.add(CFA);
        secondFrame.add(CFD);
        secondFrame.add(CLA);
        secondFrame.add(CLD);
        secondFrame.add(CTCA);
        secondFrame.add(CTCD);
        secondFrame.add(CACA);
        secondFrame.add(CACD);
        secondFrame.add(CKLA);
        secondFrame.add(CKLD);

        secondFrame.add(amountInputExplanation);
        secondFrame.add(amountInput);
        secondFrame.add(ConfirmAmount);

        secondFrame.add(title);
    }

    private JFrame ThirdUI(TableModel model){
        JTable jtable = new JTable(model);
        jtable.setEnabled(false);

        JScrollPane scroll = new JScrollPane(jtable);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JFrame jframe = new JFrame();
        jframe.setTitle("Average Fuel Result");
        jframe.setSize(1280,420);
        jframe.setIconImage(icon.getImage());
        jframe.add(scroll);
        jframe.setVisible(true);
        jframe.setResizable(false);

        return jframe;
    }

    private void Compile(int Amount, SortTypes SortType, int SortOrder) throws IOException {
        XLSX reader = new XLSX(path);
        var escortvehicles = reader.readXLSX();
        Console TestConsole = new Console();
        //TestConsole.PrintMap(escortvehicles, Amount, SortType, SortOrder);
        TableModel model = TestConsole.table(escortvehicles, Amount, SortType, SortOrder);
        if(ui3 != null){
            ui3.dispose();
            ui3 = ThirdUI(model);
        }else{
            ui3 = ThirdUI(model);
        }
    }

    private void PromptFileChooser() {
        FileDialog FD = new FileDialog(frame, "Select XLSX file", FileDialog.LOAD);
        FD.setFile("*.xlsx");

        FD.setDirectory("C:\\");
        FD.setVisible(true);
        String file = FD.getFile();
        path = FD.getDirectory() + FD.getFile();
        if (file != null) {
            frame.dispose();
            SecondUI();
            //System.exit(0);
        } else {
            System.out.println("No file was selected");
            System.exit(1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "ConfirmAmount"){
            amnt = Integer.parseInt(amountInput.getText());
            //System.out.println(amnt);
        }
    }
}
