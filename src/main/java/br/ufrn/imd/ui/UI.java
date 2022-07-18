package br.ufrn.imd.ui;

import br.ufrn.imd.file.Console;
import br.ufrn.imd.file.XLSX;
import br.ufrn.imd.math.SortTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class UI implements ActionListener {

    ImageIcon logo = new ImageIcon("./src/main/resources/logo2.jpg");
    ImageIcon icon = new ImageIcon("./src/main/resources/icon.jpeg");


    private String path;
    //private SortTypes SELECTED_TYPE;
    JFrame frame;
    JFrame secondFrame;
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
                Compile(CAmount, CTYPE, CSortOrder);
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
        title.setHorizontalAlignment(JLabel.LEFT);
        title.setVerticalTextPosition(JLabel.TOP);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(new Color(0xFFFFFF));
        title.setFont(new Font("Arial", Font.BOLD, 150));
        title.setIconTextGap(100);

        JButton CFA = CreateButton("Compile Fleet Ascending", -1, SortTypes.FLEET, 1, 100, 600, 300, 50);
        JButton CFD = CreateButton("Compile Fleet Descending", -1, SortTypes.FLEET, -1, 800, 600, 300, 50);
        JButton CLA = CreateButton("Compile Liter Ascending", -1, SortTypes.LITERS, 1, 100, 500, 300, 50);
        JButton CLD = CreateButton("Compile Liter Descending", -1, SortTypes.LITERS, -1,800 , 500, 300, 50);
        JButton CTCA = CreateButton("Compile Total Cost Ascending", -1, SortTypes.TOTALCOST, 1, 100, 400, 300, 50);
        JButton CTCD = CreateButton("Compile Total Cost Descending", -1, SortTypes.TOTALCOST, -1,800 , 400, 300, 50);
        JButton CACA = CreateButton("Compile Average LT Cost Ascending", -1, SortTypes.AVGLTCOST, 1, 100, 300, 300, 50);
        JButton CACD = CreateButton("Compile Average LT Cost Descending", -1, SortTypes.AVGLTCOST, -1,800 , 300, 300, 50);
        JButton CKLA = CreateButton("Compile Km Per Liter Ascending", -1, SortTypes.KMPERLITER, 1, 100, 500, 200, 50);
        JButton CKLD = CreateButton("Compile Km Per Liter Descending", -1, SortTypes.KMPERLITER, -1,800 , 500, 200, 50);



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


        secondFrame.add(title);
    }

    private void Compile(int Amount, SortTypes SortType, int SortOrder) throws IOException {
        XLSX reader = new XLSX(path);
        var escortvehicles = reader.readXLSX();
        Console TestConsole = new Console();
        TestConsole.PrintMap(escortvehicles, Amount, SortType, SortOrder);
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
            System.out.printf("No file was selected");
            System.exit(1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
