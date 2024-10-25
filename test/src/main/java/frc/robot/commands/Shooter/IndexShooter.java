package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class IndexShooter extends Command{
    Shooter m_shoot;
    Intake m_intake;
    double m_speed;
    boolean m_complete;
    public IndexShooter(Shooter shoot, Intake intake ,double speed){
        this.m_shoot = shoot;
        this.m_intake = intake;
        this.m_speed = speed;

        addRequirements(shoot, intake);
    }
    @Override
    public void initialize() {
        m_complete = false;
        m_intake.runIntake(.75);
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
        m_intake.runIntake(0);
    }
    @Override
    public boolean isFinished() {
        return m_complete;
    }

    
}
