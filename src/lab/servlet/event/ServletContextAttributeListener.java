package lab.servlet.event;

import javax.servlet.ServletContextAttributeEvent;

public class ServletContextAttributeListener implements javax.servlet.ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("An attribute was added to the ServletContext object");
		System.out.println(event.getName() + " : " + event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("An attribute was removed from the ServletContext object");
		System.out.println(event.getName() + " : " + event.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("An attribute was replaced in the ServletContext object");
		System.out.println(event.getName() + " : " + event.getValue());
	}

}
