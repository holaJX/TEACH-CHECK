package com.hlzt.project.service.impl;

import java.util.List;

import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.common.utils.uuid.IdUtils;
import com.hlzt.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hlzt.project.mapper.TSocialDeptMapper;
import com.hlzt.project.domain.TSocialDept;
import com.hlzt.project.service.ITSocialDeptService;
import com.hlzt.common.annotation.DataDictClass;

/**
 * 单位基本信息Service业务层处理
 *
 * @author slx
 * @date 2021-07-02
 */
@Service
public class TSocialDeptServiceImpl implements ITSocialDeptService {
    @Autowired
    private TSocialDeptMapper tSocialDeptMapper;
    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 查询单位基本信息
     *
     * @param deptId 单位基本信息ID
     * @return 单位基本信息
     */
    @DataDictClass
    @Override
    public TSocialDept selectTSocialDeptById(Long deptId) {
        return tSocialDeptMapper.selectTSocialDeptById(deptId);
    }

    /**
     * 查询单位基本信息列表
     *
     * @param tSocialDept 单位基本信息
     * @return 单位基本信息
     */
    @DataDictClass
    @Override
    public List<TSocialDept> selectTSocialDeptList(TSocialDept tSocialDept) {
        return tSocialDeptMapper.selectTSocialDeptList(tSocialDept);
    }

    /**
     * 新增单位基本信息
     *
     * @param tSocialDept 单位基本信息
     * @return 结果
     */
    @Override
    public int insertTSocialDept(TSocialDept tSocialDept) {
        tSocialDept.setCreateBy(SecurityUtils.getUsername());
        tSocialDept.setCreateTime(DateUtils.getNowDate());
        tSocialDept.setCreateBy(SecurityUtils.getUserId().toString());
        tSocialDept.setSocialDeptId(IdUtils.getNextId());
        return tSocialDeptMapper.insertTSocialDept(tSocialDept);
    }

    /**
     * 修改单位基本信息
     *
     * @param tSocialDept 单位基本信息
     * @return 结果
     */
    @Override
    public int updateTSocialDept(TSocialDept tSocialDept) {
        tSocialDept.setUpdateBy(SecurityUtils.getUsername());
        tSocialDept.setUpdateTime(DateUtils.getNowDate());
        return tSocialDeptMapper.updateTSocialDept(tSocialDept);
    }

    /**
     * 批量删除单位基本信息
     *
     * @param deptIds 需要删除的单位基本信息ID
     * @return 结果
     */
    @Override
    public int deleteTSocialDeptByIds(Long[] deptIds) {
        return tSocialDeptMapper.deleteTSocialDeptByIds(deptIds);
    }

    /**
     * 删除单位基本信息信息
     *
     * @param deptId 单位基本信息ID
     * @return 结果
     */
    @Override
    public int deleteTSocialDeptById(Long deptId) {
        return tSocialDeptMapper.deleteTSocialDeptById(deptId);
    }
}
