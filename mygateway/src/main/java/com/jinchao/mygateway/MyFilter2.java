package com.jinchao.mygateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Auther: jinchao
 * @Date: 2022/1/1 - 9:35
 * @Description: com.jinchao.mygateway
 *    自定义filter(过滤器)
 * @version: 1.0
 */
@Component
public class MyFilter2 implements Ordered,GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        List<String> list = queryParams.get("id");
        System.out.println("检查token...");
        //做权限认证
        if(null == list || list.size() == 0){
            //非法请求
            System.out.println("不要！");

//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();

            DataBuffer dataBuffer = exchange.getResponse().bufferFactory().wrap("下课了！".getBytes());
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().writeWith(Mono.just(dataBuffer));
        }
        //传递到下一个filter里
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 优先级   0优先级最高    order越小，优先级越高
        return 100;
    }
}
