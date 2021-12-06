package school.volnenko.tm.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import school.volnenko.tm.dto.ProjectDto;
import school.volnenko.tm.dto.TaskDto;
import school.volnenko.tm.enumerated.Status;
import school.volnenko.tm.service.ProjectDtoService;
import school.volnenko.tm.service.TaskDtoService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@Component
@ManagedBean
@RequestScoped
@URLMappings(mappings = {@URLMapping(id = "task-edit", pattern = "/task-edit", viewId = "/WEB-INF/views/task-edit.xhtml")})
public class TaskEditController {

    @Getter
    @Setter
    private String id;

    @Autowired
    private ProjectDtoService projectDtoService;

    @Autowired
    private TaskDtoService taskDtoService;

    @Getter
    @Setter
    private TaskDto task = new TaskDto();

    public Status[] getStatuses() {
        return Status.values();
    }

    public List<ProjectDto> getProjects() {
        return projectDtoService.findAll();
    }

    public void init() {
        taskDtoService.findById(id).ifPresent(task -> this.task = task);
    }

    public String save() {
        taskDtoService.save(task);
        return "task-list";
    }

}
