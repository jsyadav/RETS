package com.irets.exception;

public class LargeResultSetException extends Exception {
	public String message;
	public String errorCode;
	public int totalCount;
	
    public LargeResultSetException() {}

    
    public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public LargeResultSetException(String s) {
        super(s);
    }
}