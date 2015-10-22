package com.ylll.core.util;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个是列表树形式显示的实体,
 * 这里的字段是在前台显示所有的,可修改
 */
public class TreeObject {
	private Integer id;
	private Integer parentId;
	private String name;
	private String parentName;
	private String resKey;
	private String resUrl;
	private Integer level;
	private String type;
	private String description;
	private List<TreeObject> children = new ArrayList<TreeObject>();

    /**
     *
     * @return
     */
    public Integer getId() {
		return id;
	}

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
		this.id = id;
	}

    /**
     *
     * @return
     */
    public Integer getParentId() {
		return parentId;
	}

    /**
     *
     * @param parentId
     */
    public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

    /**
     *
     * @return
     */
    public List<TreeObject> getChildren() {
		return children;
	}

    /**
     *
     * @param children
     */
    public void setChildren(List<TreeObject> children) {
		this.children = children;
	}

    /**
     *
     * @return
     */
    public String getName() {
		return name;
	}

    /**
     *
     * @param name
     */
    public void setName(String name) {
		this.name = name;
	}

    /**
     *
     * @return
     */
    public String getParentName() {
		return parentName;
	}

    /**
     *
     * @param parentName
     */
    public void setParentName(String parentName) {
		this.parentName = parentName;
	}

    /**
     *
     * @return
     */
    public String getResKey() {
		return resKey;
	}

    /**
     *
     * @param resKey
     */
    public void setResKey(String resKey) {
		this.resKey = resKey;
	}

    /**
     *
     * @return
     */
    public String getResUrl() {
		return resUrl;
	}

    /**
     *
     * @param resUrl
     */
    public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

    /**
     *
     * @return
     */
    public Integer getLevel() {
		return level;
	}

    /**
     *
     * @param level
     */
    public void setLevel(Integer level) {
		this.level = level;
	}

    /**
     *
     * @return
     */
    public String getType() {
		return type;
	}

    /**
     *
     * @param type
     */
    public void setType(String type) {
		this.type = type;
	}

    /**
     *
     * @return
     */
    public String getDescription() {
		return description;
	}

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
		this.description = description;
	}
}
