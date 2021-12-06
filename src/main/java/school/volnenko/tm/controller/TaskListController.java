package school.volnenko.tm.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import school.volnenko.tm.model.Task;
import school.volnenko.tm.service.TaskService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@Component
@ManagedBean
@RequestScoped
@URLMappings(mappings = {@URLMapping(id = "task-list", pattern = "/task-list", viewId = "/WEB-INF/views/task-list.xhtml")})
public class TaskListController {

    @Autowired
    private TaskService taskService;

    public List<Task> findAll() {
        return taskService.findAll();
    }

    public void create() {
        taskService.save(new Task("NEW TASK " + System.currentTimeMillis()));
    }

    public void deleteById(final String id) {
        taskService.deleteById(id);
    }

}
