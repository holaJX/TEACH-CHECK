package com.hlzt.system.mapper;

import com.hlzt.system.domain.SysQuestion;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 问题反馈Mapper接口
 * 
 * @author slx
 * @date 2021-06-01
 */
public interface SysQuestionMapper extends Mapper<SysQuestion>{
    /**
     * 查询问题反馈
     * 
     * @param id 问题反馈ID
     * @return 问题反馈
     */
    public SysQuestion selectSysQuestionById(Long id);

    /**
     * 查询问题反馈列表
     * 
     * @param sysQuestion 问题反馈
     * @return 问题反馈集合
     */
    public List<SysQuestion> selectSysQuestionList(SysQuestion sysQuestion);

    /**
     * 新增问题反馈
     * 
     * @param sysQuestion 问题反馈
     * @return 结果
     */
    public int insertSysQuestion(SysQuestion sysQuestion);

    /**
     * 修改问题反馈
     * 
     * @param sysQuestion 问题反馈
     * @return 结果
     */
    public int updateSysQuestion(SysQuestion sysQuestion);

    /**
     * 删除问题反馈
     * 
     * @param id 问题反馈ID
     * @return 结果
     */
    public int deleteSysQuestionById(Long id);

    /**
     * 批量删除问题反馈
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysQuestionByIds(Long[] ids);
}
