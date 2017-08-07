package yu.smart4j.framework.proxy;

/**
 * 代理接口
 * Created by yu on 2017/8/5.
 */
public interface Proxy {

    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;

}
