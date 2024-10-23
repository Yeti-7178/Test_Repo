package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsConstants;

public class Solenoids extends SubsystemBase{
    final Compressor m_compress = new Compressor(PneumaticsConstants.kCompressor, PneumaticsModuleType.CTREPCM);
    static Solenoid m_intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
    static Solenoid m_shooterSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 2);
    
    public static void intakeToggle() {
        m_intakeSolenoid.toggle();
    }
    public static void shooterToggle() {
        m_shooterSolenoid.toggle();
    }
}