package mx.uv.actss.EjercicioSS;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class ListaConf {

    @Bean
   public XsdSchema listaSchema(){
       return new SimpleXsdSchema(new ClassPathResource("lista.xsd"));
   }

   @Bean
   public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
           ApplicationContext applicationContext) {
       MessageDispatcherServlet servlet = new MessageDispatcherServlet();
       servlet.setApplicationContext(applicationContext);
       servlet.setTransformWsdlLocations(true);
       return new ServletRegistrationBean<>(servlet, "/ws/*");
   }
   
   @Bean(name = "lista")
   public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema saludosSchema) {
       DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
       wsdl.setPortTypeName("listaPort");
       wsdl.setLocationUri("/ws");
       wsdl.setTargetNamespace("https://actss.uv.mx/lista");
       wsdl.setSchema(saludosSchema);
       return wsdl;
   }
   
    
}
