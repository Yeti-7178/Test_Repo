package frc.robot.commands.auton;

// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import edu.wpi.first.wpilibj2.command.WaitCommand;
// import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.Shooter.ShootCatapult;
import frc.robot.commands.drive.DefaultDrive;
import frc.robot.commands.drive.DriveDistance;
// import frc.robot.commands.drive.DriveDistance;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Solenoids;
import frc.robot.subsystems.TankDrive;
import frc.robot.commands.Shooter.IndexShooter;
import frc.robot.commands.Shooter.ShootAlways;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;




public class Auton1 extends SequentialCommandGroup{
    public Auton1(TankDrive drive, Shooter Shooter, Intake Intake, Solenoids solenoids){
        addCommands
        (
            new SequentialCommandGroup(
                new DriveDistance(15, .4, drive),
                new WaitCommand(3),
                new ShootAlways(Shooter, solenoids, 0)
            )
            
        );
    }    
}
