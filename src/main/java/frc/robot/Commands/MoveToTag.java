package frc.robot.Commands;

import java.util.function.Supplier;

import javax.swing.plaf.synth.SynthSeparatorUI;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
import frc.robot.Robot;

public class MoveToTag extends CommandBase {
    private Supplier<Double> distance;

    public MoveToTag(Supplier<Double> distance) {
        this.distance = distance;
        addRequirements(Robot.DRIVETRAIN);
      }
    
      // Called when the command is initially scheduled.
      @Override
      public void initialize() {}
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
        if(distance.get() > 30) Robot.DRIVETRAIN.arcadeDrive(-0.2, -0.2);
        System.out.println("move");
    }
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {
        Robot.DRIVETRAIN.stop();
      }
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return distance.get() < 30;
      }
}
