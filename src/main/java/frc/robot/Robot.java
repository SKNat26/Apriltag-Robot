// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.BooleanSubscriber;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.IntegerSubscriber;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.PubSubOption;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.DiffDrive;
import frc.robot.Commands.MoveToTag;
import frc.robot.Commands.TurnToTag;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  
  public static final Drivetrain DRIVETRAIN = new Drivetrain();
  public static final Joystick m_stick = new Joystick(0);
  public static final JoystickButton move = new JoystickButton(m_stick, 1);
  public static final JoystickButton turn = new JoystickButton(m_stick, 2);



  private NetworkTableInstance networkTableInstance;
  private DoubleSubscriber apriltagSubX;
  private DoubleSubscriber apriltagSubY;
  private IntegerSubscriber apriltagId;
  private DoubleSubscriber apriltagDistance;
  private BooleanSubscriber apriltagDetected;

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void robotInit() {
    networkTableInstance = NetworkTableInstance.getDefault();
    
    NetworkTable apriltagData = networkTableInstance.getTable("SmartDashboard");
    apriltagSubX = apriltagData.getDoubleTopic("X Offset").subscribe(-999999, PubSubOption.periodic(0.02));
    apriltagSubY = apriltagData.getDoubleTopic("Y Offset").subscribe(-999999, PubSubOption.periodic(0.02));
    apriltagId = apriltagData.getIntegerTopic("id").subscribe(-1, PubSubOption.periodic(0.02));
    apriltagDistance = apriltagData.getDoubleTopic("Distance").subscribe(-1, PubSubOption.periodic(0.02));
    apriltagDetected = apriltagData.getBooleanTopic("detected").subscribe(false, PubSubOption.periodic(0.02));
    move.whileTrue(new MoveToTag(() -> apriltagDistance.get()));
    turn.whileTrue(new TurnToTag(() -> apriltagSubX.get()));


    // autocommand_one = new RepeatCommand(new TurnToTag(() -> apriltagSubX.get()));
    // autocommand_two = new RepeatCommand(new MoveToTag(() -> apriltagDistance.get()));
   
    
    // CommandScheduler.getInstance().registerSubsystem(DRIVETRAIN);
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    
    

  }

  public void teleopInit() {
    CommandScheduler.getInstance().setDefaultCommand(DRIVETRAIN, new DiffDrive());
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
    //  CommandScheduler.getInstance().setDefaultCommand(DRIVETRAIN, new DiffDrive());
  }

  @Override
  public void autonomousInit() {

   
    
    // autocommand_one = new RepeatCommand(new TurnToTag(() -> apriltagSubX.get()));
    // autocommand_two = new RepeatCommand(new MoveToTag(() -> apriltagDistance.get()));
    // autocommand_one.schedule();
    // autocommand_two.schedule();
  }

  @Override
  public void autonomousPeriodic() {
    // Double x_offset = this.apriltagSubX.get();
    // Double y_offset = this.apriltagSubY.get();
    // Long id = this.apriltagId.get();
    // Double distance = this.apriltagDistance.get();
    // Boolean detected = this.apriltagDetected.get();
    // if(distance > 30){
    //   DRIVETRAIN.arcadeDrive(0.2, x_offset, distance);
    //   System.out.println(distance);
    // } 
    // System.out.print(x_offset);
    
    
    /*
    System.out.print(x_offset);
    System.out.print(" " + y_offset);
    System.out.print(" " + id);
    System.out.print(" " + distance);
    System.out.print(" " + detected);
    System.out.println();
    */

  }
}
