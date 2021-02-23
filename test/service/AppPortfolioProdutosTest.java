/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.IPrecoProdutoService;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 * @author franc
 */
public class AppPortfolioProdutosTest {

    @Test
    public void getTotalDisponivelTest() {
        //mock
        IPrecoProdutoService ipps = Mockito.mock(IPrecoProdutoService.class);
        Produto p = new Produto(1, "Arroz", 10, 3);
        Produto p1 = new Produto(2, "Feijão", 20, 4);
        Produto p2 = new Produto(3, "Macarrão", 30, 5);

        //comportamento
        Mockito.when(ipps.getPrecoProduto(p)).thenReturn(3f);
        Mockito.when(ipps.getPrecoProduto(p1)).thenReturn(4f);
        Mockito.when(ipps.getPrecoProduto(p2)).thenReturn(5f);

        List<Produto> ps = new ArrayList<>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);
        AppPortfolioProdutos app = new AppPortfolioProdutos(ipps, ps);

        float esperado = 12f;
        float resultado = app.getTotalDisponivel();
        assertEquals(esperado, resultado, 12.0f);
        Mockito.verify(ipps).getPrecoProduto(p);
        Mockito.verify(ipps).getPrecoProduto(p1);
        Mockito.verify(ipps).getPrecoProduto(p2);

    }

}
