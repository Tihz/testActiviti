package process1;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.runtime.ProcessInstance;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


public class TestProcess12 {

	
	static ProcessEngine processEngine;
	
	public static void main(String[] args) {
		ProcessEngineConfiguration processEngineConfiguration =  StandaloneProcessEngineConfiguration.createProcessEngineConfigurationFromInputStream(TestProcess12.class.getResourceAsStream("/activiti.cfg.xml"));

		Weld weld = new Weld();
		   WeldContainer container = weld.initialize();
		processEngine = processEngineConfiguration.buildProcessEngine();

		
		System.out.println("deploying ...");
		
		System.out.println(processEngine.getRepositoryService().createDeployment()
				.name("Process_12")
				.addClasspathResource("Process_12.bpmn")
				.enableDuplicateFiltering()
				.deploy()
				.getName());
		
		Map<String, Object> params = new HashMap<String, Object>();
		
//		params.put("auto_init", true);
//		params.put("auto_saisie", false);
		
		for (int i=0; i<1000; i++) {
			
			runProcess("Process_12", params);
//			runProcess("Process_11", params);
			
		}
		
		
		
	}
	
	
	private static void runProcess(String name, Map<String, Object> params) {
		long t0 = System.currentTimeMillis();
		
		ProcessInstance instance = 
				processEngine.getRuntimeService().startProcessInstanceByKey(name, params);

		
		System.out.println(name + " -> " + (System.currentTimeMillis() - t0));
	}
}
