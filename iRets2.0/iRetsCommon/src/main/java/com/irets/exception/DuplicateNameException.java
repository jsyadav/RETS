package com.irets.exception;/** * @author iretsigrator.developer * @since July 06, 2010 */public class DuplicateNameException extends Exception {    private String name;    public DuplicateNameException(String name) {        this.name = name;    }    public String getName() {        return name;    }}