package com.company;

import javax.swing.table.AbstractTableModel;

public class GornerTabel extends AbstractTableModel {
    private double from;
    private double to;
    private double step;
    private double [] coefficient

 public GornerTabel (double from, double to, double step, double[] coefficient )
 {
     this.from = from;
     this.to = to;
     this.step = step;
     this.coefficient = coefficient;
 }

}
