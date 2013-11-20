package test.base;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kevin.aop.Order;

public class OrderedRunner extends SpringJUnit4ClassRunner {

	// 定义�?��静�?变量，确�?computeTestMethods() 中的排序逻辑只运行一次（JUnit 会调用两次）
	private static List<FrameworkMethod> testMethodList;

	public OrderedRunner(Class<?> cls) throws InitializationError {
		super(cls);
	}

	@Override
	protected List<FrameworkMethod> computeTestMethods() {
		if (testMethodList == null) {
			// 获取带有 @Test 注解的方�?
			testMethodList = super.computeTestMethods();
			// 获取测试方法上的 @Order 注解，并对所有的测试方法重新排序
			Collections.sort(testMethodList, new Comparator<FrameworkMethod>() {
				public int compare(FrameworkMethod m1, FrameworkMethod m2) {
					Order o1 = m1.getAnnotation(Order.class);
					Order o2 = m2.getAnnotation(Order.class);
					if (o1 == null || o2 == null) {
						return 0;
					}
					return o1.value() - o2.value();
				}
			});
		}
		return testMethodList;
	}
}
