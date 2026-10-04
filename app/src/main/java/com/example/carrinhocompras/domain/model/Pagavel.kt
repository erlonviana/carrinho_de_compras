package com.example.carrinhocompras.domain.model

//interface Pagável

/**
 * Contrato para qualquer entidade que possa calcular seu valor total.
 */

/**
 * Contrato (interface) para qualquer entidade que saiba calcular seu valor total.
 * Garante polimorfismo entre Produto e ItemCarrinho (cada uma calcula à sua maneira).
 */
interface Pagavel {
    fun valorTotal(): Double
}