// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.ArrayList;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.IntegerSubscriber;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Commands.DiffDrive;
import frc.robot.Drivetrain;
import frc.robot.Commands.Auton;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  public static final Joystick m_stick = new Joystick(0);
  public static final Drivetrain DRIVETRAIN = new Drivetrain();

  private NetworkTableInstance networkTableInstance;

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //CommandScheduler.getInstance().setDefaultCommand(DRIVETRAIN, new diffDrive());

  }

  @Override
  public void teleopPeriodic() {
    DRIVETRAIN.arcadeDrive(m_stick);
  }

  @Override
  public void autonomousInit() {
    //auton = new Auton(DRIVETRAIN, m_stick, networkTableInstance);
  }

  @Override
  public void autonomousPeriodic() {
    // System.out.print("wow");
    // auton.execute();

    //apriltagData.addAll(apriltagData)
    
    
    //SmartDashboard.putNumber("jet", apriltagSubX.get()); 
  }
}
