package utils.helper;

import org.apache.log4j.Level;

public class VerifyLevel extends Level {
	public static final Level VERIFY = new VerifyLevel(25000, "VERIFY", 5);

	protected VerifyLevel(int level, String levelStr, int syslogEquivalent) {
		super(level, levelStr, syslogEquivalent);
	}

	public static Level toLevel(int val, Level defaultLevel) {
		switch (val) {
		case -2147483648:
			return ALL;
		case 5000:
			return TRACE;
		case 10000:
			return DEBUG;
		case 20000:
			return INFO;
		case 25000:
			return VERIFY;
		case 30000:
			return WARN;
		case 40000:
			return ERROR;
		case 50000:
			return FATAL;
		case 2147483647:
			return OFF;
		default:
			return defaultLevel;
		}
	}

	public static Level toLevel(String sArg, Level defaultLevel) {
		if (sArg == null) {
			return defaultLevel;
		} else {
			String s = sArg.toUpperCase();
			switch (s) {
			case "ALL":
				return ALL;
			case "DEBUG":
				return DEBUG;
			case "INFO":
				return INFO;
			case "VERIFY":
				return VERIFY;
			case "WARN":
				return WARN;
			case "ERROR":
				return ERROR;
			case "FATAL":
				return FATAL;
			case "OFF":
				return OFF;
			case "TRACE":
				return TRACE;
			default:
				return s.equals("İNFO") ? INFO : defaultLevel;
			}
		}
	}
}
