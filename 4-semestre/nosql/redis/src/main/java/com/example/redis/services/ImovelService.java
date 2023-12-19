package com.example.redis.services;

import com.example.redis.models.Imovel;
import com.example.redis.repositories.ImovelRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImovelService {
    private final ImovelRepository repository;

    public ImovelService(ImovelRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "imoveis")
    public List<Imovel> findAll() {
        return repository.findAll();
    }

    @Cacheable(value = "imoveis", key = "#id")
    public Imovel findById(UUID id) {
        return repository.findById(id).orElseThrow();
    }

    @CacheEvict(value = "imoveis", allEntries = true)
    public Imovel save(Imovel imovel) throws Exception {
        if (imovel == null) throw new IllegalArgumentException();
        return repository.save(imovel);
    }

    @CacheEvict(value = "imoveis", allEntries = true)
    public Imovel update(Imovel imovelAtualizado) throws Exception {
        if (imovelAtualizado.getId() == null) throw new IllegalArgumentException();

        Imovel imovel = repository.findById(imovelAtualizado.getId()).orElseThrow();

        imovel.setEndereco(imovelAtualizado.getEndereco());
        imovel.setTipo_imovel(imovelAtualizado.getTipo_imovel());
        imovel.setArea(imovelAtualizado.getArea());
        imovel.setPreco(imovelAtualizado.getPreco());

        return repository.save(imovel);
    }

    @CacheEvict(value = "imoveis", allEntries = true)
    public void delete(UUID id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException();
        repository.deleteById(id);
    }
}
