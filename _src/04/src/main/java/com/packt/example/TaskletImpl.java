package com.pact.example;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.ExitStatus;

public class TaskletImpl implements Tasklet{

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
    
    public ExitStatus execute() throws Exception {
        System.out.print(message);
        return ExitStatus.FINISHED;
    }
}
