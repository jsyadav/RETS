package com.irets.datadownloader;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Mar 26, 2011
 * Time: 5:52:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TempExteriorFeatures{

    @XmlElement(name = "ExteriorFeatures", required = true)
    protected List<String> exteriorFeatureList;
    @XmlAttribute(name = "Count",required = false)
    protected BigInteger count;
    @XmlAttribute(name = "TotalCount",required = true)
    protected BigInteger totalCount;
    @XmlAttribute(name = "ElapsedTime",required = true)
    protected BigInteger elapsedTime;
    
    //CAUTION, DON'T GENERATE THE GETTER CLASS, THE JSON GIVES DUPLICATE ENTRIES...
	public void setExteriorFeatureList(List<String> exteriorFeature) {
		this.exteriorFeatureList = exteriorFeature;
	}
    public void setCount(BigInteger mcount) {
        this.count = mcount;
    }
    public void setTotalCount(BigInteger mtotalcount) {
        this.totalCount = mtotalcount;
    }
    public void setElapsedTime(BigInteger melapsedTime) {
        this.elapsedTime = melapsedTime;
    }
}
