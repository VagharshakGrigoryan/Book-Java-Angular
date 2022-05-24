package com.example.bookbackend.controller;

import com.example.bookbackend.dtos.UserDto;
import com.example.bookbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@CrossOrigin( origins = "http://localhost:4200" )
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<EntityModel<?>> users =  this.userService.getAll().stream()
                .map(user -> EntityModel.of(user, linkTo(BookController.class).slash(user.getId()).withSelfRel()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
        UserDto user = this.userService.getById(id);
        EntityModel<?> entityModel = EntityModel.of(user, linkTo(UserController.class).slash(id).withSelfRel());
        return ResponseEntity.ok(entityModel);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateById(@PathVariable("id") Long id, @RequestBody UserDto user){
        UserDto userUpdated = this.userService.update(user);
        return ResponseEntity.ok(userUpdated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        this.userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/paged")
    public ResponseEntity<Object> getAllPaged(Pageable pageable, PagedResourcesAssembler<UserDto> assembler){
        Page<UserDto> page = this.userService.getAll(pageable);
        return ResponseEntity.ok(assembler.toModel(page));
    }


}
