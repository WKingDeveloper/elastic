package com.wkingdeveloper.elastic.domain

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "search-product")
data class Product (
    @Id
    val id : Long,
    val title : String,
    val price : Long
)
