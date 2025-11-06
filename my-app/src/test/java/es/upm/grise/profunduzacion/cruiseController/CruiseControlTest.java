package es.upm.grise.profunduzacion.cruiseController;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;
import es.upm.grise.profundizacion.exceptions.IncorrectSpeedSetException;
import es.upm.grise.profundizacion.exceptions.SpeedSetAboveSpeedLimitException;


class CruiseControlTest {
	
    @Mock
    Speedometer speedometer = mock(Speedometer.class);

    @Test
    public void testIncorrectSpeedSetException() {
        CruiseControl cc = new CruiseControl(speedometer);
        assertThrows(IncorrectSpeedSetException.class,  () -> cc.setSpeedSet(-1));
    }

    @Test
    public void testSpeedSetAboveSpeedLimitException() {
        CruiseControl cc = new CruiseControl(speedometer);
        cc.setSpeedLimit(10);
        assertThrows(SpeedSetAboveSpeedLimitException.class,  () -> cc.setSpeedSet(20));
    }
}
