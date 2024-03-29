package com.example.backend.controllers;


import com.example.backend.services.GroupService;
import com.example.backend.utils.MediaType;
import com.example.backend.vo.GroupVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/group")
@Tag(name = "Group", description = "Endpoint for managing groups.")
public class GroupController {
    final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/group
    @GetMapping
    @Operation(
            summary = "Find all groups.", description = "Find all groups.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = GroupVO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public List<GroupVO> findAll() {
        return service.findAll();
    }

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/group/ID
    @GetMapping("/{id}")
    @Operation(
            summary = "Find a group by ID.", description = "Find a group by ID.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = GroupVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public GroupVO findById(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    // CREATE - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/group
    @PostMapping
    @Operation(
            summary = "Create a group.", description = "Create a group.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = GroupVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public GroupVO save(@RequestBody GroupVO groupVO) throws Exception {
        return service.save(groupVO);
    }

    // INSERT USERS - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/group/insert-users
    @PostMapping("insert-users")
    @Operation(
            summary = "Insert a user in group.", description = "Insert a user in group.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = GroupVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public GroupVO insertUsers(@RequestBody GroupVO groupVO) {
        return service.insertUsers(groupVO);
    }

    // UPDATE - HTTP PUT
    // Endpoint: http://localhost:8080/api/v1/group
    @PutMapping
    @Operation(
            summary = "Update a group.", description = "Update a group.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = GroupVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public GroupVO update(@RequestBody GroupVO groupVO) throws Exception {
        return service.update(groupVO);
    }

    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/group/ID
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a Group by ID.", description = "Deletes a Group by ID.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public String delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
