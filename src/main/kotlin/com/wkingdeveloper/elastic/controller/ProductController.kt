package com.wkingdeveloper.elastic.controller

import com.wkingdeveloper.elastic.domain.Product
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.IndexedObjectInformation
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates
import org.springframework.data.elasticsearch.core.query.IndexQuery
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/")
class ProductController (
    private val elasticsearchOperations : ElasticsearchOperations,
) {
    @PostMapping("/product")
    fun save(@RequestBody product: Product): Long {
        val savedEntity: Product = elasticsearchOperations.save(product)
        return savedEntity.id
    }

    @PostMapping("/products")
    fun saveAll(@RequestBody products: List<Product>) : MutableList<IndexedObjectInformation> {
        val queryList: List<IndexQuery> = products.map { product ->
                IndexQueryBuilder()
                    .withId(product.id.toString())
                    .withObject(product).build()
            }
            .toList()

        return elasticsearchOperations.bulkIndex(queryList, IndexCoordinates.of("search-product"))
    }


    @GetMapping("/products/{id}")
    fun findById(@PathVariable("id") id: Long): Product? {
        return elasticsearchOperations.get(id.toString(), Product::class.java)
    }
}
