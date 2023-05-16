package gov.nasa.mas.rover.model;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {

    @NotNull
    private String command;
    private List<Action> actions;

    private List<String> commandExecutionStatusList ;

    private Rover rover;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
        actions=Arrays.stream(command.split(",")).map(Action::valueOf).toList();
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public void setCommandExecutionMessage(String commandExecutionMessage) {
        if(commandExecutionStatusList == null){
            commandExecutionStatusList = new ArrayList<>();
        }
        commandExecutionStatusList.add(commandExecutionMessage);
    }

    public List<String> getCommandExecutionStatusList() {
        return commandExecutionStatusList;
    }

    public void setCommandExecutionStatusList(List<String> commandExecutionStatusList) {
        this.commandExecutionStatusList = commandExecutionStatusList;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
