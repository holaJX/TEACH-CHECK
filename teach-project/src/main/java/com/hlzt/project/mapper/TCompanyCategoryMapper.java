package com.hlzt.project.mapper;

import java.util.List;

import com.hlzt.common.core.domain.entity.SysDept;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import com.hlzt.project.domain.TCompanyCategory;

/**
 * 单位类型Mapper接口
 * 
 * @author slx
 * @date 2021-07-02
 */
public interface TCompanyCategoryMapper extends Mapper<TCompanyCategory>{
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
     * 查询单位类型子列表
     * @param companyId
     * @return
     */
    public List<TCompanyCategory> selectChildrenTCompanyCategoryById(Long companyId);

    /**
     * 查询单位类型列表
     * 
     * @param tCompanyCategory 单位类型
     * @return 单位类型集合
     */
    public List<TCompanyCategory> selectTCompanyCategoryList(TCompanyCategory tCompanyCategory);

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
     * 修改子元素关系
     * @param companies
     * @return
     */
    public int updateTCompanyCategoryChildren(@Param("companies") List<TCompanyCategory> companies);

    /**
     * 删除单位类型
     * 
     * @param companyId 单位类型ID
     * @return 结果
     */
    public int deleteTCompanyCategoryById(Long companyId);

    /**
     * 批量删除单位类型
     * 
     * @param companyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTCompanyCategoryByIds(Long[] companyIds);
}
