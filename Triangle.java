package myCodes;

public class Triangle {
	double base;
	double height;
	double length1;
	double length2;
	double length3;
	
	public Triangle (double base, double height, 
			         double length1, double length2, double length3) {
		this.base = base;
		this.height = height;
		this.length1 = length1;
		this.length2 = length2;
		this.length3 = length3;
		
}
	public double Area() {
		return ((this.base)*(this.height)/2);
	}
}