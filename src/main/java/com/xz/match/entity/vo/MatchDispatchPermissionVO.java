package com.xz.match.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 发放权限VO
 *
 * @author gaorh
 * @create 2020-11-16
 */
public class MatchDispatchPermissionVO {

    private Long id;
    private String label;
    private List<MatchDispatchPermissionVO> children;

    public MatchDispatchPermissionVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<MatchDispatchPermissionVO> getChildren() {
        return children;
    }

    public void setChildren(List<MatchDispatchPermissionVO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MatchDispatchPermissionVO{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
