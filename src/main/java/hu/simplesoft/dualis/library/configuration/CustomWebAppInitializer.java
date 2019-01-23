package hu.simplesoft.dualis.library.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CustomWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
   
    @Override
    protected Class<?>[] getRootConfigClasses() {
     return new Class<?>[]{PersistenceJPAConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
     return new Class<?>[]{PersistenceJPAConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
     return new String[]{"/"};
    }
}
