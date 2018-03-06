package bpmn;


import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;

@ProcessApplication("Jira Ticket Update Listener")
public class JiraTicketUpdateListener extends ServletProcessApplication {
    // empty implementation
}