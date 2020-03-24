package com.oclp.dao;

import com.oclp.domain.filesystem.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileSystemRepository extends MongoRepository<FileSystem,String> {
}
