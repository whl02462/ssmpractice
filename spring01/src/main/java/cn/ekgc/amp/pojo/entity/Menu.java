package cn.ekgc.amp.pojo.entity;

import cn.ekgc.amp.base.pojo.entity.BaseEntity;

import java.util.List;

/**
 * <b>菜单实体信息</b>
 * @author Arthur
 * @version 1.0.0
 */
public class Menu extends BaseEntity {
	private static final long serialVersionUID = 26506660294356862L;
	private Long id;                        // 主键
	private Menu parent;                    // 上级菜单
	private String text;                    // 菜单文本
	private String url;                     // 链接地址
	private String icon;                    // 菜单图标
	private List<Menu> children;            // 下级菜单列表
	private List<Role> roleList;            // 拥有该菜单的集合

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}
