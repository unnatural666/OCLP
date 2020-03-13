package com.oclp.manage_cms.dao;

import com.oclp.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsPageRepository extends MongoRepository<CmsPage,String> {

}
