package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.Shooter.ShootCatapult;
import frc.robot.commands.drive.DriveDistance;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TankDrive;
import frc.robot.commands.Shooter.IndexShooter;
import frc.robot.subsystems.Intake;


public class Auton1 extends SequentialCommandGroup{
    public Auton1(TankDrive drive, Shooter Shooter, Intake Intake ){
        addCommands
        (
            new SequentialCommandGroup
            (
                new ShootCatapult(Shooter , 1),
                new ParallelCommandGroup
                (
                    new DriveDistance(150, 0.5, drive),
                    new SequentialCommandGroup
                    (
                        new IndexShooter(Shooter, Intake , 1),
                        new WaitCommand(9)
                    )
                ),
                new DriveDistance(-150, -0.5, drive),
                new ShootCatapult(Shooter, 1)
            )
        );
    }    
}
