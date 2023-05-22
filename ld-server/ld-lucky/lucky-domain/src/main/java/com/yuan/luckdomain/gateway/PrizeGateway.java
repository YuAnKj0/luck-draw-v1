package com.yuan.luckdomain.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.base.config.exception.LDException;
import com.yuan.luckclient.service.dto.query.PrizeListByParamQuery;
import com.yuan.luckdomain.prize.PrizeEntity;

import javax.swing.text.DefaultEditorKit;

/**
 * @author Ykj
 * @date 2023/4/10/16:49
 * @apiNote
 */
public interface PrizeGateway {
    
    PrizeEntity save(PrizeEntity entity);
    IPage<PrizeEntity> page(PrizeListByParamQuery query);
    default PrizeEntity one(Long id){
        PrizeListByParamQuery query = new PrizeListByParamQuery();
        PrizeEntity prizeEntity=null;
        query.setId(id);
        try {
            prizeEntity = page(query).getRecords().get(0);
        }catch (Exception e){
            throw new LDException(String.format("奖品id：%s.数据不存在",id));
        }
       
        return prizeEntity;
    }
    
    int deductionInventory(Long prizeId, Integer number);
}
