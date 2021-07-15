package com.hlzt.project.service;

import java.util.List;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.project.domain.TStandardCategory;

/**
 * 验收标准Service接口
 * 
 * @author dengyy
 * @date 2021-07-05
 */
public interface ITStandardCategoryService {
    /**
     * 查询验收标准
     * 
     * @param standardId 验收标准ID
     * @return 验收标准
     */
    public TStandardCategory selectTStandardCategoryById(Long standardId);

    /**
     * 查询验收标准列表
     * 
     * @param tStandardCategory 验收标准
     * @return 验收标准集合
     */
    public List<TStandardCategory> selectTStandardCategoryList(TStandardCategory tStandardCategory);

    /**
     * 新增验收标准
     * 
     * @param tStandardCategory 验收标准
     * @return 结果
     */
    public int insertTStandardCategory(TStandardCategory tStandardCategory);

    /**
     * 修改验收标准
     * 
     * @param tStandardCategory 验收标准
     * @return 结果
     */
    public int updateTStandardCategory(TStandardCategory tStandardCategory);

    /**
     * 批量删除验收标准
     * 
     * @param standardIds 需要删除的验收标准ID
     * @return 结果
     */
    public int deleteTStandardCategoryByIds(Long[] standardIds);

    /**
     * 删除验收标准信息
     * 
     * @param standardId 验收标准ID
     * @return 结果
     */
    public int deleteTStandardCategoryById(Long standardId);
}
