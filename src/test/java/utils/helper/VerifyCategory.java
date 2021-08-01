package utils.helper;

import org.apache.log4j.Category;

public class VerifyCategory extends Category{
	 private static final String FQCN;

	    protected VerifyCategory(String name) {
	        super(name);
	    }

	    public void verify(Object message) {
	        if (!this.repository.isDisabled(20000)) {
	            if (VerifyLevel.VERIFY.isGreaterOrEqual(this.getEffectiveLevel())) {
	                this.forcedLog(FQCN, VerifyLevel.VERIFY, message, null);
	            }
	        }
	    }

	    static {
	        FQCN = VerifyCategory.class.getName();
	    }
}
