package com.yuan.luck.gateway.resolver;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Ykj
 * @date 2023/4/10/15:06
 * @apiNote
 */
public class IPKeyResolver implements KeyResolver {
   @Override
   public Mono<String> resolve(ServerWebExchange exchange) {
      return Mono.just((exchange.getRequest().getRemoteAddress().getHostName()));
   }
}
