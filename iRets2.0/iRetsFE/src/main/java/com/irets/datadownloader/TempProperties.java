package com.irets.datadownloader;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.irets.generated.Property;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Mar 26, 2011
 * Time: 5:52:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TempProperties{

    @XmlElement(name = "Properties", required = true)
    protected List<Property> mproperty;
    @XmlAttribute(name = "Count",required = true)
    protected BigInteger mcount;
    @XmlAttribute(name = "TotalCount",required = true)
    protected BigInteger mtotalcount;
    @XmlAttribute(name = "ElapsedTime",required = true)
    protected BigInteger melapsedTime;

    public List<Property> getMproperty() {
        if (mproperty == null) {
            mproperty = new ArrayList<Property>();
        }
        return mproperty;
    }

    public void setMproperty(List<Property> mproperty) {
        this.mproperty = mproperty;
    }

    public BigInteger getMcount() {
        return mcount;
    }

    public void setMcount(BigInteger mcount) {
        this.mcount = mcount;
    }

    public BigInteger getMtotalcount() {
        return mtotalcount;
    }

    public void setMtotalcount(BigInteger mtotalcount) {
        this.mtotalcount = mtotalcount;
    }

    public BigInteger getMelapsedTime() {
        return melapsedTime;
    }

    public void setMelapsedTime(BigInteger melapsedTime) {
        this.melapsedTime = melapsedTime;
    }
}
