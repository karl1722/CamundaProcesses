package bpmn;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import primary.jiraQuestionTicket;
import primary.jiraRestClient;

public class ProcessGetQuestionDetails implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("ANSWER-PROCESS");

    public void execute(DelegateExecution execution) throws Exception {

        String questionIssueKey = (String)execution.getVariable("questionIssueKey");
        jiraRestClient jiraClient = new jiraRestClient();
        jiraQuestionTicket questionObject = jiraClient.getJiraQuestionTicketDetails(questionIssueKey);

        execution.setVariable("category",questionObject.getCategory());
        LOGGER.info(String.format("Details of Jira Ticket [%s] retrieved", questionIssueKey));
    }
}


