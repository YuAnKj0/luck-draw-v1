package com.yuan.base.config.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Ykj
 * @date 2023/6/8/22:44
 * @apiNote
 */
@Data
@Accessors(chain = true)
public class ActivityDrawMessage {
  /**
   * 业务唯一ID
   */
  private Long id;
  
  private String uuid;
  /**
   * JSON内容对象*
   */
  private String body;
}
