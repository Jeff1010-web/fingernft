package com.fingerchar.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fingerchar.base.service.IBaseService;
import com.fingerchar.domain.FcAdminToken;

@Service
public class FcAdminTokenService {

	@Autowired
    private IBaseService baseService;

    /**
     * 通过UserID获取一条AdminToken记录
     *
     * @param uid 管理员ID
     * @return
     */
    public FcAdminToken findByUserId(Long uid) {
        if (uid == null) {
            return null;
        }
        QueryWrapper<FcAdminToken> wrapper = new QueryWrapper<>();
        wrapper.eq(FcAdminToken.USER_ID,uid);
        return baseService.getByCondition(FcAdminToken.class,wrapper);
    }

    /**
     * 新增一条AdminToken记录
     *
     * @param adminToken AdminToken
     * @return 添加成功返回true，添加失败返回false
     */
    public boolean insertSelective(FcAdminToken adminToken) {
        return baseService.save(adminToken) > 0;
    }

    /**
     * 更新一条记录
     *
     * @param adminToken
     * @return
     */
    public boolean updateSelective(FcAdminToken adminToken) {
        return baseService.update(adminToken) > 0;
    }

    /**
     * 如果不存在该用户的记录，则添加一条记录
     * 如果存在该用户的记录，则更新当条记录
     *
     * @param token AdminToken
     * @return 操作成功返回ture，操作失败返回false
     */
    public boolean addOrUpdateAdminToken(FcAdminToken token) {
        if (token == null || token.getUserId() == null) {
            return false;
        }
        FcAdminToken adminToken = findByUserId(token.getUserId());
        if (adminToken == null) {
            return insertSelective(token);
        }
        token.setId(adminToken.getId());
        return updateSelective(token);
    }

    /**
     * 根据门店ID列表和组织ID获取对应的销售记录
     *
     * @param shopId     门店ID列表
     * @param organizeId 组织ID
     * @return
     */
    public List<FcAdminToken> findSalepeopleByShopIdAndOrganizeId(List<Integer> shopId, @NonNull Integer[] organizeId) {
        QueryWrapper<FcAdminToken> wrapper = new QueryWrapper<>();
        wrapper.eq(FcAdminToken.STATUS,(byte)1);
        if (shopId != null && !shopId.isEmpty()) {
            wrapper.in(FcAdminToken.ORG_ID, Arrays.asList(organizeId));
        }
        return baseService.findByCondition(FcAdminToken.class,wrapper);
    }


    public List<FcAdminToken> findListByAdminId(List<Long> adminId,Integer type){
        QueryWrapper<FcAdminToken> wrapper = new QueryWrapper<>();
        if(type.equals(2)){
           wrapper.in(FcAdminToken.USER_ID,Arrays.asList(adminId))
                   .eq(FcAdminToken.STATUS,(byte)1);
        }else{
            wrapper.in(FcAdminToken.USER_ID,Arrays.asList(adminId));
        }
        return  baseService.findByCondition(FcAdminToken.class,wrapper);
    }

    /**
     * 通过UserID获取一天AdminToken记录
     *
     * @param uid 管理员ID
     * @return
     */
    public FcAdminToken findByUserIdAndType(Long uid,Integer type) {
        if (uid == null) {
            return null;
        }
        QueryWrapper<FcAdminToken> wrapper = new QueryWrapper<>();
        if(type.equals(2)){
          wrapper.eq(FcAdminToken.USER_ID,uid)
                  .eq(FcAdminToken.STATUS,(byte)1);
        }else{
            wrapper.eq(FcAdminToken.USER_ID,uid);
        }
        return baseService.getByCondition(FcAdminToken.class,wrapper);

    }


}
