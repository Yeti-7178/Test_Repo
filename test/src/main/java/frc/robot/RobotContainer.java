// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Solenoids;
import frc.robot.subsystems.TankDrive;
import pabeles.concurrency.ConcurrencyOps.NewInstance;

import java.util.Timer;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OIConstants;
import frc.robot.Constants.TankConstants;
import frc.robot.commands.Shooter.IndexShooter;
import frc.robot.commands.Shooter.ShootCatapult;
import frc.robot.commands.auton.Auton1;
// import frc.robot.commands.auton.Auton1;
import frc.robot.commands.drive.DefaultDrive;
// import frc.robot.commands.drive.DriveDistance;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final TankDrive m_chassisSubsystem = new TankDrive();
  // The robot's subsystems and commands are defined here...
  private final Solenoids m_solenoid = new Solenoids();
  private final Intake m_intake = new Intake();
  private final Shooter m_shooter = new Shooter();
  

  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  
  // Replace with CommandPS4Controller or CommandJoystick if needed
  XboxController m_driverController = new XboxController(OIConstants.controller1);
  XboxController m_coDriverController = new XboxController(OIConstants.controller2);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    
    configureBindings();
    m_chassisSubsystem.setDefaultCommand(new DefaultDrive(
            m_chassisSubsystem,
            () -> m_driverController.getLeftY() * .75,
            () -> m_driverController.getRightY() * .75,
            true));
           
    
    m_chooser.setDefaultOption("Move back", new Auton1(m_chassisSubsystem, m_shooter, m_intake, m_solenoid));
    SmartDashboard.putData(m_chooser);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new JoystickButton(m_coDriverController,  Button.kB.value)
    // .onTrue(
    //   // new InstantCommand(Solenoids::shooterToggle)

    // );
    new JoystickButton(m_coDriverController,  Button.kLeftBumper.value)
    .onTrue(
        new InstantCommand(m_solenoid::intakeToggle)
    );
    
    new JoystickButton(m_coDriverController, Button.kRightBumper.value)
    .onTrue(
      // new ShootCatapult(m_shooter, m_solenoid, 0)
      new InstantCommand(m_solenoid::shooterToggle)
    );
    
    new JoystickButton(m_coDriverController, Button.kB.value)
    .onTrue(
      new IndexShooter(m_shooter,m_intake ,m_solenoid ,.5)
      // new InstantCommand(()->m_shooter.runShooter(.5))
    );
    // .onFalse(
    //   // new IndexShooter(m_shooter, m_intake, m_solenoid ,.75)
    //   // new InstantCommand(()->m_shooter.runShooter(0))
    // );
    new JoystickButton(m_coDriverController, Button.kA.value)
    .onTrue(
      new InstantCommand(()->m_shooter.runShooter(.5))
    )
    .onFalse(
      new InstantCommand(()->m_shooter.runShooter(0))
    );
    new JoystickButton(m_coDriverController, Button.kX.value)
    .onTrue(
      new InstantCommand(()->m_intake.runIntake(.5))
    )
    .onFalse(
      new InstantCommand(()->m_intake.runIntake(0))
    );
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
    // An example command will be run in autonomous
  }
}
