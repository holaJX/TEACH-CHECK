package com.hlzt.system.service;

import com.hlzt.common.core.domain.SysDeptUserVo;
import com.hlzt.common.core.domain.TreeSelect;
import com.hlzt.common.core.domain.entity.SysDept;

import java.util.List;

/**
 * 部门管理 服务层
 * 
 * @author ruo-yi
 */
public interface ISysDeptService
{
    /**
     * 查询部门管理数据
     * 
     * @param dept 部门信息
     * @return 部门信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    public List<SysDept> selectDeptListByConditon(SysDept dept);
    /**
     * 查询下属的部门和用户
     * @param dept
     * @return
     */

    public List<SysDeptUserVo> selectDeptAndUser(SysDept dept);

    /**
     * 构建前端所需要树结构
     * 
     * @param depts 部门列表
     * @return 树结构列表
     */
    public List<SysDept> buildDeptTree(List<SysDept> depts);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param depts 部门列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts);

    /**
     * 构建selectTree
     * @param depts
     * @return
     */
    public List<SysDeptUserVo> buildDeptTreeVoSelect(List<SysDeptUserVo> depts);
    /**
     * 根据角色ID查询部门树信息
     * 
     * @param roleId 角色ID
     * @return 选中部门列表
     */
    public List<Integer> selectDeptListByRoleId(Long roleId);

    /**
     * 根据部门ID查询信息
     * 
     * @param deptId 部门ID
     * @return 部门信息
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 修改状态
     * @param dept
     * @return
     */
    public int updateDeptStatus(SysDept dept);

    /**
     * 获取
     * @param parentId
     * @param districtCode
     * @param districtCode1
     * @return
     */
    public List<SysDept> selectDeptListByParentId(Long parentId, String districtCode, String districtCode1);

    /**
     * 获取 监管单位
     * @param parentId
     * @param districtCode
     * @return
     */
    public List<SysDept> getSupervisionItems(Long parentId, String districtCode);

    /**
     * 根据ID查询所有子部门（正常状态）
     * 
     * @param deptId 部门ID
     * @return 子部门数
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * 是否存在部门子节点
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public boolean hasChildByDeptId(Long deptId);

    /**
     * 查询部门是否存在用户
     * 
     * @param deptId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 校验单位名称是否唯一
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public String checkDeptNameUnique(SysDept dept);

    /**
     * 新增保存部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改保存部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 删除部门管理信息
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 统一社会信用代码查重
     * @param creditCode
     * @return
     */
    public int checkCreditUnique(String creditCode);

    List<SysDept> selectDeptLikeName(SysDept dept);
}
