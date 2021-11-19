package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table  extends JFrame {

    private  static final int WIDTH = 500;
    private  static final int HEIGHT = 700;
    private Double[] coefficients;
    private JFileChooser fileChooser = null;
    private TextField textField_from = new TextField("", 5);
    private TextField textField_to = new TextField("", 5);
    private TextField textField_shag = new TextField("", 5);

    private  GornerTabel data;
    private GornerTableCellRenderer render = new GornerTableCellRenderer ();


    public Table (Double [] coefficients)
     {
         super ("Table");
         setSize(WIDTH,HEIGHT);

        Toolkit kit = Toolkit.getDefaultToolkit();
         System.out.println(kit.getScreenSize().height );
        setLocation( (kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT)/2) ;
         Box cont = Box.createVerticalBox();
         getContentPane().add(cont, BorderLayout.NORTH);

         JMenuBar menuBar = new JMenuBar();
         setJMenuBar(menuBar);
         JMenu filename = new JMenu("Файл");
         JMenu tabl = new JMenu("Таблица");
        // JMenu information = new JMenu("Справка");
         Action information = new AbstractAction("Справка") {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(Table.this,
                         "Прорамму написал: Манцевич Александр \n Группа: 8", "Справка",
                         JOptionPane.INFORMATION_MESSAGE);

             }
         };
         menuBar.add(filename);
         filename.add (information);


     //    menuBar.add (tabl);
        JLabel Label_From = new JLabel("х изменяется от: " );
        JLabel Label_To = new JLabel(" до ");
         JLabel Label_Shag = new JLabel(" с шагом ");
        JPanel Label_and_TextFiled_x = new JPanel();
        Label_and_TextFiled_x.add(Label_From);
        Label_and_TextFiled_x.add (textField_from);
        Label_and_TextFiled_x.add (Label_To);
        Label_and_TextFiled_x.add (textField_to);
        Label_and_TextFiled_x.add (Box.createHorizontalStrut(10));
         Label_and_TextFiled_x.add (Label_Shag);
         Label_and_TextFiled_x.add (textField_shag);
        Label_and_TextFiled_x.setLayout(new FlowLayout (FlowLayout.CENTER));
        cont.add (Label_and_TextFiled_x);
         JPanel Result = new JPanel();
       //  Result.setLayout(new FlowLayout(FlowLayout.));
         cont.add (Result);

        JButton result = new JButton("Вычислить");
        result.setSize(10,10);
        JPanel butt = new JPanel();
         butt.add (result);
         JButton clear = new JButton("Очистить");
         clear.setSize(10,10);
butt.add (clear);

         cont.add (butt);
cont.setPreferredSize(new Dimension(WIDTH, WIDTH));



         result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        try {
            Double from = Double.parseDouble(textField_from.getText());
            Double to = Double.parseDouble(textField_to.getText());
            Double shag = Double.parseDouble(textField_shag.getText());

            data = new GornerTabel(from, to, shag, coefficients);
            JTable table = new JTable(data);
            table.setDefaultRenderer(Double.class, render);
            table.setRowHeight(30);
            Result.removeAll();
            Result.add(new JScrollPane(table));
            getContentPane().validate();
        }
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(Table.this,
                    "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                    JOptionPane.WARNING_MESSAGE);
                }
                    }
        });

         clear.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Result.removeAll();
                 textField_from.setText(" ");
                 textField_shag.setText(" ");
                 textField_to.setText(" ");
                 getContentPane().validate();

             }
         });





     }


}
