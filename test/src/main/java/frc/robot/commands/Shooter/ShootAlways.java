package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Solenoids;

public class ShootAlways extends Command{
    Shooter m_shoot;
    Solenoids m_solenoid;
    double m_speed;
    boolean m_complete;
    public ShootAlways(Shooter shoot, Solenoids solenoid ,double speed){
        this.m_shoot = shoot;
        m_solenoid = solenoid;
        this.m_speed = speed;
        addRequirements(shoot);
    }
    @Override
    public void initialize() {
        m_complete = false;

        m_solenoid.intakeToggle();
    }
    @Override
    public void execute() {
        m_shoot.runShooter(.5);
    }
    @Override
    public void end(boolean interrupted) {
    }
    @Override
    public boolean isFinished() {
        return m_complete;
    }
    
}
