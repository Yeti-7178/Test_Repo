package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class TankDrive extends SubsystemBase {
    CANSparkMax m_Right1 = new CANSparkMax(TankConstants.kRightFrontPort , MotorType.kBrushless );
    CANSparkMax m_Left1 = new CANSparkMax(TankConstants.kLeftFrontPort , MotorType.kBrushless );
    CANSparkMax m_Right2 = new CANSparkMax(TankConstants.kRightRearPort , MotorType.kBrushless );
    CANSparkMax m_Left2 = new CANSparkMax(TankConstants.kLeftRearPort , MotorType.kBrushless );

    RelativeEncoder m_EncoderRight1 = m_Right1.getEncoder();
    RelativeEncoder m_EncoderLeft1 = m_Left1.getEncoder();

    double gearboxRatio = 8.46;
    double wheelRadius = 6;
    double brakingForce = 70;

    public double getInches( double rotations ) {
        return rotations * 2 * Math.PI * (wheelRadius / gearboxRatio);
    }

    public double leftInches() {
        return getInches(m_EncoderLeft1.getPosition());
    }

    public double rightInches() {
        return getInches(m_EncoderRight1.getPosition());
    }

    public double getHeadingDeg() {
        return ( leftInches() - rightInches() ) * ( 360 / 21.5 );
    }

    public double getDistanceTraveled() { 
        return ( leftInches() + rightInches() ) / 2;
    }

    public double getVelocityInPerSec() {
        double averageRPM = (m_EncoderLeft1.getVelocity() + m_EncoderRight1.getVelocity()) / 2;
        return getInches(averageRPM) / 60;
    }

    public double getBrakingDistance() {
        double velocity = getVelocityInPerSec();
        double brakingTime = velocity / brakingForce;
        return ( (brakingForce) * ( Math.pow(brakingTime, 2) ) + (velocity * brakingTime) );

    }

    DifferentialDrive m_drive = new DifferentialDrive(m_Left1, m_Right1);
    public TankDrive() {
        m_Right1.follow(m_Right2);
        m_Left1.follow(m_Left2);

        m_Right1.restoreFactoryDefaults();
        m_Right2.restoreFactoryDefaults();
        m_Left1.restoreFactoryDefaults();
        m_Left2.restoreFactoryDefaults();

        m_Right1.setSmartCurrentLimit(OperatorConstants.kCurrentLimit);
        m_Right2.setSmartCurrentLimit(OperatorConstants.kCurrentLimit);
        m_Left1.setSmartCurrentLimit(OperatorConstants.kCurrentLimit);
        m_Left2.setSmartCurrentLimit(OperatorConstants.kCurrentLimit);

        m_Right1.setIdleMode(IdleMode.kBrake);
        m_Left1.setIdleMode(IdleMode.kBrake);
        m_Right2.setIdleMode(IdleMode.kBrake);

        m_Right1.setInverted(true);
        m_Right2.setInverted(true);
    }

    public void drive(double leftSpeed, double rightSpeed, boolean b){
        m_drive.tankDrive( leftSpeed , rightSpeed, b);
    }

    public void setBrakeMode(){
        m_Left1.setIdleMode(IdleMode.kBrake);
        m_Left2.setIdleMode(IdleMode.kBrake);
        m_Right1.setIdleMode(IdleMode.kBrake);
        m_Right2.setIdleMode(IdleMode.kBrake);
    }
    public void setCoastMode(){
        m_Left1.setIdleMode(IdleMode.kCoast);
        m_Left2.setIdleMode(IdleMode.kCoast);
        m_Right1.setIdleMode(IdleMode.kCoast);
        m_Right2.setIdleMode(IdleMode.kCoast);
    }
    
}
