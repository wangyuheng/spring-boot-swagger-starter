package com.github.wangyuheng.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@RestController
public class CategoryController {
    @RequestMapping(value = "/category/Resource", method = RequestMethod.GET)
    public ResponseEntity<String> search(@RequestParam(value = "someEnum") Category someEnum) {
        return ResponseEntity.ok(someEnum.name());
    }

    @RequestMapping(value = "/category/map", method = RequestMethod.GET)
    public Map<String, Map<String, Object>> map() {
        return newHashMap();
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> someOperation(@PathVariable long id, @RequestBody int userId) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/category/{id}/{userId}", method = RequestMethod.POST)
    public ResponseEntity<Void> ignoredParam(@PathVariable long id, @PathVariable @ApiIgnore int userId) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/category/{id}/map", method = RequestMethod.POST)
    public ResponseEntity<Void> map(@PathVariable String id, @RequestParam Map<String, String> test) {
        return ResponseEntity.ok(null);
    }
}
