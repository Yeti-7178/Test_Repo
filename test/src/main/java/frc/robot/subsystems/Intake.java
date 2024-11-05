package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.ShooterConstants;

public class Intake extends SubsystemBase{
    CANSparkMax m_shooterMotor = new CANSparkMax(IntakeConstants.kIntakePort, MotorType.kBrushed);
    public Intake(){ 
        m_shooterMotor.restoreFactoryDefaults();
        

        m_shooterMotor.setSmartCurrentLimit(OperatorConstants.kCurrentLimit);
        
        m_shooterMotor.setIdleMode(IdleMode.kBrake);
        

    }
    
    public void runIntake(double speed){
        m_shooterMotor.set(speed);
    }
    
}
