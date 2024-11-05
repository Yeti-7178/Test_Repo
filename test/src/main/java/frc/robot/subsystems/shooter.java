package frc.robot.subsystems;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.ShooterConstants;


public class Shooter extends SubsystemBase {
    DigitalInput m_limitSwitch = new DigitalInput(0);
    CANSparkMax m_shooterMotor = new CANSparkMax(ShooterConstants.kShooterPort, MotorType.kBrushed);
    public Shooter(){ 
        m_shooterMotor.restoreFactoryDefaults();
        

        m_shooterMotor.setSmartCurrentLimit(OperatorConstants.kCurrentLimit);
        
        m_shooterMotor.setIdleMode(IdleMode.kBrake);

    }
    public boolean getLimit(){
        return m_limitSwitch.get();
    }
    public void runShooter(double speed){
        m_shooterMotor.set(speed);
    }
    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Limit", getLimit());
    }
}
