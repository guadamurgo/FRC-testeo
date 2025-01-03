package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Movimiento;

public class MovimientoCommand extends Command {
    private DoubleSupplier xAxisSupplier;
    private DoubleSupplier yAxisSupplier;
    private Movimiento subSystem;

    public MovimientoCommand(Movimiento subSystem, DoubleSupplier xAxisSupplier, DoubleSupplier yAxisSupplier){
        this.xAxisSupplier = xAxisSupplier;
        this.yAxisSupplier = yAxisSupplier;
        this.subSystem = subSystem;
        addRequirements(subSystem);
    }

    @Override
    public void execute(){
        double xAxis = xAxisSupplier.getAsDouble();
        double yAxis = yAxisSupplier.getAsDouble();
        
        subSystem.drive(xAxis, yAxis);
    }

    @Override
    public void initialize(){}

    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
        subSystem.stop();
    }
}