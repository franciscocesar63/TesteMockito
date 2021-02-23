/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.IPrecoProdutoService;
import java.util.List;
import model.Produto;

/**
 *
 * @author franc
 */
public class AppPortfolioProdutos {

    private IPrecoProdutoService s;
    private List<Produto> ps;

    public AppPortfolioProdutos(IPrecoProdutoService s, List<Produto> ps) {
        this.s = s;
        this.ps = ps;
    }

    public IPrecoProdutoService getS() {
        return s;
    }

    public void setS(IPrecoProdutoService s) {
        this.s = s;
    }

    public List<Produto> getPs() {
        return ps;
    }

    public void setPs(List<Produto> ps) {
        this.ps = ps;
    }

    /**
     *
     * @return
     */
    public float getTotalDisponivel() {
        float total = 0;
        for (Produto p : ps) {
            total += s.getPrecoProduto(p);
        }

        return total;
    }

}
