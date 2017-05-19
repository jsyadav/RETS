package com.irets.datadownloader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.irets.generated.Property;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Mar 25, 2011
 * Time: 11:55:30 PM
 * To change this template use File | Settings | File Templates.
 *
 * This is junk class to mimic the crappy data while populating the results as agentStorm
 * ------ Should be deleted as soon as we move fully to our server --------
 * -------  BAD UGLY STUFFF -------
 */
public class TempProp extends Property{
    @XmlElement(name = "Photos", required = true)
    protected List<Object> lphotos;

    public List<Object> getLphotos() {
        if (lphotos == null) {
            lphotos = new ArrayList<Object>();
        }
        return lphotos;
    }

    public void setLphotos(List<Object> lphotos) {
        this.lphotos = lphotos;
    }

    public TempProp(){}

    public TempProp(Property aProperty){
        this.copyProperties(aProperty);
    }

    public void copyProperties(Property aProperty){

        Field fieldlist[]
              = Property.class.getDeclaredFields();
        for (int i= 0; i < fieldlist.length; i++) {

            try {
                Field fld = fieldlist[i];
                fld.setAccessible(true);
                Object value = fld.get(aProperty);
                fld.set(this,value);
            } catch (IllegalAccessException e) {
               System.out.println(e.getMessage());
            }

        }
    }

}
