package br.blog.makoto.errorajax.interceptor;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;

@Intercepts
@RequestScoped
public class AjaxExceptionInterceptor implements Interceptor {
	
	private HttpServletRequest request;
	private Result result;
	
	public AjaxExceptionInterceptor(HttpServletRequest request, Result result) {
		this.request = request;
		this.result = result;
	}

	public boolean accepts(ResourceMethod method) {
		return request.getHeader("accept").contains("application/json"); 
	}

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		try {
			stack.next(method, resourceInstance);
		} catch (Exception e) {
			result.use(Results.http()).body(e.getCause().getMessage());
		}
	}

}
