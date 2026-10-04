package com.example.carrinhocompras.domain.model

//data class ItemCarrinho

/**
 * Relaciona um Produto a uma quantidade.
 * Expõe três cálculos: valorBruto() (sem desconto),
 * valorTotal() (com desconto) e valorDesconto() (a diferença).
 */
data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
) : Pagavel {

    /** Valor total do item (com desconto aplicado). */
    override fun valorTotal(): Double = produto.valorTotal() * quantidade

    /** Valor bruto (sem desconto). */
    fun valorBruto(): Double = produto.preco * quantidade

    /** Valor economizado neste item. */
    fun valorDesconto(): Double = valorBruto() - valorTotal()
}