package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkLowLevel;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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


    
    public double getAvgEncoder(){
        return ((getLeftFrontEncoder() + getRightFrontEncoder()) /2) ;
    }
    public double getLeftFrontEncoder(){
        return m_EncoderLeft1.getPosition();
    }
    public double getRightFrontEncoder(){
        return m_EncoderRight1.getPosition();
    }
    public double getAverageEncoderDistanceInches(){
        return TankConstants.kEncoderConversionFactor * (getLeftFrontEncoder()+getRightFrontEncoder())/2;
    }

    
    DifferentialDrive m_drive = new DifferentialDrive(m_Left1, m_Right1);
    public TankDrive() {
        // m_time.start();
        m_Right1.restoreFactoryDefaults();
        m_Right2.restoreFactoryDefaults();
        m_Left1.restoreFactoryDefaults();
        m_Left2.restoreFactoryDefaults();
        m_Right2.follow(m_Right1);
        m_Left2.follow(m_Left1);


        m_Right1.setSmartCurrentLimit(OperatorConstants.kCurrentLimit);
        m_Right2.setSmartCurrentLimit(OperatorConstants.kCurrentLimit);
        m_Left1.setSmartCurrentLimit(OperatorConstants.kCurrentLimit);
        m_Left2.setSmartCurrentLimit(OperatorConstants.kCurrentLimit);

        m_Right1.setIdleMode(IdleMode.kCoast);
        m_Left1.setIdleMode(IdleMode.kCoast);
        m_Right2.setIdleMode(IdleMode.kCoast);
        m_Left2.setIdleMode(IdleMode.kCoast);

        m_Right1.setInverted(false);
        m_Right2.setInverted(false);

        m_Left1.setInverted(true);
        m_Left2.setInverted(true);

        

    }

    public void drive(Double leftSpeed, Double rightSpeed, boolean b){
        m_drive.tankDrive( leftSpeed , rightSpeed, b);
    }

   
    @Override
    public void periodic() {
        // SmartDashboard.putNumber("Rotations", getInches(getAvgEncoder()));
    }
    
}
