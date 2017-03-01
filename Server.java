//This is not encoded properly; copy and paste this 
//into the actual application when finished.


//This piece of code will act as the server.

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;

	//constructor
	public Server(){
		super("Instant messenger");
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
			new ActionListener(){ //waits for you to type stuff and press enter.
				public void actionPerformed(ActionEvent event){
					sendMessage(event.getActionCommand());
					userText.setText("");
					
				}
			}
		
		);
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300, 150);
		setVisible (true);
	}
	
	//setting up and running the server
	public void startRunning(){
		try{
			//port number is 6789, remember to open up the port in your router later
			//backlog of 100 --> how many clients(?) can access the port
			server = new ServerSocket(6789, 100); 
			
			while (true){
				try{
					waitForConnection();
					setupStreams();
					whileChatting();
					
				}catch (EOFException eofException){
					showMessage ("\n Server onnection ended.");
				}finally{
					closeStream();
				}
			}
		}catch (IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	//waiting for connection
	private void waitForConnection(){
		showMessage("Waiting for someone to connect...\n");
		connection = server.accept();
		showMessage("Connection establisheddddddd dawg. Connected to " +connection.getInetAddress().getHostName() +"\n");
	}
	
	//get stream to send and receive data
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("Streams are now up \n");
		
	}
	
	private void whileChatting() throws IOException{
		String msg = "You are now connected! ";
		sendMessage(msg);
		ableToType(true);
		do{
			try{
				msg = (String) input.readObject();
				showMessage("\n"+msg);
			}catch (ClassNotFoundException classNotFoundException){
				showMessage("\n something went wrong lol");
			}
		}while(!message.equals("CLIENT - END"));
	}
	
	//Closing and emptying the streams and connection.
	//Housekeeping
	private void closeStream(){
		showMessage("\n Closing connection \n");
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}catch (IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	//Sending the messages
	private void sendMessage(String message){
		try{
			output.writeObject("SERVER - " + message);
			output.flush();
			showMessage("\nSERVER - "+message);
		}catch(IOException ioException){
			chatWindow.append("\nCANNOT SEND MESSAGE");
		}
	}
	
	//chatWindow update
	private void showMessage(final String text){
		
	}
	
	
}



























