package businesscard;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
public class AddShop extends JFrame
{
	GradientPanel p1;
	JPanel p2;
	JLabel l1,l2,title,l3;
	JTextField tf1,tf2;
	JButton b1,b2;
	Font f1;
public AddShop(){
	super("Add Shop Keeper Screen");
	
	p1 = new GradientPanel(600,200);
	p1.setLayout(null);
	
	f1 = new Font("Courier New",Font.BOLD,14);
	p2 = new TitlePanel(600,60);
	p2.setBackground(new Color(204, 110, 155));
	title = new JLabel("<HTML><BODY><CENTER>UNIVERSAL BUSINESS CARD USING RFID</CENTER></BODY></HTML>");
	title.setForeground(Color.white);
	title.setFont(new Font("Times New ROMAN",Font.PLAIN,17));
	p2.add(title);

	l3 = new JLabel("Add Shop Keeper Screen");
	l3.setFont(new Font("Courier New",Font.BOLD,13));
	l3.setBounds(250,20,200,30);
	p1.add(l3);

	l1 = new JLabel("Shop Keeper Id");
	l1.setFont(f1);
	l1.setBounds(150,60,200,30);
	p1.add(l1);
	tf1 = new JTextField(15);
	tf1.setFont(f1);
	tf1.setBounds(300,60,130,30);
	p1.add(tf1);
	
	l2 = new JLabel("Shop Keeper Name");
	l2.setFont(f1);
	l2.setBounds(150,110,200,30);
	p1.add(l2);
	tf2 = new JPasswordField(15);
	tf2.setFont(f1);
	tf2.setBounds(300,110,130,30);
	p1.add(tf2);

	JPanel pan3 = new JPanel(); 
	b1 = new JButton("Add");
	b1.setFont(f1);
	b1.setBounds(220,160,80,30);
	p1.add(b1);
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			addShop();
		}
	});
	b2 = new JButton("Reset");
	b2.setFont(f1);
	b2.setBounds(320,160,80,30);
	p1.add(b2);
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			tf1.setText("");
			tf2.setText("");
		}
	});

	getContentPane().add(p1,BorderLayout.CENTER);
	getContentPane().add(p2,BorderLayout.NORTH);
}
public void clear(){
	tf1.setText("");
	tf2.setText("");
}
public void addShop(){
	String user = tf1.getText();
	String pass = tf2.getText();
	
	if(user == null || user.trim().length() <= 0){
		JOptionPane.showMessageDialog(this,"Username must be enter");
		tf1.requestFocus();
		return;
	}
	if(pass == null || pass.trim().length() <= 0){
		JOptionPane.showMessageDialog(this,"Password must be enter");
		tf2.requestFocus();
		return;
	}
	try{
		String input[] = {user,pass};
		String msg = DBCon.addShop(input);
		if(msg.equals("success")){
			JOptionPane.showMessageDialog(this,"Shop keeper details added");
			setVisible(false);
		}else{
			JOptionPane.showMessageDialog(this,"Error in adding shop keeper details");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
