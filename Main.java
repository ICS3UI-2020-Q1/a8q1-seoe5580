import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JTextField nameInput;

  JLabel nameOutput;

  JButton sayHelloButton;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    // initialize the main JPanel
    mainPanel = new JPanel();
    // Tells the main panel that we are doing manual layout
    mainPanel.setLayout(null);

    // Declares sayHello button
    sayHelloButton = new JButton("Say Hello");
    // using set bound it will locate the button
    sayHelloButton.setBounds(300,300,200,50);
    // add the action listener to the button
    sayHelloButton.addActionListener(this);
    // set the action command on the button so we know which button was pressed
    sayHelloButton.setActionCommand("Say Hello");

    // Declares the output panel
    nameOutput = new JLabel();
    // using the set bound it will locate the output label
    nameOutput.setBounds(350,200,400,50);

    // Declares the textfield so users could write
    nameInput = new JTextField();
    // using the set bound it will locate the text field
    nameInput.setBounds(200,100,400,50);

    // add the say hello button to the panel
    mainPanel.add(sayHelloButton);
    // add the output to the panel
    mainPanel.add(nameOutput);
    // add the text fields for users input to the Panel
    mainPanel.add(nameInput);
    // add the panel to the window
    frame.add(mainPanel);
  }
  
  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // gets the command from the action
    String command = e.getActionCommand();
    // using the if statement when it the button was pressed it will do the following
    if(command.equals("Say Hello")){
      // get the name from the user
      String name = nameInput.getText();
      // prints out Hello and the user's input
      nameOutput.setText("Hello " + name);
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}