package com.hlzt.project.service.impl;

import java.util.List;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hlzt.project.mapper.TScheduleConfigMapper;
import com.hlzt.project.domain.TScheduleConfig;
import com.hlzt.project.service.ITScheduleConfigService;
import com.hlzt.common.annotation.DataDictClass;

/**
 * 任务配置Service业务层处理
 * 
 * @author dyy
 * @date 2021-07-06
 */
@Service
public class TScheduleConfigServiceImpl implements ITScheduleConfigService {
    @Autowired
    private TScheduleConfigMapper tScheduleConfigMapper;

    /**
     * 查询任务配置
     * 
     * @param scheduleId 任务配置ID
     * @return 任务配置
     */
    @DataDictClass
    @Override
    public TScheduleConfig selectTScheduleConfigById(Long scheduleId)
    {
        return tScheduleConfigMapper.selectTScheduleConfigById(scheduleId);
    }

    /**
     * 查询任务配置列表
     * 
     * @param tScheduleConfig 任务配置
     * @return 任务配置
     */
    @DataDictClass
    @Override
    public List<TScheduleConfig> selectTScheduleConfigList(TScheduleConfig tScheduleConfig)
    {
        return tScheduleConfigMapper.selectTScheduleConfigList(tScheduleConfig);
    }

    /**
     * 新增任务配置
     * 
     * @param tScheduleConfig 任务配置
     * @return 结果
     */
    @Override
    public int insertTScheduleConfig(TScheduleConfig tScheduleConfig)
    {
                                                                                                        tScheduleConfig.setCreateBy(SecurityUtils.getUsername());
                tScheduleConfig.setCreateTime(DateUtils.getNowDate());
                                                        return tScheduleConfigMapper.insertTScheduleConfig(tScheduleConfig);
    }

    /**
     * 修改任务配置
     * 
     * @param tScheduleConfig 任务配置
     * @return 结果
     */
    @Override
    public int updateTScheduleConfig(TScheduleConfig tScheduleConfig)
    {
                                                                                                                        tScheduleConfig.setUpdateBy(SecurityUtils.getUsername());
                tScheduleConfig.setUpdateTime(DateUtils.getNowDate());
                                        return tScheduleConfigMapper.updateTScheduleConfig(tScheduleConfig);
    }

    /**
     * 批量删除任务配置
     * 
     * @param scheduleIds 需要删除的任务配置ID
     * @return 结果
     */
    @Override
    public int deleteTScheduleConfigByIds(Long[] scheduleIds)
    {
        return tScheduleConfigMapper.deleteTScheduleConfigByIds(scheduleIds);
    }

    /**
     * 删除任务配置信息
     * 
     * @param scheduleId 任务配置ID
     * @return 结果
     */
    @Override
    public int deleteTScheduleConfigById(Long scheduleId)
    {
        return tScheduleConfigMapper.deleteTScheduleConfigById(scheduleId);
    }
}
