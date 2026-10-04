package com.example.carrinhocompras.domain.data

//lista fixa de produtos

import com.example.carrinhocompras.domain.model.ItemCarrinho
import com.example.carrinhocompras.domain.model.Produto

object CatalogoProdutos {

    val produtos: List<Produto> = listOf(
        Produto(
            nome = "Notebook Dell Inspiron 15 3000 com processador Intel Core i5",
            preco = 3499.00,
            descricao = "Um notebook rápido para trabalho, estudos e lazer",
            descontoPercentual = 5.0
        ),
        Produto(
            nome = "Mouse sem fio",
            preco = 89.90,
            descricao = null,                     // sem descrição
            descontoPercentual = 0.0
        ),
        Produto(
            nome = "Teclado mecânico RGB",
            preco = 349.90,
            descricao = "Switch blue, ABNT2, iluminação RGB personalizável",
            descontoPercentual = 0.0
        ),
        Produto(
            nome = "Monitor 27\" 144Hz",
            preco = 1299.00,
            descricao = "Painel IPS, 1ms de resposta, FreeSync",
            descontoPercentual = 10.0            // 2º produto com desconto
        ),
        Produto(
            nome = "Headset Gamer",
            preco = 199.90,
            descricao = "Som surround 7.1 e microfone removível",
            descontoPercentual = 0.0
        ),
        Produto(
            nome = "Webcam Full HD",
            preco = 249.90,
            descricao = null,                     // sem descrição
            descontoPercentual = 0.0
        )
    )

    /** Carrinho inicial já validado no cenário. */
    fun carrinhoInicial(): List<ItemCarrinho> = listOf(
        ItemCarrinho(produtos[0], 2),  // Notebook
        ItemCarrinho(produtos[1], 1),  // Mouse
        ItemCarrinho(produtos[2], 1)   // Teclado
    )
}