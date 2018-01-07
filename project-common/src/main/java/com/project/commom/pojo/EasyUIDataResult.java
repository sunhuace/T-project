package com.project.commom.pojo;

import java.util.List;

public class EasyUIDataResult {
	
	private long total;
	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public EasyUIDataResult(long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public EasyUIDataResult() {
		super();
	}

	@Override
	public String toString() {
		return "EasyUIDataResult [total=" + total + ", rows=" + rows + "]";
	}
	
}
