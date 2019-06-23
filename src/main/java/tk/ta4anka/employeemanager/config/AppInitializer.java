package tk.ta4anka.employeemanager.config;


// AppInitializer - Register a DispatcherServlet

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?> [] getRootConfigClasses() {
        return new Class[] {RootConfig.class}; }

    @Override
    protected Class<?> [] getServletConfigClasses() {
        return new Class[] {WebMvcConfig.class}; }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
