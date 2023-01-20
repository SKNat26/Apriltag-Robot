// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
    private final WPI_TalonSRX leftMotorOne;
    private final WPI_TalonSRX leftMotorTwo;
    private final WPI_TalonSRX rightMotorOne;
    private final WPI_TalonSRX rightMotorTwo;
    private final DifferentialDrive drive;
    private final MotorControllerGroup mLeft;
    private final MotorControllerGroup mRight;

  public Drivetrain() {
    leftMotorOne = new WPI_TalonSRX(1);
    leftMotorTwo = new WPI_TalonSRX(2);
    rightMotorOne = new WPI_TalonSRX(3);
    rightMotorTwo = new WPI_TalonSRX(4);
    mLeft = new MotorControllerGroup(leftMotorOne, leftMotorTwo);
    mRight = new MotorControllerGroup(rightMotorOne, rightMotorTwo);
    mRight.setInverted(true);
    configureMotors();
    drive = new DifferentialDrive(mLeft, mRight);
  }

  public void arcadeDrive(Joystick stick){
    drive.arcadeDrive(stick.getY(), -stick.getTwist());
  }

  private void configureMotors(){
    leftMotorOne.configFactoryDefault();
    leftMotorTwo.configFactoryDefault();
    rightMotorOne.configFactoryDefault();
    rightMotorTwo.configFactoryDefault();
    leftMotorOne.setNeutralMode(NeutralMode.Brake);
    leftMotorTwo.setNeutralMode(NeutralMode.Brake);
    rightMotorOne.setNeutralMode(NeutralMode.Brake);    
    rightMotorTwo.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
  }
}
