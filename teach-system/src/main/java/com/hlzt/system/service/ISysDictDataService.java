package com.hlzt.system.service;

import com.hlzt.common.core.domain.entity.SysDictData;

import java.util.List;

/**
 * 字典 业务层
 * 
 * @author ruo-yi
 */
public interface ISysDictDataService
{
    /**
     * 根据条件分页查询字典数据
     * 
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

    public List<SysDictData> selectDictDataList(String dictType);
    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String selectDictLabel(String dictType, String dictValue);

    /**
     * 根据字典数据ID查询信息
     * 
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    public SysDictData selectDictDataById(Long dictCode);

    /**
     *
     * @param table 表格
     * @param text  显示字段
     * @param code  值字段
     * @param value 值
     * @return
     */
    public String selectTableDictLabelByValue(String table, String text, String code, String value);

    /**
     *
     * @param table
     * @param text
     * @param code
     * @return
     */
    List<SysDictData> selectTableDictItems(String table, String text, String code);

    /**
     * 批量删除字典数据信息
     * 
     * @param dictCodes 需要删除的字典数据ID
     * @return 结果
     */
    public void  deleteDictDataByIds(Long[] dictCodes);

    /**
     * 新增保存字典数据信息
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
    public int insertDictData(SysDictData dictData);

    /**
     * 修改保存字典数据信息
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
    public int updateDictData(SysDictData dictData);
}
