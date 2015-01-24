package org.usfirst.frc.team4553.robot;

import edu.wpi.first.wpilibj.Joystick;            // Joystick module
import edu.wpi.first.wpilibj.SampleRobot;         // Basic Program Hierarchy        
import edu.wpi.first.wpilibj.Timer;               // It's a Timer.
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;  //Dashboard interfacing tools
import edu.wpi.first.wpilibj.RobotDrive;          // Robot Drive toolkit
//import edu.wpi.first.wpilibj.Encoder;             // Encoder module

public class Robot extends SampleRobot {
	
    Joystick mainStick = new Joystick(0);         // declaring Joystick object
    RobotDrive chassis = new RobotDrive(0,1,2,3); //PWM ports for motors
	double rotation = 0;
	double gyroAngle = 0;
	
    public void robotInit() {	
    }
    
    public void autonomous() {
    	
    }
        
    //Operator Function and main loop (called when TeleOp is Enabled)
    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
        	
        	//Rotation values vary from -0.5 to 0.5 based on buttons 4 & 5
        	if (mainStick.getRawButton(4) == true && mainStick.getRawButton(5) == false){
        		rotation = -0.5;
        	}else if (mainStick.getRawButton(5) == true && mainStick.getRawButton(4) == false){
        		rotation = 0.5;
        	}else{
        		rotation = 0;}
        	
        	//Driving function (gyroAngle is permanently 0)
        	chassis.mecanumDrive_Cartesian(mainStick.getX(), mainStick.getY(), rotation, gyroAngle);
        	
        	//Displaying Joystick output on the Dashboard
        	SmartDashboard.putNumber("Joystick_Y", mainStick.getY());
        	SmartDashboard.putNumber("Joystick_X", mainStick.getX());
        	
        	//Timer to avoid a framerate bomb and alleviate CPU strain
        	Timer.delay(0.005);
        }
    }
}