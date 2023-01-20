// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import java.util.ArrayList;

import edu.wpi.first.networktables.BooleanSubscriber;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.IntegerSubscriber;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Drivetrain;

public class Auton extends CommandBase {
  private Drivetrain drivetrain;
  private Joystick joystick;
  private NetworkTableInstance nInstance;
  private DoubleSubscriber apriltagSubX;
  private DoubleSubscriber apriltagSubY;
  private IntegerSubscriber apriltagId;
  private DoubleSubscriber apriltagDistance;
  private BooleanSubscriber apriltagDetected;


  
  public Auton(Drivetrain drivetrain, Joystick joystick, NetworkTableInstance nInstance) {
    this.drivetrain = drivetrain;
    this.joystick = joystick;
    this.nInstance = nInstance;
    nInstance = NetworkTableInstance.getDefault();
    NetworkTable apriltagData = nInstance.getTable("SmartDashboard");
    this.apriltagSubX = apriltagData.getDoubleTopic("X Offset").subscribe(-999999);
    this.apriltagSubY = apriltagData.getDoubleTopic("Y Offset").subscribe(-999999);
    this.apriltagId = apriltagData.getIntegerTopic("id").subscribe(-1);
    this.apriltagDistance = apriltagData.getDoubleTopic("Distance").subscribe(-1);
    this.apriltagDetected = apriltagData.getBooleanTopic("detected").subscribe(false);

    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Double x_offset = this.apriltagSubX.get();
    Double y_offset = this.apriltagSubY.get();
    Long id = this.apriltagId.get();
    Double distance = this.apriltagDistance.get();
    Boolean detected = this.apriltagDetected.get();
    
    System.out.println(x_offset);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
