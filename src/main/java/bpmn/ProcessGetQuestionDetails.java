package bpmn;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import primary.jiraRestClient;

public class ProcessGetQuestionDetails implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("ANSWER-PROCESS");

    public void execute(DelegateExecution execution) throws Exception {

        String questionIssueKey = (String)execution.getVariable("jiraIssueKey");
        jiraRestClient jiraClient = new jiraRestClient();
        jiraClient.createAnswerTicket(questionIssueKey);

        LOGGER.info(String.format("Details of Jira Ticket {0} retrieved", questionIssueKey));
    }
}


