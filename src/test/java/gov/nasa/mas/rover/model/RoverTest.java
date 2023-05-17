package gov.nasa.mas.rover.model;

import gov.nasa.mas.rover.service.RoverField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {


    @Test
    void move_forward_north() {
        Rover rover = new Rover(5, 11, Direction.N);
        Command command = new Command();
        RoverField field = new RoverField();
        rover.move(Action.f, command, field);
        Assertions.assertEquals(12, rover.getPositionY());
    }

    @Test
    void move_forward_east() {
        Rover rover = new Rover(5, 11, Direction.E);
        Command command = new Command();
        RoverField field = new RoverField();
        rover.move(Action.f, command, field);
        Assertions.assertEquals(6, rover.getPositionX());
    }

    @Test
    void move_forward_south() {
        Rover rover = new Rover(5, 11, Direction.S);
        Command command = new Command();
        RoverField field = new RoverField();
        rover.move(Action.f, command, field);
        Assertions.assertEquals(10, rover.getPositionY());
    }

    @Test
    void move_forward_west() {
        Rover rover = new Rover(5, 11, Direction.W);
        Command command = new Command();
        RoverField field = new RoverField();
        rover.move(Action.f, command, field);
        Assertions.assertEquals(4, rover.getPositionX());
    }

    @Test
    void move_back_north() {
        Rover rover = new Rover(5, 11, Direction.S);
        Command command = new Command();
        RoverField field = new RoverField();
        rover.move(Action.b, command, field);
        Assertions.assertEquals(12, rover.getPositionY());
    }

    @Test
    void move_back_east() {
        Rover rover = new Rover(5, 11, Direction.W);
        Command command = new Command();
        RoverField field = new RoverField();
        rover.move(Action.b, command, field);
        Assertions.assertEquals(6, rover.getPositionX());
    }

    @Test
    void move_back_south() {
        Rover rover = new Rover(5, 11, Direction.N);
        Command command = new Command();
        RoverField field = new RoverField();
        rover.move(Action.b, command, field);
        Assertions.assertEquals(10, rover.getPositionY());
    }

    @Test
    void move_back_west() {
        Rover rover = new Rover(5, 11, Direction.E);
        Command command = new Command();
        RoverField field = new RoverField();
        rover.move(Action.b, command, field);
        Assertions.assertEquals(4, rover.getPositionX());
    }

    @Test
    void rotateRight() {
        Rover rover = new Rover(5, 11, Direction.N);
        Command command = new Command();
        RoverField field = new RoverField();
        rover.move(Action.r, command, field);
        Assertions.assertEquals(5, rover.getPositionX());
        Assertions.assertEquals(11, rover.getPositionY());
        Assertions.assertEquals(Direction.E, rover.getDirection());

        rover.move(Action.r, command, field);
        Assertions.assertEquals(5, rover.getPositionX());
        Assertions.assertEquals(11, rover.getPositionY());
        Assertions.assertEquals(Direction.S, rover.getDirection());

        rover.move(Action.r, command, field);
        Assertions.assertEquals(5, rover.getPositionX());
        Assertions.assertEquals(11, rover.getPositionY());
        Assertions.assertEquals(Direction.W, rover.getDirection());

        rover.move(Action.r, command, field);
        Assertions.assertEquals(5, rover.getPositionX());
        Assertions.assertEquals(11, rover.getPositionY());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    void rotateLeft() {
        Rover rover = new Rover(5, 11, Direction.N);
        Command command = new Command();
        RoverField field = new RoverField();
        rover.move(Action.l, command, field);
        Assertions.assertEquals(5, rover.getPositionX());
        Assertions.assertEquals(11, rover.getPositionY());
        Assertions.assertEquals(Direction.W, rover.getDirection());

        rover.move(Action.l, command, field);
        Assertions.assertEquals(5, rover.getPositionX());
        Assertions.assertEquals(11, rover.getPositionY());
        Assertions.assertEquals(Direction.S, rover.getDirection());

        rover.move(Action.l, command, field);
        Assertions.assertEquals(5, rover.getPositionX());
        Assertions.assertEquals(11, rover.getPositionY());
        Assertions.assertEquals(Direction.E, rover.getDirection());

        rover.move(Action.l, command, field);
        Assertions.assertEquals(5, rover.getPositionX());
        Assertions.assertEquals(11, rover.getPositionY());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

}