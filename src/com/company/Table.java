package com.company;

import javax.swing.*;
import java.awt.*;

public class Table  extends JFrame {

    private  static final int WIDTH = 400;
    private  static final int HEIGHT = 300;

    public Table ()
     {
         super ("Table");
         setSize(WIDTH,HEIGHT);

         Toolkit kit = Toolkit.getDefaultToolkit();
         setLocation( (kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT)/2) ;

     }





}
