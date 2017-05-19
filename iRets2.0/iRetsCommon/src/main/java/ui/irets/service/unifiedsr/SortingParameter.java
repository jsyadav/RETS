package ui.irets.service.unifiedsr;

public class SortingParameter {
    public SortingParameter() {}

    public SortingParameter(String property, boolean ascending) {
        this.property = property;
        this.ascending= ascending;
    }
	
    /* Sort property */
    private String property; 

    /* Sort order */
    private boolean ascending;
    
    public String getProperty() {
    	return this.property;
    }

    public void setProperty(String prop) {
    	this.property = prop;
    }

    public boolean isAscending() {
    	return this.ascending;
    }
    
    public void setAscending(boolean ascending) {
    	this.ascending = ascending;
    }
}
