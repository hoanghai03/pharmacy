package io.hoanghai.pharmacy.controller.rest;

import io.hoanghai.pharmacy.model.Group;
import io.hoanghai.pharmacy.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GroupRestController {

    private GroupService groupService;

    @Autowired
    public GroupRestController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/group")
    public List<Group> get(){
        return groupService.findAll();
    }

}
