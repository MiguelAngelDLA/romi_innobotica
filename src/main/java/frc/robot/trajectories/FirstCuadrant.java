package frc.robot.trajectories;

import java.util.List;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;

public class FirstCuadrant {
    DifferentialDriveVoltageConstraint autoVoltageConstraint =
        new DifferentialDriveVoltageConstraint(
            new SimpleMotorFeedforward(DriveConstants.ksVolts, 
                                       DriveConstants.kvVoltSecondsPerMeter, 
                                       DriveConstants.kaVoltSecondsSquaredPerMeter),
            DriveConstants.kDriveKinematics,
            5);

    TrajectoryConfig config =
    new TrajectoryConfig(AutoConstants.kMaxSpeedMetersPerSecond, 
                         AutoConstants.kMaxAccelerationMetersPerSecondSquared)
        .setKinematics(DriveConstants.kDriveKinematics)
        .addConstraint(autoVoltageConstraint);

    public Trajectory firstMove(){
        config.setReversed(false);
        Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0.05, -0.5, new Rotation2d(0)),
        List.of(
            new Translation2d(0.15, -0.6)
        ),
        new Pose2d(0.23, -1, Rotation2d.fromDegrees(-90)),
        config);


        return exampleTrajectory;
    }

    public Trajectory secondMove(){
        config.setReversed(true);
        Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0.23, -1, new Rotation2d(-90)),
        List.of(
            new Translation2d(0.23, -0.5)
        ),
        new Pose2d(0.25, -0.2, Rotation2d.fromDegrees(-90)),
        config);


        return exampleTrajectory;
    }

    public Trajectory thirdMove(){
        config.setReversed(false);
        Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0.23, -0.2, new Rotation2d(-90)),
        List.of(
            new Translation2d(0.3, -0.3)
        ),
        new Pose2d(0.35, -0.5, Rotation2d.fromDegrees(-90)),
        config);


        return exampleTrajectory;
    }
}
