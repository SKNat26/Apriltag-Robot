package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TurnToTag extends CommandBase {
    private Supplier<Double> x_offset;

    public TurnToTag(Supplier<Double> x_offset) {
        this.x_offset = x_offset;
        addRequirements(Robot.DRIVETRAIN);
      }
    
      // Called when the command is initially scheduled.
      @Override
      public void initialize() {}
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
        if(x_offset.get() != -999999) {
            if(x_offset.get() < -10) {
                Robot.DRIVETRAIN.arcadeDrive(0.2, -0.2);
                System.out.println("turn left");
            } else if (x_offset.get() > 10) {
                Robot.DRIVETRAIN.arcadeDrive(-0.2, 0.2);
                System.out.println("turn right");
            }
        }
        
      }
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {
        Robot.DRIVETRAIN.stop();
      }
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return x_offset.get() > -10 && x_offset.get() < 10;
      }
}
