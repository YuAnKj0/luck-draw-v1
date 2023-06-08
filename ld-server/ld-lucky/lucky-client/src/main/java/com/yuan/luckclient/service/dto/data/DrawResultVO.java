package com.yuan.luckclient.service.dto.data;

import lombok.Data;

/**
 * @author Ykj
 * @date 2023/6/2/11:24
 * @apiNote
 */
@Data
public class DrawResultVO {
  
  //我是傻逼，这儿写了个final，服了
  private String awardName;
  private String prizeName;
  private Boolean isDraw;
  
}
