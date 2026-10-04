package com.example.carrinhocompras.ui.components

//componente reutilizável (parametrizado)
//Não conhece nenhum produto específico — recebe tudo por parâmetro.

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * Componente parametrizado. Nenhum dado de produto é fixado aqui.
 */
@Composable
fun ItemCarrinhoCard(
    nome: String,
    descricao: String?,          // pode ser nulo
    quantidade: Int,
    precoUnitario: Double,
    precoTotal: Double,
    temDesconto: Boolean,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {

            Text(
                text = nome,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = descricao ?: "Sem descrição",
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(8.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Qtd: $quantidade",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "Unit.: ${formatarMoeda(precoUnitario)}",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "Total: ${formatarMoeda(precoTotal)}",
                    style = MaterialTheme.typography.labelLarge,
                    color = if (temDesconto)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

internal fun formatarMoeda(valor: Double): String =
    java.lang.String.format(java.util.Locale("pt", "BR"), "R$ %.2f", valor)