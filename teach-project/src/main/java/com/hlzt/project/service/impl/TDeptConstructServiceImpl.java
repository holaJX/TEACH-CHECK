package com.hlzt.project.service.impl;

import java.util.List;

import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hlzt.project.mapper.TDeptConstructMapper;
import com.hlzt.project.domain.TDeptConstruct;
import com.hlzt.project.service.ITDeptConstructService;
import com.hlzt.common.annotation.DataDictClass;

/**
 * 建（构）筑物Service业务层处理
 *
 * @author slx
 * @date 2021-07-02
 */
@Service
public class TDeptConstructServiceImpl implements ITDeptConstructService {
    @Autowired
    private TDeptConstructMapper tDeptConstructMapper;

    /**
     * 查询建（构）筑物
     *
     * @param constructId 建（构）筑物ID
     * @return 建（构）筑物
     */
    @DataDictClass
    @Override
    public TDeptConstruct selectTDeptConstructById(Long constructId) {
        return tDeptConstructMapper.selectTDeptConstructById(constructId);
    }

    /**
     * 查询建（构）筑物列表
     *
     * @param tDeptConstruct 建（构）筑物
     * @return 建（构）筑物
     */
    @DataDictClass
    @Override
    public List<TDeptConstruct> selectTDeptConstructList(TDeptConstruct tDeptConstruct) {
        return tDeptConstructMapper.selectTDeptConstructList(tDeptConstruct);
    }

    /**
     * 新增建（构）筑物
     *
     * @param tDeptConstruct 建（构）筑物
     * @return 结果
     */
    @Override
    public int insertTDeptConstruct(TDeptConstruct tDeptConstruct) {
        tDeptConstruct.setConstructId(IdUtils.getNextId());
        tDeptConstruct.setCreateTime(DateUtils.getNowDate());
        tDeptConstruct.setCreateBy(SecurityUtils.getUsername());
        tDeptConstruct.setCreateTime(DateUtils.getNowDate());
        //todo 关联sys_dept
        return tDeptConstructMapper.insertTDeptConstruct(tDeptConstruct);
    }

    /**
     * 修改建（构）筑物
     *
     * @param tDeptConstruct 建（构）筑物
     * @return 结果
     */
    @Override
    public int updateTDeptConstruct(TDeptConstruct tDeptConstruct) {
        tDeptConstruct.setUpdateBy(SecurityUtils.getUsername());
        tDeptConstruct.setUpdateTime(DateUtils.getNowDate());
        return tDeptConstructMapper.updateTDeptConstruct(tDeptConstruct);
    }

    /**
     * 批量删除建（构）筑物
     *
     * @param constructIds 需要删除的建（构）筑物ID
     * @return 结果
     */
    @Override
    public int deleteTDeptConstructByIds(Long[] constructIds) {
        return tDeptConstructMapper.deleteTDeptConstructByIds(constructIds);
    }

    /**
     * 删除建（构）筑物信息
     *
     * @param constructId 建（构）筑物ID
     * @return 结果
     */
    @Override
    public int deleteTDeptConstructById(Long constructId) {
        return tDeptConstructMapper.deleteTDeptConstructById(constructId);
    }
}
