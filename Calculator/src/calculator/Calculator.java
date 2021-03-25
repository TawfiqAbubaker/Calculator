package calculator;
public class Calculator {
	private double first;
	private double second;
	private String oP = new String();
	//getters and setters for first
	public double getFirst() {
		return first;
	}
	public void setFirst(double first) {
		this.first = first;
	}
	//getters and setters for second
	public double getSecond() {
		return second;
	}
	public void setSecond(double second) {
		this.second = second;
	}
	
	//getters and setters for oP

	public String getoP() {
		return oP;
	}
	public void setoP(String oP) {
		this.oP = oP;
	}
	
	
	public Calculator() {  //constructeur sans argument
	}
	void operation(String str) {
		first = second; // garde la 1er operande
		second = 0; // initialise et mise à jour pour la 2ème operande
		oP = str;

	}
	void add() { operation("+"); }
	void substract() { operation("-"); }
	void multiply() { operation("*"); }
	void divide() { operation("/"); }
	void factorial() { operation("!"); }           //operations
	void pow() { operation("POW"); }
	void rootSquare() { operation("sqrt"); }
	void nepLog() { operation("ln"); }
	void compute() {								//calcule le resultat
		if (oP == "+") {
			 second = first + second;
		}
		if (oP == "-") {
			second = first - second;
		}
		if (oP == "*") {
			second = first * second;
		}
		if (oP == "/") {
			second = first / second;
		}
		if (oP == "!") {
			if (first == 0) {second = 1;}
			else {
			second = Math.round(((Math.sqrt(2*Math.PI*first))*(Math.pow(first/2.718,first))*(1+(1/(12*first)))));
		}
		}
		if (oP == "POW") {
			second = Math.pow(first,second);
		}
		if (oP == "sqrt") {
			second = Math.sqrt(first);
		}
		if (oP == "ln") {
			second = Math.log(first);
		}
	}
	void clear() {						//reset les valeurs
		first = 0;
		second = 0;
		oP = "";
	}
	double display() {
		return second;					//retourne second
	}
}
