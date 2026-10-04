package com.example.carrinhocompras.domain.usecase

//processamento funcional + Log

import android.util.Log
import com.example.carrinhocompras.domain.model.ItemCarrinho
import java.util.Locale

object RelatorioLogcat {

    private const val TAG = "RelatorioCarrinho"

    /**
     * Processa o carrinho com operações funcionais e imprime no Logcat
     * apenas os itens com desconto, ordenados do maior valor final para o menor.
     */
    fun imprimir(itens: List<ItemCarrinho>) {
        Log.i(TAG, "===== RELATÓRIO DE ITENS COM DESCONTO =====")

        itens.asSequence()
            .filter { it.produto.temDesconto }                 // filtragem
            .sortedByDescending { it.valorTotal() }            // ordenação
            .map { item ->                                      // mapeamento
                "${item.produto.nome} -> ${formatar(item.valorTotal())}"
            }
            .forEach { linha ->                                 // consumo
                Log.i(TAG, linha)
            }

        val total = itens
            .filter { it.produto.temDesconto }
            .map { it.valorTotal() }
            .fold(0.0) { acc, v -> acc + v }                    // redução

        Log.i(TAG, "Total (itens com desconto): ${formatar(total)}")
        Log.i(TAG, "===========================================")
    }

    private fun formatar(valor: Double): String =
        String.format(Locale("pt", "BR"), "R$ %.2f", valor)
}