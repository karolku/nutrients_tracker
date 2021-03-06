package com.karolk.controller.rest;

import com.karolk.dto.UserDto;
import com.karolk.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControllerRest {
    private UserService userService;

    public UserControllerRest(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    List<UserDto> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable Long userId) {
        return userService.findById(userId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        if(userDto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"The object cannot have already set id.");
        UserDto userSaved = userService.save(userDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId())
                .toUri();
        return ResponseEntity.created(uri).body(userSaved);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(@PathVariable Long userId, @RequestBody UserDto userDto) {
        if(!(userId.equals(userDto.getId())))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The provided id needs to be the same as the provided user id");
        UserDto updatedUser = userService.update(userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}
