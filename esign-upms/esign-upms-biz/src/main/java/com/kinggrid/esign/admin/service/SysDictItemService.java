package com.kinggrid.esign.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kinggrid.esign.admin.api.entity.SysDictItem;
import com.kinggrid.esign.common.core.util.R;

/**
 * 字典项
 */
public interface SysDictItemService extends IService<SysDictItem> {

	/**
	 * 删除字典项
	 * @param id 字典项ID
	 * @return
	 */
	R removeDictItem(Integer id);

	/**
	 * 更新字典项
	 * @param item 字典项
	 * @return
	 */
	R updateDictItem(SysDictItem item);

}
