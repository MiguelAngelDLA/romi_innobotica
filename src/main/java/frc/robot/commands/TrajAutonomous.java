package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.trajectories.FirstCuadrant;

public class TrajAutonomous extends SequentialCommandGroup{

    FirstCuadrant firstCuadrant = new FirstCuadrant();
    public TrajAutonomous(Drivetrain drivetrain){

        var ResetOdometry = new InstantCommand(() -> drivetrain.resetOdometry(firstCuadrant.firstMove().getInitialPose()));
        var ResetGyro = new InstantCommand(() -> drivetrain.resetGyro());

        addCommands(
            ResetGyro,
            ResetOdometry,
            drivetrain.createCommandForTrajectory(firstCuadrant.firstMove(), true),
            new InstantCommand(() -> drivetrain.resetOdometry(firstCuadrant.secondMove().getInitialPose())),
            drivetrain.createCommandForTrajectory(firstCuadrant.secondMove(), true),
            new InstantCommand(() -> drivetrain.resetOdometry(firstCuadrant.thirdMove().getInitialPose())),
            drivetrain.createCommandForTrajectory(firstCuadrant.thirdMove(), true),
            new InstantCommand(() -> drivetrain.resetOdometry(firstCuadrant.fourthMove().getInitialPose())),
            drivetrain.createCommandForTrajectory(firstCuadrant.fourthMove(), true),
            new InstantCommand(() -> drivetrain.resetOdometry(firstCuadrant.fithMove().getInitialPose())),
            drivetrain.createCommandForTrajectory(firstCuadrant.fithMove(), true)
        );
    }
    
}
