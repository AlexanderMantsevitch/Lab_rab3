package com.company;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JLabel label = new JLabel(" ");
    private JPanel panel = new JPanel();
    private String scan = null;
    private String from = null;
    private String to = null;
    private DecimalFormat formatter =  (DecimalFormat) NumberFormat.getInstance();
    public GornerTableCellRenderer ()
    {

        formatter.setMaximumFractionDigits(6);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols a = formatter.getDecimalFormatSymbols();
        a.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(a);
        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add (label);

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);
        if ((column + row) % 2 == 1)
        {
            label.setForeground(Color.WHITE);
            panel.setBackground(Color.BLACK);
        }
        else
        {

            label.setForeground(Color.black);
            panel.setBackground(Color.WHITE);
        }



        if (column== 1 && scan!=null && scan.equals(formattedDouble)) {

            panel.setBackground(Color.RED);
        }
        if (column == 2 && scan!=null && scan.equals(formattedDouble)) {

            panel.setBackground(Color.red);
        }
        if ((column == 1 || column == 2) &&from !=null&& to!=null && Double.parseDouble(from) <= Double.parseDouble(formattedDouble) &&
        Double.parseDouble(formattedDouble) <= Double.parseDouble(to))
        {
            panel.setBackground(Color.ORANGE);
        }


        return panel;

    }
    public void setScan(String scan) {
        this.scan = scan;
    }
    public void setFrom(String scan) {
        this.from = scan;
    }
    public void setTo(String scan) {
        this.to = scan;
    }
}
