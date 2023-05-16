package gov.nasa.mas.rover.service;

import gov.nasa.mas.rover.model.Command;
import gov.nasa.mas.rover.model.Rover;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RoverField{

    private final Map<String,Rover> roversMap = new ConcurrentHashMap<>();
    private final Set<String> occupiedCoordinates =  new HashSet<String>();

    public Rover addARover(Rover rover){
        rover.setName("R"+roversMap.size());
        if(occupiedCoordinates.contains(rover.getPositionX()+","+rover.getPositionY())){
           throw new RuntimeException("There is a rover exist at this coordinate");
        }
        occupiedCoordinates.add(rover.getPositionX()+","+rover.getPositionY());
        roversMap.put(rover.getName(),rover);
        return rover;
    }

    public Rover getARoverByName(String name){
        return roversMap.get(name);
    }

    public boolean runCommand(String name,Command command) {
        Rover rover = this.roversMap.get(name);
        command.setRover(rover);
        return command.getActions().stream().map(action-> rover.move(action,command,this)).filter(f->!f).findAny().orElse(true);
    }

    public void releaseCell(int positionX, int positionY){
        occupiedCoordinates.remove(positionX + "," + positionY);
    }

    public void occupyCell(int positionX, int positionY){
        occupiedCoordinates.add(positionX + "," + positionY);
    }

    public boolean isCellOccupied(int positionX, int positionY){
        return occupiedCoordinates.contains(positionX+","+positionY);
    }

}
