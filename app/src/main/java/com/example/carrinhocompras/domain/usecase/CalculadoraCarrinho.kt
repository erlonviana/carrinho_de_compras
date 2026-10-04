package com.example.carrinhocompras.domain.usecase

//funções puras de cálculo

import com.example.carrinhocompras.domain.model.ItemCarrinho

object CalculadoraCarrinho {

    fun subtotalBruto(itens: List<ItemCarrinho>): Double =
        itens.sumOf { it.valorBruto() }

    fun totalDescontos(itens: List<ItemCarrinho>): Double =
        itens.sumOf { it.valorDesconto() }

    fun totalFinal(itens: List<ItemCarrinho>): Double =
        itens.sumOf { it.valorTotal() }
}