package frc.robot.commands.drive;

import java.util.function.DoubleSupplier;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class DefaultDrive extends Command {
    private final TankDrive m_drive;
    private final DoubleSupplier m_leftSpeed;
    private final DoubleSupplier m_rightRotation;
    public final boolean m_joyInput;

    
    public DefaultDrive(TankDrive subsystem, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed, Boolean joyInput){
        m_drive = subsystem;
        m_leftSpeed = leftSpeed;
        m_rightRotation = rightSpeed;
        m_joyInput = joyInput;
        addRequirements(m_drive);
    }

    @Override
    public void execute(){
        m_drive.drive(m_leftSpeed.getAsDouble(), m_rightRotation.getAsDouble(), m_joyInput);
    }
}