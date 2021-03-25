package calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;

public class GUI extends JFrame implements ActionListener{
	private Calculator cal = new Calculator();
	private JTextField input = new JTextField(25);
	private int middle_index = 0;
	private boolean part_one = true;
	private boolean activated = false;
	private boolean error = false;
	/**
	 * Constructor
	 */
	public GUI() {
		super("Calculator");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,350);
		
		JPanel up   = new JPanel();
		up.add(input);
		this.add(up, BorderLayout.NORTH);
		
		JPanel down = new JPanel();
		down.setLayout(new GridLayout(4,4));
		this.add(down);
		
        
	
		JButton zero = new JButton("0");
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");								
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		JButton POW = new JButton("POW");
		JButton sqrt = new JButton("sqrt");
		JButton ln = new JButton("ln");
		JButton egal = new JButton("=");
		JButton divide = new JButton("/");
		JButton multiply = new JButton("*");
		JButton factorielle = new JButton("!");
		JButton minus = new JButton("-");
		JButton plus = new JButton("+");
		JButton C = new JButton("C");
		down.add(zero);
		down.add(one);
		down.add(two);
		down.add(three);
		down.add(C);
		down.add(four);
		down.add(five);
		down.add(six);
		down.add(seven);
		down.add(factorielle);										
		down.add(eight);
		down.add(nine);
		down.add(plus);
		down.add(minus);
		down.add(multiply);
		down.add(POW);
		down.add(sqrt);
		down.add(ln);
		down.add(egal);
		down.add(divide);
		zero.addActionListener(this);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);								
		nine.addActionListener(this);
		POW.addActionListener(this);
		sqrt.addActionListener(this);
		ln.addActionListener(this);
		egal.addActionListener(this);
		divide.addActionListener(this);
		multiply.addActionListener(this);
		factorielle.addActionListener(this);
		minus.addActionListener(this);
		plus.addActionListener(this);
		C.addActionListener(this);
		input.setEditable(false);
        setVisible(true);
		
	}
	/**
	 * Calls a specific function depending on the button clicked.
	 */
	public void actionPerformed(ActionEvent e) {	//actions differentes dependement du bouton clique
		String str = e.getActionCommand();
		if (str == "+") {
			if(middle_index != 0) {
			second_setter(input.getText());
			cal.add();
			if(activated == false) {
			input.setText(input.getText()+str);
			}
			else {
				input.setText(input.getText()+str);
				}
			if(error == true)Resetter();
			}
			}
		if (str == "-") {
			if(middle_index != 0 && middle_index != input.getText().length()-1) {
			second_setter(input.getText());
			cal.substract();
			}
			if(input.getText().equals("-")==false) {
				if(middle_index ==0) { middle_index += 1;}
				input.setText(input.getText()+str);
			}
			if(error == true)Resetter();
		}
		if (str == "*") {
			if(middle_index != 0) {
			second_setter(input.getText());
			cal.multiply();
			if(activated == false) {
				input.setText(input.getText()+str);
				}
				else {input.setText(input.getText()+str);}
			}
			if(error == true)Resetter();
		}
		if (str == "/") {
			if(middle_index != 0) {
			second_setter(input.getText());
			cal.divide();
			if(activated == false) {
				input.setText(input.getText()+str);
				}
				else {input.setText(input.getText()+str);}
			}
			if(error == true)Resetter();
		}
		if (str == "!") {
			if(middle_index != 0) {
			second_setter(input.getText());
			cal.factorial();
			input.setText(input.getText()+str);
			}
		}
		if (str == "POW") {
			if(middle_index != 0) {
			second_setter(input.getText());
			cal.pow();
			input.setText(input.getText()+str);
			middle_index += 2;
			}
		}
		if (str == "sqrt") {
			if(middle_index != 0) {
			second_setter(input.getText());
			cal.rootSquare();
			input.setText(input.getText()+str);
			middle_index += 3;
			}
		}
		if (str == "ln") {
			if(middle_index != 0) {
			second_setter(input.getText());
			cal.nepLog();
			input.setText(input.getText()+str);
			middle_index += 1;
			}
		}
		if (str == "=") {
			if(middle_index != 0) {
			if(second_getter(input.getText()).isEmpty() == false) {
			second_setter(second_getter(input.getText()));
			}
			cal.compute();
			input.setText(Double.toString(cal.getSecond()));
			part_one = true;
			middle_index = Double.toString(cal.getSecond()).length();
			activated = true;
			}
		}
		if (str == "C") {
			Resetter();
		}
		if(double_tester(str)==true) {
			input.setText(input.getText()+str);
			if(part_one==true) {
			middle_index += 1;
			}
		}
		
		
	}
	/**
	 * Resets the calculator
	 */
	public void Resetter() {
		input.setText("");
		middle_index = 0;
		part_one = true;
		cal.clear();
		activated = false;
		error = false;
	}
	/**
	 * Tests if the string represents one of the number buttons or not
	 * @param str Input string which can be either a number or one of the other buttons
	 * @return
	 */
	public boolean double_tester(String str) {
		String[] temp = {"+","-","*","/","!","POW","sqrt","ln","=","C"};       
		for (String i : temp) {
			if (i == str) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Parses the received string and sends it to Calculator.java
	 * @param str a number which will be parsed.
	 */
	public void second_setter(String str) {
		try {
		cal.setSecond(Double.parseDouble(str));								
		part_one = false;
		}
		catch(NumberFormatException k){
			System.out.println("Please only use 1 operator");
			error = true;
		}
	}
	/**
	 * Finds the second number and returns it
	 * @param str Current text that's displayed in the JTextField
	 * @return value of the second number as a string
	 */
	public String second_getter(String str) {								
		String new_second = "";
		for(int k = middle_index+1; k < str.length();k++) {
			new_second += str.charAt(k);
		}
		return new_second;
	}
	/**
	 * Creation a new GUI
	 * @param args
	 */
	public static void main(String[] args) {
		GUI test = new GUI();
	}
	
}
