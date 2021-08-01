package utils.helper;

import org.apache.log4j.Category;
import org.apache.log4j.spi.LoggerRepository;

public class Log  extends VerifyCategory {
	protected Log(String name) {
        super(name);
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public void setRepository(LoggerRepository repo) {
        this.repository = repo;
    }
}
