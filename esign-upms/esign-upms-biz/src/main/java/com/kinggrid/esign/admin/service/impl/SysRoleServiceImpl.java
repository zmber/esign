package com.kinggrid.esign.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kinggrid.esign.admin.api.entity.SysRole;
import com.kinggrid.esign.admin.api.entity.SysRoleMenu;
import com.kinggrid.esign.admin.mapper.SysRoleMapper;
import com.kinggrid.esign.admin.mapper.SysRoleMenuMapper;
import com.kinggrid.esign.admin.service.SysRoleService;
import com.kinggrid.esign.common.core.constant.CacheConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

	private final SysRoleMenuMapper sysRoleMenuMapper;

	/**
	 * 通过用户ID，查询角色信息
	 * @param userId
	 * @return
	 */
	@Override
	public List findRolesByUserId(Integer userId) {
		return baseMapper.listRolesByUserId(userId);
	}

	/**
	 * 通过角色ID，删除角色,并清空角色菜单缓存
	 * @param id
	 * @return
	 */
	@Override
	@CacheEvict(value = CacheConstants.MENU_DETAILS, allEntries = true)
	@Transactional(rollbackFor = Exception.class)
	public Boolean removeRoleById(Integer id) {
		sysRoleMenuMapper.delete(Wrappers.<SysRoleMenu>update().lambda().eq(SysRoleMenu::getRoleId, id));
		return this.removeById(id);
	}

}
