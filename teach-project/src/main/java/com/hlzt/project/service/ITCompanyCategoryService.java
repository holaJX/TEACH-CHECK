package com.hlzt.project.service;

import java.util.List;
import com.hlzt.project.domain.TCompanyCategory;

/**
 * 单位类型Service接口
 * 
 * @author slx
 * @date 2021-07-02
 */
public interface ITCompanyCategoryService {
    /**
     * 查询单位类型
     * 
     * @param companyId 单位类型ID
     * @return 单位类型
     */
    public TCompanyCategory selectTCompanyCategoryById(Long companyId);

    /**
     * 查询单位类型
     * @param keyName
     * @return
     */
    public TCompanyCategory selectTCompanyCategoryByKeyName(String keyName);

    /**
     * 查询单位类型列表
     * 
     * @param tCompanyCategory 单位类型
     * @return 单位类型集合
     */
    public List<TCompanyCategory> selectTCompanyCategoryList(TCompanyCategory tCompanyCategory);


    public List<TCompanyCategory> selectTCompanyCategoryTree(TCompanyCategory tCompanyCategory);

    /**
     * 新增单位类型
     * 
     * @param tCompanyCategory 单位类型
     * @return 结果
     */
    public int insertTCompanyCategory(TCompanyCategory tCompanyCategory);

    /**
     * 修改单位类型
     * 
     * @param tCompanyCategory 单位类型
     * @return 结果
     */
    public int updateTCompanyCategory(TCompanyCategory tCompanyCategory);

    /**
     * 批量删除单位类型
     * 
     * @param companyIds 需要删除的单位类型ID
     * @return 结果
     */
    public int deleteTCompanyCategoryByIds(Long[] companyIds);

    /**
     * 删除单位类型信息
     * 
     * @param companyId 单位类型ID
     * @return 结果
     */
    public int deleteTCompanyCategoryById(Long companyId);
}
