package gov.nasa.mas.rover.service;

import gov.nasa.mas.rover.model.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverFieldTest {

    @Test
    void addARover_success() {
        RoverField roverField = new RoverField();
        Rover rover = new Rover();
        roverField.addARover(rover);
        Rover roverR = roverField.getARoverByName("R0");
        assertNotNull(roverR); //rover regisration is successful
    }

    @Test
    void addARover_fails_when_overlap() {
        RoverField roverField = new RoverField();
        Rover rover = new Rover();
        rover.setPositionX(5);
        rover.setPositionX(11);
        roverField.addARover(rover);
        Exception e = assertThrows(RuntimeException.class, () -> roverField.addARover(rover));
        assertEquals("There is a rover exist at this coordinate", e.getMessage());
    }
}