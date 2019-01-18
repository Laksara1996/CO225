//package lab02;

public class E15048Ball {		//Main Class

	public static void main(String[] args) {
	
		Ball b1 = new Ball(0.0, 1.0, 10.0, 45.0);	//Ball b1 object
		Ball.updateTime(5.0);
		
		Ball b2 = new Ball(0.0, 1.0, 20.0, 45.0);	//Ball b2 object
		Ball.updateTime(5.0);
	
		if(b2.willCollide(b1)  == true)
			System.out.println("B1 and B2 will collide ");
		else
			System.out.println("B1 and B2 won't collide");
		
		Ball b3 = new Ball(-10.0, 5.0, 3.0, 30.0);	//Ball b3 object
		Ball.updateTime(20.0);
		
		if( b2.willCollide(b3) == true)
			System.out.println("B2 and B3 will collide ");
		else
			System.out.println("B2 and B3 won't collide");

	}
}

class Ball {		//Ball Class
	
	private double x = 0.0;
	private double y = 0.0;
	private double speed = 0.0;
	private double angleOfSpeedWithX = 0.0;
	public static double timeTotal = 0.0;
	public static double currentTime = 0.0;
	
	public Ball(double x, double y, double speed, double angleOfSpeedWithX) {		//Balls info
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.angleOfSpeedWithX = angleOfSpeedWithX;
	}
	
	public static void updateTime(double time) {		//Updating time
		currentTime = timeTotal;	//previous time before updating the new time
		timeTotal += time;			//total time
	}
	
	public boolean willCollide(Ball b1) {		//Check if the two balls will collide

		b1.x += (b1.speed * Math.cos(Math.toRadians(b1.angleOfSpeedWithX)) * timeTotal);		//Given ball x position update
		b1.y += (b1.speed * Math.sin(Math.toRadians(b1.angleOfSpeedWithX)) * timeTotal);		//Given ball y position update
		
		x += (speed * Math.cos(Math.toRadians(angleOfSpeedWithX)) * (timeTotal - currentTime));		//Ball object x position update
		y += (speed * Math.sin(Math.toRadians(angleOfSpeedWithX)) * (timeTotal - currentTime));		//Ball object y position update
		
		return ((b1.x == x) && (b1.y == y));		//Return true if the 2 balls collide
	}
}

