package com.xz.match.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author gaorh
 * @create 2020-11-17
 */
public class MatchDispatchPermissionChildrenVO implements Serializable {

    private static final long serialVersionUID = -2937823558792787369L;
    private String childrenId;
    private String childrenLabel;
    private List<MatchDispatchPermissionChildrenVO> children;


    public MatchDispatchPermissionChildrenVO() {
    }

    public String getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(String childrenId) {
        this.childrenId = childrenId;
    }

    public String getChildrenLabel() {
        return childrenLabel;
    }

    public void setChildrenLabel(String childrenLabel) {
        this.childrenLabel = childrenLabel;
    }

    public List<MatchDispatchPermissionChildrenVO> getChildren() {
        return children;
    }

    public void setChildren(List<MatchDispatchPermissionChildrenVO> children) {
        this.children = children;
    }
}