package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShootCatapult extends Command{
    Shooter m_shoot;
    double m_speed;
    boolean m_complete;
    public ShootCatapult(Shooter shoot, double speed){
        this.m_shoot = shoot;
        this.m_speed = speed;
        addRequirements(shoot);
    }
    @Override
    public void initialize() {
        m_complete = false;
    }
    @Override
    public void execute() {
        if(m_shoot.getLimit() == true){
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
