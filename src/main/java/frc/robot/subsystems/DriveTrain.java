// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  public static Talon leftMaster;
  public static Talon leftSlave;
  public static Talon rightMaster;
  public static Talon rightSlave;

  public static DifferentialDrive differentialDrive;
  public static MotorControllerGroup leftMotors;
  public static MotorControllerGroup rightMotors;

  public static ADXRS450_Gyro gyro;

  private boolean isInverted;

  public DriveTrain() {
    leftMaster = new Talon(Constants.LEFT_MASTER);
    leftSlave = new Talon(Constants.LEFT_SLAVE);
    rightMaster = new Talon(Constants.RIGHT_MASTER);
    rightMaster = new Talon(Constants.RIGHT_SLAVE);

    leftMotors = new MotorControllerGroup(leftMaster, leftSlave);
    rightMotors = new MotorControllerGroup(rightMaster, rightSlave);

    leftMotors.setInverted(true);
    isInverted = true;

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }


  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }
  

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  public boolean isInverted() {
    return isInverted;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
