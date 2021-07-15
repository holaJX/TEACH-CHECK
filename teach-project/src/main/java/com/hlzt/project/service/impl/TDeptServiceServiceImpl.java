package com.hlzt.project.service.impl;

import java.util.List;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hlzt.project.mapper.TDeptServiceMapper;
import com.hlzt.project.domain.TDeptService;
import com.hlzt.project.service.ITDeptServiceService;
import com.hlzt.common.annotation.DataDictClass;

/**
 * 服务机构Service业务层处理
 * 
 * @author slx
 * @date 2021-07-06
 */
@Service
public class TDeptServiceServiceImpl implements ITDeptServiceService {
    @Autowired
    private TDeptServiceMapper tDeptServiceMapper;

    /**
     * 查询服务机构
     * 
     * @param deptId 服务机构ID
     * @return 服务机构
     */
    @DataDictClass
    @Override
    public TDeptService selectTDeptServiceById(Long deptId)
    {
        return tDeptServiceMapper.selectTDeptServiceById(deptId);
    }

    /**
     * 查询服务机构列表
     * 
     * @param tDeptService 服务机构
     * @return 服务机构
     */
    @DataDictClass
    @Override
    public List<TDeptService> selectTDeptServiceList(TDeptService tDeptService)
    {
        return tDeptServiceMapper.selectTDeptServiceList(tDeptService);
    }

    /**
     * 新增服务机构
     * 
     * @param tDeptService 服务机构
     * @return 结果
     */
    @Override
    public int insertTDeptService(TDeptService tDeptService)
    {
                                                                                                                        tDeptService.setCreateBy(SecurityUtils.getUsername());
                tDeptService.setCreateTime(DateUtils.getNowDate());
                                                                        return tDeptServiceMapper.insertTDeptService(tDeptService);
    }

    /**
     * 修改服务机构
     * 
     * @param tDeptService 服务机构
     * @return 结果
     */
    @Override
    public int updateTDeptService(TDeptService tDeptService)
    {
                                                                                                                                        tDeptService.setUpdateBy(SecurityUtils.getUsername());
                tDeptService.setUpdateTime(DateUtils.getNowDate());
                                                        return tDeptServiceMapper.updateTDeptService(tDeptService);
    }

    /**
     * 批量删除服务机构
     * 
     * @param deptIds 需要删除的服务机构ID
     * @return 结果
     */
    @Override
    public int deleteTDeptServiceByIds(Long[] deptIds)
    {
        return tDeptServiceMapper.deleteTDeptServiceByIds(deptIds);
    }

    /**
     * 删除服务机构信息
     * 
     * @param deptId 服务机构ID
     * @return 结果
     */
    @Override
    public int deleteTDeptServiceById(Long deptId)
    {
        return tDeptServiceMapper.deleteTDeptServiceById(deptId);
    }
}
