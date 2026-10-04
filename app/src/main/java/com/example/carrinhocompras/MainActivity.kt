package com.example.carrinhocompras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.carrinhocompras.domain.data.CatalogoProdutos
import com.example.carrinhocompras.domain.usecase.RelatorioLogcat
import com.example.carrinhocompras.ui.screen.CarrinhoScreen
import com.example.carrinhocompras.ui.theme.CarrinhoComprasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Gera relatório no Logcat (operações funcionais)
        RelatorioLogcat.imprimir(CatalogoProdutos.carrinhoInicial())

        setContent {
            CarrinhoComprasTheme {
                CarrinhoScreen()
            }
        }
    }
}