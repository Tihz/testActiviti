package process1;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Named("ProcessDef")
public class ProcessDef {

	@PostConstruct
	public void init() {
//		System.out.println("init");
	}
	
	public boolean isInitManual() {
		return false;
	}
	
	public boolean isSaisieManual() {
		return false;
	}
	
	public boolean isTraitementManual() {
		return false;
	}
	
	public boolean isValidationManual() {
		return false;
	}
}
