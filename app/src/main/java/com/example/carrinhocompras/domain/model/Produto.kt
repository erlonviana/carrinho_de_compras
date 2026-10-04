package com.example.carrinhocompras.domain.model

//data class Produto

/**
 * Modelo de um produto do catálogo.
 * - descricao pode ser nula
 * - descontoPercentual tem valor padrão 0.0
 * Implementa Pagavel: valorTotal() devolve o preço JÁ com desconto aplicado.
 */

data class Produto(
    val nome: String,
    val preco: Double,
    val descricao: String? = null,
    val descontoPercentual: Double = 0.0
) : Pagavel {

    /** Preço já com desconto aplicado (unitário). */
    override fun valorTotal(): Double =
        preco * (1 - descontoPercentual / 100.0)

    val temDesconto: Boolean
        get() = descontoPercentual > 0.0
}