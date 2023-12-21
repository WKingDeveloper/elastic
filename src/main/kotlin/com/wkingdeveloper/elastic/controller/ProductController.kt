package com.wkingdeveloper.elastic.controller

import com.wkingdeveloper.elastic.domain.Product
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/")
class ProductController (
    private val elasticsearchOperations : ElasticsearchOperations
) {
    @PostMapping("/product")
    fun save(@RequestBody product: Product): Long {
        val savedEntity: Product = elasticsearchOperations.save(product)
        return savedEntity.id
    }

    @GetMapping("/product/{id}")
    fun findById(@PathVariable("id") id: Long): Product? {
        println("ProductController findById() id : $id")
        return elasticsearchOperations.get(id.toString(), Product::class.java)
    }
}
