package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot blank = new Robot(400, 200);
		Robot blank2 = new Robot(400, 300);
		Robot blank3 = new Robot(400, 400);
		Robot blank4 = new Robot(500, 250);
		Robot blank5 = new Robot(500, 350);
		blank.setSpeed(10);
		blank.penDown();
		blank2.setSpeed(10);
		blank2.penDown();
		blank3.setSpeed(10);
		blank3.penDown();
		blank4.setSpeed(10);
		blank4.penDown();
		blank5.setSpeed(10);
		blank5.penDown();
		Thread r1 = new Thread(() -> bots(blank));
		r1.start();

		Thread r2 = new Thread(() -> bots(blank2));
		r2.start();

		Thread r3 = new Thread(() -> bots(blank3));
		r3.start();

		Thread r4 = new Thread(() -> bots(blank4));
		r4.start();

		Thread r5 = new Thread(() -> bots(blank5));
		r5.start();
	}

	public static void bots(Robot b) {
		for (int i = 0; i < 360; i++) {
			b.setAngle(i);
			b.move(1);
		}
	}
}
