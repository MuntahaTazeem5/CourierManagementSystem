/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.couriermanagementsystem;

/**
 *
 * @author hp
 */
import javax.swing.*;
import java.awt.event.*;

class Courier {

    private String senderName;
    private String receiverName;
    private String address;
    private String trackingID;
    private double charges;


    public Courier(String senderName, String receiverName, String address,
                   String trackingID, double charges){

        this.senderName = senderName;
        this.receiverName = receiverName;
        this.address = address;
        this.trackingID = trackingID;
        this.charges = charges;
    }


    public String getSenderName(){
        return senderName;
    }

    public String getReceiverName(){
        return receiverName;
    }

    public String getAddress(){
        return address;
    }

    public String getTrackingID(){
        return trackingID;
    }

    public double getCharges(){
        return charges;
    }
}


public class CourierManagementSystem extends JFrame implements ActionListener {

    JTextField senderField;
    JTextField receiverField;
    JTextField addressField;
    JTextField trackingField;
    JTextField chargesField;

    JButton addButton;
    JButton statusButton;
    JButton clearButton;
    JTextArea result;

    Courier courier;

    public CourierManagementSystem(){

        setTitle("Courier Management System");
        setSize(550,550);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Sender Name:");
        l1.setBounds(50,50,120,30);

        senderField = new JTextField();
        senderField.setBounds(180,50,220,30);

        JLabel l2 = new JLabel("Receiver Name:");
        l2.setBounds(50,100,120,30);

        receiverField = new JTextField();
        receiverField.setBounds(180,100,220,30);

        JLabel l3 = new JLabel("Address:");
        l3.setBounds(50,150,120,30);

        addressField = new JTextField();
        addressField.setBounds(180,150,220,30);

        JLabel l4 = new JLabel("Tracking ID:");
        l4.setBounds(50,200,120,30);

        trackingField = new JTextField();
        trackingField.setBounds(180,200,220,30);

        JLabel l5 = new JLabel("Charges:");
        l5.setBounds(50,250,120,30);

        chargesField = new JTextField();
        chargesField.setBounds(180,250,220,30);

        addButton = new JButton("Add Courier");
        addButton.setBounds(40,320,130,40);

        statusButton = new JButton("Tracking Status");
        statusButton.setBounds(190,320,150,40);

        clearButton = new JButton("Clear");
        clearButton.setBounds(370,320,90,40);

        result = new JTextArea();
        result.setBounds(80,390,350,100);

        add(l1);
        add(senderField);

        add(l2);
        add(receiverField);

        add(l3);
        add(addressField);

        add(l4);
        add(trackingField);

        add(l5);
        add(chargesField);


        add(addButton);
        add(statusButton);
        add(clearButton);

        add(result);

        addButton.addActionListener(this);
        statusButton.addActionListener(this);
        clearButton.addActionListener(this);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addButton){
            courier = new Courier(

                    senderField.getText(),
                    receiverField.getText(),
                    addressField.getText(),
                    trackingField.getText(),
                    Double.parseDouble(chargesField.getText())

            );
            result.setText(

                    "Courier Added Successfully\n\n"+ "Tracking ID: "+courier.getTrackingID()

            );

        }
        if(e.getSource()==statusButton){
            String status = JOptionPane.showInputDialog(
                    "Enter Status (Delivered / On the Way)"
            );
            result.setText(

                    "Courier Status\n\n"+"Sender: "+courier.getSenderName()+"\nReceiver: "+courier.getReceiverName()+
                    "\nTracking ID: "+courier.getTrackingID()+ "\nStatus: "+status);
        }
        if(e.getSource()==clearButton){

            senderField.setText("");
            receiverField.setText("");
            addressField.setText("");
            trackingField.setText("");
            chargesField.setText("");
            result.setText("");
        }
    }
    public static void main(String args[]){
        new CourierManagementSystem();
    }
}