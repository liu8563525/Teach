package com.kevin.page;

public class Page {
	
	protected int pageSize = 10; // 每页默认10条数据
	protected int currentPage = 1; // 当前页
	protected int totalPages = 0; // 总页数
	protected int totalRows = 0; // 总数据数
	protected int pageStartRow = 0; // 每页的起始行数
	protected int pageEndRow = 0; // 每页显示数据的终止行数
	protected boolean pagination = false; // 是否分页
	boolean hasNextPage = false; // 是否有下一页
	boolean hasPreviousPage = false; // 是否有前一页
	
	private static ThreadLocal<Page> context = new ThreadLocal<Page>();

	public static Page getContext()
	{
		Page ci = context.get();
		if(ci == null)
		{
			ci = new Page();
			context.set(ci);
		}
		return ci;
	}

	public  static void removeContext()
	{
		context.remove();
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		totalPages=(totalRows+pageSize-1)/pageSize;
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getPageStartRow() {
		return pageStartRow;
	}
	public void setPageStartRow(int pageStartRow) {
		this.pageStartRow = pageStartRow;
	}
	public int getPageEndRow() {
		return pageEndRow;
	}
	public void setPageEndRow(int pageEndRow) {
		this.pageEndRow = pageEndRow;
	}
	public boolean isPagination() {
		return pagination;
	}
	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	
}
