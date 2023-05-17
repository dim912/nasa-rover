package gov.nasa.mas.rover.model;

import gov.nasa.mas.rover.service.RoverField;
import jakarta.validation.constraints.NotNull;

public class Rover {

    private String name;
    @NotNull
    private int positionX;
    @NotNull
    private int positionY;
    @NotNull
    private Direction direction;

    public Rover(){
    }

    public Rover(int positionX, int positionY, Direction direction){
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }

    public boolean move(Action action, Command command,RoverField roverField) {
        if (action == Action.f || action == Action.b) {
            int incomingDir = action == Action.f ? 1 : -1;
            int facingDir = (direction == Direction.W || direction == Direction.S) ? -1 : 1;
            int newPositionX = (direction == Direction.E || direction == Direction.W) ? this.positionX +  incomingDir * facingDir: this.positionX;
            int newPositionY = (direction == Direction.S || direction == Direction.N) ? this.positionY + incomingDir * facingDir: this.positionY;
            if(roverField.isCellOccupied(newPositionX,newPositionY)){
                command.setCommandExecutionMessage(action + " : This move cause to collision. Hence ignored");
                return false;
            }
            else{
                roverField.releaseCell(this.positionX,this.positionY);
                this.positionX = newPositionX;
                this.positionY= newPositionY;
                roverField.occupyCell(newPositionX,newPositionY);
                command.setCommandExecutionMessage(action + " : success");
            }
        } else if (action == Action.r){
            this.direction = this.direction.nextClockWiseDir();
        } else if (action == Action.l) {
            this.direction = this.direction.nextAntiClockWiseDir();
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
