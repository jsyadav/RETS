package ui.irets.service.unifiedsr;

public class FilterItem {
    String field;
    String value;
    
    public FilterItem(String field, String value){
    	this.field=field;
    	this.value = value;
    }
    
    public FilterItem(){
    
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
