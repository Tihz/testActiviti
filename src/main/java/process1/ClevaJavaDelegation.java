package process1;


import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.impl.el.FixedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named("ClevaJavaDelegation")
public class ClevaJavaDelegation implements JavaDelegate {

	private static final Logger logger = LoggerFactory.getLogger(ClevaJavaDelegation.class);
	
	public FixedValue valu;
	
	@PostConstruct
	public void init() {
//		System.out.println("INIT CJD");
	}
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		

		System.out.println(valu.getValue(execution));
		
	}

}
