package CSCI5308.GroupFormationTool;

public class LoggerFactory extends LoggerAbstractFactory {

	@Override
	public LoggerInterface makeLoggerInstance() {
		return new LoggerUtil();
	}

}
