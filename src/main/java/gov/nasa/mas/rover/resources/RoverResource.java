package gov.nasa.mas.rover.resources;

import gov.nasa.mas.rover.model.Command;
import gov.nasa.mas.rover.model.Rover;
import gov.nasa.mas.rover.service.RoverField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rover")
public class RoverResource {

    @Autowired
    private RoverField RoverField;

    @PostMapping
    public Rover create(@Validated  @RequestBody  Rover rover){
        return RoverField.addARover(rover);
    }

    @GetMapping("/{name}")
    public Rover create(@PathVariable  String name){
        return RoverField.getARoverByName(name);
    }

    @PostMapping("/{name}/command")
    public ResponseEntity<Command> command(@PathVariable String name, @Validated  @RequestBody Command command){
        boolean runStatus = RoverField.runCommand(name,command);
        if(!runStatus){
            return ResponseEntity.badRequest().body(command);
        }
        return ResponseEntity.ok(command);
    }

}
