package com.irets.persistence;public class Relation {    private long parentId;    private long childId;    public long getParentId() {        return parentId;    }    public void setParentId(long parentId) {        this.parentId = parentId;    }    public long getChildId() {        return childId;    }    public void setChildId(long childId) {        this.childId = childId;    }}