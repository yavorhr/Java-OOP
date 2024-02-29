package p06_TirePressureMonitoringSystem;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

  @Test
  public void testAlarmIsTurnedOnDueLowPressure() {
    Sensor sensor = Mockito.mock(Sensor.class);
    Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.9);
    Alarm alarm = new Alarm(sensor);

    alarm.check();
    Assert.assertTrue(alarm.getAlarmOn());
  }

  @Test
  public void testAlarmIsTurnedOnDueHighPressure() {
    Sensor sensor = Mockito.mock(Sensor.class);
    Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.5);
    Alarm alarm = new Alarm(sensor);

    alarm.check();
    Assert.assertTrue(alarm.getAlarmOn());
  }

  @Test
  public void testAlarmIsTurnedOff() {
    Sensor sensor = Mockito.mock(Sensor.class);
    Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.00);
    Alarm alarm = new Alarm(sensor);

    alarm.check();
    Assert.assertFalse(alarm.getAlarmOn());
  }
}