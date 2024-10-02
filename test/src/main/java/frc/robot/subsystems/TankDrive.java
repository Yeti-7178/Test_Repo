package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkLowLevel;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController; // motor manager we should use instead of other previous things. very useful
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankDrive extends SubsystemBase {
    PWMSparkMax m_Right1 = new PWMSparkMax(Constants.OperatorConstants.kRightFrontPort);
    PWMSparkMax m_Left1 = new PWMSparkMax(Constants.OperatorConstants.kLeftFrontPort);
    PWMSparkMax m_Right2 = new PWMSparkMax(Constants.OperatorConstants.kRightRearPort);
    PWMSparkMax m_Left2 = new PWMSparkMax(Constants.OperatorConstants.kLeftRearPort);

    DifferentialDrive m_drive = new DifferentialDrive(m_Left1, m_Right1);
    public TankDrive() {
        m_Right1.addFollower(m_Right2);
        m_Left1.addFollower(m_Left2);

        m_Right1.restoreFactoryDefaults();
        m_Right2.restoreFactoryDefaults();
        m_Left1.restoreFactoryDefaults();
        m_Left2.restoreFactoryDefaults();

        m_Right1.setSmartCurrentLimit(Constants.OperatorConstants.kCurrentLimit);
        m_Right2.setSmartCurrentLimit(Constants.OperatorConstants.kCurrentLimit);
        m_Left1.setSmartCurrentLimit(Constants.OperatorConstants.kCurrentLimit);
        m_Left2.setSmartCurrentLimit(Constants.OperatorConstants.kCurrentLimit);

        m_Right1.setIdleMode(IdleMode.kBrake);
        m_Left1.setIdleMode(IdleMode.kBrake);
        m_Right2.setIdleMode(IdleMode.kBrake);
        m_Left1.setIdleMode(IdleMode.kBrake);

        m_Right1.setInverted(true);
        m_Right2.setInverted(true);
    }
    public void drive(double xSpeed, double zRotation, boolean b){
        m_drive.tankDrive(xSpeed, -zRotation, b);
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
