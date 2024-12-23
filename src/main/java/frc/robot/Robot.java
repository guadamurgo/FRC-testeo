package frc.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;


public class Robot extends TimedRobot {

  // Motores lanzamiento
  private final Spark motorArribaLanzamiento = new Spark(0); // Puerto PWM 0
  private final Spark motorAbajoLanzamiento = new Spark(1); // Puerto PWM 1

  // Joystick
  private final Joystick joystick = new Joystick(0); // Puerto USB 0

  // boton para activar los motores lanzamiento
  private final int botonActivarTiro = 1; // Botón 1 del joystick

  //boton de disparo forzado
  private final int botonDisparoForzado = 2; // botón 2 del joystick

  // temporizador lanzamiento disparo forzado
  private final Timer timer = new Timer();

  // indicar si los motores lanzamiento están activos
  private boolean estanActivos = false;

  // sensor para detectar si hay un disco zona de lanzamiento
  private final DigitalInput sensorDisco = new DigitalInput(0); // Puerto DIO 0

  //Indica si se encuentra o no un disco zona de lanzamiento
  private boolean hayDisco = false; //no importa que inicie en falso porque este valor se actualiza todo el tiempo

  @Override
  public void robotPeriodic() {
    //esto se esta actualizando todo el tiempo
    hayDisco = sensorDisco.get(); // true si el sensor detecta el disco, false si no
  }

  @Override
  public void teleopPeriodic() {
    Lanzamiento.lanzamientoPeriodico(motorArribaLanzamiento, motorAbajoLanzamiento, joystick, botonActivarTiro, botonDisparoForzado, timer, estanActivos, sensorDisco, hayDisco);
  }
}