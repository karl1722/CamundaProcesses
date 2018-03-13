package bpmn;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import primary.jiraRestClient;

public class ProcessCreateAnswerTicket implements JavaDelegate{


    private final static Logger LOGGER = Logger.getLogger("ANSWER-PROCESS");

    public void execute(DelegateExecution execution) throws Exception {

        String questionIssueKey = (String)execution.getVariable("questionIssueKey");
        String assignee = (String)execution.getVariable("answerAssignee");
        jiraRestClient jiraClient = new jiraRestClient();
        jiraClient.createAnswerTicket(questionIssueKey,assignee);

        LOGGER.info("Jira Answer Ticket Created ");
    }
}
