package com.company;

import java.awt.*;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.border.LineBorder;

public class Main implements ActionListener{//LISTENER DE EVENTOS

    JButton bt1,bt2,bt3,bt4; //botones
    JLabel jl1,jl2,jl3; //etiquetas
    JTextField jt1,jt2,jt3;
    JFrame jf = new JFrame("Calculadora Virtual");

    public Main(){//constructor de clase

        jf.setLayout(new FlowLayout());//Espacio del jframe
        Dimension d = new Dimension();//ancho de ventana

        //Instanciar etiquetas
        jl1 = new JLabel("Primer operando");
        jl2 = new JLabel("Segundo operando");
        jl3 = new JLabel("=");

        //Intanciar cuadros de texto
        jt1 = new JTextField(6);
        jt2 = new JTextField(6);
        jt3 = new JTextField(6);

        //Instanciar botton
        bt1 = new JButton("+");
        bt2 = new JButton("-");
        bt3 = new JButton("x");
        bt4 = new JButton("÷");


        //Colocar objetos a ventana
        jf.add(jl1);jf.add(jt1);
        JPanel botones = new JPanel();
        botones.setBorder(LineBorder.createBlackLineBorder());
        botones.setBackground(Color.gray);
        botones.add(bt1);
        botones.add(bt2);
        botones.add(bt3);
        botones.add(bt4);
        jf.add(botones);
        jf.add(jl2);jf.add(jt2);
        jf.add(jl3);jf.add(jt3);


        //margenes de texto en boton
        bt1.setMargin(new Insets(1,5,1,5));
        bt2.setMargin(new Insets(1,5,1,5));
        bt3.setMargin(new Insets(1,5,1,5));
        bt4.setMargin(new Insets(1,5,1,5));

        //Añadir listener de eventos para manipular eventos del click
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza prog al hacer click en x
        jf.setResizable(false);
        jf.setLocation((int)(d.getWidth()/2+2), 50);//ubicar donde se ubica la ventana al principio
        jf.setSize(600,300);//setear tamaño de ventana
        jf.setVisible(true);//setear visualizacion de la ventana
    }

    public static void main(String[] args){
        Main gj= new Main();//uso de constructor para la ventana
    }

    @Override
    public void actionPerformed(ActionEvent e){

        double nr;
        DecimalFormat df = new DecimalFormat("#.00");

        if(e.getSource()==bt1){
            Double  n1 = Double.parseDouble(jt1.getText());
            Double n2 = Double.parseDouble(jt2.getText());

            nr = n1+n2;

            jt3.setText("" + df.format(nr));
        }else if(e.getSource()==bt2) {
            Double  n1 = Double.parseDouble(jt1.getText());
            Double n2 = Double.parseDouble(jt2.getText());

            nr = n1-n2;
            jt3.setText(""+df.format(nr));
        }else if(e.getSource()==bt3){
            Double  n1 = Double.parseDouble(jt1.getText());
            Double n2 = Double.parseDouble(jt2.getText());

            nr = n1*n2;
            jt3.setText(""+df.format(nr));
        }else if(e.getSource()==bt4){
            Double  n1 = Double.parseDouble(jt1.getText());
            Double n2 = Double.parseDouble(jt2.getText());

            nr = n1/n2;
            jt3.setText(""+df.format(nr));

        }
    }
}
