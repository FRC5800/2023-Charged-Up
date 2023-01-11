// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  
  WPI_TalonSRX rightMaster = new WPI_TalonSRX(1);
  WPI_TalonSRX rightSlave = new WPI_TalonSRX(2);
  WPI_TalonSRX leftMaster = new WPI_TalonSRX(3);
  WPI_TalonSRX leftSlave = new WPI_TalonSRX(4);

  private DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  
  /** Creates a new DriveTrain. */
  public DriveTrain() {

    rightSlave.follow(rightMaster);
    leftSlave.follow(leftMaster);

    rightMaster.setInverted(true);

  }

  public void stopMotors() {
    drive.stopMotor();
  }

  public void arcadeDrive(double fwd, double rot) {

    drive.arcadeDrive(fwd, rot);

  }
  
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
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


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

}