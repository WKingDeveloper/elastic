package com.wkingdeveloper.elastic.repository

import com.wkingdeveloper.elastic.domain.Product
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface ProductRepository : ElasticsearchRepository<Product,Long>{
}
