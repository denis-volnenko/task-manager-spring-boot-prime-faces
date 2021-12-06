package school.volnenko.tm.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@Component
@ManagedBean
@RequestScoped
@URLMappings(mappings = {@URLMapping(id = "index", pattern = "/", viewId = "/WEB-INF/views/index.xhtml")})
public class IndexController {
}
