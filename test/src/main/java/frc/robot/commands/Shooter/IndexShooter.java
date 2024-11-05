package frc.robot.commands.Shooter;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Solenoids;

public class IndexShooter extends Command{
    Shooter m_shoot;
    Solenoids m_solenoids;
    double m_speed;
    boolean m_complete;
    public IndexShooter(Shooter shoot,Solenoids solenoids, double d){
        this.m_shoot = shoot;
        this.m_solenoids = solenoids;
        this.m_speed = d;


        addRequirements(shoot);
    }
    @Override
    public void initialize() {
        m_complete = false;

    }
    @Override
    public void execute() {

        if(m_shoot.getLimit() == false){
            m_shoot.runShooter(m_speed);
        }
        else{
            m_shoot.runShooter(0);
            m_complete = true;
        }
    }
    @Override
    public void end(boolean interrupted) {
        m_shoot.runShooter(0);
    }
    @Override
    public boolean isFinished() {
        return m_complete;
    }

    
}
