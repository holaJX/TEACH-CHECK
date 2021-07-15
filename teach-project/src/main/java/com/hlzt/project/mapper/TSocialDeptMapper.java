package com.hlzt.project.mapper;

import java.util.List;
import tk.mybatis.mapper.common.Mapper;
import com.hlzt.project.domain.TSocialDept;

/**
 * 单位基本信息Mapper接口
 * 
 * @author slx
 * @date 2021-07-02
 */
public interface TSocialDeptMapper extends Mapper<TSocialDept>{
    /**
     * 查询单位基本信息
     * 
     * @param deptId 单位基本信息ID
     * @return 单位基本信息
     */
    public TSocialDept selectTSocialDeptById(Long deptId);

    /**
     * 查询单位基本信息列表
     * 
     * @param tSocialDept 单位基本信息
     * @return 单位基本信息集合
     */
    public List<TSocialDept> selectTSocialDeptList(TSocialDept tSocialDept);

    /**
     * 新增单位基本信息
     * 
     * @param tSocialDept 单位基本信息
     * @return 结果
     */
    public int insertTSocialDept(TSocialDept tSocialDept);

    /**
     * 修改单位基本信息
     * 
     * @param tSocialDept 单位基本信息
     * @return 结果
     */
    public int updateTSocialDept(TSocialDept tSocialDept);

    /**
     * 删除单位基本信息
     * 
     * @param deptId 单位基本信息ID
     * @return 结果
     */
    public int deleteTSocialDeptById(Long deptId);

    /**
     * 批量删除单位基本信息
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTSocialDeptByIds(Long[] deptIds);
}
