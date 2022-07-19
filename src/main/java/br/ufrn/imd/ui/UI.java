package br.ufrn.imd.ui;

import br.ufrn.imd.file.Console;
import br.ufrn.imd.file.XLSX;
import br.ufrn.imd.math.SortTypes;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UI implements ActionListener {

    ImageIcon logo = new ImageIcon(getClass().getResource("/logo2.jpg"));
    ImageIcon icon = new ImageIcon(getClass().getResource("/icon.jpeg"));


    private String path;
    private int amount = -1;
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
        fileChooserButton.setBounds(140, 150, 200, 30);
        fileChooserButton.addActionListener(e -> PromptFileChooser());
        fileChooserButton.setText("Abrir arquivo");
        fileChooserButton.setFocusable(false);
        fileChooserButton.setFont(new Font("Arial", Font.BOLD, 15));
        fileChooserButton.setForeground(new Color(0x000000));

        frame = new JFrame();
        frame.setTitle("Average Fuel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(500, 300);
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(0xFFFFFF));
        frame.setResizable(true);

        frame.add(fileChooserButton);
        frame.add(title);
    }

    private JButton CreateButton(String Text, int CAmount, SortTypes CTYPE, int CSortOrder, int x, int y, int w, int h){
        JButton btn = new JButton();
        btn.setBounds(x, y, w, h);
        btn.addActionListener(e -> {
            try {
                Compile(amount, CTYPE, CSortOrder);
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

        JButton CFA = CreateButton("Gerar tabela - Frota Crescente", amount, SortTypes.FLEET, 1, 100, 100, 325, 30);
        JButton CFD = CreateButton("Gerar tabela - Frota Decrescente", amount, SortTypes.FLEET, -1, 800, 100, 325, 30);
        JButton CLA = CreateButton("Gerar tabela - Litros Crescente", amount, SortTypes.LITERS, 1, 100, 150, 325, 30);
        JButton CLD = CreateButton("Gerar tabela - Litros Decrescente", amount, SortTypes.LITERS, -1,800 , 150, 325, 30);
        JButton CTCA = CreateButton("Gerar tabela - Custo Crescente", amount, SortTypes.TOTALCOST, 1, 100, 200, 325, 30);
        JButton CTCD = CreateButton("Gerar tabela - Custo Decrescente", amount, SortTypes.TOTALCOST, -1,800 , 200, 325, 30);
        JButton CACA = CreateButton("Gerar tabela - Valor p/Litro Crescente", amount, SortTypes.AVGLTCOST, 1, 100, 250, 325, 30);
        JButton CACD = CreateButton("Gerar tabela - Valor p/Litro Decrescente", amount, SortTypes.AVGLTCOST, -1,800 , 250, 325, 30);
        JButton CKLA = CreateButton("Gerar tabela - Média KM/L Crescente", amount, SortTypes.KMPERLITER, 1, 100, 300, 325, 30);
        JButton CKLD = CreateButton("Gerar tabela - Média KM/L Decrescente", amount, SortTypes.KMPERLITER, -1,800 , 300, 325, 30);


        JLabel amountInputExplanation = new JLabel();
        amountInputExplanation.setBounds(525,460, 250, 50);
        amountInputExplanation.setForeground(new Color(0x000000));
        amountInputExplanation.setText("[-1] TODOS | [>0] ORDEM");
        amountInputExplanation.setFont(new Font("Arial", Font.BOLD, 15));

        amountInput = new JTextField("-1");
        amountInput.setHorizontalAlignment(JTextField.CENTER);
        amountInput.setBounds(540,500, 150, 30);
        amountInput.setActionCommand("UpdateAmount");
        amountInput.addActionListener(this);

        JButton ConfirmAmount = new JButton();
        ConfirmAmount.setHorizontalAlignment(JTextField.CENTER);
        ConfirmAmount.setBounds(540,532, 150, 20);
        ConfirmAmount.setActionCommand("ConfirmAmount");
        ConfirmAmount.setText("OK");
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
        TableModel model = TestConsole.table(escortvehicles, Amount, SortType, SortOrder);
        if(ui3 != null){
            ui3.dispose();
        }
        ui3 = ThirdUI(model);
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
            amount = Integer.parseInt(amountInput.getText());
            //System.out.println(amnt);
        }
    }
}
