package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TankDrive;

public class DriveDistance extends Command{
    private final TankDrive m_drive;
    private double m_distance;
    private double m_speed;
    private double start_encoders;
    private boolean m_complete = false;
    
    public DriveDistance(double inches, double speed, TankDrive subsystem){
        m_distance = inches;
        m_speed = speed;
        m_drive = subsystem;
        addRequirements(m_drive);
    }

    @Override
    public void initialize(){
        m_complete = false;
        start_encoders = m_drive.getAvgEncoder();
    }

 

    @Override
    public void execute(){
            if(Math.abs(m_drive.getDistanceTraveled()-start_encoders)>=m_distance){
                m_drive.drive(0.0,0.0,true);
                m_complete = true;
            }else{
                m_drive.drive(m_speed,m_speed,true);
            }
    
        // }else{
        //     if(Math.abs(m_drive.getAverageEncoderDistanceInches()-start_encoders)<=m_distance){
        //         m_drive.drive(0.0,0.0,0.0);
        //         m_complete = true;
        //     }else{
        //         m_drive.drive(m_speed,0.0,0.0);
        //     }
    
        // }
    }

    @Override
    public void end(boolean interrupted){
        m_drive.drive(0.0, 0.0, false);
    }

    @Override
    public boolean isFinished(){
        return m_complete;
    }
    
}