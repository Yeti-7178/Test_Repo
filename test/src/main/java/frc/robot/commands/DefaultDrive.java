import java.util.function.DoubleSupplier;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class DefaultDrive extends Command {
    private final TankDrive m_drive;
    private final Double m_xSpeed;
    private final Double m_zRotation;
    public final boolean m_joyInput;

    
    public DefaultDrive(TankDrive subsystem, Double xSpeed, double zRotation, Boolean joyInput){
        m_drive = subsystem;
        m_xSpeed = xSpeed;
        m_zRotation = zRotation;
        m_joyInput = joyInput;
        addRequirements(m_drive);
    }

    @Override
    public void execute(){
        m_drive.drive(m_xSpeed, m_zRotation, m_joyInput);
    }
}