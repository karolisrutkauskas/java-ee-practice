package lt.vu.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logger
@Interceptor
public class LoggerImpl {
    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception{
        String methodBeingCalled = ctx.getMethod().getDeclaringClass().getName() + "." + ctx.getMethod().getName();

        System.out.println("Started method: " + methodBeingCalled);

        try{
            Object o = ctx.proceed();
            System.out.println("Successfully executed");
            return o;
        } catch (Exception ex) {
            System.out.println("Exception occurred: ");
            ex.printStackTrace();
            throw ex;
        }
    }
}
