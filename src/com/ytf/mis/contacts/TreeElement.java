package com.ytf.mis.contacts;

import java.util.ArrayList;

/**
 * Package: com.ytf.contactsdemo
 * Created with ContactsDemo
 * User: WuHua
 * Date: 14-11-10
 * Time: 16:00
 * Description:
 */
public class TreeElement {
    /**
     * Field
     */
    private String id;
    private String title;
    private boolean hasParent;
    private boolean hasChild;
    private TreeElement parent;
    private int level;
    private ArrayList<TreeElement> children = new ArrayList<TreeElement>();
    private boolean expanded;

    /**
     *
     * @param id
     * @param title
     */
    public TreeElement(String id, String title) {
        super();
        this.id = id;
        this.title = title;
        this.level = 0;
        this.hasParent = true;
        this.hasChild = false;
        this.parent = null;
    }

    /**
     *
     * @param id
     * @param outlineTitle
     * @param hasParent
     * @param hasChild
     * @param parent
     * @param level
     * @param expanded
     */
    public TreeElement(String id, String outlineTitle,
                       boolean hasParent, boolean hasChild, TreeElement parent, int level,
                       boolean expanded) {
        super();
        this.id = id;
        this.title = outlineTitle;
        this.hasParent = hasParent;
        this.hasChild = hasChild;
        this.parent = parent;
        if (parent != null) {
            this.parent.getChildren().add(this);
        }
        this.level = level;
        this.expanded = expanded;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
    public boolean isHasParent() {
        return hasParent;
    }

    /**
     *
     * @param hasParent
     */
    public void setHasParent(boolean hasParent) {
        this.hasParent = hasParent;
    }

    /**
     *
     * @return
     */
    public boolean isHasChild() {
        return hasChild;
    }

    /**
     *
     * @param hasChild
     */
    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    /**
     *
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     *
     * @return
     */
    public boolean isExpanded() {
        return expanded;
    }

    /**
     *
     * @param expanded
     */
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    /**
     *
     * @return
     */
    public ArrayList<TreeElement> getChildren() {
        return children;
    }

    /**
     *
     * @return
     */
    public TreeElement getParent() {
        return parent;
    }

    /**
     *
     * @param parent
     */
    public void setParent(TreeElement parent) {
        this.parent = parent;
    }

    /**
     *
     * @param element
     */
    public void addChild(TreeElement element) {
        this.children.add(element);
        this.hasParent = false;
        this.hasChild = true;
        element.parent = this;
        element.level = this.level + 1;

    }


}
