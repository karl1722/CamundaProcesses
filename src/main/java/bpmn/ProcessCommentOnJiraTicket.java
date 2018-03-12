package bpmn;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import primary.jiraRestClient;

public class ProcessCommentOnJiraTicket implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("COMMENT-PROCESS");

    public void execute(DelegateExecution execution) throws Exception {

      String issueKey = (String)execution.getVariable("jiraIssueKey");
      jiraRestClient jiraClient = new jiraRestClient();
      jiraClient.commentOnJiraTicket(issueKey, "A Comment");
      LOGGER.info("Transition message received from " + execution.getVariable("jiraIssueKey") + "...");
    }
}
