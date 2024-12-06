package container;

import java.util.HashMap;
import java.util.Map;

/**
 * Page Context for Dependency Injection
 */
public class PageContext {
	public PageContext() {
		System.out.println("PAGE CONTEXT");
	}

	private static final ThreadLocal<Map<String, Object>> pageContext = ThreadLocal.withInitial(HashMap::new);

	public Object get(String objectName) {
		return pageContext.get().get(objectName);
	}

	public void set(String objectName, Object objectValue) {
		pageContext.get().put(objectName, objectValue);
	}

	public void remove() {
		pageContext.remove();
	}
}
