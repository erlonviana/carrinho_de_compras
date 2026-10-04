package com.example.carrinhocompras.ui.screen

//tela principal + resumo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carrinhocompras.domain.data.CatalogoProdutos
import com.example.carrinhocompras.domain.usecase.CalculadoraCarrinho
import com.example.carrinhocompras.ui.components.ItemCarrinhoCard
import com.example.carrinhocompras.ui.components.formatarMoeda

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarrinhoScreen() {
    val itens = CatalogoProdutos.carrinhoInicial()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Carrinho de Compras",
                    style = MaterialTheme.typography.titleLarge
                )
            })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(itens) { item ->
                    ItemCarrinhoCard(
                        nome = item.produto.nome,
                        descricao = item.produto.descricao,
                        quantidade = item.quantidade,
                        // 👇 preço UNITÁRIO SEM desconto
                        precoUnitario = item.produto.preco,
                        // 👇 total do item SEM desconto
                        precoTotal = item.valorBruto(),
                        // 👇 sinaliza visualmente que o produto TEM desconto,
                        // mas sem alterar os valores exibidos acima
                        temDesconto = item.produto.temDesconto
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
            HorizontalDivider()
            Spacer(Modifier.height(16.dp))

            Resumo(
                subtotal = CalculadoraCarrinho.subtotalBruto(itens),
                descontos = CalculadoraCarrinho.totalDescontos(itens),
                total = CalculadoraCarrinho.totalFinal(itens)
            )
        }
    }
}

@Composable
private fun Resumo(subtotal: Double, descontos: Double, total: Double) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            text = "Subtotal: ${formatarMoeda(subtotal)}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Descontos: - ${formatarMoeda(descontos)}",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Total: ${formatarMoeda(total)}",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}