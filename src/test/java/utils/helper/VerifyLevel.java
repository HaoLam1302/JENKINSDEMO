package utils.helper;

import org.apache.log4j.Level;

public class VerifyLevel extends Level {
	public static final Level VERIFY = new VerifyLevel(25000, "VERIFY", 5);

	protected VerifyLevel(int level, String levelStr, int syslogEquivalent) {
		super(level, levelStr, syslogEquivalent);
	}

	public static Level toLevel(int val, Level defaultLevel) {
		if (val == -2147483648) {
			return ALL;
		} else if (val == 10000) {
			return DEBUG;
		} else if (val == 20000) {
			return INFO;
		} else if (val == 25000) {
			return VERIFY;
		}else if(val==30000) {
			return WARN;
		}else if(val==40000)
		{
			return ERROR;
		}else
		{
		return defaultLevel;
	}}

	public static Level toLevel(String sArg, Level defaultLevel) {
		if (sArg == null) {
			return defaultLevel;
		} else {
			if (sArg.toUpperCase().equals("ALL")) {
				return ALL;
			} else if (sArg.toUpperCase().equals("DEBUG")) {
				return DEBUG;
			} else if (sArg.toUpperCase().equals("INFO")) {
				return INFO;
			} else if (sArg.toUpperCase().equals("VERIFY")) {
				return VERIFY;
			} else if (sArg.toUpperCase().equals("ERROR")) {
				return ERROR;
			} else if (sArg.toUpperCase().equals("WARN")) {
				return WARN;
			} else {
				return sArg.toUpperCase().equals("INFO") ? INFO : defaultLevel;
			}
		}
	}
}
