package com.hlzt.project.mapper;

import java.util.List;
import tk.mybatis.mapper.common.Mapper;
import com.hlzt.project.domain.TScheduleConfig;

/**
 * 任务配置Mapper接口
 * 
 * @author dyy
 * @date 2021-07-06
 */
public interface TScheduleConfigMapper extends Mapper<TScheduleConfig>{
    /**
     * 查询任务配置
     * 
     * @param scheduleId 任务配置ID
     * @return 任务配置
     */
    public TScheduleConfig selectTScheduleConfigById(Long scheduleId);

    /**
     * 查询任务配置列表
     * 
     * @param tScheduleConfig 任务配置
     * @return 任务配置集合
     */
    public List<TScheduleConfig> selectTScheduleConfigList(TScheduleConfig tScheduleConfig);

    /**
     * 新增任务配置
     * 
     * @param tScheduleConfig 任务配置
     * @return 结果
     */
    public int insertTScheduleConfig(TScheduleConfig tScheduleConfig);

    /**
     * 修改任务配置
     * 
     * @param tScheduleConfig 任务配置
     * @return 结果
     */
    public int updateTScheduleConfig(TScheduleConfig tScheduleConfig);

    /**
     * 删除任务配置
     * 
     * @param scheduleId 任务配置ID
     * @return 结果
     */
    public int deleteTScheduleConfigById(Long scheduleId);

    /**
     * 批量删除任务配置
     * 
     * @param scheduleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTScheduleConfigByIds(Long[] scheduleIds);
}
