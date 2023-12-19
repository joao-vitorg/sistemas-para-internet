package com.example.redis.controllers;

import com.example.redis.models.Imovel;
import com.example.redis.services.ImovelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {
    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @GetMapping
    public List<Imovel> getImoveis() {
        return imovelService.findAll();
    }

    @GetMapping("/{id}")
    public Imovel getImovel(@PathVariable UUID id) {
        return imovelService.findById(id);
    }

    @PostMapping
    public Imovel postImovel(@RequestBody Imovel imovel) throws Exception {
        return imovelService.save(imovel);
    }

    @PutMapping
    public Imovel putImovel(@RequestBody Imovel imovel) throws Exception {
        return imovelService.update(imovel);
    }

    @DeleteMapping("/{id}")
    public void deleteImovel(@PathVariable UUID id) {
        imovelService.delete(id);
    }
}
