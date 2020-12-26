package cn.ekgc.amp.pojo.entity;

import cn.ekgc.amp.base.pojo.entity.BaseEntity;

import java.util.List;

/**
 * <b>角色实体信息</b>
 * @author Arthur
 * @version 1.0.0
 */
public class Role extends BaseEntity {
	private static final long serialVersionUID = 9053014754573428721L;
	private Long id;                        // 主键
	private String name;                    // 角色名称
	private List<Menu> menuList;            // 该角色所拥有的菜单

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
}
