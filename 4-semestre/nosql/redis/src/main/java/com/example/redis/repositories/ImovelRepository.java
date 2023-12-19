package com.example.redis.repositories;

import com.example.redis.models.Imovel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImovelRepository extends CassandraRepository<Imovel, UUID> {
}
