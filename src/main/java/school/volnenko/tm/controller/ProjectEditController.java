package school.volnenko.tm.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import school.volnenko.tm.dto.ProjectDto;
import school.volnenko.tm.enumerated.Status;
import school.volnenko.tm.service.ProjectDtoService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@Component
@ManagedBean
@RequestScoped
@URLMappings(mappings = {@URLMapping(id = "project-edit", pattern = "/project-edit", viewId = "/WEB-INF/views/project-edit.xhtml")})
public class ProjectEditController {

    @Getter
    @Setter
    private String id;

    @Autowired
    private ProjectDtoService projectDtoService;

    @Getter
    @Setter
    private ProjectDto project = new ProjectDto();

    public Status[] getStatuses() {
        return Status.values();
    }

    public void init() {
        projectDtoService.findById(id).ifPresent(project -> this.project = project);
    }

    public String save() {
        projectDtoService.save(project);
        return "project-list";
    }

}
