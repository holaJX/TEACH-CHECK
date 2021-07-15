package com.hlzt.project.service;

import java.util.List;
import com.hlzt.project.domain.TDeptService;

/**
 * 服务机构Service接口
 * 
 * @author slx
 * @date 2021-07-06
 */
public interface ITDeptServiceService {
    /**
     * 查询服务机构
     * 
     * @param deptId 服务机构ID
     * @return 服务机构
     */
    public TDeptService selectTDeptServiceById(Long deptId);

    /**
     * 查询服务机构列表
     * 
     * @param tDeptService 服务机构
     * @return 服务机构集合
     */
    public List<TDeptService> selectTDeptServiceList(TDeptService tDeptService);

    /**
     * 新增服务机构
     * 
     * @param tDeptService 服务机构
     * @return 结果
     */
    public int insertTDeptService(TDeptService tDeptService);

    /**
     * 修改服务机构
     * 
     * @param tDeptService 服务机构
     * @return 结果
     */
    public int updateTDeptService(TDeptService tDeptService);

    /**
     * 批量删除服务机构
     * 
     * @param deptIds 需要删除的服务机构ID
     * @return 结果
     */
    public int deleteTDeptServiceByIds(Long[] deptIds);

    /**
     * 删除服务机构信息
     * 
     * @param deptId 服务机构ID
     * @return 结果
     */
    public int deleteTDeptServiceById(Long deptId);
}
