package school.volnenko.tm.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import school.volnenko.tm.model.Project;
import school.volnenko.tm.service.ProjectService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@Component
@ManagedBean
@RequestScoped
@URLMappings(mappings = {@URLMapping(id = "project-list", pattern = "/project-list", viewId = "/WEB-INF/views/project-list.xhtml")})
public class ProjectListController {

    @Autowired
    private ProjectService projectService;

    public List<Project> findAll() {
        return projectService.findAll();
    }

    public void create() {
        projectService.save(new Project("NEW PROJECT " + System.currentTimeMillis()));
    }

    public void deleteById(final String id) {
        projectService.deleteById(id);
    }

}
