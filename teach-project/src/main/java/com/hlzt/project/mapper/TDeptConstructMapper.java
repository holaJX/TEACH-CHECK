package com.hlzt.project.mapper;

import java.util.List;
import tk.mybatis.mapper.common.Mapper;
import com.hlzt.project.domain.TDeptConstruct;

/**
 * 建（构）筑物Mapper接口
 * 
 * @author slx
 * @date 2021-07-02
 */
public interface TDeptConstructMapper extends Mapper<TDeptConstruct>{
    /**
     * 查询建（构）筑物
     * 
     * @param constructId 建（构）筑物ID
     * @return 建（构）筑物
     */
    public TDeptConstruct selectTDeptConstructById(Long constructId);

    /**
     * 查询建（构）筑物列表
     * 
     * @param tDeptConstruct 建（构）筑物
     * @return 建（构）筑物集合
     */
    public List<TDeptConstruct> selectTDeptConstructList(TDeptConstruct tDeptConstruct);

    /**
     * 新增建（构）筑物
     * 
     * @param tDeptConstruct 建（构）筑物
     * @return 结果
     */
    public int insertTDeptConstruct(TDeptConstruct tDeptConstruct);

    /**
     * 修改建（构）筑物
     * 
     * @param tDeptConstruct 建（构）筑物
     * @return 结果
     */
    public int updateTDeptConstruct(TDeptConstruct tDeptConstruct);

    /**
     * 删除建（构）筑物
     * 
     * @param constructId 建（构）筑物ID
     * @return 结果
     */
    public int deleteTDeptConstructById(Long constructId);

    /**
     * 批量删除建（构）筑物
     * 
     * @param constructIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTDeptConstructByIds(Long[] constructIds);
}
