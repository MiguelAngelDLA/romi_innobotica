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
            new Translation2d(0.3, -0.5)
        ),
        new Pose2d(0.32, -0, Rotation2d.fromDegrees(-90)),
        config);


        return exampleTrajectory;
    }

    public Trajectory thirdMove(){
        config.setReversed(false);
        Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0.32, 0, new Rotation2d(-90)),
        List.of(
            new Translation2d(0.32, -0.3)
        ),
        new Pose2d(0.6, -0.6, Rotation2d.fromDegrees(-90)),
        config);


        return exampleTrajectory;
    }

    public Trajectory fourthMove(){
        config.setReversed(true);
        Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0.6, -0.6, new Rotation2d(-90)),
        List.of(
            new Translation2d(0.6, -0.2)
        ),
        new Pose2d(0.6, 0.15, Rotation2d.fromDegrees(-90)),
        config);


        return exampleTrajectory;
    }

    public Trajectory fithMove(){
        config.setReversed(false);
        Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0.6, 0.15, new Rotation2d(-90)),
        List.of(
            new Translation2d(0.75, -0.3)
        ),
        new Pose2d(1.15, -0.7, Rotation2d.fromDegrees(-90)),
        config);


        return exampleTrajectory;
    }

    public Trajectory sixthMove(){
        config.setReversed(true);
        Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(1.15, -0.7, new Rotation2d(-90)),
        List.of(
            new Translation2d(1.2, -0.3)
        ),
        new Pose2d(1.3, -0, Rotation2d.fromDegrees(-90)),
        config);


        return exampleTrajectory;
    }
}
