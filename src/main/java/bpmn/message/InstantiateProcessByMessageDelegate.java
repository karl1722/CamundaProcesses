package bpmn.message;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class InstantiateProcessByMessageDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("MESSENGER-PROCESS");

    public void execute(DelegateExecution execution) throws Exception {

        String message = (String)execution.getVariable("messageToSend");
        String questionIssueKey = (String)execution.getVariable("issueKey");

        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        Map processVariables = new HashMap();
        processVariables.put("questionIssueKey", questionIssueKey);
        runtimeService.startProcessInstanceByMessage(message,processVariables);
        LOGGER.info(String.format("Message: $0 sent ", message));
    }

}
