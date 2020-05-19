package com.sso.gateway.filter;

import com.sso.common.exception.GlobalExecption;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class AccsessFilter implements GlobalFilter ,Ordered{

    // url匹配器
    private AntPathMatcher pathMatcher = new AntPathMatcher();
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();
        if (pathMatcher.match("/oauth/**", path)){
           return chain.filter(exchange);
        }
        String authToken = this.verifyToken(exchange.getRequest());

        if (authToken==null){
            return Mono.error(()->new GlobalExecption("出错拉"));
        }

        return chain.filter(exchange);
    }

    private String verifyToken(ServerHttpRequest request) {
        List<String> stringList = request.getHeaders().get(HttpHeaders.AUTHORIZATION);
        String authToken = null;
        if (stringList != null) {
            String param = stringList.get(0);
            if (StringUtils.isNotBlank(param)) {
                authToken = param.substring("Bearer".length()).trim();
            }
        }
        if (StringUtils.isBlank(authToken)) {
            stringList = request.getQueryParams().get("access_token");
            if (stringList != null) {
                authToken = stringList.get(0);
            }
        }

        return authToken;

    }

    @Override
    public int getOrder() {
        return -500;
    }
}
