package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsConstants;

public class Solenoids extends SubsystemBase{
    static Compressor m_compress = new Compressor(17, PneumaticsModuleType.CTREPCM);
    static Solenoid m_intakeSolenoid = new Solenoid(17,PneumaticsModuleType.CTREPCM, 4);
    static Solenoid m_shooterSolenoid = new Solenoid(17, PneumaticsModuleType.CTREPCM, 3);
    public Solenoids(){

    }
    public void enableCompressor(){
        m_compress.enableAnalog(0, 60.0);
    }
    public static void disableCompressor(){
        m_compress.disable();
    }
    
    public void intakeToggle() {
        m_intakeSolenoid.toggle();
    }
    public void shooterToggle() {
        m_shooterSolenoid.toggle();
    }
    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Voltage", m_compress.getPressureSwitchValue());
        SmartDashboard.putBoolean("Is active", m_compress.isEnabled());

    }
}