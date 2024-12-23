// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    

    public static final int kCurrentLimit = 40;

    public static final boolean squareInputs = true;

    
  }
  public static final class OIConstants {
    public static final int controller1 = 0;
    public static final int controller2 = 1;
  }
  public static final class ShooterConstants{
    public static int kShooterPort = 5;
  }
  public static final class PneumaticsConstants{
    public static int kCompressor = 4;
  }
  public static final class IntakeConstants{
    public static int kIntakePort = 14;
  }

  public static final class TankConstants{
    public static int kLeftRearPort = 1;
    public static int kRightRearPort = 18;
    public static int kLeftFrontPort = 19;
    public static int kRightFrontPort = 20;
    public static final double kEncoderConversionFactor = 6 * Math.PI / 9.52;

  }
}
/* */