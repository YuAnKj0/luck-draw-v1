package com.yuan.luckapp.award.command;

import com.yuan.base.config.utils.AssertUtil;
import com.yuan.luckapp.assembler.AwardAssembler;
import com.yuan.luckclient.service.dto.AwardAddCmd;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckdomain.award.AwardEntity;
import com.yuan.luckdomain.gateway.AwardGateway;
import com.yuan.luckdomain.gateway.PrizeGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/4/11/17:37
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class AwardAddCmdExe {
    private final AwardGateway awardGateway;
    private final PrizeGateway prizeGateway;
    
    public AwardVO excute(AwardAddCmd cmd) {
        //保存奖项
        AwardEntity entity = awardGateway.save(AwardAssembler.toAddEntity(cmd));
        //扣减库存
        if (Boolean.FALSE.equals(entity.isPrize())){
            //奖品是谢谢参与一类，不需要扣减
            return AwardAssembler.toAwardVO(entity);
        }
        
        
        int update = prizeGateway.deductionInventory(cmd.getPrizeId(), cmd.getNumber());
        AssertUtil.isTrue(update<1,String.format("抽取奖品：%s, 出错，库存不足或者奖品不存在"));
        
        
        return AwardAssembler.toAwardVO(entity);
    }
}
