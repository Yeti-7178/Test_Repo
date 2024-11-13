// package frc.robot.commands.drive;

// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.subsystems.TankDrive;

// public class TurnAngleDeg extends Command {
//     private double m_angle;
//     private double m_speed;
//     private TankDrive m_drive;
//     private boolean m_turnLeft;
//     private boolean m_complete = false;
    
//     public TurnAngleDeg(double angleDeg, double speed, TankDrive subsystem){
//         m_angle = angleDeg;
//         m_speed = speed;
//         m_drive = subsystem;
//         addRequirements(m_drive);
//     }

//     @Override
//     public void initialize() {
//         m_turnLeft = (m_angle < 0);
//         m_angle += m_drive.getHeadingDeg();
//     }

//     @Override
//     public void execute() {
//         if (m_drive.getHeadingDeg() > m_angle && m_turnLeft == false){
//             m_drive.drive(m_speed,m_speed * -1, true);
//         }
//         else if (m_drive.getHeadingDeg() < m_angle && m_turnLeft == true){
//             m_drive.drive(m_speed * -1,m_speed, true);
//         }
//         else {
//             m_complete = true;
//         }
//     }

//     @Override
//     public boolean isFinished() {
//         return m_complete;
//     }

// }
