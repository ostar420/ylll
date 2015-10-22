package com.ylll.core.util;
/**
 * 用来存储Excel标题的对象，通过该对象可以获取标题和方法的对应关系
 */
public class ExcelHeader implements Comparable<ExcelHeader> {

	private String title; // 标题名称
	private int order; // 标题顺序
	private int width; // 宽度
	private String methodName; // 对应方法名称

    /**
     *
     * @param title
     * @param order
     * @param width
     * @param methodName
     */
    public ExcelHeader(String title, int order, int width, String methodName) {
		super();
		this.width = width;
		this.title = title;
		this.order = order;
		this.methodName = methodName;
	}

	public int compareTo(ExcelHeader o) {
		return order > o.order ? 1 : (order < o.order? -1 : 0);
	}

    /**
     *
     * @return
     */
    public String getTitle() {
		return title;
	}

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
		this.title = title;
	}

    /**
     *
     * @return
     */
    public int getOrder() {
		return order;
	}

    /**
     *
     * @param order
     */
    public void setOrder(int order) {
		this.order = order;
	}

    /**
     *
     * @return
     */
    public String getMethodName() {
		return methodName;
	}

    /**
     *
     * @param methodName
     */
    public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

    /**
     *
     * @return
     */
    public int getWidth() {
		return width;
	}

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
		this.width = width;
	}
	
}
