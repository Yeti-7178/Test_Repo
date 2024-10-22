package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.Subsystem;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooter extends SubsystemBase {
    public static Command Fire() throws InterruptedException { 
        // fires the slingshot then reloads. 
        // is command class because .onTrue only takes Commands
        
        DigitalInput limitSwitch1 = new DigitalInput(3);
        CANSparkMax sparkMotor1 = new CANSparkMax(0, MotorType.kBrushless);
        sparkMotor1.set(0.5);
        Thread.sleep(300);

        while (!limitSwitch1.get()) {
            sparkMotor1.set(0.5);
        }

        sparkMotor1.set(0);        
        limitSwitch1.close();
        sparkMotor1.close();   
        return new Command() {};
    }
}
